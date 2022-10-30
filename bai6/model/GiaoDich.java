/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author HieuDuy
 */
public class GiaoDich implements Serializable {

    private String id, ngay;

    public GiaoDich() {
    }

    public GiaoDich(String id, String ngay) {
        this.id = id;
        this.ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getNam() {
        try {
            return Integer.parseInt(ngay.substring(ngay.lastIndexOf("/") + 1).trim());
        } catch (NumberFormatException e) {
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.YEAR);
        }
    }
}
