package com.example.dr_projem;

public class adresler {
    private int adres_id;
    private String il;
    private String ilce;
    private String mahalle;
    private String cadde;
    private int bina_no;

public adresler( int adres_id, String il, String ilce, String mahalle, String cadde, int bina_no)
{

    this.adres_id=adres_id;
    this.il=il;
    this.ilce=ilce;
    this.mahalle=mahalle;
    this.cadde=cadde;
    this.bina_no=bina_no;

}

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getCadde() {
        return cadde;
    }

    public void setCadde(String cadde) {
        this.cadde = cadde;
    }

    public int getBina_no() {
        return bina_no;
    }

    public void setBina_no(int bina_no) {
        this.bina_no = bina_no;
    }
}
