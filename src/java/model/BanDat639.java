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
public class BanDat639 {
    private int id;
    private Date ngayDat, gioBatDau, gioKetThuc;
    private String ghiChu;
    private int trangThai; // trạng thái duyệt
    private Ban639 ban;
    private KhachHang639 khachHang;
    private List<MonAnDat639> monAnDat;
    private List<ComboDat639> ComboDat;

    public BanDat639() {
    }

    public BanDat639(int id) {
        this.id = id;
    }
    
    
    public BanDat639(int id, Date ngayDat, Date gioBatDau, Date gioKetThuc, String ghiChu, int trangThai, Ban639 ban, KhachHang639 khachHang, List<MonAnDat639> monAnDat, List<ComboDat639> ComboDat) {
        this.id = id;
        this.ngayDat = ngayDat;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.ban = ban;
        this.khachHang = khachHang;
        this.monAnDat = monAnDat;
        this.ComboDat = ComboDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Date getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Ban639 getBan() {
        return ban;
    }

    public void setBan(Ban639 ban) {
        this.ban = ban;
    }

    public KhachHang639 getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang639 khachHang) {
        this.khachHang = khachHang;
    }

    public List<MonAnDat639> getMonAnDat() {
        return monAnDat;
    }

    public void setMonAnDat(List<MonAnDat639> monAnDat) {
        this.monAnDat = monAnDat;
    }

    public List<ComboDat639> getComboDat() {
        return ComboDat;
    }

    public void setComboDat(List<ComboDat639> ComboDat) {
        this.ComboDat = ComboDat;
    }
}
