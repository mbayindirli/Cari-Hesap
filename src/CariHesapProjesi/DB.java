/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CariHesapProjesi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    
    final private String url = "org.sqlite.JDBC";
    final private String db = "jdbc:sqlite:db/";
    private String dbName = "CARDATA.db";
    
    private Connection conn = null;
    private Statement st = null;

    public DB() {
    }
    
    public DB(String dbName) {
        this.dbName = dbName;
    }
    
    // bağlan methodu kuruluyor
    public Statement baglan() {
        if(st!=null&&conn!=null)
        {
            kapat();
        }
        
        try {
            Class.forName(url);
            conn = DriverManager.getConnection(db+dbName);
            st = conn.createStatement();
            System.out.println("Bağlantı başarılı");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Bağlantı Hatası : " + e);
        }
        return st;
    }
    
    
    // bağlantı kapat
    public void kapat() {
        if(st != null && conn != null) {
            try {
                st.close();
                conn.close();
                st = null;
                conn = null;
                System.out.println("Kapatma Yapıldı");
            } catch (SQLException e) {
                System.err.println("Kapatma Hatası : " + e);
            }
        }
    }
    
}