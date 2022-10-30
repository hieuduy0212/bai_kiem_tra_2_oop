/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4.model;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author HieuDuy
 */
public class GiangVienThinhGiang extends GiangVien implements Serializable, IGiangVien {

    private static double donGia = 200000;
    private String diaChiLamViec, dienThoaiLamViec;

    public GiangVienThinhGiang() {
    }

    public GiangVienThinhGiang(String diaChiLamViec, String dienThoaiLamViec) {
        this.diaChiLamViec = diaChiLamViec;
        this.dienThoaiLamViec = dienThoaiLamViec;
    }

    public GiangVienThinhGiang(String diaChiLamViec, String dienThoaiLamViec, String id, String ten, String email, String hocHam, String hocVi, String diaChi, String dienThoai, double soGioDay, double heSoLuong) {
        super(id, ten, email, hocHam, hocVi, diaChi, dienThoai, soGioDay, heSoLuong);
        this.diaChiLamViec = diaChiLamViec;
        this.dienThoaiLamViec = dienThoaiLamViec;
    }

    public String getDiaChiLamViec() {
        return diaChiLamViec;
    }

    public void setDiaChiLamViec(String diaChiLamViec) {
        this.diaChiLamViec = diaChiLamViec;
    }

    public String getDienThoaiLamViec() {
        return dienThoaiLamViec;
    }

    public void setDienThoaiLamViec(String dienThoaiLamViec) {
        this.dienThoaiLamViec = dienThoaiLamViec;
    }

    //tinh luong
    public double tinhLuong() {
        double tong = super.getSoGioDay() * 200000 * super.getHeSoLuong();
        return tong;
    }

    @Override
    public String getCode() {
        String c = getId().toUpperCase();
        StringTokenizer s = new StringTokenizer(this.getTen().trim().toUpperCase());
        while (s.hasMoreTokens()) {
            c += s.nextToken().charAt(0);
        }
        return c;
    }

    @Override
    public String toString() {
        return this.getId() + "\t" + this.getTen() + "\t" + this.getHocHam() + "\t" + this.getHocVi() + "\t" + String.format("%.3f", this.tinhLuong());
    }
}
