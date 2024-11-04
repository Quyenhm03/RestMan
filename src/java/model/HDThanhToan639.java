/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class HDThanhToan639 {
    private int id;
    private Date ngayTao;
    private float tongTien;
    private String ghiChu;
    private NVBanHang639 nvBanHang;
    private BanDat639 banDat;

    public HDThanhToan639() {
    }
   
    public HDThanhToan639(float tongTien, NVBanHang639 nvBanHang, BanDat639 banDat) {       
        this.ngayTao = new Date();
        this.tongTien = tongTien;
        this.nvBanHang = nvBanHang;
        this.banDat = banDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BanDat639 getBanDat() {
        return banDat;
    }

    public void setBanDat(BanDat639 banDat) {
        this.banDat = banDat;
    }  
       
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChuHD) {
        this.ghiChu = ghiChuHD;
    }

    public NVBanHang639 getNvBanHang() {
        return nvBanHang;
    }

    public void setNvBanHang(NVBanHang639 nvBanHang) {
        this.nvBanHang = nvBanHang;
    }
    
}
