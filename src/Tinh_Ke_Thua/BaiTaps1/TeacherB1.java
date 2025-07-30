package Tinh_Ke_Thua.BaiTaps1;

import java.math.BigDecimal;
import java.util.Scanner;

public class TeacherB1 extends PersonB1 {
    private String subject;//môn hoc
    static double salaryCoefficient = 200000;

    public TeacherB1() {
    }

    public TeacherB1(String name, int age, double workingTime, String subject) {
        super(name, age, workingTime);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public static double getSalaryCoefficient() {
        return salaryCoefficient;
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
            this.subject = sc.nextLine().trim();
            if (this.subject.matches("[a-zA-ZÀ-Ỹà-ỹ-0-9\\s]+")) break;
            else System.out.println("❌ Môn dạy không hợp lệ! Không chứa ký tự đặc biệt.");

        }
    }
    @Override
    public String toString() {
        return super.toString() +
                String.format(" | %-15s | %,.2f VND", subject,super.wagePerson().doubleValue());
    }

}
