/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO639.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.BanDat639;
import model.HDThanhToan639;
import model.MonAn639;
import model.MonAnDat639;
import model.NVBanHang639;

/**
 *
 * @author DELL
 */
public class HDThanhToanDAO639 extends DAO639{

    public HDThanhToanDAO639() {
    }
           
    public boolean luuHDThanhToan(HDThanhToan639 hoaDon) {
        boolean res = false;
        String sql1 = "INSERT INTO tblHDThanhToan639(ngayTao, tongTien, tblBanDat639ID, tblNVBanHang639ID) VALUES(?,?,?,?)";
        String sql2 = "UPDATE tblBanDat639 SET trangThai = 2 WHERE ID = ?";

        try {            
            PreparedStatement ps = con.prepareStatement(sql1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, sdf.format(hoaDon.getNgayTao()));
            ps.setString(2, String.valueOf(hoaDon.getTongTien())); 
            ps.setString(3, String.valueOf(hoaDon.getBanDat().getId())); 
            ps.setString(4, String.valueOf(hoaDon.getNvBanHang().getId()));                   
            ps.executeUpdate();
         
            try {
                PreparedStatement psSua = con.prepareStatement(sql2);
                psSua.setString(1, String.valueOf(hoaDon.getBanDat().getId())); 
                psSua.executeUpdate(); 
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
            
            res = true; 
        } catch (SQLException e) {
            e.printStackTrace(); 
        } 

        return res; 
    }
    
    public static void main(String[] args) {
        HDThanhToanDAO639 tmp = new HDThanhToanDAO639();
        HDThanhToan639 hd = new HDThanhToan639(89000, new NVBanHang639(2, "abc"), new BanDat639(1));
        System.out.println(tmp.luuHDThanhToan(hd));
    }
}
