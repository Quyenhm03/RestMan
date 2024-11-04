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
import model.Combo639;
import model.ComboDat639;

/**
 *
 * @author DELL
 */
public class ComboDatDAO639 {
    private float tongTien = 0;

    public ComboDatDAO639() {
    }
    
    public List<ComboDat639> getDSComboDat(int idbanDat) {
        List<ComboDat639> list = new ArrayList<>();      

        String sql = "SELECT \n" +
                    "    tblComboDat639.ID AS ComboDatID,\n" +
                    "    tblComboDat639.soLuong AS SoLuong,\n" +
                    "    tblComboDat639.thanhTien AS ThanhTien,\n" +
                    "    tblCombo639.ID AS ComboID,\n" +
                    "    tblCombo639.ten AS TenCombo,\n" +
                    "    tblCombo639.donGia AS DonGia\n" +
                    "FROM tblComboDat639\n" +
                    "INNER JOIN tblCombo639 ON tblComboDat639.tblCombo639ID = tblCombo639.ID\n" +
                    "WHERE tblComboDat639.tblBanDat639ID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, String.valueOf(idbanDat));
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ComboDat639 comboDat = new ComboDat639();
                comboDat.setId(rs.getInt("ComboDatID"));
                comboDat.setSoLuong(rs.getInt("SoLuong"));
                comboDat.setThanhTien(rs.getFloat("ThanhTien"));
               
                Combo639 combo = new Combo639();
                combo.setId(rs.getInt("ComboID"));
                combo.setTen(rs.getString("TenCombo"));
                combo.setDonGia(rs.getFloat("DonGia"));
              
                comboDat.setCombo(combo);

                this.tongTien += rs.getFloat("ThanhTien");
                list.add(comboDat);
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
