/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLySach.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import quanLySach.model.Bao;
import quanLySach.model.ChucNang;
import quanLySach.model.Sach;
import quanLySach.model.TaiLieu;

/**
 *
 * @author HieuDuy
 */
public class QLTV implements ChucNang {

    private List<TaiLieu> list;
    private Scanner sc = new Scanner(System.in);

    public QLTV() {
        list = new ArrayList<>();
    }

    public void setList(List<TaiLieu> lst) {
        this.list = lst;
    }

    // tim tai lieu theo ma
    public int timViTri(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    private TaiLieu nhap() {
        String ma, tenNXB;
        int soPH;
        String re = "^[ABCD]{1}\\d{3}";
        while (true) {
            try {
                System.out.print("Ma: ");
                ma = sc.nextLine().toUpperCase();
                if (timViTri(ma) == -1 && ma.matches(re)) {
                    break;
                } else {
                    throw new ValidException("Ma khong dung hoac khong dung dinh dang");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        System.out.print("Ten NXB: ");
        tenNXB = sc.nextLine();
        while (true) {
            try {
                System.out.print("So ban PH: ");
                soPH = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
        return new TaiLieu(ma, tenNXB, soPH);
    }

    @Override
    public void nhapSach() {
        TaiLieu t = nhap();
        String tenTG, tenSach;
        int soTrang;
        System.out.print("Ten Sach: ");
        tenSach = sc.nextLine();
        System.out.print("Ten TG: ");
        tenTG = sc.nextLine();
        while (true) {
            try {
                System.out.print("So trang: ");
                soTrang = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
        list.add(new Sach(t.getMa(), t.getTenNXB(), t.getSoBanPH(), tenTG, tenSach, soTrang));
    }

    @Override
    public void nhapBao() {
        TaiLieu t = nhap();
        String ngayPH;
        String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while (true) {
            try {
                System.out.print("Ngay PH: ");
                ngayPH = sc.nextLine();
                if (ngayPH.matches(re)) {
                    break;
                } else {
                    throw new ValidException("Dinh dang ngay chua dung dd/mm/yyyy");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        list.add(new Bao(t.getMa(), t.getTenNXB(), t.getSoBanPH(), ngayPH));
    }

    @Override
    public void hienThiDS() {
        for (TaiLieu t : list) {
            System.out.println(t);
        }
        System.out.println("Tong: " + list.size());
    }

    @Override
    public void luu(String filename) {
        IOFile.viet(filename, list);
    }

    @Override
    public void docra(String filename) {
        setList(IOFile.doc(filename));
    }

    @Override
    public void xoa() {
        System.out.print("Nhap vao ma muon xoa: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay ma muon xoa");
        } else {
            System.out.println("Tai lieu xoa: " + list.remove(vt));
            System.out.println("Xoa thanh cong");
        }
    }

    @Override
    public void sua() {
        System.out.print("Nhap vao ma muon sua: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay ma muon sua");
        } else {
            TaiLieu t = list.get(vt);
            String tenNXB;
            int soPH;
            System.out.print("Ten NXB: ");
            tenNXB = sc.nextLine();
            while (true) {
                try {
                    System.out.print("So ban PH: ");
                    soPH = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
            t.setSoBanPH(soPH);
            t.setTenNXB(tenNXB);
            if (t instanceof Sach) { // t la sach
                String tenTG, tenSach;
                int soTrang;
                System.out.print("Ten Sach: ");
                tenSach = sc.nextLine();
                System.out.print("Ten TG: ");
                tenTG = sc.nextLine();
                while (true) {
                    try {
                        System.out.print("So trang: ");
                        soTrang = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println(e);
                    }
                }
                ((Sach) t).setTenSach(tenSach);
                ((Sach) t).setSoTrang(soTrang);
                ((Sach) t).setTenTG(tenTG);
            } else if (t instanceof Bao) {// t la bao
                String ngayPH;
                String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
                while (true) {
                    try {
                        System.out.print("Ngay PH: ");
                        ngayPH = sc.nextLine();
                        if (ngayPH.matches(re)) {
                            break;
                        } else {
                            throw new ValidException("Dinh dang ngay chua dung dd/mm/yyyy");
                        }
                    } catch (ValidException e) {
                        System.err.println(e);
                    }
                }
                ((Bao) t).setNgayPH(ngayPH);
            }
            System.out.println("Sua thanh cong");
        }
    }

    @Override
    public void timTheoTenSach() {
        List<Sach> sach = new ArrayList<>();
        for (TaiLieu t : list) {
            if (t instanceof Sach) {
                sach.add((Sach) t);
            }
        }
        System.out.print("Nhap ten sach can tim:");
        int tongSach = 0;
        String ten = sc.nextLine();
        for (Sach s : sach) {
            if (s.getTenSach().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(s);
                tongSach++;
            }
        }
        if (tongSach == 0) {
            System.out.println("Khong tim thay sach");
        } else {
            System.out.println("Tong: " + tongSach);
        }
    }

    @Override
    public void timBaoTuDenNam() {
        List<Bao> bao = new ArrayList<>();
        for (TaiLieu t : list) {
            if (t instanceof Bao) {
                bao.add((Bao) t);
            }
        }
        try {
            System.out.print("Nhap tu nam: ");
            int nam1 = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap den nam: ");
            int nam2 = Integer.parseInt(sc.nextLine());
            int tongBao = 0;
            for (Bao b : bao) {
                if (b.getNam() >= nam1 && b.getNam() <= nam2) {
                    System.out.println(b);
                    tongBao++;
                }
            }
            if (tongBao == 0) {
                System.out.println("Khong tim thay bao");
            } else {
                System.out.println("Tong: " + tongBao);
            }
        } catch (NumberFormatException e) {
            System.err.println(e);
        }

    }

    @Override
    public void sapXepSoBanPH() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sapXepSachTheoTenTG() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sapXepBao2TTinh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void thongKe1() {
        // dem so sach theo ten nha xb
        Map<String, Long> count = list.stream().collect(Collectors.groupingBy(TaiLieu::getTenNXB, Collectors.counting()));
        Iterator i = count.keySet().iterator();
        while(i.hasNext()){
            Object key = i.next();
            System.out.println(key + "\t" + count.get(key));
        }
//        System.out.println(count);
        
    }

    @Override
    public void thongKe2() {
        List<Bao> bao = new ArrayList<>();
        for(TaiLieu t : list){
            if (t instanceof Bao){
                bao.add((Bao)t);
            }
        }
        //them so ban phat hanh theo nam
        Map<Integer, Integer> sum = bao.stream().collect(
                Collectors.groupingBy(Bao::getNam, Collectors.summingInt(Bao::getSoBanPH))
        );
        Iterator i = sum.keySet().iterator();
        while(i.hasNext()){
            Object key = i.next();
            System.out.println(key + " " + sum.get(key));
        }
    }
    
    public void thongKe3(){
        List<Sach> sach = new ArrayList();
        for(TaiLieu t : list){
            if(t instanceof Sach){
                sach.add((Sach)t);
            }
        }
        // tim ra sach co so trang max
        Optional<Sach> max = sach.stream().collect(
                Collectors.maxBy(
                        Comparator.comparing(Sach::getSoTrang)
                )
        );
        System.out.print("Sach co so trang nhieu nhat: ");
        System.out.println(max.isPresent()?max.get():"Khong co");
    }
//max group
    //sach co so trang lon nhat theo tenPH
    public void thongKe4(){
        List<Sach> sach = new ArrayList();
        for(TaiLieu t : list){
            if(t instanceof Sach){
                sach.add((Sach)t);
            }
        }
        //sach co so trang lon nhat theo ten nxb
        Map<String, Sach> max = sach.stream().collect(
                Collectors.groupingBy(Sach::getTenNXB, Collectors.collectingAndThen(
                        Collectors.reducing((Sach s1, Sach s2) -> s1.getSoTrang() > s2.getSoTrang()?s1:s2), Optional::get)
                )
        );
        Iterator i = max.keySet().iterator();
        while(i.hasNext()){
            Object key = i.next();
            System.out.println(key + " " + max.get(key));
        }
    }
    public void thongKe5(){
        List<Bao> bao = new ArrayList();
        for(TaiLieu t : list){
            if(t instanceof Bao){
                bao.add((Bao)t);
            }
        }
        //so ban phat hanh nhieu nhat theo nam
        Map<Integer, Bao> max = bao.stream().collect(
                Collectors.groupingBy(Bao::getNam, Collectors.collectingAndThen(
                        Collectors.reducing((Bao b1, Bao b2) -> 
                                b1.getSoBanPH() > b2.getSoBanPH() ? b1:b2), Optional::get
                        )
                )
        );
        Iterator i = max.keySet().iterator();
        while(i.hasNext()){
            Object key = i.next();
            System.out.println(key + " " + max.get(key));
        }
    }
}
