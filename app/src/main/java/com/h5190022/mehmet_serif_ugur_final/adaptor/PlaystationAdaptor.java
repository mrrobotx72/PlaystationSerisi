package com.h5190022.mehmet_serif_ugur_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190022.mehmet_serif_ugur_final.util.GlideUtil;
import com.h5190022.mehmet_serif_ugur_final.model.PlaystationModel;
import com.h5190022.mehmet_serif_ugur_final.R;

import java.util.List;

public class PlaystationAdaptor extends RecyclerView.Adapter<PlaystationViewHolder> {


    List<PlaystationModel> konsollar;
    Context context;
    OnItemClickListener Listener;

    public interface OnItemClickListener {
        void onClick (int position);
    }

    public PlaystationAdaptor(List<PlaystationModel> konsollar, Context context,OnItemClickListener Listener) {
        this.konsollar = konsollar;
        this.context = context;
        this.Listener = Listener;
    }

    @NonNull
    @Override
    public PlaystationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_playstation,parent,false);
        return new PlaystationViewHolder(itemView,Listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaystationViewHolder viewHolder, int position) {

        viewHolder.txtKonsolAdi.setText(konsollar.get(position).getKonsolAdi());
        viewHolder.txtTarih.setText(konsollar.get(position).getCikisTarihi());
        viewHolder.txtMarka.setText(konsollar.get(position).getMarkasi());
        GlideUtil.resmiIndiripGoster(context,konsollar.get(position).getLogoUrl(),viewHolder.imgPlaystationLogo);

    }

    @Override
    public int getItemCount() {
        return konsollar.size();
    }
}
