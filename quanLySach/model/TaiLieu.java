/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLySach.model;

import java.io.Serializable;

/**
 *
 * @author HieuDuy
 */
public class TaiLieu implements Serializable{
    private String ma, tenNXB;
    private int soBanPH;

    public TaiLieu() {
    }

    public TaiLieu(String ma, String tenNXB, int soBanPH) {
        this.ma = ma;
        this.tenNXB = tenNXB;
        this.soBanPH = soBanPH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }
}
