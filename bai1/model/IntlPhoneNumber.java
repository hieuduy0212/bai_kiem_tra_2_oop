/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.model;

/**
 *
 * @author HieuDuy
 */
public class IntlPhoneNumber extends PhoneNumber {

    private String maQuocGia;

    public IntlPhoneNumber() {
    }

    public IntlPhoneNumber(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    public IntlPhoneNumber(String maQuocGia, String maVung, String noiVung) {
        super(maVung, noiVung);
        this.maQuocGia = maQuocGia;
    }

    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    @Override
    public String toString() {
        return this.maQuocGia + "-" + super.getMaVung() + "-" + super.getNoiVung();
    }
}
