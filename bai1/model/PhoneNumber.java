/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.model;

/**
 *
 * @author HieuDuy
 */
public class PhoneNumber {

    private String maVung, noiVung;

    public PhoneNumber() {
    }

    public PhoneNumber(String maVung, String noiVung) {
        this.maVung = maVung;
        this.noiVung = noiVung;
    }

    public String getMaVung() {
        return maVung;
    }

    public void setMaVung(String maVung) {
        this.maVung = maVung;
    }

    public String getNoiVung() {
        return noiVung;
    }

    public void setNoiVung(String noiVung) {
        this.noiVung = noiVung;
    }

    @Override
    public String toString() {
        return this.maVung + "-" + this.noiVung;
    }
}
