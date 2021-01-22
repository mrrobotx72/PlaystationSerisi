package com.h5190022.mehmet_serif_ugur_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.h5190022.mehmet_serif_ugur_final.R;
import com.h5190022.mehmet_serif_ugur_final.adaptor.PlaystationAdaptor;
import com.h5190022.mehmet_serif_ugur_final.model.PlaystationModel;
import com.h5190022.mehmet_serif_ugur_final.network.Service;
import com.h5190022.mehmet_serif_ugur_final.util.Constants;
import com.h5190022.mehmet_serif_ugur_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();

    }

    private  void  init()
    {
        konsollariGetir();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder =new AlertDialog.Builder(ListeActivity.this);
        builder.setTitle("ÇIKIŞ");
        builder.setMessage("ÇIKIŞ YAPMAK ÜZERESİNİZ");
        builder.setPositiveButton("ÇIKIŞ", (intf, i) -> {
            intf.dismiss();
            finish();
        });
        builder.setNegativeButton("VAZGEÇ", (intf, i) -> {
            intf.dismiss();

        });

        builder.show();
    }

    void  konsollariGetir()
    {

        new Service().getServiceApi().konsollariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PlaystationModel>>() {

                    List<PlaystationModel> konsollar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<PlaystationModel> konsolList) {
                        Log.e("RETROFIT","onNext : ");
                        konsollar=konsolList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(konsollar.size()>0) {



                            initRecycleView(konsollar);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<PlaystationModel> konsolList)
    {

        recyclerView =findViewById(R.id.rcvKonsollar);
        PlaystationAdaptor PlaystationAdaptor =new PlaystationAdaptor(konsolList, getApplicationContext(), new PlaystationAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                PlaystationModel tiklananKonsol =konsolList.get(position);
                Toast.makeText(getApplicationContext(), "TIKLANAN ADI : " + tiklananKonsol.getKonsolAdi(), Toast.LENGTH_SHORT).show();

                opennextactivity(tiklananKonsol);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(PlaystationAdaptor);

    }

    private void opennextactivity(PlaystationModel tiklanankonsol){
        Intent secondActivityIntent=new Intent(getApplicationContext(), KonsolAciklamaActivity.class);
        String tiklananKonsolString= ObjectUtil.konsolToJsonString(tiklanankonsol);
        secondActivityIntent.putExtra(Constants.TIKLANAN_KONSOL_TASINANIN_BASLIGI, tiklananKonsolString);
        startActivity(secondActivityIntent);
    }
}