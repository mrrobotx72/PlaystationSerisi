package com.h5190022.mehmet_serif_ugur_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190022.mehmet_serif_ugur_final.R;

import org.w3c.dom.Text;

public class PlaystationViewHolder extends RecyclerView.ViewHolder {

    ImageView imgPlaystationLogo;
    TextView txtKonsolAdi;
    TextView txtTarih;
    TextView txtMarka;

    public PlaystationViewHolder(@NonNull View cardView, PlaystationAdaptor.OnItemClickListener Listener) {
        super(cardView);

        imgPlaystationLogo =cardView.findViewById(R.id.imgPlaystationLogo);
        txtKonsolAdi =cardView.findViewById(R.id.txtKonsolAdi);
        txtTarih =cardView.findViewById(R.id.txtTarih);
        txtMarka =cardView.findViewById(R.id.txtMarka);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Listener.onClick(getAdapterPosition());
            }
        });
    }
}
