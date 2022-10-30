/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4.run;

import bai4.controller.QLGV;
import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fname = "src/bai4/run/giangvien.dat";
        QLGV q = new QLGV();
        while (true) {
            System.out.println("\n----------------MENU----------------");
            System.out.println("1. Nhap giang vien co huu");
            System.out.println("2. Nhap giang vien thinh huu");
            System.out.println("3. Show danh sach");
            System.out.println("4. Doc tu file");
            System.out.println("5. Luu vao file");
            System.out.println("6. Xoa theo id");
            System.out.println("7. Sua theo id");
            System.out.println("8. Danh sach giang vien co huu");
            System.out.println("9. Danh sach giang vien thinh huu");
            System.out.println("10. Tim kiem theo ten");
            System.out.println("11. Sap xep theo ten");
            System.out.println("12. Tinh tong tien luong");
            System.out.println("13. Giang vien co luong cao nhat");
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
                case 0:  System.out.println("BYE"); System.exit(0);
                case 1:q.nhapGiangVienCoHuu(); break;
                case 2: q.nhapGiangVienThinhHuu();break;
                case 3: q.inDanhSach(); break;
                case 4:  q.vao(fname); break;
                case 5: q.ra(fname); break;
                case 6: q.xoa();break;
                case 7: q.sua();break;
                case 8: q.inDanhSachGiangVienCoHuu();break;
                case 9: q.inDanhSachGiangThinhHuu();break;
                case 10: q.timKiem();break;
                case 11: q.sapXepTheoTen(); break;
                case 12: q.tinhTongTienLuong(); break;
                case 13: q.giangVienCoTongLuongCaoNhat();break;
                default:
                    System.out.println("Vui long chon 0- 13");
            }
        }
    }
}
