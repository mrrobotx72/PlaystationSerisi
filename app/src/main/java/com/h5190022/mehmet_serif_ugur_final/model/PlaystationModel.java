package com.h5190022.mehmet_serif_ugur_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaystationModel {

    @SerializedName("KonsolAdi")
    @Expose
    private String konsolAdi;
    @SerializedName("CikisTarihi")
    @Expose
    private String cikisTarihi;
    @SerializedName("Markasi")
    @Expose
    private String markasi;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;

    public String getKonsolAdi() {
        return konsolAdi;
    }

    public void setKonsolAdi(String konsolAdi) {
        this.konsolAdi = konsolAdi;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public String getMarkasi() {
        return markasi;
    }

    public void setMarkasi(String markasi) {
        this.markasi = markasi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
