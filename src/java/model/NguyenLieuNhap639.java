/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class NguyenLieuNhap639 {
    private int id, soLuong;
    private float thanhTien;
    private NguyenLieu639 nguyenLieu;

    public NguyenLieuNhap639() {
    }

    public NguyenLieuNhap639(int id, int soLuong, float thanhTien, NguyenLieu639 nguyenLieu) {
        this.id = id;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.nguyenLieu = nguyenLieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public NguyenLieu639 getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu639 nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
    
}
