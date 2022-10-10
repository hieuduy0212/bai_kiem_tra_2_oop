/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.run;

import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Them 1 so dien thoai moi");
            System.out.println("2. Tim theo ma vung");
            System.out.println("3. Liet ke so trong nuoc/quoc te/ca 2");
            System.out.println("4. Tinh tong so dien thoai theo tung vung");
            System.out.println("5. Tim kiem so theo duoi ...");
            System.out.println("6. Sap xep so dien thoai");

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
                    break;
                default:
                    System.out.println("Nhap 1 so 0-12");
            }
        }
    }
}
