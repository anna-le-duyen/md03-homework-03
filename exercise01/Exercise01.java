package exercise01;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập thông tin hóa đơn từ bàn phím khớp giao diện mẫu
        System.out.println("========== NHẬP THÔNG TIN HÓA ĐƠN ==========");
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double giaSanPham = scanner.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        int soLuong = scanner.nextInt();

        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean laThanhVien = scanner.nextBoolean();

        // 2. Tính toán các giá trị số học
        double thanhTien = giaSanPham * soLuong;
        
        double giamGia = 0;
        if (laThanhVien) {
            giamGia = thanhTien * 0.10;
        }

        // VAT tính trên số tiền sau giảm giá: (Thành tiền - Giảm giá) * 8%
        double vat = (thanhTien - giamGia) * 0.08;
        
        double tongThanhToan = thanhTien - giamGia + vat;

        // 3. In kết quả hóa đơn khớp chính xác 100% giao diện yêu cầu
        System.out.println("==================== HÓA ĐƠN ====================");
        System.out.println("Khách hàng: " + tenKhachHang);
        System.out.println("Sản phẩm  : " + tenSanPham);
        System.out.println("Số lượng  : " + soLuong);
        
        // Sử dụng %,.2f để tự động thêm dấu phẩy ngăn cách hàng nghìn và lấy 2 số thập phân
        System.out.printf("Đơn giá   : %,.2f VND\n", giaSanPham);
        System.out.printf("Thành tiền: %,.2f VND\n", thanhTien);
        System.out.printf("Giảm giá thành viên (10%%): %,.2f VND\n", giamGia);
        System.out.printf("Tiền VAT (8%%): %,.2f VND\n", vat);
        System.out.printf("Tổng thanh toán: %,.2f VND\n", tongThanhToan);
        System.out.println("=================================================");

        scanner.close();
    }
}