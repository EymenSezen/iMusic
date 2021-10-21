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
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String country;
    private int abonelik;
    
    public User(int id, String name, String email, String password, String country,int abonelik) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.abonelik=abonelik;
    }

    User(int id, String email) {
        this.id=id;
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAbonelik() {
        return abonelik;
    }

    public void setAbonelik(int abonelik) {
        this.abonelik = abonelik;
    }

    public User(String email) {
        this.email = email;//emaili alıyor
    }
    //useral ile tek bir user alabiliriz aslında ama başka bir yöntem deniyorum
    

}
