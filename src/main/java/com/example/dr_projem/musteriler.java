package com.example.dr_projem;

public class musteriler {
private int musteri_id;
    private String musteri_adi;
    private String musteri_soyadi;
    private String musteri_sifre;
    private String musteri_email;
    private String kullanici_adi;
    private String telefon;
    private String cinsiyet;




    public musteriler(int musteri_id,String musteri_adi, String musteri_soyadi, String musteri_sifre,String musteri_email, String kullanici_adi, String telefon, String cinsiyet)
    {
        this.musteri_id = musteri_id;
        this.musteri_adi = musteri_adi;
        this.musteri_soyadi = musteri_soyadi;
        this.musteri_sifre = musteri_sifre;
        this.musteri_email=musteri_email;
        this.kullanici_adi = kullanici_adi;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;

    }


    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getMusteri_adi() {
        return this.musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
    }

    public String getMusteri_soyadi() {
        return this.musteri_soyadi;
    }

    public void setMusteri_soyadi(String musteri_soyadi) {
        this.musteri_soyadi = musteri_soyadi;
    }

    public String getMusteri_sifre() {
        return this.musteri_sifre;
    }

    public void setMusteri_sifre(String musteri_sifre) {
        this.musteri_sifre = musteri_sifre;
    }

    public String getMusteri_email() {
        return musteri_email;
    }

    public void setMusteri_email(String musteri_email) {
        this.musteri_email = musteri_email;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return this.cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }


}
