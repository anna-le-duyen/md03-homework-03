package exercise03;
import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int soNhanVien = 0;
        double tongLuong = 0;
        double luongCaoNhat = -1;
        double luongThapNhat = 500000001; 
        double tongThuong = 0;
        
        int luaChon;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        double luong = scanner.nextDouble();

                        if (luong == -1) {
                            break;
                        }

                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // Phân loại thu nhập khớp chính xác text trong ảnh
                        String phanLoai = "";
                        if (luong < 5000000) {
                            phanLoai = "Thấp";
                        } else if (luong >= 5000000 && luong <= 15000000) {
                            phanLoai = "Trung bình";
                        } else if (luong > 15000000 && luong <= 50000000) {
                            phanLoai = "Khá";
                        } else {
                            phanLoai = "Cao";
                        }
                        System.out.println("→ Phân loại: " + phanLoai);

                        // Tính toán thưởng
                        double phanTramThuong = 0;
                        if (luong >= 0 && luong < 5000000) {
                            phanTramThuong = 0.05;
                        } else if (luong >= 5000000 && luong <= 15000000) {
                            phanTramThuong = 0.10;
                        } else if (luong > 15000000 && luong <= 50000000) {
                            phanTramThuong = 0.15;
                        } else if (luong > 50000000 && luong <= 100000000) {
                            phanTramThuong = 0.20;
                        } else if (luong > 100000000) {
                            phanTramThuong = 0.25;
                        }
                        tongThuong += luong * phanTramThuong;

                        soNhanVien++;
                        tongLuong += luong;

                        if (luong > luongCaoNhat) {
                            luongCaoNhat = luong;
                        }
                        if (luong < luongThapNhat) {
                            luongThapNhat = luong;
                        }
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("\n--- Thống kê ---");
                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu\n");
                    } else {
                        double luongTrungBinh = tongLuong / soNhanVien;
                        System.out.println("Số nhân viên: " + soNhanVien);
                        System.out.printf("Tổng lương: %,.0f VND\n", tongLuong);
                        System.out.printf("Lương trung bình: %,.0f VND\n", luongTrungBinh);
                        System.out.printf("Lương cao nhất: %,.0f VND\n", luongCaoNhat);
                        System.out.printf("Lương thấp nhất: %,.0f VND\n", luongThapNhat);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Tính tổng số tiền thưởng nhân viên ---");
                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu\n");
                    } else {
                        System.out.printf("Tổng tiền thưởng nhân viên: %,.0f VND\n", tongThuong);
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.\n");
                    break;
            }
        } while (luaChon != 4);
    }
}