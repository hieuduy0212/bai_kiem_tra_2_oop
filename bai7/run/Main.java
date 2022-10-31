/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7.run;

import bai7.controller.QLKS;
import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class Main {
     public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fname = "src/bai7/run/hd.dat";
        QLKS q = new QLKS(fname);
        while (true) {
            System.out.println("\n----------------MENU----------------");
            System.out.println("1. Nhap hoa don ngay");
            System.out.println("2. Nhap hoa don gio");
            System.out.println("3. Hien thi");
            System.out.println("4. Luu vao file");
            System.out.println("5. Sua hoa don theo ma");
            System.out.println("6. Sap xep hoa don theo ngay xuat");
            System.out.println("7. Tong tien hoa don theo nam");
            
            System.out.println("0. Thoat");
            int select = -1;
            while (true) {
                try {
                    System.out.print("Ban chon lua chon: ");
                    select = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhap vao 1 so!");
                }
            }
            switch (select) {
                case 0: System.out.println("BYE"); System.exit(0);
                case 1: q.nhapHoaDonNgay();break;
                case 2: q.nhapHoaDonGio();break;
                case 3: q.hienThiHoaDon();break;
                case 4: q.luu(fname);break;
                case 5: q.sua(); break;
                case 6: q.sapXep(); break;
                case 7: q.tongTienHoaDonTheoNam();break;
//                case 8: q.doc(fname);break;
                default:
                    System.out.println("Vui long chon 0-7");
            }
        }
    }
}
