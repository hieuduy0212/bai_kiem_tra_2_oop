/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4.controller;

import bai4.model.ChucNang;
import bai4.model.GiangVien;
import bai4.model.GiangVienCoHuu;
import bai4.model.GiangVienThinhGiang;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author HieuDuy
 */
public class QLGV implements ChucNang {

    private List<GiangVien> list;
    private Scanner sc = new Scanner(System.in);
    private List<String> listHocHam = new ArrayList<>(Arrays.asList("khong", "giao su", "pho giao su"));
    private List<String> listHocVi = new ArrayList<>(Arrays.asList("dai hoc", "thac si", "tien si"));

    public QLGV() {
        list = new ArrayList<>();
    }

    public List<GiangVien> getList() {
        return list;
    }

    public void setList(List<GiangVien> list) {
        this.list = list;
    }

    public int timViTri(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public double tinhHeSoLuong(String hocHam, String hocVi) {
        double sum = 0.0;
        if (hocVi.equalsIgnoreCase("dai hoc")) {
            sum += 1;
        } else if (hocVi.equalsIgnoreCase("thac si")) {
            sum += 1.1;
        } else if (hocVi.equalsIgnoreCase("tien si")) {
            sum += 1.2;
        }
        if (hocHam.equalsIgnoreCase("giao su")) {
            sum += 0.2;
        } else if (hocHam.equalsIgnoreCase("pho giao su")) {
            sum += 0.1;
        }
        return sum;
    }

    private GiangVien nhapGiangVien() {
        String id, ten, email, hocHam, hocVi, diaChi, dienThoai;
        double soGioDay, heSoLuong;
        String re = "^[A-D]{1}\\d{2}\\w{4}\\d{3}";
        while (true) {
            try {
                System.out.print("ID: ");
                id = sc.nextLine().toUpperCase();
                if (timViTri(id) == -1 && id.matches(re)) {
                    break;
                } else {
                    throw new ValidException("Id da ton tai hoac khong dung dinh dang");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        System.out.print("Ten: ");
        ten = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();

        while (true) {
            System.out.print("Hoc ham(khong, giao su, pho giao su): ");
            hocHam = sc.nextLine().trim();
            if (listHocHam.contains(hocHam.trim().toLowerCase())) {
                break;
            }
        }
        while (true) {
            System.out.print("Hoc vi(dai hoc, thac si, tien si): ");
            hocVi = sc.nextLine().trim();
            if (listHocVi.contains(hocVi.trim().toLowerCase())) {
                break;
            }
        }
        System.out.print("Dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("Dien thoai: ");
        dienThoai = sc.nextLine();
        while (true) {
            try {
                System.out.print("So gio day: ");
                soGioDay = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
        heSoLuong = tinhHeSoLuong(hocHam, hocVi);
        return new GiangVien(id, ten, email, hocHam, hocVi, diaChi, dienThoai, soGioDay, heSoLuong);
    }

    @Override
    public void nhapGiangVienCoHuu() {
        GiangVien gv = nhapGiangVien();
        double luongThoaThuan;
        while (true) {
            try {
                System.out.print("Luong thoa thuan: ");
                luongThoaThuan = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
        list.add(new GiangVienCoHuu(luongThoaThuan, gv.getId(), gv.getTen(), gv.getEmail(), gv.getHocHam(), gv.getHocVi(), gv.getDiaChi(), gv.getDienThoai(), gv.getSoGioDay(), gv.getHeSoLuong()));
        System.out.println("Them thanh cong giang vien co huu");
    }

    @Override
    public void nhapGiangVienThinhHuu() {
        GiangVien gv = nhapGiangVien();
        String diaChiLamViec, dienThoaiLamViec;
        System.out.print("Dia chi lam viec: ");
        diaChiLamViec = sc.nextLine();
        System.out.print("Dien thoai lam viec: ");
        dienThoaiLamViec = sc.nextLine();
        list.add(new GiangVienThinhGiang(diaChiLamViec, dienThoaiLamViec, gv.getId(), gv.getTen(), gv.getEmail(), gv.getHocHam(), gv.getHocVi(), gv.getDiaChi(), gv.getDienThoai(), gv.getSoGioDay(), gv.getHeSoLuong()));
        System.out.println("Them thanh cong giang vien thinh huu");
    }

    @Override
    public void inDanhSach() {
//        System.out.println("ID" + "\t" + "Ten" + "\t" + "Hoc ham" + "\t" + "Hoc vi" + "\t" + "Luong");
        for (GiangVien t : list) {
            System.out.println(t);
        }
        System.out.println("Tong: " + list.size());
    }

    @Override
    public void xoa() {
        System.out.print("Nhap id can xoa: ");
        String id = sc.nextLine();
        int vt = timViTri(id);
        if (vt == -1) {
            System.out.println("Khong tim thay id");
        } else {
            GiangVien gv = list.remove(vt);
            System.out.println("Xoa thanh cong: " + gv);
        }
    }

    @Override
    public void sua() {
        System.out.print("Nhap id can sua: ");
        String id = sc.nextLine();
        int vt = timViTri(id);
        if (vt == -1) {
            System.out.println("Khong tim thay id");
        } else {
            GiangVien gv = list.get(vt);
            String ten, email, hocHam, hocVi, diaChi, dienThoai;
            double soGioDay, heSoLuong;
            System.out.print("Ten: ");
            ten = sc.nextLine();
            System.out.print("Email: ");
            email = sc.nextLine();
            while (true) {
                System.out.print("Hoc ham(khong, giao su, pho giao su): ");
                hocHam = sc.nextLine().trim();
                if (listHocHam.contains(hocHam.trim().toLowerCase())) {
                    break;
                }
            }
            while (true) {
                System.out.print("Hoc vi(dai hoc, thac si, tien si): ");
                hocVi = sc.nextLine().trim();
                if (listHocVi.contains(hocVi.trim().toLowerCase())) {
                    break;
                }
            }
            System.out.print("Dia chi: ");
            diaChi = sc.nextLine();
            System.out.print("Dien thoai: ");
            dienThoai = sc.nextLine();
            while (true) {
                try {
                    System.out.print("So gio day: ");
                    soGioDay = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
            heSoLuong = tinhHeSoLuong(hocHam, hocVi);
            gv.setDiaChi(diaChi);
            gv.setDienThoai(dienThoai);
            gv.setEmail(email);
            gv.setHeSoLuong(heSoLuong);
            gv.setHocHam(hocHam);
            gv.setHocVi(hocVi);
            gv.setSoGioDay(soGioDay);
            gv.setTen(ten);
            if (gv instanceof GiangVienCoHuu) {
                double luongThoaThuan;
                while (true) {
                    try {
                        System.out.print("Luong thoa thuan: ");
                        luongThoaThuan = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println(e);
                    }
                }
                ((GiangVienCoHuu) gv).setLuongThoaThuan(luongThoaThuan);
                System.out.println("Sua thanh cong giang vien co huu");
            }
            if (gv instanceof GiangVienThinhGiang) {
                String diaChiLamViec, dienThoaiLamViec;
                System.out.print("Dia chi lam viec: ");
                diaChiLamViec = sc.nextLine();
                System.out.print("Dien thoai lam viec: ");
                dienThoaiLamViec = sc.nextLine();
                ((GiangVienThinhGiang) gv).setDiaChiLamViec(diaChiLamViec);
                ((GiangVienThinhGiang) gv).setDienThoaiLamViec(dienThoaiLamViec);
                System.out.println("Sua thanh cong giang vien thinh huu");
            }
        }
    }

    @Override
    public void inDanhSachGiangVienCoHuu() {
//        System.out.println("ID" + "\t" + "Ten" + "\t" + "Hoc ham" + "\t" + "Hoc vi" + "\t" + "Luong");
        List<GiangVienCoHuu> listgvch = new ArrayList<>();
        for (GiangVien gv : list) {
            if (gv instanceof GiangVienCoHuu) {
                listgvch.add((GiangVienCoHuu) gv);
            }
        }
        if (listgvch.isEmpty()) {
            System.out.println("Danh sach gvch trong");
        } else {
            for (GiangVienCoHuu gvch : listgvch) {
                System.out.println(gvch);
            }
            System.out.println("Tong: " + listgvch.size());
        }
    }

    @Override
    public void inDanhSachGiangThinhHuu() {
//        System.out.println("ID" + "\t" + "Ten" + "\t" + "Hoc ham" + "\t" + "Hoc vi" + "\t" + "Luong");
        List<GiangVienThinhGiang> listgvtg = new ArrayList<>();
        for (GiangVien gv : list) {
            if (gv instanceof GiangVienThinhGiang) {
                listgvtg.add((GiangVienThinhGiang) gv);
            }
        }
        if (listgvtg.isEmpty()) {
            System.out.println("Danh sach gvtg trong");
        } else {
            for (GiangVienThinhGiang gvtg : listgvtg) {
                System.out.println(gvtg);
            }
            System.out.println("Tong: " + listgvtg.size());
        }
    }
// tim kiem theo ten gan dung

    @Override
    public void timKiem() {
        System.out.print("Nhap ten muon tim: ");
        String ten = sc.nextLine();
        int c = 0;
        for (GiangVien gv : list) {
            if (gv.getTen().toLowerCase().trim().contains(ten.trim().toLowerCase())) {
                System.out.println(gv);
                c++;
            }
        }
        System.out.println("Tong: " + c);
    }

    @Override
    public void sapXepTheoTen() {
        Collections.sort(list, (GiangVien g1, GiangVien g2) -> {
            return g1.getTen().compareTo(g2.getTen());
        });
        System.out.println("Da sap xep xong");
    }

    @Override
    public void tinhTongTienLuong() {
        double sum = 0;
        for (GiangVien gv : list) {
            if (gv instanceof GiangVienCoHuu) {
                sum += ((GiangVienCoHuu) gv).tinhLuong();
            } else if (gv instanceof GiangVienThinhGiang) {
                sum += ((GiangVienThinhGiang) gv).tinhLuong();
            }
        }
        System.out.println("Tong so luong cua toan bo giang vien: " + String.format("%.3f", sum));
    }

    @Override
    public void giangVienCoTongLuongCaoNhat() {
        List<GiangVienCoHuu> listGVCH = new ArrayList<>();
        list.forEach(gv -> {
            if (gv instanceof GiangVienCoHuu) {
                listGVCH.add((GiangVienCoHuu) gv);
            }
        });
        List<GiangVienThinhGiang> listGVTG = new ArrayList<>();
        list.forEach(gv -> {
            if (gv instanceof GiangVienThinhGiang) {
                listGVTG.add((GiangVienThinhGiang) gv);
            }
        });
        Optional<GiangVienCoHuu> maxGVCH = listGVCH.stream().collect(Collectors.maxBy(Comparator.comparing(GiangVienCoHuu::tinhLuong)));
        Optional<GiangVienThinhGiang> maxGVTG = listGVTG.stream().collect(Collectors.maxBy(Comparator.comparing(GiangVienThinhGiang::tinhLuong)));
        System.out.println(maxGVCH.isPresent()?maxGVCH.get():"khong co gvch");
        System.out.println(maxGVTG.isPresent()?maxGVTG.get():"khong co gvtg");
//        if (maxGVCH.get().tinhLuong() > maxGVTG.get().tinhLuong()) {
//            System.out.print("Giang vien co luong cao nhat: ");
//            System.out.println(maxGVCH.get());
//        } else if (maxGVCH.get().tinhLuong() < maxGVTG.get().tinhLuong()) {
//            System.out.print("Giang vien co luong cao nhat: ");
//            System.out.println(maxGVTG.get());
//        }

    }

    @Override
    public void vao(String fname) {
        setList(IOFile.vao(fname));
        System.out.println("Da doc tu file");
    }

    @Override
    public void ra(String fname) {
        IOFile.ra(fname, list);
        System.out.println("Luu file thanh cong");
    }

}
