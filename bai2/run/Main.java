package bai2.run;

import bai2.controller.QLPT;
import java.util.Scanner;

/**
 *
 * @author HieuDuy
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLPT qlpt = new QLPT();
        String fname = "src/bai2/controller/ptgt.dat";
        
        while (true) {
            System.out.println("\n--------------MENU--------------");
            System.out.println("1. Nhap 1 ptgt");
            System.out.println("2. Hien thi danh sach ptgt");
            System.out.println("3. Luu vao file");
            System.out.println("4. Doc tu file");
            System.out.println("5. Tim kiem theo hang");
            System.out.println("6. Tim kiem theo mau");
            System.out.println("7. Tim kiem gia tu ... den ....");
            System.out.println("8. Sua thong tin 1 ptgt");
            System.out.println("9. Xoa 1 ptgt");
            System.out.println("10. Sap xep ptgt theo nam");
            System.out.println("11. Sap xep ptgt theo hang");
            System.out.println("12. Sap xep ptgt theo 2 hang va gia");
            System.out.println("0. Thoat");
            String tmp = sc.nextLine();
            int select = 0;
            if(tmp.matches("\\d+")){
                select = Integer.parseInt(tmp);
            }else{
                System.out.println("Chon 1 so tu 0 - 12");
                continue;
            }
            switch (select) {
                case 0:
                    System.out.println("BYE!!!");
                    System.exit(0);
                case 1:
                    qlpt.nhap();
                    break;
                case 2:
                    qlpt.hienThi();
                    break;
                case 3:
                    qlpt.luu(fname);
                    break;
                case 4:
                    qlpt.doc(fname);
                    break;
                case 5:
                    qlpt.timTheoHang();
                    break;
                case 6:
                    qlpt.timTheoMau();
                    break;
                case 7:
                    qlpt.timTheoGia();
                    break;
                case 8:
                    qlpt.sua();
                    break;
                case 9:
                    qlpt.xoa();
                    break;
                case 10:
                    qlpt.sapXepTheoNam();
                    break;
                case 11:
                    qlpt.sapXepTheoHang();
                    break;
                case 12:
                    qlpt.sapXepTheoHangVaGia();
                    break;
                default:
                    System.out.println("Chon 0-12");

            }
        }
    }
}
