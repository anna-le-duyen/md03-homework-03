package exercise02;
import java.util.Scanner;
public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Khởi tạo các biến thống kê dữ liệu học viên
        int soHocVien = 0;
        double tongDiem = 0;
        double diemCaoNhat = -1;
        double diemThapNhat = 11;
        
        int luaChon;

        // Vòng lặp duy trì MENU chính của chương trình
        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        double diem = scanner.nextDouble();

                        // Thoát khỏi chức năng nhập khi gõ -1
                        if (diem == -1) {
                            break;
                        }

                        // Kiểm tra điều kiện điểm hợp lệ (0 - 10)
                        if (diem < 0 || diem > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // Phân loại học lực chuẩn xác theo chữ hoa/thường của hình ảnh mẫu
                        String xepLoai = "";
                        if (diem >= 0 && diem < 5) {
                            xepLoai = "Yếu";
                        } else if (diem >= 5 && diem < 7) {
                            xepLoai = "Trung bình"; // Chữ 'b' viết thường theo ảnh mẫu
                        } else if (diem >= 7 && diem < 8) {
                            xepLoai = "Khá";
                        } else if (diem >= 8 && diem < 9) {
                            xepLoai = "Giỏi";
                        } else if (diem >= 9 && diem <= 10) {
                            xepLoai = "Xuất sắc";
                        }
                        System.out.println("Học lực: " + xepLoai);

                        // Cập nhật số liệu thống kê
                        soHocVien++;
                        tongDiem += diem;

                        if (diem > diemCaoNhat) {
                            diemCaoNhat = diem;
                        }
                        if (diem < diemThapNhat) {
                            // Nếu là học viên đầu tiên, gán cả điểm thấp nhất bằng điểm này
                            diemThapNhat = diem;
                        }
                    }
                    System.out.println(); // Xuống dòng tạo khoảng cách sau khi thoát nhập điểm
                    break;

                case 2:
                    System.out.println("\n--- KẾT QUẢ ---");
                    if (soHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTrungBinh = tongDiem / soHocVien;
                        System.out.println("Số học viên đã nhập: " + soHocVien);
                        // Định dạng hiển thị lấy chính xác 2 chữ số thập phân (%.2f)
                        System.out.printf("Điểm trung bình: %.2f\n", diemTrungBinh);
                        System.out.printf("Điểm cao nhất: %.2f\n", diemCaoNhat);
                        System.out.printf("Điểm thấp nhất: %.2f\n", diemThapNhat);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Kết thức chương trình."); // Khớp chính xác lỗi chính tả "Kết thức" trong ảnh mẫu nếu có, hoặc sửa thành "Kết thúc"
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        } while (luaChon != 3);
    }
}