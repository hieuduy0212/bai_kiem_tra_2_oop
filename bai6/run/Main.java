/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.run;

import bai4.run.*;
import bai4.controller.QLGV;
import bai6.controller.QLGD;
import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fname = "src/bai6/run/giaodich.dat";
        QLGD q = new QLGD();
        while (true) {
            System.out.println("\n----------------MENU----------------");
            System.out.println("1. Nhap giao dich vang");
            System.out.println("2. Nhap giao dich tien te");
            System.out.println("3. Nhap giao dich dat");
            System.out.println("4. Hien thi tat ca giao dich");
            System.out.println("5. Doc tu file");
            System.out.println("6. Luu vao file");
            System.out.println("7. Xoa theo id");
            System.out.println("8. Sua theo id");
            System.out.println("9. Tong so luong giao dich");
            System.out.println("10. Danh sach giao dich theo ngay...");
            System.out.println("11. Danh sach giao dich co chua ngay...");
            System.out.println("12. Danh sach giao dich tu nam... den nam...");
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
                case 1: q.themGiaoDichVang();break;
                case 2: q.themGiaoDichTienTe();break;
                case 3: q.themGiaoDichDat();break;
                case 4: q.hienThiDanhSach();break;
                case 5:  q.vao(fname); break;
                case 6: q.ra(fname); break;
                case 7: q.xoa();break;
                case 8: q.sua();break;
                case 9: q.tongSoLuongCacGiaoDich();break;
                case 10: q.hienThiDanhSachGiaoDichTheoNgay();break;
                case 11: q.hienThiDanhSachGiaoDichCoChuaNgay();break;
                case 12: q.hienThiDanhSachGiaoDichTuNamDenNam();break;
                default:
                    System.out.println("Vui long chon 0-12");
            }
        }
    }
}
