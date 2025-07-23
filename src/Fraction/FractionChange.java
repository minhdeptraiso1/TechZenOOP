package Fraction;

import java.util.ArrayList;
import java.util.Scanner;

public class FractionChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Fraction> fractions = new ArrayList<>();

        // Nhập 2 phân số
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập phân số thứ " + (i + 1) + ":");
            Fraction f = new Fraction();
            f.input();
            fractions.add(f);
        }

        // Lấy 2 phân số đã nhập
        Fraction f1 = fractions.get(0);
        Fraction f2 = fractions.get(1);

        f1.checkFraction(f1);

        f2.checkFraction(f2);
        // In các phân số đã nhập
        System.out.println("\n=== PHÂN SỐ ĐÃ NHẬP ===");
        System.out.print("Phân số thứ 1: ");
        f1.output();
        System.out.print("Phân số thứ 2: ");
        f2.output();

        // Tạo đối tượng để thực hiện các phép toán
        Fraction calculator = new Fraction();

        // Thực hiện các phép toán
        System.out.println("\n=== KẾT QUẢ CÁC PHÉP TOÁN ===");

        // Phép cộng
        System.out.print("Tổng: ");
        Fraction sum = calculator.sum(f1, f2);
        sum.output();

        // Phép trừ
        System.out.print("Hiệu: ");
        Fraction sub = calculator.subtraction(f1, f2);
        sub.output();

        // Phép nhân
        System.out.print("Tích: ");
        Fraction mul = calculator.multiplication(f1, f2);
        mul.output();

        // Phép chia
        System.out.print("Thương: ");
        try {
            if (f2.numerator == 0) {
                System.out.println("Không thể chia cho phân số có tử số bằng 0!");
            } else {
                Fraction div = calculator.division(f1, f2);
                div.output();
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi thực hiện phép chia!");
        }



    }
}