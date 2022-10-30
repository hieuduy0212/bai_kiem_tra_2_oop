/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4.model;

import java.io.Serializable;

/**
 *
 * @author HieuDuy
 */
public class GiangVien implements Serializable {
    
    private String id, ten, email, hocHam, hocVi, diaChi, dienThoai;
    private double soGioDay, heSoLuong;

    public GiangVien() {
    }

    public GiangVien(String id, String ten, String email, String hocHam, String hocVi, String diaChi, String dienThoai, double soGioDay, double heSoLuong) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.hocHam = hocHam;
        this.hocVi = hocVi;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.soGioDay = soGioDay;
        this.heSoLuong = heSoLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public double getSoGioDay() {
        return soGioDay;
    }

    public void setSoGioDay(double soGioDay) {
        this.soGioDay = soGioDay;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    
}
