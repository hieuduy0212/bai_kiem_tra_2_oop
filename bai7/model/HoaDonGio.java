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
public class HoaDonGio extends HoaDon implements IHoaDon, Serializable {

    private double soGioThue;

    public HoaDonGio(double soGioThue) {
        this.soGioThue = soGioThue;
    }

    public HoaDonGio(double soGioThue, String ma, String ngayXuat, String hoTen) {
        super(ma, ngayXuat, hoTen);
        this.soGioThue = soGioThue;
        getTienTT();
    }

    public double getSoGioThue() {
        return soGioThue;
    }

    public void setSoGioThue(double soGioThue) {
        this.soGioThue = soGioThue;
    }

    @Override
    public void getTienTT() {
        double tong = 50 * soGioThue;
        if (soGioThue >= 5) {
            tong *= 0.7;
        }
        setTienThanhToan(tong);
    }

    @Override
    public String toString() {
        return super.getMa() + "\t" + getNgayXuat() + "\t" + getHoTen() + "\t" + String.format("%.3f", this.getSoGioThue()) + "\t" + String.format("%.3f", getTienThanhToan());
    }
}
