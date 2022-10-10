/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2.controller;

import bai2.model.PTGT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class QLPT {

    private List<PTGT> list;

    private static Scanner sc = new Scanner(System.in);

    public QLPT() {
        list = new ArrayList<>();
    }

    public void setList(List<PTGT> list) {
        this.list = list;
    }

    // check co trung ma ko
    private int vitri(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void nhap() {
        String re = "^[^ab]{1}\\d{4}";
        String ma, hang, mau;
        int nam;
        double gia;
        while (true) {
            try {
                System.out.print("Nhap ma: ");
                ma = sc.nextLine().toUpperCase();
                if (vitri(ma) == -1 && ma.matches(re)) {
                    break;
                } else {
                    throw new ValidException(("trung ma hoac khong dung dinh dang"));
                }
            } catch (ValidException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Hang: ");
        hang = sc.nextLine();

        while (true) {
            try {
                System.out.print("Nam: ");
                nam = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap 1 so co 4 chu so");
            }
        }

        while (true) {
            try {
                System.out.print("Gia: ");
                gia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thuc");
            }
        }

        System.out.print("Mau: ");
        mau = sc.nextLine();
        list.add(new PTGT(ma, hang, mau, nam, gia));
        System.out.println("Them thanh cong");
    }

    public void hienThi() {
        System.out.println("Danh sach ptgt");
        list.forEach(System.out::println);
        System.out.println("\nTong so: " + list.size());
    }

    public void luu(String fname) {
        IOFile.ghi(fname, list);
        System.out.println("Da luu thanh cong");
    }

    public void doc(String fname) {
        setList(IOFile.doc(fname));
        System.out.println("Da doc thanh cong");
    }

    public void timTheoHang() {
        int t = 0;
        System.out.print("Nhap ten hang muon tim: ");
        String key = sc.nextLine();
        for (PTGT x : list) {
            if (x.getHang().toLowerCase().indexOf(key.toLowerCase()) >= 0) {
                System.out.println(x);
                t++;
            }
        }
        if (t == 0) {
            System.out.println("Khong tim thay phuong tien nao");
        }
    }

    public void timTheoMau() {
        int t = 0;
        System.out.print("Nhap mau muon tim: ");
        String key = sc.nextLine();
        for (PTGT x : list) {
            if (x.getMau().toLowerCase().indexOf(key.toLowerCase()) >= 0) {
                System.out.println(x);
                t++;
            }
        }
        if (t == 0) {
            System.out.println("Khong tim thay phuong tien nao");
        }
    }

    public void timTheoGia() {
        int t = 0;
        double fi = 0.0, se = 0.0;
        String re = "(\\d+(\\.\\d*)?)|(\\.\\d+)$";

        System.out.print("Tim gia tu: ");
        String a = sc.nextLine();

        while (!a.matches(re)) {
            System.out.print("Nhap 1 so thuc: ");
            a = sc.nextLine();
        }
        fi = Double.parseDouble(a);
        System.out.print("Den gia: ");
        a = sc.nextLine();
        while (!a.matches(re)) {
            System.out.print("Nhap 1 so thuc: ");
            a = sc.nextLine();
        }
        se = Double.parseDouble(a);

        for (PTGT x : list) {
            if (x.getGia() >= fi && x.getGia() <= se) {
                System.out.println(x);
                t++;
            }
        }
        if (t == 0) {
            System.out.println("Khong tim thay phuong tien nao");
        }
    }

    public void xoa() {
        System.out.print("Nhap ma PT muon xoa: ");
        String key = sc.nextLine();
        int vt = vitri(key);
        if (vt == -1) {
            System.out.println("Khong tim thay " + key + " trong danh sach");
        } else {
            PTGT p = list.remove(vt);

            System.out.println("Xoa thanh cong " + key);
            System.out.println(p);
        }
    }

    public void sua() {
        System.out.print("Nhap ma PT muon xoa: ");
        String key = sc.nextLine();
        int vt = vitri(key);
        if (vt == -1) {
            System.out.println("Khong tim thay " + key + " trong danh sach");
        } else {
            String re = "^[^ab]{1}\\d{4}";
            String ma, hang, mau;
            int nam;
            double gia;
            while (true) {
                try {
                    System.out.print("Nhap ma: ");
                    ma = sc.nextLine().toUpperCase();
                    if (vitri(ma) == -1 && ma.matches(re)) {
                        break;
                    } else {
                        throw new ValidException(("trung ma hoac khong dung dinh dang"));
                    }
                } catch (ValidException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("Hang: ");
            hang = sc.nextLine();

            while (true) {
                try {
                    System.out.print("Nam: ");
                    nam = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhap 1 so co 4 chu so");
                }
            }

            while (true) {
                try {
                    System.out.print("Gia: ");
                    gia = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhap so thuc");
                }
            }

            System.out.print("Mau: ");
            mau = sc.nextLine();
            PTGT p = new PTGT(ma, hang, mau, nam, gia);
            list.set(vt, p);
            System.out.println("Sua thanh cong");
        }
    }

    public void sapXepTheoNam() {
        Collections.sort(list);
    }

    public void sapXepTheoHang() {
        list.sort((PTGT o1, PTGT o2) -> o1.getHang().compareToIgnoreCase(o2.getHang()));
    }
    public void sapXepTheoHangVaGia(){
        list.sort((PTGT o1, PTGT o2) -> {
            if(o1.getHang().equalsIgnoreCase(o2.getHang())){
                return Double.compare(o1.getGia(), o2.getGia());
            }else{
                return o1.getHang().compareToIgnoreCase(o2.getHang());
            }
        });
    }
}
