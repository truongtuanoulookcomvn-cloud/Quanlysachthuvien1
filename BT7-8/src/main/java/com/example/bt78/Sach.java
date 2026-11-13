package com.example.bt78;

import java.time.Year;

public class Sach {
    // Yêu cầu 1: Tất cả thuộc tính phải là private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Yêu cầu 4: Constructor có tham số đầy đủ
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        // Gọi setter để kiểm tra dữ liệu ngay khi khởi tạo
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yêu cầu 2: Cung cấp đầy đủ Getters và Setters

    // --- Getters ---
    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // --- Setters ---

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    // Yêu cầu 3: Kiểm tra năm xuất bản
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue(); // Lấy năm hiện tại
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Lỗi: Năm xuất bản không hợp lệ! (Phải từ 1 đến " + currentYear + ")");
            this.namXuatBan = 0;
        }
    }

    // Yêu cầu 3: Kiểm tra số lượng
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Lỗi: Số lượng không được âm!");
            this.soLuong = 0;
        }
    }

    // Phương thức hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tiêu đề: " + tieuDe);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm XB: " + namXuatBan);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("-------------------------");
    }
}