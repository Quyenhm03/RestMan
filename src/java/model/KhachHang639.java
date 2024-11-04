/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class KhachHang639 extends NguoiDung639{

    public KhachHang639(int id, String hoTen, String tenDangNhap, String matKhau, String ngaySinh, String diaChi, String sdt, String email, String moTa, int vaiTro) {
        super(id, hoTen, tenDangNhap, matKhau, ngaySinh, diaChi, sdt, email, moTa, vaiTro);
    } 

    public KhachHang639(int id, String hoTen, String sdt) {
        super(id, hoTen, sdt);
    }
  
}
