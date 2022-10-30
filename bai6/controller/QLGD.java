/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.controller;

import bai6.model.ChucNang;
import bai6.model.Dat;
import bai6.model.GiaoDich;
import bai6.model.TienTe;
import bai6.model.Vang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import quanLySach.model.Bao;

/**
 *
 * @author HieuDuy
 */
public class QLGD implements ChucNang {

    private List<GiaoDich> list;
    private Scanner sc = new Scanner(System.in);

    public QLGD() {
        list = new ArrayList<>();
    }

    public int timViTri(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }

    public GiaoDich nhapGiaoDich() {
        String id, ngay;
        String re1 = "^[A-Za-z]{1}\\d{3}";
        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (timViTri(id) == -1 && id.matches(re1)) {
                break;
            } else {
                System.err.println("ID da ton tai hoac sai dinh dang");
            }
        }
        String re2 = "\\d{1,2}/\\d{1,2}/\\d{4}";

        while (true) {
            System.out.print("Ngay: ");
            ngay = sc.nextLine();
            if (ngay.matches(re2)) {
                break;
            } else {
                System.err.println("Ngay khong hop le dd/mm/yyyy");
            }
        }
        return new GiaoDich(id, ngay);
    }

    @Override
    public void themGiaoDichVang() {
        GiaoDich gd = nhapGiaoDich();
        //double donGia, double soLuong, String loaiVang, String id, String ngay
        String loaiVang;
        double donGia, soLuong;
        System.out.print("Loai vang: ");
        loaiVang = sc.nextLine();
        while (true) {
            try {
                System.out.print("Don gia: ");
                donGia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        while (true) {
            try {
                System.out.print("So luong: ");
                soLuong = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        list.add(new Vang(donGia, soLuong, loaiVang, gd.getId(), gd.getNgay()));
    }

    @Override
    public void themGiaoDichTienTe() {
        //double donGia, double soLuong, double tiGia, String loaiTienTe, String id, String ngay
        GiaoDich gd = nhapGiaoDich();
        String loaiTienTe;
        double donGia, soLuong, tiGia;
        while (true) {
            try {
                System.out.print("Loai tien te(USD, EURO, VN): ");
                loaiTienTe = sc.nextLine();
                if (loaiTienTe.equalsIgnoreCase("usd") || loaiTienTe.equalsIgnoreCase("euro") || loaiTienTe.equalsIgnoreCase("vn")) {
                    break;
                } else {
                    throw new ValidException("Loai tien te chua dung");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        while (true) {
            try {
                System.out.print("Don gia: ");
                donGia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        while (true) {
            try {
                System.out.print("So luong: ");
                soLuong = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        while (true) {
            try {
                System.out.print("Ti gia: ");
                tiGia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        list.add(new TienTe(donGia, soLuong, tiGia, loaiTienTe, gd.getId(), gd.getNgay()));
    }

    @Override
    public void themGiaoDichDat() {
        //double donGia, double soLuong, String loaiDat, String id, String ngay
        GiaoDich gd = nhapGiaoDich();
        String loaiDat;
        double donGia, soLuong;
        while (true) {
            try {
                System.out.print("Loai dat(1, 2, 3): ");
                loaiDat = sc.nextLine();
                if (loaiDat.equalsIgnoreCase("1") || loaiDat.equalsIgnoreCase("2") || loaiDat.equalsIgnoreCase("3")) {
                    break;
                } else {
                    throw new ValidException("Loai dat chua dung");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        while (true) {
            try {
                System.out.print("Don gia: ");
                donGia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        while (true) {
            try {
                System.out.print("So luong: ");
                soLuong = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so thap phan");
            }
        }
        list.add(new Dat(donGia, soLuong, loaiDat, gd.getId(), gd.getNgay()));
    }

    @Override
    public void hienThiDanhSach() {
        for (GiaoDich gd : list) {
            System.out.println(gd);
        }
        System.out.println("Tong: " + list.size());
    }

    private void setList(List<GiaoDich> l) {
        this.list = l;
    }

    @Override
    public void sua() {
        System.out.print("Nhap id muon xoa:");
        String id = sc.nextLine();
        int vt = timViTri(id);
        if (vt == -1) {
            System.err.println("Khong tim thay id");
        } else {
            GiaoDich gd = list.get(vt);
            String ngay;
            String re2 = "\\d{1,2}/\\d{1,2}/\\d{4}";

            while (true) {
                System.out.print("Ngay: ");
                ngay = sc.nextLine();
                if (ngay.matches(re2)) {
                    break;
                } else {
                    System.err.println("Ngay khong hop le dd/mm/yyyy");
                }
            }
            gd.setNgay(ngay);

            if (gd instanceof Vang) {
                String loaiVang;
                double donGia, soLuong;
                System.out.print("Loai vang: ");
                loaiVang = sc.nextLine();
                while (true) {
                    try {
                        System.out.print("Don gia: ");
                        donGia = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                while (true) {
                    try {
                        System.out.print("So luong: ");
                        soLuong = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                ((Vang) gd).setDonGia(donGia);
                ((Vang) gd).setLoaiVang(loaiVang);
                ((Vang) gd).setSoLuong(soLuong);
            }
            if (gd instanceof TienTe) {
                String loaiTienTe;
                double donGia, soLuong, tiGia;
                while (true) {
                    try {
                        System.out.print("Loai tien te(USD, EURO, VN): ");
                        loaiTienTe = sc.nextLine();
                        if (loaiTienTe.equalsIgnoreCase("usd") || loaiTienTe.equalsIgnoreCase("euro") || loaiTienTe.equalsIgnoreCase("vn")) {
                            break;
                        } else {
                            throw new ValidException("Loai tien te chua dung");
                        }
                    } catch (ValidException e) {
                        System.err.println(e);
                    }
                }
                while (true) {
                    try {
                        System.out.print("Don gia: ");
                        donGia = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                while (true) {
                    try {
                        System.out.print("So luong: ");
                        soLuong = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                while (true) {
                    try {
                        System.out.print("Ti gia: ");
                        tiGia = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                ((TienTe) gd).setLoaiTienTe(loaiTienTe);
                ((TienTe) gd).setSoLuong(soLuong);
                ((TienTe) gd).setTiGia(tiGia);
            }
            if (gd instanceof Dat) {
                String loaiDat;
                double donGia, soLuong;
                while (true) {
                    try {
                        System.out.print("Loai dat(1, 2, 3): ");
                        loaiDat = sc.nextLine();
                        if (loaiDat.equalsIgnoreCase("1") || loaiDat.equalsIgnoreCase("2") || loaiDat.equalsIgnoreCase("3")) {
                            break;
                        } else {
                            throw new ValidException("Loai dat chua dung");
                        }
                    } catch (ValidException e) {
                        System.err.println(e);
                    }
                }
                while (true) {
                    try {
                        System.out.print("Don gia: ");
                        donGia = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                while (true) {
                    try {
                        System.out.print("So luong: ");
                        soLuong = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Nhap so thap phan");
                    }
                }
                ((Dat) gd).setLoaiDat(loaiDat);
                ((Dat) gd).setSoLuong(soLuong);
                ((Dat) gd).setDonGia(donGia);
            }
            System.out.println("Da sua thanh cong");
        }
    }

    @Override
    public void xoa() {
        System.out.print("Nhap id muon xoa:");
        String id = sc.nextLine();
        int vt = timViTri(id);
        if (vt == -1) {
            System.err.println("Khong tim thay id");
        } else {
            System.out.println("Giao dich da xoa: " + list.remove(vt));
            System.out.println("Da xoa thanh cong");
        }
    }

    @Override
    public void tongSoLuongCacGiaoDich() {
        List<Vang> listVang = new ArrayList<>();
        List<TienTe> listTienTe = new ArrayList<>();
        List<Dat> listDat = new ArrayList<>();
        for (GiaoDich gd : list) {
            if (gd instanceof Vang) {
                listVang.add((Vang) gd);
            } else if (gd instanceof TienTe) {
                listTienTe.add((TienTe) gd);
            } else if (gd instanceof Dat) {
                listDat.add((Dat) gd);
            }
        }
        System.out.println("So giao dich vang: " + listVang.size());
        System.out.println("So giao dich tien te: " + listTienTe.size());
        System.out.println("So giao dich dat: " + listDat.size());

    }

    @Override
    public void hienThiDanhSachGiaoDichTheoNgay() {
        String ngay = "";
        String re2 = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while (true) {
            System.out.println("Nhap ngay muon tim(dd/mm/yyyy): ");
            ngay = sc.nextLine();
            if (ngay.matches(re2)) {
                break;
            } else {
                System.err.println("Nhap ngay dung dinh dang");
            }
        }
        int tong = 0;
        for (GiaoDich gd : list) {
            if (gd.getNgay().equals(ngay)) {
                System.out.println(gd);
                tong++;
            }
        }
        if(tong == 0) System.out.println("Khong tim thay");
        else System.out.println("Tong: " + tong);
    }

    @Override
    public void hienThiDanhSachGiaoDichCoChuaNgay() {
        String ngay = "";
        String re2 = "\\d{1,2}";
        while (true) {
            System.out.println("Nhap ngay muon tim: ");
            ngay = sc.nextLine();
            if (ngay.matches(re2)) {
                break;
            } else {
                System.err.println("Nhap ngay dung dinh dang");
            }
        }
        int tong = 0;
        for (GiaoDich gd : list) {
            if (gd.getNgay().contains(ngay)) {
                System.out.println(gd);
                tong++;
            }
        }
        if(tong == 0) System.out.println("Khong tim thay");
        else System.out.println("Tong: " + tong);
    }

    @Override
    public void hienThiDanhSachGiaoDichTuNamDenNam() {
        try {
            System.out.print("Nhap tu nam: ");
            int nam1 = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap den nam: ");
            int nam2 = Integer.parseInt(sc.nextLine());
            int tong = 0;
            for (GiaoDich gd : list) {
                if (gd.getNam() >= nam1 && gd.getNam() <= nam2) {
                    System.out.println(gd);
                    tong++;
                }
            }
            if (tong == 0) {
                System.out.println("Khong tim thay bao");
            } else {
                System.out.println("Tong: " + tong);
            }
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
    }

    @Override
    public void vao(String fname) {
        setList(IOFile.vao(fname));
    }

    @Override
    public void ra(String fname) {
        IOFile.ra(fname, list);
    }

}
