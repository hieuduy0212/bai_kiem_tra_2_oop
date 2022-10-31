/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7.controller;

import bai7.model.HoaDon;
import bai7.model.HoaDonGio;
import bai7.model.HoaDonNgay;
import bai7.model.IChucNang;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author HieuDuy
 */
public class QLKS implements IChucNang {

    private List<HoaDon> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public QLKS(String fname) {
        doc(fname);
    }
    
    public List<HoaDon> getList() {
        return list;
    }

    public void setList(List<HoaDon> list) {
        this.list = list;
    }

    public int timViTri(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }

    public HoaDon nhapHoaDon() {
        String ma, ngayXuat, hoTen;
        String re1 = "^(0*[1-9]{1}|[12][0-9]|3[01])/(0*[1-9]|1[012])/(\\d{4})$";
        String re2 = "[NXnx]\\d{2}";
        while (true) {
            try {
                System.out.print("Ma: ");
                ma = sc.nextLine();
                if (timViTri(ma) == -1 && ma.matches(re2)) {
                    ma = ma.toUpperCase();
                    break;
                } else {
                    throw new ValidException("Ma da ton tai hoac sai dinh dang");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        while (true) {
            try {
                System.out.print("Ngay: ");
                ngayXuat = sc.nextLine();
                if (ngayXuat.matches(re1)) {
                    break;
                } else {
                    throw new ValidException("Ngay sai dinh dang(dd/mm/yyyy)");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        System.out.print("Ho ten khach hang: ");
        hoTen = sc.nextLine();
        return new HoaDon(ma, ngayXuat, hoTen);
    }

    @Override
    public void nhapHoaDonNgay() {
        HoaDon hd = nhapHoaDon();
        double soNgayThue;
        while (true) {
            try {
                System.out.print("So ngay thue: ");
                soNgayThue = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so ngay dang so thap phan");
            }
        }
        list.add(new HoaDonNgay(soNgayThue, hd.getMa(), hd.getNgayXuat(), hd.getHoTen()));
        System.out.println("Them hoa don theo ngay thanh cong");
    }

    @Override
    public void nhapHoaDonGio() {
        HoaDon hd = nhapHoaDon();
        double soGioThue;
        while (true) {
            try {
                System.out.print("So gio thue: ");
                soGioThue = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so gio dang so thap phan");
            }
        }
        list.add(new HoaDonGio(soGioThue, hd.getMa(), hd.getNgayXuat(), hd.getHoTen()));
        System.out.println("Them hoa don theo gio thanh cong");
    }

    @Override
    public void hienThiHoaDon() {
        for (HoaDon hd : list) {
            System.out.println(hd);
        }
        System.out.println("Tong: " + list.size());
    }

    @Override
    public void luu(String fname) {
        IOFile.ra(fname, list);
    }

    @Override
    public void doc(String fname) {
        setList(IOFile.vao(fname));
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma hoa don can sua: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt == -1) {
            System.err.println("Khong tim thay ma");
        } else {
            HoaDon hd = list.get(vt);
            String ngayXuat, hoTen;
            String re1 = "^(0*[1-9]{1}|[12][0-9]|3[01])/(0*[1-9]|1[012])/(\\d{4})$";
            while (true) {
                try {
                    System.out.print("Ngay: ");
                    ngayXuat = sc.nextLine();
                    if (ngayXuat.matches(re1)) {
                        break;
                    } else {
                        throw new ValidException("Ngay sai dinh dang(dd/mm/yyyy)");
                    }
                } catch (ValidException e) {
                    System.err.println(e);
                }
            }
            System.out.print("Ho ten khach hang: ");
            hoTen = sc.nextLine();
            hd.setHoTen(hoTen);
            hd.setNgayXuat(ngayXuat);
            if(hd instanceof HoaDonNgay){
                double soNgayThue;
                while (true) {
                    try {
                        System.out.print("So ngay thue: ");
                        soNgayThue = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so ngay dang so thap phan");
                    }
                }
                ((HoaDonNgay) hd).setSoNgayThue(soNgayThue);
            }
            if(hd instanceof HoaDonGio){
                 double soGioThue;
                while (true) {
                    try {
                        System.out.print("So gio thue: ");
                        soGioThue = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so gio dang so thap phan");
                    }
                }
                ((HoaDonGio) hd).setSoGioThue(soGioThue);
            }
            System.out.println("Da sua thanh cong");
        }
    }

    @Override
    public void sapXep() { // sap xep hoa don theo ngay xuat
        Collections.sort(list, new Comparator<HoaDon>(){
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                String[] d1 = o1.getNgayXuat().split("/");
                String[] d2 = o2.getNgayXuat().split("/");                
                String a1 = ""; for(int i = d1.length-1;i>=0;i--) a1 += d1[i]; //20021202
                String a2 = ""; for(int i = d2.length-1;i>=0;i--) a2 += d2[i]; //20011202
                return a1.compareTo(a2);
            }
        });
        System.out.println("Da sap xep xong");
    }

    @Override
    public void tongTienHoaDonTheoNam() {
        Map<Integer, Double> map = list.stream().collect(Collectors.groupingBy(HoaDon::getNam, Collectors.summingDouble(HoaDon::getTienThanhToan)));
        TreeMap<Integer, Double> treeMap = new TreeMap<>(map);
        System.out.println("Tong tien hoa don theo nam:");
        for(Map.Entry<Integer, Double> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
