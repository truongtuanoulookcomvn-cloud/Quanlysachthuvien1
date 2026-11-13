package com.example.bt78;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        System.out.println("=== KIỂM TRA TÍNH ĐÓNG GÓI (Tuần 8) ===");

        // 1. Thử tạo đối tượng với dữ liệu HỢP LỆ
        System.out.println("-> Tạo sách 1 (Dữ liệu hợp lệ):");
        Sach sach1 = new Sach("S001", "Lập trình Java", "Nguyễn Văn A", 2023, 10);
        danhSachSach.add(sach1);
        sach1.hienThiThongTin();

        // 2. Thử tạo đối tượng với dữ liệu KHÔNG HỢP LỆ (Năm > hiện tại, số lượng âm)
        System.out.println("-> Tạo sách 2 (Dữ liệu không hợp lệ - Năm 2030, Số lượng -5):");
        Sach sach2 = new Sach("S002", "Cấu trúc dữ liệu", "Trần Thị B", 2030, -5);
        danhSachSach.add(sach2);
        sach2.hienThiThongTin();

        // 3. Thử thay đổi thông tin thông qua Setter
        System.out.println("-> Cập nhật thông tin sách 1:");
        sach1.setSoLuong(15); // Hợp lệ
        sach1.setNamXuatBan(2025); // Hợp lệ (năm nay là 2024/2025 tùy máy)
        sach1.hienThiThongTin();

        // Nhập từ bàn phím (Tùy chọn)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sách muốn thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            System.out.print("Mã sách: ");
            String ma = scanner.nextLine();
            System.out.print("Tiêu đề: ");
            String tieuDe = scanner.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = scanner.nextLine();

            System.out.print("Năm XB: ");
            int nam = scanner.nextInt();
            System.out.print("Số lượng: ");
            int sl = scanner.nextInt();
            scanner.nextLine();

            // Tạo đối tượng (Setter sẽ tự động kiểm tra dữ liệu)
            Sach s = new Sach(ma, tieuDe, tacGia, nam, sl);
            danhSachSach.add(s);
        }

        System.out.println("\n=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }

        scanner.close();
    }
}