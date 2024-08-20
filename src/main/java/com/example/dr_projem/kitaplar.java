package com.example.dr_projem;

import java.sql.Date;

public class kitaplar {

    private String kitap_adi;
    private String yazar_adi;
    private int sayfa_sayisi;
    private float kitap_fiyati;
    private Date basim_tarihi;
    private String yayinevi_adi;
    private String tur_adi;

    public kitaplar( String kitap_adi, String yazar_adi, int sayfa_sayisi, float kitap_fiyati, Date basim_tarihi, String yayinevi_adi,String tur_adi)
    {
        this.kitap_adi=kitap_adi;
        this.yazar_adi=yazar_adi;
        this.sayfa_sayisi=sayfa_sayisi;
        this.kitap_fiyati=kitap_fiyati;
        this.basim_tarihi=basim_tarihi;
        this.yayinevi_adi=yayinevi_adi;
        this.tur_adi=tur_adi;
    }




    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getYazar_adi() {
        return yazar_adi;
    }

    public void setYazar_adi(String yazar_adi) {
        this.yazar_adi = yazar_adi;
    }

    public int getSayfa_sayisi() {
        return sayfa_sayisi;
    }

    public void setSayfa_sayisi(int sayfa_sayisi) {
        this.sayfa_sayisi = sayfa_sayisi;
    }

    public float getKitap_fiyati() {
        return kitap_fiyati;
    }

    public void setKitap_fiyati(float kitap_fiyati) {
        this.kitap_fiyati = kitap_fiyati;
    }

    public Date getBasim_tarihi() {
        return basim_tarihi;
    }

    public void setBasim_tarihi(Date basim_tarihi) {
        this.basim_tarihi = basim_tarihi;
    }

    public String getYayinevi_adi() {
        return yayinevi_adi;
    }

    public void setYayinevi_adi(String yayinevi_adi) {
        this.yayinevi_adi = yayinevi_adi;
    }

    public String getTur_adi() {
        return tur_adi;
    }

    public void setTur_adi(String tur_adi) {
        this.tur_adi = tur_adi;
    }
}

