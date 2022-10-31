/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author HieuDuy
 */
public class HoaDon implements Serializable {

    private String ma, ngayXuat, hoTen;
    private double tienThanhToan;

    public HoaDon() {
    }

    public HoaDon(String ma, String ngayXuat, String hoTen) {
        this.ma = ma;
        this.ngayXuat = ngayXuat;
        this.hoTen = hoTen;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(double tienTT) {
        this.tienThanhToan = tienTT;
    }

    public int getNam() {
        try {
            return Integer.parseInt(ngayXuat.substring(ngayXuat.lastIndexOf("/") + 1).trim());
        } catch (NumberFormatException e) {
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.YEAR);
        }
    }
}
