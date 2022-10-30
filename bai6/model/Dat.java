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
public class Dat extends GiaoDich implements Serializable, IGiaoDich {

    private double donGia, soLuong;
    private String loaiDat;

    public Dat() {
    }

    public Dat(double donGia, double soLuong, String loaiDat) {
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiDat = loaiDat;
    }

    public Dat(double donGia, double soLuong, String loaiDat, String id, String ngay) {
        super(id, ngay);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiDat = loaiDat;
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

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
    public double heSo(){
        if(loaiDat.equals("1")) return 200.0;
        if(loaiDat.equals("2")) return 400.0;
        return 800.0;
    }
    @Override
    public double thanhTien() {
        return donGia * soLuong * heSo();
    }

    @Override
    public String toString() {
        return super.getId() + "\t" + super.getNgay() + "\t" + this.loaiDat + "\t" + String.format("%.4f", this.thanhTien());
    }

}
