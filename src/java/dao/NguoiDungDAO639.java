/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.NguoiDung639;

/**
 *
 * @author DELL
 */
public class NguoiDungDAO639 extends DAO639{

    public NguoiDungDAO639() {
    }
    
    public boolean ktraDangNhap(NguoiDung639 nd){
        boolean kq = false;
        String sql = "SELECT* FROM tblNguoiDung639 WHERE tenDangNhap = ? AND matKhau = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, nd.getTenDangNhap());
            ps.setString(2, nd.getMatKhau());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                nd.setId(rs.getInt("ID"));
                nd.setVaiTro(rs.getInt("vaiTro"));
                nd.setHoTen(rs.getString("hoten"));
                kq = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            kq = false;
        } 
        
        return  kq;
    }
    
//    public NguoiDung639 getNguoiDung(int idNguoiDung) {
//        NguoiDung639 nd = new NguoiDung639();
//        String sql = "SELECT * FROM tblNguoiDung639 WHERE ID = ?";
//        
//         try {
//            PreparedStatement ps = con.prepareStatement(sql);    
//            ps.setString(1, String.valueOf(idNguoiDung));
//            ResultSet rs = ps.executeQuery();
//            
//            if(rs.next()) {   
//                nd.setId(rs.getInt("ID"));
//                nd.setHoTen(rs.getString("hoten"));                     
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
//        return nd;
//    }
}
