/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author EYMEN
 */
public class Song {
    private int id;
    private String ad,tarih,alb_id,tür,süre,dinlenme;

    public Song(int id, String ad, String tarih, String alb_id, String tür, String süre, String dinlenme) {
        this.id = id;
        this.ad = ad;
        this.tarih = tarih;
        this.alb_id = alb_id;
        this.tür = tür;
        this.süre = süre;
        this.dinlenme = dinlenme;
    }

    Song(String sarkiadi, String dinlenme) {
        ad=sarkiadi;
        this.dinlenme=dinlenme;
    }

    Song(String ad, String tur, String dinlenme) {
        this.ad=ad;
        this.tür=tur;
        this.dinlenme=dinlenme;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(String alb_id) {
        this.alb_id = alb_id;
    }

    public String getTür() {
        return tür;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }

    public String getSüre() {
        return süre;
    }

    public void setSüre(String süre) {
        this.süre = süre;
    }

    public String getDinlenme() {
        return dinlenme;
    }

    public void setDinlenme(String dinlenme) {
        this.dinlenme = dinlenme;
    }
    
    
}
