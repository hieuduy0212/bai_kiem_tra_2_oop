/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2.model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author HieuDuy
 */
public class PTGT implements Serializable{

    private String ma, hang, mau;
    private int nam;
    private double gia;

    public PTGT() {
    }

    public PTGT(String ma, String hang, String mau, int nam, double gia) {
        this.ma = ma;
        this.hang = hang;
        this.mau = mau;
        this.nam = nam;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.#");
        return ma + "\t" + hang + "\t" + nam + "\t" + df.format(gia) + "\t" + mau;
    }
}
