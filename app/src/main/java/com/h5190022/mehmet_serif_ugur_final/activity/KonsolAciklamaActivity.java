package com.h5190022.mehmet_serif_ugur_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190022.mehmet_serif_ugur_final.R;
import com.h5190022.mehmet_serif_ugur_final.model.PlaystationModel;
import com.h5190022.mehmet_serif_ugur_final.util.Constants;
import com.h5190022.mehmet_serif_ugur_final.util.GlideUtil;
import com.h5190022.mehmet_serif_ugur_final.util.ObjectUtil;

public class KonsolAciklamaActivity extends AppCompatActivity {


    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtAciklama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsol_aciklama);

        String tasinanKonsolString = getIntent().getStringExtra(Constants.TIKLANAN_KONSOL_TASINANIN_BASLIGI);
        PlaystationModel playstationModel = ObjectUtil.jsonStringTokonsol(tasinanKonsolString);


        imgKapak =findViewById(R.id.imgKapak);
        txtBaslik =findViewById(R.id.txtBaslik);
        txtAciklama =findViewById(R.id.txtAciklama);


        txtBaslik.setText(playstationModel.getKonsolAdi());
        txtAciklama.setText(playstationModel.getAciklama());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),playstationModel.getKapakFotoUrl(),imgKapak);

    }

}