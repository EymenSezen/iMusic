/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.DataBase;
import BackEnd.Song;
import BackEnd.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EYMEN
 */
public class NormalUser extends javax.swing.JFrame {

    /**
     * Creates new form NormalUser
     */
    String email;
    String femail;
    DataBase db = new DataBase();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    DefaultTableModel model4 = new DefaultTableModel();
    DefaultTableModel model5 = new DefaultTableModel();

    public NormalUser() {

    }

    NormalUser(User user) {
        initComponents();
        this.setLocationRelativeTo(null);
        email = user.getEmail();
        System.out.println(user.getEmail());
        this.userlabel.setText(email);
        model1 = (DefaultTableModel) premiumusers.getModel();
        model2 = (DefaultTableModel) songs.getModel();
        model3 = (DefaultTableModel) poptable.getModel();
        model4 = (DefaultTableModel) jazztable.getModel();
        model5 = (DefaultTableModel) classictable.getModel();
        pUserListele();
        songsListele();
        userPopListele();
        userJazzListele();
        userClassicListele();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userlabel = new javax.swing.JLabel();
        mesaj = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        songs = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        poptable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        listeler = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        premiumusers = new javax.swing.JTable();
        followed = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jazztable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        classictable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        uyari = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("be premium");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        userlabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userlabel.setForeground(new java.awt.Color(51, 204, 255));
        userlabel.setText("user");

        mesaj.setText("hello dear");

        jButton2.setText("view");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("TOP10");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        songs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "tur", "dinlenme"
            }
        ));
        songs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        songs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                songsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(songs);

        poptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "dinlenme"
            }
        ));
        jScrollPane3.setViewportView(poptable);

        jLabel2.setText("premium users");

        jButton1.setText("follow");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listeler.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pop", "jazz", "classic" }));
        listeler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setText("add song");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("songs");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("followed users");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        premiumusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ad", "email", "ülke", "abonelik"
            }
        ));
        premiumusers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        premiumusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                premiumusersMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(premiumusers);

        followed.setForeground(new java.awt.Color(255, 51, 51));

        jButton7.setText("albums");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setText("pop");

        jLabel5.setText("jazz");

        jLabel6.setText("classic");

        jazztable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "dinlenme"
            }
        ));
        jScrollPane7.setViewportView(jazztable);

        classictable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "dinlenme"
            }
        ));
        jScrollPane8.setViewportView(classictable);

        jLabel7.setText("my songs");

        uyari.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(mesaj)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(userlabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listeler, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(uyari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(363, 363, 363))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(followed, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(userlabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(followed, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(14, 14, 14)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uyari, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listeler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(mesaj)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        String email = this.userlabel.getText();
        db.premiumOl(email);

        mesaj.setText("premium olundu");
        this.setVisible(false);
        PremiumUser ps = new PremiumUser(new User(email));
        ps.setVisible(true);

        //   db.premiumOl();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Top10 t = new Top10(new User(email));
        t.setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Songs s = new Songs(new User(email));
        s.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedrow = premiumusers.getSelectedRow();

        if (selectedrow == -1) {
            followed.setText("bir kullanıcı seçiniz.");
        } else {
            femail = (String) premiumusers.getValueAt(selectedrow, 2);
            if (takipciMi()) {
                followed.setText("zaten takip ediliyor.");
            } else {
                db.followerOl(email, femail);
                this.followed.setText(femail + " takip ediliyor");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void premiumusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_premiumusersMouseClicked
        // TODO add your handling code here:
        //        int selectedrow = premiumusers.getSelectedRow();
        //        this.userad.setText((String) premiumusers.getValueAt(selectedrow, 1));
        //        this.email.setText((String) premiumusers.getValueAt(selectedrow, 2));
        //        this.sifre.setText((String) premiumusers.getValueAt(selectedrow, 3));
        //        this.ulke.setText((String) premiumusers.getValueAt(selectedrow, 4));
        //        abonelik.setText(premiumusers.getValueAt(selectedrow, 5).toString());
    }//GEN-LAST:event_premiumusersMouseClicked

    private void songsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songsMouseClicked
        // TODO add your handling code here:
        int selectedrow = songs.getSelectedRow();
        String name = (String) songs.getValueAt(selectedrow, 0);
        String dinlenme = String.valueOf(songs.getValueAt(selectedrow, 2));
        int tiklama = Integer.parseInt(dinlenme);
        tiklama++;
        db.dinlenmeSayisi(name, tiklama);
        db.ldinlenmeSayisi(name, tiklama);
        db.sdinlenmeSayisi(name, tiklama);
        JOptionPane.showMessageDialog(this, name + " dinleniyor");
        songs.setValueAt(tiklama, selectedrow, 2);

        this.userClassicListele();
        this.userJazzListele();
        this.userPopListele();
    }//GEN-LAST:event_songsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedrow = this.premiumusers.getSelectedRow();

        if (selectedrow == -1) {
            followed.setText("kullanici seçiniz.");
        } else {
            femail = (String) premiumusers.getValueAt(selectedrow, 2);
            if (takipEdildiMi()) {
                System.out.println(femail);
                FollowedScreen f = new FollowedScreen(new User(email), new User(femail));
                this.setVisible(false);
                f.setVisible(true);
            } else {
                followed.setText("lütfen önce takip ediniz.");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        FollowedUsersScreen fd = new FollowedUsersScreen(new User(email));
        fd.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AlbumScreen as = new AlbumScreen(new User(email));
        as.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedrow = songs.getSelectedRow();
        System.out.println(selectedrow);
        String sarkiAdi = null;
        int dinlenme = 0;
        String turAl = null;
        if (selectedrow == -1) {
            this.uyari.setText("seçim yapiniz");
        } else {
            sarkiAdi = (String) songs.getValueAt(selectedrow, 0);
            dinlenme = (int) songs.getValueAt(selectedrow, 2);
            turAl = (String) this.songs.getValueAt(selectedrow, 1);
        }
        if (listeler.getSelectedIndex() == 0) {

            if (turAl.equals("pop")) {
                //popa ekle
                System.out.println(email);
                if (listemdeMi(email, sarkiAdi)) {
                    this.uyari.setText("şarkı listenizde var");
                } else {
                    db.calmaList(email, dinlenme, turAl, sarkiAdi);
                    this.userPopListele();
                    this.uyari.setText("popa eklendi");
                }
            } else {
                uyari.setText("wrong genre");
            }

        } else if (listeler.getSelectedItem().equals("jazz")) {

            if (turAl.equals("jazz")) {
                //jazz işlemleri
                System.out.println(email);
                if (listemdeMi(email, sarkiAdi)) {
                    this.uyari.setText("şarkı listenizde var");
                } else {
                    db.calmaList(email, dinlenme, turAl, sarkiAdi);
                    this.userJazzListele();
                    this.uyari.setText("jazza eklendi");
                }
            } else {
                uyari.setText("wrong genre");
            }
        } else if (listeler.getSelectedItem().equals("classic")) {

            if (turAl.equals("classic")) {
                //classic işlemleri
                System.out.println(email);
                if (listemdeMi(email, sarkiAdi)) {
                    this.uyari.setText("şarkı listenizde var");
                } else {
                    db.calmaList(email, dinlenme, turAl, sarkiAdi);
                    this.userClassicListele();
                    this.uyari.setText("classice eklendi");
                }
            } else {
                uyari.setText("wrong genre");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NormalUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classictable;
    private javax.swing.JLabel followed;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jazztable;
    private javax.swing.JComboBox<String> listeler;
    private javax.swing.JLabel mesaj;
    private javax.swing.JTable poptable;
    private javax.swing.JTable premiumusers;
    private javax.swing.JTable songs;
    public javax.swing.JLabel userlabel;
    private javax.swing.JLabel uyari;
    // End of variables declaration//GEN-END:variables

    private boolean takipciMi() {
        if (db.followerMi(email, femail)) {
            return true;
        } else {
            return false;
        }
    }

//    private void userListele(User user) {
//        String usermail=user.getEmail()
//        db.userAl();
//    }
    private boolean takipEdildiMi() {
        if (db.followerMi(email, femail)) {
            return true;
        } else {
            return false;
        }
    }

    private void pUserListele() {
        model1.setRowCount(0);
        ArrayList<User> user = new ArrayList<User>();
        user = db.premiumlarAl();
        if (user != null) {
            for (User us : user) {
                Object[] ekle = {us.getId(), us.getName(), us.getEmail(), us.getCountry(), us.getAbonelik()};
                model1.addRow(ekle);
            }
        }
    }

    private void songsListele() {
        model2.setRowCount(0);
        ArrayList<Song> s = new ArrayList<Song>();
        s = db.userSarkiAl(email);
        if (s != null) {
            for (Song songs : s) {
                String[] eklee = {songs.getAd(), songs.getTür(), songs.getDinlenme()};
                model2.addRow(eklee);
            }

        }
    }

    private void userPopListele() {
        model3.setRowCount(0);
        ArrayList<Song> song = new ArrayList<Song>();
        song = db.userPopAl(email);
        if (song != null) {
            for (Song songs : song) {
                Object add[] = {songs.getAd(), songs.getDinlenme()};
                model3.addRow(add);
            }

        }
    }

    private void userJazzListele() {
        model4.setRowCount(0);
        ArrayList<Song> song = new ArrayList<Song>();
        song = db.userJazzAl(email);
        if (song != null) {
            for (Song songs : song) {
                Object add[] = {songs.getAd(), songs.getDinlenme()};
                model4.addRow(add);
            }

        }
    }

    private void userClassicListele() {
        model5.setRowCount(0);
        ArrayList<Song> song = new ArrayList<Song>();
        song = db.userClassicAl(email);
        if (song != null) {
            for (Song songs : song) {
                Object add[] = {songs.getAd(), songs.getDinlenme()};
                model5.addRow(add);
            }

        }
    }

    private boolean listemdeMi(String email, String sarkiAdi) {
        if (db.sarkiListemde(sarkiAdi, email)) {
            return true;
        } else {
            return false;
        }
    }

}