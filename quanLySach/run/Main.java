/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLySach.run;

import java.util.Scanner;
import quanLySach.controller.QLTV;

/**
 *
 * @author HieuDuy
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        QLTV q = new QLTV();
        String filename = "src/quanLySach/run/tailieu.dat";
        while (true) {
            System.out.println("\n----------------MENU----------------");
            System.out.println("1. Nhap Sach");
            System.out.println("2. Nhap Bao");
            System.out.println("3. Hien thi");
            System.out.println("4. Luu vao");
            System.out.println("5. Doc ra");
            System.out.println("6. Xoa");
            System.out.println("7. Sua");
            System.out.println("8. Tim theo ten sach");
            System.out.println("9. Tim bao tu nam... den nam...");
            System.out.println("10. Thong ke 1");
            System.out.println("11. Thong ke 2");
            System.out.println("12. Thong ke 3");
            System.out.println("13. Thong ke 4");
            System.out.println("14. Thong ke 5");
            System.out.println("0. Thoat");
            String tmp = sc.nextLine();
            int select = 0;
            if (tmp.matches("\\d+")) {
                select = Integer.parseInt(tmp);
            } else {
                System.out.println("Nhap vao 1 so");
                continue;
            }
            switch (select) {
                case 0:
                    System.out.println("BYE!!!");
                    System.exit(0);
                case 1:
                    q.nhapSach();
                    break;
                case 2:
                    q.nhapBao();
                    break;
                case 3:
                    q.hienThiDS();
                    break;
                case 4:
                    q.luu(filename);
                    break;
                case 5:
                    q.docra(filename);
                    break;
                case 6:
                    q.xoa();
                    break;
                case 7:
                    q.sua();
                    break;
                case 8:
                    q.timTheoTenSach();
                    break;
                case 9:
                    q.timBaoTuDenNam();
                    break;
                case 10:
                    q.thongKe1();
                    break;
                case 11:
                    q.thongKe2();
                    break;
                case 12:
                    q.thongKe3();
                    break;
                case 13:
                    q.thongKe4();
                    break;
                case 14:
                    q.thongKe5();
                    break;
                default:
                    System.out.println("Nhap 1 so 0-12");
            }
        }
    }
}
