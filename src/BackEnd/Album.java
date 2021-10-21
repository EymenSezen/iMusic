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
public class Album {
    private int id;
    private String name;
    private String sanatci_id;
    private String sarki_id;
    private String tarih;
    private String tur;

    public Album(int id, String name, String sanatci_id, String sarki_id, String tarih, String tur) {
        this.id = id;
        this.name = name;
        this.sanatci_id = sanatci_id;
        this.sarki_id = sarki_id;
        this.tarih = tarih;
        this.tur = tur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSanatci_id() {
        return sanatci_id;
    }

    public void setSanatci_id(String sanatci_id) {
        this.sanatci_id = sanatci_id;
    }

    public String getSarki_id() {
        return sarki_id;
    }

    public void setSarki_id(String sarki_id) {
        this.sarki_id = sarki_id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
    
         
}
