/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CariHesapProjesi;

import static CariHesapProjesi.AdminLogin.LOGIN_ID;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author macbookAir
 */
public class AnaSayfa extends javax.swing.JFrame {

    DB db = new DB();
    int tutar;

    public void itemDoldur(JComboBox je) {
        try {
            je.removeAllItems();
            String selectQuery = "select adi from KATEGORI ";
            ResultSet rs = db.baglan().executeQuery(selectQuery);
            while (rs.next()) {
                String deger = rs.getString("adi");
                je.addItem(deger);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }

    public void itemDoldur2(JComboBox je) {
        try {
            je.removeAllItems();
            String selectQuery = "select adi from MUSTERI ";
            ResultSet rs = db.baglan().executeQuery(selectQuery);
            while (rs.next()) {
                String deger = rs.getString("adi");
                je.addItem(deger);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }

    public void itemDoldur3(JComboBox je) {
        try {
            je.removeAllItems();
            String selectQuery = "select kategori from STOK ";
            ResultSet rs = db.baglan().executeQuery(selectQuery);
            while (rs.next()) {
                String deger = rs.getString("kategori");
                je.addItem(deger);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }

    public void dataGetir() {
        try {
            String musteriQuery = "select *from MUSTERI ";
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Adı");
            dtm.addColumn("Soyadı");
            dtm.addColumn("Telefon");
            dtm.addColumn("Adres");

            // satırlara gelecek datalar alınıyor
            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("ID"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("telno"), rs.getString("adres")});
            }
            tblMusteri.setModel(dtm);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }
    }

    public void dataGetir2() {
        try {
            String musteriQuery = "select *from KATEGORI ";
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Adı");
            dtm.addColumn("Aciklama");

            // satırlara gelecek datalar alınıyor
            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("ID"), rs.getString("adi"), rs.getString("aciklama")});
            }
            tblKategoriListesi.setModel(dtm);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }
    }

    public void dataGetir3() {
        try {
            String musteriQuery = "select *from STOK ";
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("KATEGORI");
            dtm.addColumn("ADI");
            dtm.addColumn("MIKTAR");
            dtm.addColumn("BIRIM FIYAT");
            dtm.addColumn("SATIS FIYATI");
            // satırlara gelecek datalar alınıyor
            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("ID"), rs.getString("kategori"), rs.getString("adi"), rs.getString("miktar"), rs.getString("maliyet"), rs.getString("satisfiyati")});
            }
            tblUrunListesi.setModel(dtm);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }

    }

    public void dataGetir4() {
        try {

            String kategori = comboKategori.getSelectedItem().toString();
            System.out.println(kategori);
            String selectQuery = "select ID,kategori,adi,miktar,satisfiyati from STOK where kategori= '" + kategori + "'";
            ResultSet rs = db.baglan().executeQuery(selectQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("KATEGORI");
            dtm.addColumn("ADI");
            dtm.addColumn("MIKTARI");
            dtm.addColumn("SATIS FIYATI");

            // satırlara gelecek datalar alınıyor
            while (rs.next()) {
                System.out.println(rs.getString("adi"));
                dtm.addRow(new String[]{rs.getString("ID"), rs.getString("kategori"), rs.getString("adi"), rs.getString("miktar"), rs.getString("satisfiyati")});
            }
            tblsatislistesi.setModel(dtm);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }

    }

    public AnaSayfa() {
        initComponents();
        dataGetir3();
        dataGetir();
        dataGetir2();
        dataGetir4();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jMenu1 = new javax.swing.JMenu();
        comboUrunKatogori1 = new javax.swing.JComboBox<>();
        btnListe = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtilkGun = new javax.swing.JTextField();
        txtIkincigun = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtIlkay = new javax.swing.JTextField();
        txtIkinciay = new javax.swing.JTextField();
        txtIlkyil = new javax.swing.JTextField();
        txtIkinciyil = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        btnListele = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        button2 = new java.awt.Button();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMusteri = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnMSil = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMAdi = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMEkle = new javax.swing.JButton();
        txtMSoyadi = new javax.swing.JTextField();
        txtMNo = new javax.swing.JTextField();
        txtMAdres = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAguncel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAguncel1 = new javax.swing.JTextField();
        txtAguncel2 = new javax.swing.JTextField();
        txtAguncel3 = new javax.swing.JTextField();
        btnMGuncelle = new javax.swing.JButton();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKategoriListesi = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        btnKategoriSil = new javax.swing.JButton();
        btnKatogoriDuzenle = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnKategoriEkle = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnKategoriGuncelle = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        guncelAd = new javax.swing.JTextField();
        guncelAciklama = new javax.swing.JTextField();
        txtKategoriAdi1 = new javax.swing.JTextField();
        txtKategoriAciklama1 = new javax.swing.JTextField();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUrunListesi = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        btnUrunSil = new javax.swing.JButton();
        btnUrunDuzenle = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtUrunAdi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnUrunEkle = new javax.swing.JButton();
        txtStokMiktari = new javax.swing.JTextField();
        txtMaliyet = new javax.swing.JTextField();
        txtSatisfiyat = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        txtAdiGuncel = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaliyetGuncel = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtsSatisFiyatiGncel = new javax.swing.JTextField();
        btnUrunGuncel = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        comboUrunKatogori2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        comboUrunKatogori = new javax.swing.JComboBox<>();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        comboKategori = new javax.swing.JComboBox<>();
        btnUrunListe = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblsatislistesi = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSatisliste = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        comboMusteri = new javax.swing.JComboBox<>();
        txtSatisMiktar = new javax.swing.JTextField();
        btnsSatisTamam = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txtSatisMiktar1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtMiktar = new javax.swing.JTextField();
        comboboxMusteri = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        btnSatisTamamla = new javax.swing.JButton();
        urunid = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        sKategori = new javax.swing.JLabel();
        comboboxKat = new javax.swing.JComboBox<>();
        txtSatilan = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jc = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        musteri = new javax.swing.JRadioButton();
        urun = new javax.swing.JRadioButton();
        kategori = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        aranan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        dateTime2 = new com.toedter.calendar.JDateChooser();
        dateTime1 = new com.toedter.calendar.JDateChooser();
        listele = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFiltreListesi = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtSonuc = new javax.swing.JTextField();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pswEskiSifre = new javax.swing.JPasswordField();
        pswYeniSifre = new javax.swing.JPasswordField();
        sifreonay = new javax.swing.JPasswordField();
        btnDegistir = new javax.swing.JButton();
        btnCikis = new javax.swing.JButton();

        button1.setLabel("button1");

        jMenu1.setText("jMenu1");

        comboUrunKatogori1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnListe.setText("LISTELE");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel47.setText("AY");

        jLabel48.setText("YIL");

        jLabel46.setText("GUN");

        btnListele.setText("LISTELE");
        btnListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeleActionPerformed(evt);
            }
        });

        btnList.setText("LISTELE");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        button2.setLabel("button2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MUSTERI LISTESI");

        tblMusteri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMusteri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMusteriMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMusteriMouseClicked(evt);
            }
        });
        tblMusteri.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblMusteriVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblMusteri);

        btnMSil.setText("SIL");
        btnMSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSilActionPerformed(evt);
            }
        });

        btnDuzenle.setText("DUZENLE");
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMSil, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 175, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnMSil)
                .addGap(18, 18, 18)
                .addComponent(btnDuzenle)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jLabel7.setText("   ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setText("ADI:");

        jLabel4.setText("SOYAD:");

        jLabel5.setText("TELEFON:");

        jLabel6.setText("ADRES:");

        jButton2.setText("KAYDET");

        jLabel2.setText("MUSTERI EKLE");

        btnMEkle.setText("EKLE");
        btnMEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMEkleActionPerformed(evt);
            }
        });

        jLabel8.setText("ADI:");

        jLabel9.setText("SOYAD:");

        jLabel10.setText("TELEFON:");

        jLabel11.setText("ADRES:");

        jLabel12.setText("GUNCELLEME");

        txtAguncel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAguncel3ActionPerformed(evt);
            }
        });

        btnMGuncelle.setText("GUNCELLE");
        btnMGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMGuncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMGuncelle)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAguncel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAguncel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAguncel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAguncel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8))
                    .addComponent(txtAguncel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAguncel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAguncel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAguncel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnMGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMNo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(btnMEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(856, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtMSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMEkle)
                        .addGap(71, 71, 71)))
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("MUSTERILER", jPanel2);

        jTabbedPane1.addTab("MUSTERILER", jTabbedPane2);

        jLabel26.setText("KATEGORI LISTESI");

        tblKategoriListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKategoriListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKategoriListesiMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriListesiMouseClicked(evt);
            }
        });
        tblKategoriListesi.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblKategoriListesiVetoableChange(evt);
            }
        });
        jScrollPane5.setViewportView(tblKategoriListesi);

        btnKategoriSil.setText("SIL");
        btnKategoriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriSilActionPerformed(evt);
            }
        });

        btnKatogoriDuzenle.setText("DUZENLE");
        btnKatogoriDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKatogoriDuzenleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKatogoriDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKategoriSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 170, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnKategoriSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKatogoriDuzenle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setText("ADI");

        jLabel28.setText("ACIKLAMA");

        jLabel31.setText("KATEGORI EKLE");

        btnKategoriEkle.setText("EKLE");
        btnKategoriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriEkleActionPerformed(evt);
            }
        });

        jLabel32.setText("ADI");

        jLabel33.setText("ACIKLAMA");

        btnKategoriGuncelle.setText("GUNCELLE");
        btnKategoriGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriGuncelleActionPerformed(evt);
            }
        });

        jLabel36.setText("GUNCELLEME");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(btnKategoriGuncelle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addContainerGap(147, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guncelAd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guncelAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(13, 13, 13)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(guncelAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33))
                    .addComponent(guncelAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnKategoriGuncelle))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKategoriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKategoriAdi1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKategoriAciklama1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)))
                .addGap(129, 129, 129)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(txtKategoriAdi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(txtKategoriAciklama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(btnKategoriEkle)))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane6.addTab("KATEGORI YONETIMI", jPanel6);

        jTabbedPane1.addTab("KATEGORI YONETIMI", jTabbedPane6);

        tblUrunListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUrunListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUrunListesiMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUrunListesiMouseClicked(evt);
            }
        });
        tblUrunListesi.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblUrunListesiVetoableChange(evt);
            }
        });
        jScrollPane4.setViewportView(tblUrunListesi);

        jLabel15.setText("URUN LISTESI");

        btnUrunSil.setText("SIL");
        btnUrunSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunSilActionPerformed(evt);
            }
        });

        btnUrunDuzenle.setText("DUZENLE");
        btnUrunDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunDuzenleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUrunDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 170, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnUrunSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUrunDuzenle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("ADI");

        jLabel17.setText("STOK MIKTARI");

        jLabel18.setText("BIRIM FIYATI");

        jLabel19.setText("SATIS FIYATI");

        jLabel20.setText("URUN EKLE");

        btnUrunEkle.setText("EKLE");
        btnUrunEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunEkleActionPerformed(evt);
            }
        });

        jLabel21.setText("ADI");

        jLabel22.setText("STOK MIKTARI");

        txtMaliyetGuncel.setText("  ");

        jLabel23.setText("MALIYETI");

        jLabel24.setText("SATIS FIYATI");

        btnUrunGuncel.setText("GUNCELLE");
        btnUrunGuncel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunGuncelActionPerformed(evt);
            }
        });

        jLabel25.setText("GUNCELLEME");

        jLabel38.setText("KATEGORI");

        comboUrunKatogori2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboUrunKatogori2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(btnUrunGuncel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdiGuncel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtsSatisFiyatiGncel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txtMaliyetGuncel)))))
                    .addComponent(jLabel25)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(38, 38, 38)
                        .addComponent(comboUrunKatogori2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(comboUrunKatogori2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdiGuncel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23)
                    .addComponent(txtMaliyetGuncel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtsSatisFiyatiGncel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnUrunGuncel))
        );

        jLabel37.setText("KATEGORI");

        comboUrunKatogori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboUrunKatogoriMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSatisfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(btnUrunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(38, 38, 38)
                        .addComponent(comboUrunKatogori, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(comboUrunKatogori, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtUrunAdi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtMaliyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtSatisfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUrunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTabbedPane5.addTab("URUN YONETIMI", jPanel5);

        jTabbedPane1.addTab("URUN YONETIMI", jTabbedPane5);

        comboKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboKategoriMouseClicked(evt);
            }
        });

        btnUrunListe.setText("LISTELE");
        btnUrunListe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunListeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        tblsatislistesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblsatislistesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblsatislistesiMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsatislistesiMouseClicked(evt);
            }
        });
        tblsatislistesi.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblsatislistesiVetoableChange(evt);
            }
        });
        jScrollPane6.setViewportView(tblsatislistesi);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        tblSatisliste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSatisliste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSatislisteMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSatislisteMouseClicked(evt);
            }
        });
        tblSatisliste.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblSatislisteVetoableChange(evt);
            }
        });
        jScrollPane7.setViewportView(tblSatisliste);

        jLabel42.setText("miktar");

        jLabel43.setText("musteri");

        txtSatisMiktar.setText(" ");

        btnsSatisTamam.setText("SATISI TAMAMLA");

        jLabel52.setText("secilen urun");

        txtSatisMiktar1.setText(" ");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42)
                            .addComponent(jLabel52))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSatisMiktar1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSatisMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(comboMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnsSatisTamam, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtSatisMiktar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(txtSatisMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(comboMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsSatisTamam))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel39.setText("MIKTAR");

        txtMiktar.setText(" ");

        comboboxMusteri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboboxMusteriMouseClicked(evt);
            }
        });

        jLabel40.setText("MUSTERI");

        btnSatisTamamla.setText("SATISI TAMAMLA");
        btnSatisTamamla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatisTamamlaActionPerformed(evt);
            }
        });

        urunid.setText(" ");

        jLabel41.setText("URUNID");

        sKategori.setText("KATEGORI");

        comboboxKat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboboxKatMouseClicked(evt);
            }
        });

        txtSatilan.setText(" ");

        jLabel54.setText("URUN ADI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39)
                                        .addComponent(jLabel40))
                                    .addGap(36, 36, 36)
                                    .addComponent(comboboxMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(urunid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnUrunListe, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel41)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(sKategori)
                            .addGap(27, 27, 27)
                            .addComponent(comboboxKat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(27, 27, 27)
                        .addComponent(txtSatilan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSatisTamamla, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUrunListe)
                            .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(urunid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sKategori)
                            .addComponent(comboboxKat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(comboboxMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSatilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addComponent(btnSatisTamamla, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("SATIS YONETIMI", jPanel4);

        jTabbedPane1.addTab("SATIS YONETIMI", jTabbedPane4);

        jLabel44.setText("FILTRE");

        jLabel45.setText("ARANILACAK BOLGE");

        buttonGroup1.add(musteri);
        musteri.setText("MUSTERI");

        buttonGroup1.add(urun);
        urun.setText("URUN");

        buttonGroup1.add(kategori);
        kategori.setText("KATEGORI");

        jLabel13.setText("ARA");

        jLabel14.setText("TARIH ARALIGI");

        dateTime2.setDateFormatString("dd.MM.yyyy");

        dateTime1.setDateFormatString("dd.MM.yyyy");

        listele.setText("LISTELE");
        listele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcLayout = new javax.swing.GroupLayout(jc);
        jc.setLayout(jcLayout);
        jcLayout.setHorizontalGroup(
            jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcLayout.createSequentialGroup()
                .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(jcLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcLayout.createSequentialGroup()
                                .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jcLayout.createSequentialGroup()
                                        .addComponent(musteri)
                                        .addGap(18, 18, 18)
                                        .addComponent(urun)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kategori))
                                    .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(aranan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateTime1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                        .addComponent(dateTime2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel14)
                            .addComponent(listele, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jcLayout.setVerticalGroup(
            jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dateTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jcLayout.createSequentialGroup()
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(musteri)
                    .addComponent(urun)
                    .addComponent(kategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(aranan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(40, 40, 40)
                .addComponent(listele))
        );

        jLabel49.setText("SONUC LISTESI");

        tblFiltreListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFiltreListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFiltreListesiMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFiltreListesiMouseClicked(evt);
            }
        });
        tblFiltreListesi.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblFiltreListesiVetoableChange(evt);
            }
        });
        jScrollPane2.setViewportView(tblFiltreListesi);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel49)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel50.setText("KASAYA GIREN PARA");

        jLabel51.setText("CIRO");

        txtSonuc.setText(" ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(txtSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel50)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("RAPORLAR", jPanel3);

        jTabbedPane1.addTab("RAPORLAR", jTabbedPane3);

        jLabel29.setForeground(new java.awt.Color(0, 0, 204));
        jLabel29.setText("SIFRE:");

        jLabel30.setForeground(new java.awt.Color(0, 0, 204));
        jLabel30.setText("YENI SIFRE:");

        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setText("YENI SIFRE:");

        pswEskiSifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswEskiSifreActionPerformed(evt);
            }
        });

        btnDegistir.setForeground(new java.awt.Color(0, 0, 255));
        btnDegistir.setText("DEGISTIR");
        btnDegistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDegistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDegistir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel34))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(pswEskiSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sifreonay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pswYeniSifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(pswEskiSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(pswYeniSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(sifreonay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("AYARLAR", jPanel7);

        jTabbedPane1.addTab("AYARLAR", jTabbedPane7);

        btnCikis.setText("CIKIS");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCikis)
                .addGap(172, 172, 172))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCikis)
                .addGap(34, 34, 34)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMusteriMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMusteriMousePressed

    }//GEN-LAST:event_tblMusteriMousePressed

    private void tblMusteriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMusteriMouseClicked


    }//GEN-LAST:event_tblMusteriMouseClicked

    private void tblMusteriVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblMusteriVetoableChange

    }//GEN-LAST:event_tblMusteriVetoableChange

    private void tblUrunListesiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUrunListesiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUrunListesiMousePressed

    private void tblUrunListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUrunListesiMouseClicked

    }//GEN-LAST:event_tblUrunListesiMouseClicked

    private void tblUrunListesiVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblUrunListesiVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUrunListesiVetoableChange

    private void tblKategoriListesiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriListesiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKategoriListesiMousePressed

    private void tblKategoriListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriListesiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKategoriListesiMouseClicked

    private void tblKategoriListesiVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblKategoriListesiVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKategoriListesiVetoableChange

    private void tblsatislistesiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsatislistesiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblsatislistesiMousePressed

    private void tblsatislistesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsatislistesiMouseClicked
        itemDoldur3(comboboxKat);
        int row = tblsatislistesi.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Duzenlemek satiri seciniz!");
        } else {
            // silme işlemini yap
            try {

                String satirQery = "select adi ,kategori,ID from STOK where ID = '" + tblsatislistesi.getValueAt(row, 0) + "' ";

                ResultSet rs = db.baglan().executeQuery(satirQery);
                comboboxKat.getAction();
                comboboxKat.setSelectedItem(tblsatislistesi.getValueAt(row, 1).toString().trim());
                txtSatilan.setText(rs.getString("adi").toString());
                urunid.setText(rs.getString("ID").toString());
                JOptionPane.showMessageDialog(rootPane, "data  başarılı bir sekilde geldi");

            } catch (Exception e) {
                System.err.println("duzenleme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }        // TODO add your handli
    }//GEN-LAST:event_tblsatislistesiMouseClicked

    private void tblsatislistesiVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblsatislistesiVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblsatislistesiVetoableChange

    private void tblSatislisteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSatislisteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSatislisteMousePressed

    private void tblSatislisteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSatislisteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSatislisteMouseClicked

    private void tblSatislisteVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblSatislisteVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSatislisteVetoableChange

    private void tblFiltreListesiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFiltreListesiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFiltreListesiMousePressed

    private void tblFiltreListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFiltreListesiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFiltreListesiMouseClicked

    private void tblFiltreListesiVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblFiltreListesiVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFiltreListesiVetoableChange

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnMEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMEkleActionPerformed

        String adi = txtMAdi.getText().trim();
        String soyadi = txtMSoyadi.getText().trim();
        String telno = txtMNo.getText().trim();
        String adres = txtMAdres.getText().trim();

        if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adınızı giriniz");
            txtMAdi.requestFocus();
        } else if (soyadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen soyadı giriniz");
            txtMSoyadi.requestFocus();
        } else if (telno.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen telefon no giriniz");
            txtMNo.requestFocus();
        } else if (adres.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adres giriniz");
            txtMAdres.requestFocus();
        } else {
            try {
                // yazma işlemi yapılıyor
                String yazQuery = "insert into MUSTERI values(null, '" + adi + "', '" + soyadi + "', '" + telno + "', '" + adres + "' ) ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    dataGetir();
                    
                    txtMAdi.setText("");
                    txtMSoyadi.setText("");
                    txtMNo.setText("");
                    txtMAdres.setText("");
                    txtMNo.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {
                db.kapat();
            }

        }
    }//GEN-LAST:event_btnMEkleActionPerformed

    private void btnMSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSilActionPerformed
        int row = tblMusteri.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Silmek icin musteri seciniz!");
        } else {
            // silme işlemini yap
            try {

                String silQuery = "delete from MUSTERI where ID = '" + tblMusteri.getValueAt(row, 0) + "' ";
                int silSonuc = db.baglan().executeUpdate(silQuery);
                if (silSonuc > 0) {
                    dataGetir();
                    JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Silme hatası !");
                }
            } catch (Exception e) {
                System.err.println("Silme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
    }//GEN-LAST:event_btnMSilActionPerformed
    }
    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        int row = tblMusteri.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Duzenlemek istediginiz musteri seciniz!");
        } else {
            // silme işlemini yap
            try {

                String satirQery = "select * from MUSTERI where ID = '" + tblMusteri.getValueAt(row, 0) + "' ";

                ResultSet rs = db.baglan().executeQuery(satirQery);
                txtAguncel3.setText(rs.getString("adi"));
                txtAguncel2.setText(rs.getString("soyadi"));
                txtAguncel.setText(rs.getString("telno"));
                txtAguncel1.setText(rs.getString("adres"));

               

            } catch (Exception e) {
                System.err.println("duzenleme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }
    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void txtAguncel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAguncel3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAguncel3ActionPerformed

    private void btnMGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMGuncelleActionPerformed

        String adi = txtAguncel3.getText();
        String soyadi = txtAguncel2.getText();
        String telno = txtAguncel.getText();
        String adres = txtAguncel1.getText();
        if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adınızı giriniz");
            txtAguncel3.requestFocus();
        } else if (soyadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen soyadı giriniz");
            txtAguncel2.requestFocus();
        } else if (telno.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen telefon no giriniz");
            txtAguncel.requestFocus();
        } else if (adres.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adres giriniz");
            txtAguncel1.requestFocus();
        } else {
            try {
                int row = tblMusteri.getSelectedRow();
                String updateQuery = "update  MUSTERI set adi= '" + adi + "',"
                        + "soyadi= '" + soyadi + "',telno= '" + telno + "',"
                        + "adres= '" + adres + "'where ID='" + tblMusteri.getValueAt(row, 0) + "'";
                int yazSonuc = db.baglan().executeUpdate(updateQuery);
                if (yazSonuc > 0) {
                    dataGetir();
                    JOptionPane.showMessageDialog(rootPane, "Update işlemi başarılı");
                    txtAguncel1.setText("");
                    txtAguncel.setText("");
                    txtAguncel2.setText("");
                    txtAguncel3.setText("");
                    txtAguncel3.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {
                db.kapat();
            }        // TODO add your handling code here:
    }//GEN-LAST:event_btnMGuncelleActionPerformed
    }
    private void btnDegistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDegistirActionPerformed

        try {
            String satirQery = "select sifre from KULLANICI where ID = '" + LOGIN_ID + "' ";
            ResultSet rs = db.baglan().executeQuery(satirQery);
            String sifre = rs.getString("sifre");
            String yenisifre = pswYeniSifre.getText();
            String onay = sifreonay.getText();
            String eskiSifre = pswEskiSifre.getText();
            if (sifre.equalsIgnoreCase("")||yenisifre.equalsIgnoreCase("")||onay.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(rootPane, "Sifre alanlari bos  olamaz! ");
            }
            else if (!eskiSifre.equalsIgnoreCase(sifre)) {
                JOptionPane.showMessageDialog(rootPane, "Gerekli alanlar bos eksik ya da hatali");
                pswYeniSifre.setText("");
                    sifreonay.setText("");
                    pswEskiSifre.setText("");
            } else if (!yenisifre.equalsIgnoreCase(onay)) {
                JOptionPane.showMessageDialog(rootPane, "onay sifreleri uyumsuz");
                pswYeniSifre.setText("");
                    sifreonay.setText("");
                    pswEskiSifre.setText("");
            } 
            else if (rs.isClosed()) {
                JOptionPane.showMessageDialog(rootPane, "bilgileerinizi kontrol ediniz");
                 pswYeniSifre.setText("");
                    sifreonay.setText("");
                    pswEskiSifre.setText("");
            } 
            else {
                String updateQuery = "update  KULLANICI set sifre= '" + yenisifre + "'";
                int yazSonuc = db.baglan().executeUpdate(updateQuery);
                if (yazSonuc > 0) {

                    JOptionPane.showMessageDialog(rootPane, "Update işlemi başarılı");
                    pswYeniSifre.setText("");
                    sifreonay.setText("");
                    pswEskiSifre.setText("");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnDegistirActionPerformed

    private void pswEskiSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswEskiSifreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswEskiSifreActionPerformed

    private void btnKategoriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriEkleActionPerformed
        String adi = txtKategoriAdi1.getText().trim();
        String aciklama = txtKategoriAciklama1.getText().trim();

        if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kategori adi giriniz");
            txtKategoriAdi1.requestFocus();
        } else if (aciklama.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kategori aciklamasi giriniz");
            txtKategoriAciklama1.requestFocus();
        } else {
            try {
                // yazma işlemi yapılıyor
                String yazQuery = "insert into KATEGORI values(null, '" + adi + "', '" + aciklama + "' ) ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    dataGetir();
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarılı");
                    txtKategoriAdi1.setText("");
                    txtKategoriAciklama1.setText("");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {
                db.kapat();
            }
            dataGetir2();
    }//GEN-LAST:event_btnKategoriEkleActionPerformed
    }
    private void btnKatogoriDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKatogoriDuzenleActionPerformed
        int row = tblKategoriListesi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Duzenlemek satir seciniz!");
        } else {
            // silme işlemini yap

            String satirQery = "select  * from KATEGORI where ID = '" + tblKategoriListesi.getValueAt(row, 0).toString() + "' ";

            try {
                ResultSet rs = db.baglan().executeQuery(satirQery);
                guncelAd.setText(rs.getString("adi"));
                guncelAciklama.setText(rs.getString("aciklama"));

                JOptionPane.showMessageDialog(rootPane, "data  başarılı bir sekilde geldi");

            } catch (Exception e) {
                System.err.println("duzenleme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnKatogoriDuzenleActionPerformed

    private void btnKategoriGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriGuncelleActionPerformed
        String adi = guncelAd.getText();
        String aciklama = guncelAciklama.getText();

        if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adınızı giriniz");
            guncelAd.requestFocus();
        } else if (aciklama.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen aciklama giriniz");
            guncelAciklama.requestFocus();

        } else {
            try {
                int row = tblKategoriListesi.getSelectedRow();
                String updateQuery = "update  KATEGORI set adi= '" + adi + "',"
                        + "aciklama= '" + aciklama + "'where ID='" + tblKategoriListesi.getValueAt(row, 0) + "'";
                int yazSonuc = db.baglan().executeUpdate(updateQuery);
                if (yazSonuc > 0) {
                    dataGetir2();
                    JOptionPane.showMessageDialog(rootPane, "Update işlemi başarılı");
                    guncelAciklama.setText("");
                    guncelAd.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {

                db.kapat();
            }        // TODO add you        // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriGuncelleActionPerformed
    }
    private void btnKategoriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriSilActionPerformed
        int row = tblKategoriListesi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Silmek icin satir  seciniz!");
        } else {
            // silme işlemini yap
            try {

                String silQuery = "delete from KATEGORI where ID = '" + tblKategoriListesi.getValueAt(row, 0) + "' ";
                int silSonuc = db.baglan().executeUpdate(silQuery);
                if (silSonuc > 0) {
                    dataGetir2();
                    JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Silme hatası !");
                }
            } catch (Exception e) {
                System.err.println("Silme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }                                    // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriSilActionPerformed

    private void comboUrunKatogoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUrunKatogoriMouseClicked
        itemDoldur(comboUrunKatogori);
    }//GEN-LAST:event_comboUrunKatogoriMouseClicked

    private void btnUrunEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunEkleActionPerformed
        String kategori = comboUrunKatogori.getSelectedItem().toString().trim();
        String urunadi = txtUrunAdi.getText().trim();
        String miktar = txtStokMiktari.getText().trim();
        String maliyet = txtMaliyet.getText().trim();
        String satisfiyat = txtSatisfiyat.getText().trim();

        if (kategori.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kategori giriniz");

        } else if (urunadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen urun adi giriniz");
            txtUrunAdi.requestFocus();
        } else if (miktar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen miktar  giriniz");
            txtStokMiktari.requestFocus();
        } else if (maliyet.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen birim fiyati giriniz");
            txtMaliyet.requestFocus();
        } else if (satisfiyat.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen satis fiyati giriniz");
            txtSatisfiyat.requestFocus();
        } else {
            try {
                // yazma işlemi yapılıyor
                String yazQuery = "insert into STOK values(null, '" + kategori + "', '" + urunadi + "', '" + miktar + "', '" + maliyet + "' , '" + satisfiyat + "' ) ";

                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    dataGetir();
                  
                    txtUrunAdi.setText("");
                    txtStokMiktari.setText("");
                    txtMaliyet.setText("");
                    txtSatisfiyat.setText("");
                   
                    dataGetir3();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {
                db.kapat();
            }

        }

    }//GEN-LAST:event_btnUrunEkleActionPerformed

    private void btnUrunSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunSilActionPerformed
        int row = tblUrunListesi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Silmek icin satir seciniz!");
        } else {
            // silme işlemini yap
            try {

                String silQuery = "delete from STOK where ID = '" + tblUrunListesi.getValueAt(row, 0) + "' ";
                int silSonuc = db.baglan().executeUpdate(silQuery);
                if (silSonuc > 0) {
                    dataGetir3();
                    JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Silme hatası !");
                }
            } catch (Exception e) {
                System.err.println("Silme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }                                             // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunSilActionPerformed

    private void btnUrunDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunDuzenleActionPerformed

        itemDoldur(comboUrunKatogori2);
        int row = tblUrunListesi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Duzenlemek istediginiz ogeyi seciniz!");
        } else {
            // silme işlemini yap
            try {

                String satirQery = "select * from STOK where ID = '" + tblUrunListesi.getValueAt(row, 0) + "' ";

                ResultSet rs = db.baglan().executeQuery(satirQery);

                comboUrunKatogori2.setSelectedItem(rs.getString("kategori"));
                txtAdiGuncel.setText(rs.getString("adi"));
                jTextField14.setText(rs.getString("miktar"));
                txtMaliyetGuncel.setText(rs.getString("maliyet"));
                txtsSatisFiyatiGncel.setText(rs.getString("satisfiyati"));
                JOptionPane.showMessageDialog(rootPane, "data  başarılı bir sekilde geldi");

            } catch (Exception e) {
                System.err.println("duzenleme hatası : " + e);
            } finally {
                db.kapat();
            }

            System.out.println();
// TODO add your handling code here:
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunDuzenleActionPerformed

    private void btnUrunGuncelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunGuncelActionPerformed
        String kategori = comboUrunKatogori2.getSelectedItem().toString();
        String adi = txtAdiGuncel.getText();
        String miktar = jTextField14.getText();
        String maliyet = txtMaliyetGuncel.getText();
        String satisfiyati = txtsSatisFiyatiGncel.getText();
        if (kategori.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adınızı giriniz");
            comboUrunKatogori2.requestFocus();
        } else if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen soyadı giriniz");
            txtAdiGuncel.requestFocus();
        } else if (miktar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen telefon no giriniz");
            jTextField14.requestFocus();
        } else if (maliyet.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adres giriniz");
            txtMaliyetGuncel.requestFocus();

        } else if (satisfiyati.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen adres giriniz");
            txtsSatisFiyatiGncel.requestFocus();

        } else {
            try {
                int row = tblUrunListesi.getSelectedRow();
                String updateQuery = "update  STOK set kategori= '" + kategori + "',"
                        + "adi= '" + adi + "',miktar= '" + miktar + "',"
                        + "maliyet= '" + maliyet + "',satisfiyati= '" + satisfiyati + "'where ID='" + tblUrunListesi.getValueAt(row, 0) + "'";
                int yazSonuc = db.baglan().executeUpdate(updateQuery);
                if (yazSonuc > 0) {
                    dataGetir3();
                    JOptionPane.showMessageDialog(rootPane, "Update işlemi başarılı");
                    comboUrunKatogori2.setSelectedIndex(0);
                    txtAdiGuncel.setText("");
                    jTextField14.setText("");
                    txtMaliyetGuncel.setText("");
                    txtsSatisFiyatiGncel.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                }
            } catch (SQLException ex) {
                System.err.println("Yazma Hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                }
            } finally {
                db.kapat();
            }        // TODO add your handling code here:
        }                                                   // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunGuncelActionPerformed

    private void comboUrunKatogori2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUrunKatogori2MouseClicked
        itemDoldur(comboUrunKatogori2);
    }//GEN-LAST:event_comboUrunKatogori2MouseClicked

    private void comboKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboKategoriMouseClicked
        itemDoldur(comboKategori);        // TODO add your handling code here:
    }//GEN-LAST:event_comboKategoriMouseClicked

    private void btnUrunListeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunListeActionPerformed

        dataGetir4();
    }//GEN-LAST:event_btnUrunListeActionPerformed

    private void comboboxMusteriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxMusteriMouseClicked

        itemDoldur2(comboboxMusteri);        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxMusteriMouseClicked

    private void btnSatisTamamlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatisTamamlaActionPerformed
        if (txtSatilan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Secilen urun bos olamaz");
        } else if (txtMiktar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Miktar  bos olamaz");
        } else if (comboboxMusteri.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Musteri  bos olamaz");
        } else {
            String gecici = txtSatilan.getText();
            String fiyatQery = "select satisfiyati,miktar from STOK where adi='" + gecici + "'";
            try {

                ResultSet rs = db.baglan().executeQuery(fiyatQery);
                String smiktar = rs.getString("miktar");
                int smiktarto = Integer.parseInt(smiktar);
                String fiyat = rs.getString("satisfiyati");
                int satisfiyat = Integer.parseInt(fiyat);
                int miktar = Integer.parseInt(txtMiktar.getText().trim());
                if (miktar == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Stokta  urun kalmadi");
                } else if (miktar > smiktarto) {
                    JOptionPane.showMessageDialog(rootPane, "Stokta bu kadar urun kalmadi ancak   " + smiktarto + "  kadar alabilirsiniz");
                    txtMiktar.setText("");
                } else {
                    tutar = miktar * satisfiyat;
                    smiktarto = smiktarto - miktar; //guncel stok
                    System.out.println(smiktarto);

                    try {

                        Calendar simdi = Calendar.getInstance();
                        int ay = simdi.get(Calendar.MONTH); // Ağustos
                        int gun = simdi.get(Calendar.DATE);         // 24
                        int yil = simdi.get(Calendar.YEAR);         // 2014

                        String yazQuery = "insert into SATIS values(null, '" + comboboxKat.getSelectedItem().toString().trim() + "' ,'" + txtSatilan.getText() + "', '" + txtMiktar.getText().trim() + "' , '" + tutar + "' , '" + comboboxMusteri.getSelectedItem() + "','" + gun + "." + ay + "." + yil + "' ) ";
                        int yazSonuc = db.baglan().executeUpdate(yazQuery);
                        if (yazSonuc > 0) {

                            JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarılı");
                            db.kapat();

                            String updateQuery = "update  STOK set miktar= '" + smiktarto + "'where ID='" + urunid.getText().trim() + "'";
                            int yaz = db.baglan().executeUpdate(updateQuery);
                            if (yaz > 0) {

                                
                                dataGetir4();
                            }

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarısız oldu !");
                        }
                    } catch (SQLException ex) {
                        System.err.println("Yazma Hatası : " + ex);
                        if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                            JOptionPane.showMessageDialog(rootPane, "Aynı mail adresi ile kayıt yapılamaz !");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                db.kapat();
            }
        }

    }//GEN-LAST:event_btnSatisTamamlaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(jc);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeleActionPerformed


    }//GEN-LAST:event_btnListeleActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed

    }//GEN-LAST:event_btnListActionPerformed

    private void listeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeleActionPerformed

        if (urun.isSelected()) {
            String ara = aranan.getText().trim();
            String t1 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime1.getDate());
            String t2 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime2.getDate());

            try {
                String arananDeger=aranan.getText().trim();
                System.out.println(arananDeger);
                String sqlKomut =" select *from SATIS WHERE secilenurun LIKE '%"+arananDeger+"%'AND tarih between '"+t1+"'and'"+t2+"'";
                System.out.println(sqlKomut);
                ResultSet rs = db.baglan().executeQuery(sqlKomut);
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("URUN");
                dtm.addColumn("SATIS ID");
                dtm.addColumn("MUSTERI ADI");
                dtm.addColumn("MIKTAR");
                dtm.addColumn("TUTAR");
                int toplam=0;
                // satırlara gelecek datalar alınıyor
                while (rs.next()) {
                    dtm.addRow(new String[]{rs.getString("secilenurun"), rs.getString("ID"), rs.getString("musteriadi"), rs.getString("miktar"), rs.getString("tutar")});
                   String degisken= rs.getString("tutar");
                   int gecici=Integer.parseInt(degisken);
                   toplam=toplam+gecici;
                    System.out.println(toplam);
                   
                }
                tblFiltreListesi.setModel(dtm);
                txtSonuc.setText(""+toplam);
            } catch (Exception e) {
                System.err.println("Data getirme hatası : " + e);
            } finally {
                db.kapat();
            }
        } else if (musteri.isSelected()) {
            String ara = aranan.getText().trim();
            String t1 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime1.getDate());
            String t2 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime2.getDate());

            try {
                String arananDeger=aranan.getText().trim();
                System.out.println(arananDeger);
                String sqlKomut =" select *from SATIS WHERE musteriadi LIKE '%"+arananDeger+"%'AND tarih between '"+t1+"'and'"+t2+"'";
                ResultSet rs = db.baglan().executeQuery(sqlKomut);
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("MUSTERI ADI");
                dtm.addColumn("SATIS ID");
                dtm.addColumn("SECILEN URUN");
                dtm.addColumn("MIKTAR");
                dtm.addColumn("TUTAR");
                int toplam=0;// satırlara gelecek datalar alınıyor
                while (rs.next()) {
                    dtm.addRow(new String[]{rs.getString("musteriadi"), rs.getString("ID"), rs.getString("secilenurun"), rs.getString("miktar"), rs.getString("tutar")});
              String degisken= rs.getString("tutar");
                   int gecici=Integer.parseInt(degisken);
                   toplam=toplam+gecici;
                    System.out.println(toplam);
                }
                tblFiltreListesi.setModel(dtm);
                txtSonuc.setText(""+toplam);
            } catch (Exception e) {
                System.err.println("Data getirme hatası : " + e);
            } finally {
                db.kapat();
            }
            
        }
        else if (kategori.isSelected()) {
            String ara = aranan.getText().trim();
            String t1 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime1.getDate());
            String t2 = new SimpleDateFormat("dd.MM.yyyy").format(dateTime2.getDate());

            try {
                String arananDeger=aranan.getText().trim();
                System.out.println(arananDeger);
                String sqlKomut =" select *from SATIS WHERE kategori LIKE '%"+arananDeger+"%'AND tarih between '"+t1+"'and'"+t2+"'";
                ResultSet rs = db.baglan().executeQuery(sqlKomut);
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("KATEGORI");
                 dtm.addColumn("SATISID");
                dtm.addColumn("URUN ADI");
                dtm.addColumn("MIKTARI");
                dtm.addColumn("TUTAR");
                dtm.addColumn("MUSTERI ADI");
                // satırlara gelecek datalar alınıyor
                 int toplam=0;// satırlara gelecek datalar alınıyor
                while (rs.next()) {
                    dtm.addRow(new String[]{rs.getString("kategori"), rs.getString("ID"), rs.getString("secilenurun"), rs.getString("miktar"), rs.getString("tutar"), rs.getString("musteriadi")});
              String degisken= rs.getString("tutar");
                   int gecici=Integer.parseInt(degisken);
                   toplam=toplam+gecici;
                    System.out.println(toplam);
                }
                tblFiltreListesi.setModel(dtm);
                txtSonuc.setText(""+toplam);
            } catch (Exception e) {
                System.err.println("Data getirme hatası : " + e);
            } finally {
                db.kapat();
            }}
    }//GEN-LAST:event_listeleActionPerformed

    private void comboboxKatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxKatMouseClicked
        itemDoldur3(comboboxKat);        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxKatMouseClicked

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
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaSayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aranan;
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnDegistir;
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnKategoriEkle;
    private javax.swing.JButton btnKategoriGuncelle;
    private javax.swing.JButton btnKategoriSil;
    private javax.swing.JButton btnKatogoriDuzenle;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnListe;
    private javax.swing.JButton btnListele;
    private javax.swing.JButton btnMEkle;
    private javax.swing.JButton btnMGuncelle;
    private javax.swing.JButton btnMSil;
    private javax.swing.JButton btnSatisTamamla;
    private javax.swing.JButton btnUrunDuzenle;
    private javax.swing.JButton btnUrunEkle;
    private javax.swing.JButton btnUrunGuncel;
    private javax.swing.JButton btnUrunListe;
    private javax.swing.JButton btnUrunSil;
    private javax.swing.JButton btnsSatisTamam;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboKategori;
    private javax.swing.JComboBox<String> comboMusteri;
    private javax.swing.JComboBox<String> comboUrunKatogori;
    private javax.swing.JComboBox<String> comboUrunKatogori1;
    private javax.swing.JComboBox<String> comboUrunKatogori2;
    private javax.swing.JComboBox<String> comboboxKat;
    private javax.swing.JComboBox<String> comboboxMusteri;
    private com.toedter.calendar.JDateChooser dateTime1;
    private com.toedter.calendar.JDateChooser dateTime2;
    private javax.swing.JTextField guncelAciklama;
    private javax.swing.JTextField guncelAd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JPanel jc;
    private javax.swing.JRadioButton kategori;
    private javax.swing.JButton listele;
    private javax.swing.JRadioButton musteri;
    private javax.swing.JPasswordField pswEskiSifre;
    private javax.swing.JPasswordField pswYeniSifre;
    private javax.swing.JLabel sKategori;
    private javax.swing.JPasswordField sifreonay;
    private javax.swing.JTable tblFiltreListesi;
    private javax.swing.JTable tblKategoriListesi;
    private javax.swing.JTable tblMusteri;
    private javax.swing.JTable tblSatisliste;
    private javax.swing.JTable tblUrunListesi;
    private javax.swing.JTable tblsatislistesi;
    private javax.swing.JTextField txtAdiGuncel;
    private javax.swing.JTextField txtAguncel;
    private javax.swing.JTextField txtAguncel1;
    private javax.swing.JTextField txtAguncel2;
    private javax.swing.JTextField txtAguncel3;
    private javax.swing.JTextField txtIkinciay;
    private javax.swing.JTextField txtIkincigun;
    private javax.swing.JTextField txtIkinciyil;
    private javax.swing.JTextField txtIlkay;
    private javax.swing.JTextField txtIlkyil;
    private javax.swing.JTextField txtKategoriAciklama1;
    private javax.swing.JTextField txtKategoriAdi1;
    private javax.swing.JTextField txtMAdi;
    private javax.swing.JTextField txtMAdres;
    private javax.swing.JTextField txtMNo;
    private javax.swing.JTextField txtMSoyadi;
    private javax.swing.JTextField txtMaliyet;
    private javax.swing.JTextField txtMaliyetGuncel;
    private javax.swing.JTextField txtMiktar;
    private javax.swing.JTextField txtSatilan;
    private javax.swing.JTextField txtSatisMiktar;
    private javax.swing.JTextField txtSatisMiktar1;
    private javax.swing.JTextField txtSatisfiyat;
    private javax.swing.JTextField txtSonuc;
    private javax.swing.JTextField txtStokMiktari;
    private javax.swing.JTextField txtUrunAdi;
    private javax.swing.JTextField txtilkGun;
    private javax.swing.JTextField txtsSatisFiyatiGncel;
    private javax.swing.JRadioButton urun;
    private javax.swing.JTextField urunid;
    // End of variables declaration//GEN-END:variables
}
