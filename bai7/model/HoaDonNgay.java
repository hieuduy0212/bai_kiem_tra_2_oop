/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7.model;

import java.io.Serializable;

/**
 *
 * @author HieuDuy
 */
public class HoaDonNgay extends HoaDon implements IHoaDon, Serializable {

    private double soNgayThue;

    public HoaDonNgay(double soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public HoaDonNgay(double soNgayThue, String ma, String ngayXuat, String hoTen) {
        super(ma, ngayXuat, hoTen);
        this.soNgayThue = soNgayThue;
        getTienTT();
    }

    public double getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(double soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    @Override
    public void getTienTT() {
        double tong = 300 * soNgayThue;
        if (soNgayThue >= 7) {
            tong *= 0.9;
        }
        super.setTienThanhToan(tong);
    }

    @Override
    public String toString() {
        return super.getMa() + "\t" + getNgayXuat() + "\t" + getHoTen() + "\t" + String.format("%.3f", this.getSoNgayThue()) + "\t" + String.format("%.3f", getTienThanhToan());
    }
}
