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
import model.BanDat639;
import model.MonAn639;
import model.MonAnDat639;

/**
 *
 * @author DELL
 */
public class MonAnDatDAO639 {
    
    private float tongTien = 0;

    public MonAnDatDAO639() {
    }
    
    public List<MonAnDat639> getDSMonAnDat(int idbanDat) {
        List<MonAnDat639> list = new ArrayList<>();      

        String sql = "SELECT \n" +
                    "    tblMonAnDat639.ID AS MonAnDatID,\n" +
                    "    tblMonAnDat639.soLuong AS SoLuong,\n" +
                    "    tblMonAnDat639.thanhTien AS ThanhTien,\n" +
                    "    tblMonAn639.ID AS MonAnID,\n" +
                    "    tblMonAn639.ten AS TenMon,\n" +
                    "    tblMonAn639.donGia AS DonGia\n" +
                    "FROM tblMonAnDat639\n" +
                    "INNER JOIN tblMonAn639 ON tblMonAnDat639.tblMonAn639ID = tblMonAn639.ID\n" +
                    "WHERE tblMonAnDat639.tblBanDat639ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, String.valueOf(idbanDat));
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                MonAnDat639 monDat = new MonAnDat639();
                monDat.setId(rs.getInt("MonAnDatID"));
                monDat.setSoLuong(rs.getInt("SoLuong"));
                monDat.setThanhTien(rs.getFloat("ThanhTien"));
               
                MonAn639 monAn = new MonAn639();
                monAn.setId(rs.getInt("MonAnID"));
                monAn.setTen(rs.getString("TenMon"));
                monAn.setDonGia(rs.getFloat("DonGia"));
              
                monDat.setMonAn(monAn);

                this.tongTien += rs.getFloat("ThanhTien");
                list.add(monDat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return list;        
    }

    public float getTongTien() {
        return tongTien;
    }
 
}
