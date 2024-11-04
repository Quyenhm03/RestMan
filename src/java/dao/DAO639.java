/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAO639 {
    public static Connection con;

    public DAO639(){
        if(con == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO639.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:sqlserver://localhost:1433; databaseName=RestMan;"
                    + "user=sa;password=123;"
                    + "encrypt=true;trustServerCertificate=true";
            try {    
                
                con = DriverManager.getConnection(url);   
            } 
            catch (SQLException e) {
                e.printStackTrace();
            } 
        }
    }
  
}
