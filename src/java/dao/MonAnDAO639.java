/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO639.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MonAn639;

/**
 *
 * @author DELL
 */
public class MonAnDAO639 extends DAO639{

    public MonAnDAO639() {
    }
    
    public List<MonAn639> getDSMonAn(String tenMonAn) {
        List<MonAn639> list = new ArrayList<>();
        String sql = "SELECT * FROM tblMonAn639 WHERE LOWER(ten) LIKE LOWER(?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, "%" + tenMonAn + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                MonAn639 mon = new MonAn639();
                mon.setId(rs.getInt("ID"));
                mon.setTen(rs.getString("ten"));
                mon.setDonGia(rs.getFloat("donGia"));
                mon.setMoTa(rs.getString("moTa"));
                mon.setAnh(rs.getString("anh"));
                list.add(mon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
    
    public MonAn639 getMonAn(int idMonAn) {
        MonAn639 mon = new MonAn639();
        String sql = "SELECT * FROM tblMonAn639 WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, String.valueOf(idMonAn));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {               
                mon.setId(rs.getInt("ID"));
                mon.setTen(rs.getString("ten"));
                mon.setDonGia(rs.getFloat("donGia"));
                mon.setMoTa(rs.getString("moTa"));
                mon.setAnh(rs.getString("anh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return mon;
    }
    
    public static void main(String[] args) {
        MonAnDAO639 tmp = new MonAnDAO639();
        MonAn639 mon = tmp.getMonAn(1);
        System.out.println(mon.getId() + " " + mon.getTen() + " " + mon.getAnh());
    }
}
