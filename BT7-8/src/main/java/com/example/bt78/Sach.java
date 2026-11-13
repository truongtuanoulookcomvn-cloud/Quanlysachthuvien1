package com.example.bt78;

public class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Hàm khởi tạo (Constructor)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Phương thức hiển thị thông tin (Yêu cầu 2)
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tiêu đề: " + tieuDe);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm XB: " + namXuatBan);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("-------------------------");
    }

    // Getter và Setter (nếu cần dùng cho các bài sau)
    public String getMaSach() { return maSach; }
}