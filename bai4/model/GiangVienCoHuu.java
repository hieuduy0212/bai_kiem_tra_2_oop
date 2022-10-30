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
public class GiangVienCoHuu extends GiangVien implements Serializable, IGiangVien {

    private double luongThoaThuan;
    private static double soGioQuyDinhChung = 40;

    public GiangVienCoHuu() {
    }

    public GiangVienCoHuu(double luongThoaThuan, double soGioQuyDinhChung) {
        this.luongThoaThuan = luongThoaThuan;
    }

    public GiangVienCoHuu(double luongThoaThuan, String id, String ten, String email, String hocHam, String hocVi, String diaChi, String dienThoai, double soGioDay, double heSoLuong) {
        super(id, ten, email, hocHam, hocVi, diaChi, dienThoai, soGioDay, heSoLuong);
        this.luongThoaThuan = luongThoaThuan;
    }

    public double getLuongThoaThuan() {
        return luongThoaThuan;
    }

    public void setLuongThoaThuan(double luongThoaThuan) {
        this.luongThoaThuan = luongThoaThuan;
    }

    //tinh luong
    public double tinhLuong() {
        double tong = luongThoaThuan + (super.getSoGioDay() - soGioQuyDinhChung) * 50000;
        return tong * super.getHeSoLuong();
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
