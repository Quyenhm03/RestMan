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
public class HDNhap639 {
    private int id;
    private Date ngayNhap;
    private float tongTien;
    private NhaCungCap639 ncc;
    private List<NguyenLieuNhap639> listNguyenLieuNhap;

    public HDNhap639() {
    }

    public HDNhap639(int id, Date ngayNhap, float tongTien, NhaCungCap639 ncc, List<NguyenLieuNhap639> listNguyenLieuNhap) {
        this.id = id;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.ncc = ncc;
        this.listNguyenLieuNhap = listNguyenLieuNhap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public NhaCungCap639 getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap639 ncc) {
        this.ncc = ncc;
    }

    public List<NguyenLieuNhap639> getListNguyenLieuNhap() {
        return listNguyenLieuNhap;
    }

    public void setListNguyenLieuNhap(List<NguyenLieuNhap639> listNguyenLieuNhap) {
        this.listNguyenLieuNhap = listNguyenLieuNhap;
    }
      
}
