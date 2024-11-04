/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class NguyenLieu639 {
    private int id;
    private String ten;   
    private float donGia;
    private String loai,moTag;

    public NguyenLieu639() {
    }

    public NguyenLieu639(int id, String ten, float donGia, String loai, String moTag) {
        this.id = id;
        this.ten = ten;     
        this.donGia = donGia;
        this.loai = loai;
        this.moTag = moTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMoTag() {
        return moTag;
    }

    public void setMoTag(String moTag) {
        this.moTag = moTag;
    }
       
}
