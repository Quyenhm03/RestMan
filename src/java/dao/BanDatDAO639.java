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
import model.Ban639;
import model.BanDat639;
import model.KhachHang639;
import model.MonAn639;
import model.NguoiDung639;

/**
 *
 * @author DELL
 */
public class BanDatDAO639 extends DAO639{   
       
    public BanDatDAO639() {
    }
    
    public List<BanDat639> getDSBanDat(String tenBan) {
        List<BanDat639> list = new ArrayList<>();
        String sql = "SELECT \n" +
                     "    tblBan639.ID AS BanID, \n" +
                     "    tblBan639.ten AS TenBan,\n" +
                     "    tblBanDat639.ID AS BanDatID, \n" +
                     "    tblBanDat639.ngayDat AS NgayDat, \n" +
                     "    tblBanDat639.gioBatDau AS GioBatDau, \n" +
                     "    tblBanDat639.gioKetThuc AS GioKetThuc\n" +
                     "FROM tblBanDat639\n" +
                     "INNER JOIN tblBan639 ON tblBanDat639.tblBan639ID = tblBan639.ID\n" +
                     "WHERE LOWER(tblBan639.ten) LIKE LOWER(?) AND tblBanDat639.trangThai = 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, "%" + tenBan + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Ban639 ban = new Ban639();
                ban.setId(rs.getInt("BanID"));
                ban.setTen(rs.getString("TenBan"));
                
                BanDat639 banDat = new BanDat639();
                banDat.setId(rs.getInt("BanDatID"));
                banDat.setNgayDat(rs.getDate("NgayDat"));
                banDat.setGioBatDau(rs.getTime("GioBatDau"));
                banDat.setGioKetThuc(rs.getTime("GioKetThuc"));
                banDat.setBan(ban);
                
                list.add(banDat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return list;
    }
    
    public BanDat639 getBanDat(int idBanDat) {
        BanDat639 banDat = new BanDat639();       
        int idKH = 0;
        
        String sql1 = "SELECT \n" +
                     "    tblBan639.ID AS BanID, \n" +
                     "    tblBan639.ten AS TenBan,\n" +
                     "    tblBanDat639.ID AS BanDatID, \n" +
                     "    tblBanDat639.ngayDat AS NgayDat, \n" +
                     "    tblBanDat639.gioBatDau AS GioBatDau, \n" +
                     "    tblBanDat639.gioKetThuc AS GioKetThuc,\n" +
                     "    tblBanDat639.tblKhachHang639ID AS KhachHangID\n" +
                     "FROM tblBanDat639\n" +
                     "INNER JOIN tblBan639 ON tblBanDat639.tblBan639ID = tblBan639.ID\n" +
                     "WHERE tblBanDat639.ID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql1);    
            ps.setString(1, String.valueOf(idBanDat));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {               
                Ban639 ban = new Ban639();
                ban.setId(rs.getInt("BanID"));
                ban.setTen(rs.getString("TenBan"));
                System.out.println(rs.getInt("BanID") + " " + rs.getString("TenBan"));
                                
                banDat.setId(rs.getInt("BanDatID"));
                banDat.setNgayDat(rs.getDate("NgayDat"));
                banDat.setGioBatDau(rs.getTime("GioBatDau"));
                banDat.setGioKetThuc(rs.getTime("GioKetThuc"));
                idKH = rs.getInt("KhachHangID");              
                banDat.setBan(ban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        String sql2 = "SELECT * FROM tblNguoiDung639 WHERE ID = ?";
        NguoiDung639 kh = new NguoiDung639();
        try {
            PreparedStatement ps = con.prepareStatement(sql2);    
            ps.setString(1, String.valueOf(idKH));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {                               
                kh.setId(rs.getInt("ID"));
                kh.setHoTen(rs.getString("hoten"));
                kh.setSdt(rs.getString("sdt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        banDat.setKhachHang(new KhachHang639(kh.getId(), kh.getHoTen(), kh.getSdt()));
        
        return banDat;
    }
    
    public static void main(String[] args) {
        BanDatDAO639 banDat = new BanDatDAO639();
        BanDat639 tmp = banDat.getBanDat(1);
        System.out.println(tmp);
    }
}

