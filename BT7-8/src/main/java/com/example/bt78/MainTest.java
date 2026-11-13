package com.example.bt78;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        ArrayList<Sach> danhSachSach = new ArrayList<>();


        Sach sach1 = new Sach("S001", "Lập trình Java", "Nguyễn Văn A", 2023, 10);
        Sach sach2 = new Sach("S002", "Cấu trúc dữ liệu", "Trần Thị B", 2022, 5);
        Sach sach3 = new Sach("S003", "Mạng máy tính", "Lê Văn C", 2021, 8);

        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);

        System.out.println("=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sách muốn thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Bỏ qua dòng trống

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
            scanner.nextLine(); // Bỏ qua dòng trống

            Sach s = new Sach(ma, tieuDe, tacGia, nam, sl);
            danhSachSach.add(s);
        }

        System.out.println("\n=== DANH SÁCH SAU KHI NHẬP ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }
    }
}