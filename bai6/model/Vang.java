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
public class Vang extends GiaoDich implements Serializable, IGiaoDich {

    private double donGia, soLuong;
    private String loaiVang;

    public Vang() {
    }

    public Vang(double donGia, double soLuong, String loaiVang) {
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiVang = loaiVang;
    }

    public Vang(double donGia, double soLuong, String loaiVang, String id, String ngay) {
        super(id, ngay);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiVang = loaiVang;
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

    public String getLoaiVang() {
        return loaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }

    @Override
    public double thanhTien() {
        return this.soLuong * this.donGia;
    }

    @Override
    public String toString() {
        return super.getId() + "\t" + super.getNgay() + "\t" + this.loaiVang + "\t" + String.format("%.4f", this.thanhTien());
    }

}
