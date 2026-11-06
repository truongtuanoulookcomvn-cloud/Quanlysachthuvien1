package com.example.bt56;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baithuchanh56 {

    // Tạo lớp Sách ngay trong file để dễ quản lý (hoặc bạn có thể tách ra file riêng)
    static class Sach {
        String maSach;
        String tenSach;
        String tacGia;
        int namXB;
        double donGia;
        int soLuong;
        String loaiSach;

        public Sach() {}

        public double getThanhTien() {
            return donGia * soLuong;
        }

        public double getTongTienNhap() {
            return getThanhTien() + getThanhTien() * 0.05; // Cộng 5% phí vận chuyển
        }

        public String getLoaiGia() {
            if (donGia < 50000) return "Sách giá thấp";
            else if (donGia <= 100000) return "Sách giá trung bình";
            else if (donGia <= 200000) return "Sách giá cao";
            else return "Sách giá đặc biệt";
        }

        public String getTonKho() {
            if (soLuong == 0) return "Hết sách";
            else if (soLuong <= 5) return "Sắp hết";
            else if (soLuong <= 20) return "Còn ít";
            else return "Còn nhiều";
        }

        public boolean isHopLe() {
            int namHienTai = Year.now().getValue();
            if (donGia <= 0) return false;
            if (soLuong < 0) return false;
            if (namXB <= 0 || namXB > namHienTai) return false;
            return true;
        }

        public void hienThi() {
            System.out.printf("Mã: %-5s | Tên: %-15s | Tác giả: %-12s | Năm: %d | Giá: %,.0f | SL: %d | Loại: %s | Tổng: %,.0f\n",
                    maSach, tenSach, tacGia, namXB, donGia, soLuong, loaiSach, getTongTienNhap());
        }
    }

    // Hàm nhập thông tin 1 cuốn sách
    public static Sach nhapSach(Scanner sc) {
        Sach s = new Sach();
        System.out.print("Mã sách: ");
        s.maSach = sc.nextLine();

        System.out.print("Tên sách: ");
        s.tenSach = sc.nextLine();

        System.out.print("Tác giả: ");
        s.tacGia = sc.nextLine();

        System.out.print("Năm xuất bản: ");
        s.namXB = Integer.parseInt(sc.nextLine());

        System.out.print("Đơn giá: ");
        s.donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Số lượng: ");
        s.soLuong = Integer.parseInt(sc.nextLine());

        System.out.println("Chọn loại sách (1-Giáo khoa, 2-Tham khảo, 3-Chuyên ngành, 4-Khác): ");
        int chon = Integer.parseInt(sc.nextLine());
        switch (chon) {
            case 1: s.loaiSach = "Sách giáo khoa"; break;
            case 2: s.loaiSach = "Sách tham khảo"; break;
            case 3: s.loaiSach = "Sách chuyên ngành"; break;
            default: s.loaiSach = "Sách khác"; break;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        List<Sach> danhSach = new ArrayList<>();

        // ===== BÀI 1 & BÀI 3: MENU LẶP VÀ NHẬP N SÁCH BẰNG VÒNG LẶP =====
        int luaChon;
        do {
            System.out.println("\n========== MENU QUẢN LÝ THƯ VIỆN ==========");
            System.out.println("1. Nhập n sách (Bài 1)");
            System.out.println("2. Tính tổng số lượng và tổng giá trị sách (Bài 2)");
            System.out.println("3. Tìm sách theo mã (Bài 4)");
            System.out.println("4. Hiển thị danh sách sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng sách muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    // Vòng lặp for để nhập n sách
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin sách thứ " + (i + 1) + " ---");
                        Sach s = nhapSach(sc);
                        if (s.isHopLe()) {
                            danhSach.add(s);
                            System.out.println("-> Thêm sách thành công!");
                        } else {
                            System.out.println("-> LỖI: Dữ liệu không hợp lệ (Giá > 0, SL >= 0, Năm hợp lệ). Bỏ qua sách này!");
                        }
                    }
                    break;

                case 2:
                    // ===== BÀI 2: TÍNH TỔNG SỐ LƯỢNG VÀ TỔNG GIÁ TRỊ =====
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống! Vui lòng nhập sách trước.");
                    } else {
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;
                        // Dùng vòng lặp for-each để duyệt
                        for (Sach s : danhSach) {
                            tongSoLuong += s.soLuong;
                            tongGiaTri += s.getTongTienNhap();
                        }
                        System.out.println("\n===== THỐNG KÊ THƯ VIỆN =====");
                        System.out.println("Tổng số lượng sách: " + tongSoLuong + " cuốn");
                        System.out.printf("Tổng giá trị nhập kho: %,.0f VNĐ\n", tongGiaTri);
                    }
                    break;

                case 3:
                    // ===== BÀI 4: TÌM SÁCH THEO MÃ =====
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập mã sách cần tìm: ");
                        String maTim = sc.nextLine();
                        boolean timThay = false;

                        // Vòng lặp để tìm kiếm
                        for (Sach s : danhSach) {
                            if (s.maSach.equalsIgnoreCase(maTim)) {
                                System.out.println("-> Đã tìm thấy sách:");
                                s.hienThi();
                                System.out.println("   Phân loại: " + s.getLoaiGia() + " | Tồn kho: " + s.getTonKho());
                                timThay = true;
                                break; // Tìm thấy thì dừng vòng lặp
                            }
                        }
                        if (!timThay) {
                            System.out.println("-> Không tìm thấy sách có mã: " + maTim);
                        }
                    }
                    break;

                case 4:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH SÁCH HIỆN CÓ =====");
                        for (Sach s : danhSach) {
                            s.hienThi();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0); // Điều kiện lặp của Menu (Bài 3)

        // =========================================================
        // PHẦN VIẾT NỐI TIẾP: BÀI TẬP MỚI (MẢNG VÀ LIST)
        // =========================================================
        System.out.println("\n\n****************************************************");
        System.out.println("*** CHÀO MỪNG ĐẾN VỚI PHẦN BÀI TẬP MẢNG VÀ LIST ***");
        System.out.println("****************************************************");

        // ===== BÀI 1 MỚI: MẢNG SỐ LƯỢNG CỦA 5 CUỐN SÁCH =====
        System.out.println("\n--- BÀI 1: Mảng số lượng của 5 cuốn sách ---");
        int[] soLuong = new int[5];
        int tongSL = 0;
        int maxSL = Integer.MIN_VALUE;

        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Nhập số lượng cuốn sách thứ " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
            tongSL += soLuong[i];
            if (soLuong[i] > maxSL) {
                maxSL = soLuong[i];
            }
        }

        System.out.print("-> Hiển thị mảng số lượng: [");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print(soLuong[i] + (i < 4 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("-> Tổng số lượng: " + tongSL);
        System.out.println("-> Số lượng lớn nhất: " + maxSL);


        // ===== BÀI 2 MỚI: ArrayList<String> LƯU MÃ SÁCH =====
        System.out.println("\n--- BÀI 2: Quản lý mã sách bằng ArrayList<String> ---");
        List<String> dsMaSach = new ArrayList<>();

        // 1. Thêm mã sách
        dsMaSach.add("S01");
        dsMaSach.add("S02");
        dsMaSach.add("S03");
        System.out.println("Đã thêm 3 mã sách mẫu: S01, S02, S03");

        // 2. Hiển thị
        System.out.println("Danh sách mã sách hiện tại: " + dsMaSach);

        // 3. Tìm mã sách
        String maCanTim = "S02";
        if (dsMaSach.contains(maCanTim)) {
            System.out.println("-> Tìm thấy mã sách: " + maCanTim + " (Dùng hàm contains())");
        } else {
            System.out.println("-> Không tìm thấy mã sách: " + maCanTim);
        }

        // 4. Xóa mã sách
        dsMaSach.remove("S02");
        System.out.println("-> Đã xóa mã S02. Danh sách sau khi xóa: " + dsMaSach);


        // ===== BÀI 3 & BÀI 4 MỚI: MENU HOÀN CHỈNH (CRUD) =====
        System.out.println("\n--- BÀI 3 & 4: MENU QUẢN LÝ SÁCH NÂNG CAO ---");
        List<Sach> danhSachNangCao = new ArrayList<>();
        int luaChonMoi;

        do {
            System.out.println("\n========== MENU QUẢN LÝ THƯ VIỆN (MỚI) ==========");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát chương trình hoàn toàn");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChonMoi = Integer.parseInt(sc.nextLine());

            switch (luaChonMoi) {
                case 1: // Thêm sách
                    System.out.print("Nhập số lượng sách muốn thêm: ");
                    int nMoi = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < nMoi; i++) {
                        System.out.println("\n--- Nhập thông tin sách thứ " + (i + 1) + " ---");
                        Sach s = nhapSach(sc);
                        if (s.isHopLe()) {
                            danhSachNangCao.add(s);
                            System.out.println("-> Thêm sách thành công!");
                        } else {
                            System.out.println("-> LỖI: Dữ liệu không hợp lệ! Bỏ qua.");
                        }
                    }
                    break;

                case 2: // Hiển thị
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH SÁCH (" + danhSachNangCao.size() + " cuốn) =====");
                        for (Sach s : danhSachNangCao) {
                            s.hienThi();
                        }
                    }
                    break;

                case 3: // Tìm sách
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập mã sách cần tìm: ");
                        String maTim = sc.nextLine();
                        boolean timThay = false;
                        for (Sach s : danhSachNangCao) {
                            if (s.maSach.equalsIgnoreCase(maTim)) {
                                System.out.println("-> Đã tìm thấy:");
                                s.hienThi();
                                timThay = true;
                                break;
                            }
                        }
                        if (!timThay) System.out.println("-> Không tìm thấy sách có mã: " + maTim);
                    }
                    break;

                case 4: // Xóa sách
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập mã sách cần xóa: ");
                        String maXoa = sc.nextLine();
                        boolean daXoa = false;
                        for (int i = 0; i < danhSachNangCao.size(); i++) {
                            if (danhSachNangCao.get(i).maSach.equalsIgnoreCase(maXoa)) {
                                danhSachNangCao.remove(i); // Xóa bằng hàm remove của List
                                daXoa = true;
                                System.out.println("-> Đã xóa sách có mã: " + maXoa);
                                break;
                            }
                        }
                        if (!daXoa) System.out.println("-> Không tìm thấy sách để xóa!");
                    }
                    break;

                case 5: // Sửa sách
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập mã sách cần sửa: ");
                        String maSua = sc.nextLine();
                        boolean daSua = false;
                        for (int i = 0; i < danhSachNangCao.size(); i++) {
                            if (danhSachNangCao.get(i).maSach.equalsIgnoreCase(maSua)) {
                                System.out.println("-> Tìm thấy. Nhập thông tin mới:");
                                Sach sMoi = nhapSach(sc);
                                if (sMoi.isHopLe()) {
                                    danhSachNangCao.set(i, sMoi); // Cập nhật bằng hàm set của List
                                    System.out.println("-> Cập nhật thành công!");
                                } else {
                                    System.out.println("-> LỖI: Dữ liệu không hợp lệ. Hủy sửa!");
                                }
                                daSua = true;
                                break;
                            }
                        }
                        if (!daSua) System.out.println("-> Không tìm thấy sách để sửa!");
                    }
                    break;

                case 6: // Tính tổng số lượng
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        int tongSLMoi = 0;
                        for (Sach s : danhSachNangCao) {
                            tongSLMoi += s.soLuong;
                        }
                        System.out.println("-> Tổng số lượng sách: " + tongSLMoi + " cuốn.");
                    }
                    break;

                case 7: // Tính tổng giá trị
                    if (danhSachNangCao.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        double tongGiaTriMoi = 0;
                        for (Sach s : danhSachNangCao) {
                            tongGiaTriMoi += s.getTongTienNhap();
                        }
                        System.out.printf("-> Tổng giá trị nhập kho: %,.0f VNĐ\n", tongGiaTriMoi);
                    }
                    break;

                case 8:
                    System.out.println("Đã thoát chương trình hoàn toàn. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChonMoi != 8);

        sc.close();
    }
}
