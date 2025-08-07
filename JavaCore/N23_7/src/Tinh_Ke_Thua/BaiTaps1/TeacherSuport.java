package Tinh_Ke_Thua.BaiTaps1;

import java.math.BigDecimal;
import java.util.Scanner;

public class TeacherSuport extends PersonB1 {
    private String subjectSuport;
    private static double salaryCoefficient = 100000;
    public TeacherSuport() {
    }

    public static double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public String getSubjectSuport() {
        return subjectSuport;
    }

    public TeacherSuport(String name, int age, double workingTime, String subjectSuport) {
        super(name, age, workingTime);
        this.subjectSuport = subjectSuport;

    }
    @Override
    public BigDecimal wagePerson(){
        BigDecimal wage = BigDecimal.valueOf(getWorkingTime() * salaryCoefficient);
        return wage;
    }
    @Override
    public void input(Scanner sc) {
        super.input(sc);
        // Nhập môn hc
        while (true) {
            System.out.print("Nhập môn dạy: ");
            this.subjectSuport = sc.nextLine().trim();
            if (this.subjectSuport.matches("[a-zA-ZÀ-Ỹà-ỹ-0-9\\s]+")) break;
            else System.out.println("❌ Môn dạy không hợp lệ! Không chứa ký tự đặc biệt.");

        }
    }
    @Override
    public String toString() {
        return super.toString() +
                String.format(" | %-15s | %,.2f VND", subjectSuport, super.wagePerson().doubleValue());
    }
}
