package ss10_exception;

import java.util.Scanner;

public class BaiTap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //b1
        try {
            System.out.print("Nhập một số nguyên: ");
            String input = sc.nextLine();

            // Chuyển sang số nguyên
            int number = Integer.parseInt(input);

            if (number < 0) {
                throw new IllegalArgumentException("Số âm không có căn bậc hai thực");
            }

            // Tính căn bậc hai
            double result = Math.sqrt(number);
            System.out.println("Căn bậc hai: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Báo lỗi NumberFormatException: không phải số nguyên.");
        } catch (IllegalArgumentException e) {
            System.out.println("Báo lỗi IllegalArgumentException: " + e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc");
        }
    }
}
