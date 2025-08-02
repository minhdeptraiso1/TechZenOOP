package BT_1_8.chieu;

import java.util.Scanner;

public class StudentBE extends Student {
    String ngonNguLapTrinh;
    int soBuoiHoc;

    public StudentBE() {
    }

    public StudentBE(String id, String name, int age, String email, double diemTrungBinh, String ngonNguLapTrinh, int soBuoiHoc) {
        super(id, name, age, email, diemTrungBinh);
        this.ngonNguLapTrinh = ngonNguLapTrinh;
        this.soBuoiHoc = soBuoiHoc;
    }

    public String getNgonNguLapTrinh() {
        return ngonNguLapTrinh;
    }

    public void setNgonNguLapTrinh(String ngonNguLapTrinh) {
        this.ngonNguLapTrinh = ngonNguLapTrinh;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("  %-20s|", ngonNguLapTrinh);
    }

    public void printHeaderSBE() {
        System.out.printf("| %10s | %-20s | %-8s | %-25s | %-10s | %-20s |\n",
                "ID", "Họ tên", "Tuổi", "Email", "Điểm TB", "Ngôn ngữ lập trình");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập ngôn ngữ lập trình: ");
        this.ngonNguLapTrinh = sc.nextLine().trim();
    }

    @Override
    public String xepLoai() {
        String loai;
        if (getDiemTrungBinh() >= 7.5) {
            loai = "Giỏi";
        } else if (getDiemTrungBinh() >= 5) {
            loai = "Khá";
        } else {
            loai = "Trung bình";
        }
        return loai;
    }

    @Override
    public double getTuition() {
        return soBuoiHoc * 50000 * 90 / 100;
    }
}
