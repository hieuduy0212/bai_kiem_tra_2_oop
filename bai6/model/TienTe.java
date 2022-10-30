/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.model;

import java.io.Serializable;

/**
 *
 * @author HieuDuy
 */
public class TienTe extends GiaoDich implements Serializable, IGiaoDich{

    private double donGia, soLuong, tiGia;
    private String loaiTienTe;

    public TienTe() {
    }

    public TienTe(double donGia, double soLuong, double tiGia, String loaiTienTe) {
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    public TienTe(double donGia, double soLuong, double tiGia, String loaiTienTe, String id, String ngay) {
        super(id, ngay);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getTiGia() {
        return tiGia;
    }

    public void setTiGia(double tiGia) {
        this.tiGia = tiGia;
    }

    public String getLoaiTienTe() {
        return loaiTienTe;
    }

    public void setLoaiTienTe(String loaiTienTe) {
        this.loaiTienTe = loaiTienTe;
    }

    @Override
    public double thanhTien() {
        if(loaiTienTe.equalsIgnoreCase("vn")) return donGia*soLuong;
        return donGia * soLuong * tiGia;
        
    }

    
    @Override
    public String toString() {
        return super.getId() + "\t" + super.getNgay() + "\t" + this.loaiTienTe + "\t" + String.format("%.4f", this.thanhTien());
    }
}
