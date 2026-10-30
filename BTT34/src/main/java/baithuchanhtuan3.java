import java.time.Year;
import java.util.Scanner;

public class baithuchanhtuan3 {
    public static void main(String[] args) {
        // Sử dụng UTF-8 để hiển thị tiếng Việt không bị lỗi font
        Scanner sc = new Scanner(System.in, "UTF-8");

        // ===== Nhập thông tin sách =====
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXB = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        // ===== Bài 1: Kiểm tra dữ liệu hợp lệ =====
        int namHienTai = Year.now().getValue();
        if (donGia <= 0) {
            System.out.println("Dữ liệu không hợp lệ: đơn giá phải > 0.");
            return;
        } else if (soLuong < 0) {
            System.out.println("Dữ liệu không hợp lệ: số lượng phải >= 0.");
            return;
        } else if (namXB <= 0 || namXB > namHienTai) {
            System.out.println("Dữ liệu không hợp lệ: năm xuất bản phải từ 1 đến " + namHienTai + ".");
            return;
        }
        System.out.println("\nDữ liệu hợp lệ.");

        // ===== Tính tiền =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ===== In thông tin sách =====
        System.out.println("\n===== THÔNG TIN SÁCH =====");
        System.out.println("Mã sách     : " + maSach);
        System.out.println("Tên sách    : " + tenSach);
        System.out.println("Tác giả     : " + tacGia);
        System.out.println("Năm xuất bản: " + namXB);
        System.out.printf("Đơn giá     : %,.0f%n", donGia);
        System.out.println("Số lượng    : " + soLuong);

        System.out.println("\n===== TÍNH TOÁN =====");
        System.out.printf("Thành tiền      : %,.0f%n", thanhTien);
        System.out.printf("Phí vận chuyển  : %,.0f%n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập  : %,.0f%n", tongTienNhap);

        // ===== Bài 2: Phân loại giá =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sách giá thấp";
        } else if (donGia <= 100000) {
            loaiGia = "Sách giá trung bình";
        } else if (donGia <= 200000) {
            loaiGia = "Sách giá cao";
        } else {
            loaiGia = "Sách giá đặc biệt";
        }
        System.out.println("\nPhân loại giá: " + loaiGia);

        // ===== Bài 3: Phân loại tồn kho =====
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Hết sách";
        } else if (soLuong <= 5) {
            tonKho = "Sắp hết";
        } else if (soLuong <= 20) {
            tonKho = "Còn ít";
        } else {
            tonKho = "Còn nhiều";
        }
        System.out.println("Tồn kho: " + tonKho);

        // ===== Bài 4: Dùng switch chọn loại sách =====
        System.out.println("\nChọn loại sách:");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn (1-4): ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                System.out.println("Loại sách: Sách giáo khoa");
                break;
            case 2:
                System.out.println("Loại sách: Sách tham khảo");
                break;
            case 3:
                System.out.println("Loại sách: Sách chuyên ngành");
                break;
            case 4:
                System.out.println("Loại sách: Sách khác");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }

        sc.close();
    }
}