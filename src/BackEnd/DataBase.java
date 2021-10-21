/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author EYMEN
 */
public class DataBase {

    String username = "root";
    String password = "Eymen1903!!!!";
    String dbUrl = "jdbc:mysql://localhost:3306/imusic";
    Connection connection;
    PreparedStatement ps;

    public DataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver bulunamadı");
        }
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("bağlandı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız");
        }
    }

    public boolean girisYap(String email, String password) {
        String query = "select * from users where email=? and password=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
//            if(rs.next()==false)
//            {
//            return false;
//            }
//            else
//            {
//            return true;
//            }
            return rs.next() != false;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<Song> sarkiGetir() {
        ArrayList<Song> song = new ArrayList<Song>();

        try {

            Statement st = connection.createStatement();
            String query = "select * from imusic.sarkilar";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String tarih = rs.getString("tarih");
                String album_id = rs.getString("album_id");
                String tur = rs.getString("tur");
                String sure = rs.getString("sure");
                String dinlenme_sayisi = rs.getString("dinlenme_sayisi");
                song.add(new Song(id, name, tarih, album_id, tur, sure, dinlenme_sayisi));
            }
            return song;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }

    }

    public void sarkiEkle(String ad, String tarih, String alb_id, String tur, float sure, String dinlenme) {
        String query = "insert into sarkilar (name,tarih,album_id,tur,sure,dinlenme_sayisi)values(?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, tarih);
            ps.setString(3, alb_id);
            ps.setString(4, tur);
            ps.setFloat(5, sure);
            ps.setString(6, dinlenme);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sarkiGuncelle(int id, String ad, String tarih, String alb_id, String tur, float sure, String dinlenme) {
        String query = "update  sarkilar set name=?,tarih=?,album_id=?,tur=?,sure=?,dinlenme_sayisi=? where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, tarih);
            ps.setString(3, alb_id);
            ps.setString(4, tur);
            ps.setFloat(5, sure);
            ps.setString(6, dinlenme);
            ps.setInt(7, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sarkiSil(int id) {
        String query = "delete from sarkilar where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sanatciEkle(String ad, String ulke) {
        String query = "insert into singers (name,country) values(?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, ulke);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Singer> sanatciGetir() {
        String query = "select * from singers";
        ArrayList<Singer> singer = new ArrayList<Singer>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                singer.add(new Singer(id, name, country));
                //listelenirken daha çok rs kullanıyoruz ve de statement
            }
            return singer;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void sanatciGuncelle(int id, String ad, String ulke) {
        String query = "update singers set name=?,country=? where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, ulke);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("sorgu çalışıyor");

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sanatciSil(int id) {
        String query = "delete from singers where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> kullaniciGetir() {
        ArrayList<User> user = new ArrayList<User>();
        String query = "select * from users";
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String country = rs.getString("country");
                int abonelik = rs.getInt("abonelik");
                user.add(new User(id, name, email, password, country, abonelik));

            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void kullaniciEkle(String ad, String email, String sifre, String country, int abonelik) {
        String query = "insert into users (name,email,password,country,abonelik)values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, email);
            ps.setString(3, sifre);
            ps.setString(4, country);
            ps.setInt(5, abonelik);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void userGuncelle(int id, String ad, String email, String password, String country, int abonelik) {
        String query = "update users set name=?,email=?,password=?,country=?,abonelik=? where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, country);
            ps.setInt(5, abonelik);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kullaniciSil(int id) {
        String query = "delete from users where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Album> albumAl() {
        ArrayList<Album> albumeekle = new ArrayList<Album>();
        String query = "select * from albums ";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sanatci_id = rs.getString("sanatci_id");
                String sarki_id = rs.getString("sarki_id");
                String tarih = rs.getString("tarih");
                String tur = rs.getString("tur");
                albumeekle.add(new Album(id, name, sanatci_id, sarki_id, tarih, tur));
            }
            return albumeekle;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void albumSil(int id) {
        String query = "delete from albums where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void premiumOl(String email) {
        String query = "update users set abonelik=1 where email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userAl(String usermail) {
        String query = "select name,email from users where email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usermail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean premiumAl(String email) {
        String query = "select * from users where email=? and abonelik=1";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next() != false;//sadece sorguyu çalıştırıp alıyorum

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void kayitAl(String name, String email, String password, String country) {
        String query = "insert into users (name,email,password,country)values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, country);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calmaListesineEkle(String email) {
        String query = "insert into playlists (tur,email) values(?,?),(?,?),(?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "pop");
            ps.setString(2, email);
            ps.setString(3, "classic");
            ps.setString(4, email);
            ps.setString(5, "jazz");
            ps.setString(6, email);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<User> premiumlarAl() {
        ArrayList<User> users = new ArrayList<User>();
        String query = "select * from users where abonelik =1";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String country = rs.getString("country");
                int abonelik = rs.getInt("abonelik");
                users.add(new User(id, name, email, password, country, abonelik));
                
                //passwordu listede gösterilmedi!!!!
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void dinlenmeSayisi(int id, int index) {
        String query = "update sarkilar set dinlenme_sayisi=? where id=?";
        try {
            String dinlenme = String.valueOf(index);

            ps = connection.prepareStatement(query);
            ps.setString(1, dinlenme);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Song> popAl() {
        ArrayList<Song> pop = new ArrayList();
        try {
            String query = "SELECT  name,dinlenme_sayisi from sarkilar where tur='pop' order by dinlenme_sayisi desc limit 10 ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String sarkiadi = rs.getString("name");
                String dinlenme = rs.getString("dinlenme_sayisi");
                pop.add(new Song(sarkiadi, dinlenme));
            }
            return pop;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Song> jazzAl() {
        ArrayList<Song> jazz = new ArrayList();
        try {
            String query = "SELECT  name,dinlenme_sayisi from sarkilar where tur='jazz' order by dinlenme_sayisi desc limit 10 ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String sarkiadi = rs.getString("name");
                String dinlenme = rs.getString("dinlenme_sayisi");
                jazz.add(new Song(sarkiadi, dinlenme));
            }
            return jazz;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Song> classicAl() {
        ArrayList<Song> classic = new ArrayList();
        try {
            String query = "SELECT  name,dinlenme_sayisi from sarkilar where tur='classic' order by dinlenme_sayisi desc limit 10 ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String sarkiadi = rs.getString("name");
                String dinlenme = rs.getString("dinlenme_sayisi");
                classic.add(new Song(sarkiadi, dinlenme));
            }
            return classic;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Song> allAl() {
        ArrayList<Song> all = new ArrayList();
        try {
            String query = "SELECT  name,dinlenme_sayisi from sarkilar order by dinlenme_sayisi desc limit 10 ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String sarkiadi = rs.getString("name");
                String dinlenme = rs.getString("dinlenme_sayisi");
                all.add(new Song(sarkiadi, dinlenme));
            }
            return all;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void albumEkle(String albad, String sanid, String sarid, String tarih, String tur) {
        String query = "insert into albums (name,sanatci_id,sarki_id,tarih,tur)values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, albad);
            ps.setString(2, sanid);
            ps.setString(3, sarid);
            ps.setString(4, tarih);
            ps.setString(5, tur);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void albumGuncelle(int id, String ad, String sanid, String sarid, String tarih, String tur) {
        String query = "update albums set name=?,sanatci_id=?,sarki_id=?,tarih=?,tur=? where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, sanid);
            ps.setString(3, sarid);
            ps.setString(4, tarih);
            ps.setString(5, tur);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sarkiyiKullaniciyaEkle(int id, String ad, String tarih, String alb_id, String tur, String sure, String dinlenme, String email) {
        String query = "insert into users_songs (song_id,user_id,name,dinlenme,tur) values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, email);
            ps.setString(3, ad);
            ps.setString(4, dinlenme);
            ps.setString(5, tur);
            //ben şarkılar tablosundan bir şey sildiğimde buradaki de silinecek...
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Song> userSarkiAl(String email) {
        String query = "select name,tur,dinlenme from users_songs where user_id=?";
        ArrayList<Song> song = new ArrayList<Song>();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            System.out.println(email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ad = rs.getString("name");
                String dinlenme = rs.getString("dinlenme");
                String tur = rs.getString("tur");
                song.add(new Song(ad, tur, dinlenme));
            }
            return song;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //bütün ilişkili tablolarda sayıları güncelliyoruz
    public void dinlenmeSayisi(String name, int tiklama) {
        String query = "update users_songs set dinlenme=? where name=?;";
        try {
            String dinleme = String.valueOf(tiklama);
            ps = connection.prepareStatement(query);
            ps.setString(1, dinleme);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sdinlenmeSayisi(String name, int tiklama) {

        String query2 = "update sarkilar set dinlenme_sayisi=? where name=?;";

        try {
            String dinleme = String.valueOf(tiklama);
            ps = connection.prepareStatement(query2);
            ps.setString(1, dinleme);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ldinlenmeSayisi(String name, int tiklama) {
        //bütün kullanıcılarda dinlenmeyi arttıracak song_id kullansam yine aynı sonuca varacaktım... aynı song_idyi değil aynı namei
        //alan kullanıcılarda şarkıları güncelliyorum.
        String query3 = "update songs_playlists set dinlenme=? where name=?";
        try {
            String dinleme = String.valueOf(tiklama);
            ps = connection.prepareStatement(query3);
            ps.setString(1, dinleme);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //childrowlar için foreignkeylerle oluşturuldu ve songs_playlists önemli bir tablomuz
    public void calmaList(String email, int dinlenme, String turAl, String sarkiAdi) {
        String query = "insert into songs_playlists (email,dinlenme,tur,name)values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, dinlenme);
            ps.setString(3, turAl);
            ps.setString(4, sarkiAdi);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Song> userPopAl(String email) {
        ArrayList<Song> s = new ArrayList<Song>();
        String query = "select * from songs_playlists where tur ='pop' and email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String dinlenme = rs.getString("dinlenme");
                s.add(new Song(name, dinlenme));

            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Song> userJazzAl(String email) {
        ArrayList<Song> s = new ArrayList<Song>();
        String query = "select * from songs_playlists where tur='jazz' and email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String dinlenme = rs.getString("dinlenme");
                s.add(new Song(name, dinlenme));

            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Song> userClassicAl(String email) {
        ArrayList<Song> s = new ArrayList<Song>();
        String query = "select * from songs_playlists where tur='classic' and email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String dinlenme = rs.getString("dinlenme");
                s.add(new Song(name, dinlenme));

            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void followerOl(String email, String femail) {
        String query = "insert into follows (follower_id,followed_id) values (?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, femail);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean followerMi(String email, String femail) {
        String query = "select * from follows where follower_id=? and followed_id=?";
        try {
            System.out.println(femail);
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, femail);
            ResultSet rs = ps.executeQuery();
            return rs.next() != false;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public void followerPopEkle(String name, String dinlenme, String email) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur)values(?,?,?,'pop')";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userPopListeyiAl(String email, String name, String dinlenme) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur) values (?,?,?,'pop')";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void followerJazzEkle(String name, String dinlenme, String email) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur)values(?,?,?,'jazz')";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void followerClassicEkle(String name, String dinlenme, String email) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur)values(?,?,?,'classic')";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userJazzListeyiAl(String email, String name, String dinlenme) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur)values(?,?,?,'jazz')";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userClassicListeyiAl(String email, String name, String dinlenme) {
        String query = "insert into songs_playlists (email,name,dinlenme,tur)values(?,?,?,'classic')";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, dinlenme);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> followedAl(String email) {
        ArrayList<User> user = new ArrayList<User>();
        String query = "select followed_id,id from follows where follower_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String femail = rs.getString("followed_id");
                user.add(new User(id, femail));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean zatenTakipci(String email, String femail) {
        String query = "select * from follows where follower_id=? and followed_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, femail);
            ResultSet rs = ps.executeQuery();
            return rs.next() != false;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<User> followerAl(String email) {
        ArrayList<User> user = new ArrayList<User>();
        String query = "select follower_id,id from follows where followed_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String femail = rs.getString("follower_id");
                user.add(new User(id, femail));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean ayniSarki(String email, String ad) {
        String query = "select * from users_songs where user_id=? and name=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, ad);
            ResultSet rs=ps.executeQuery();
            return rs.next()!=false;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean sarkiListemde(String name, String email) {
        String query="select * from songs_playlists where email=? and name=?";
        try {
            ps=connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ResultSet rs=ps.executeQuery();
            return rs.next()!=false;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

}
