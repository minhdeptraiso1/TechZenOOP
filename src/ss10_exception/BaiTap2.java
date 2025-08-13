package ss10_exception;

import java.io.IOException;
import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Nhập a:");
        a = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập b:");
        b = sc.nextInt();
        sc.nextLine();
        //uncheck có thể ể ngoài try cacth
        //divide(a, b);

//        try {
//            System.out.println(divide(a, b));
//        } catch (ArithmeticException e) {
//            System.out.println("Báo lỗi ArithmeticException: " + e.getMessage());
//        }
//    }
        //check phải bỏ vào và kí tên ở method
        try {
            System.out.println(divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Báo lỗi ArithmeticException: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ArithmeticException là một exc uncheck nên ko có throws ở method và try cacth ko lỗi nhưng ngược lại là 1 exc check sẽ báo lỗi
    //day la uncheck
//    private static double divide(int a, int b) {
//        if (b == 0) {
//            throw new ArithmeticException("Không thể chia cho 0");
//        }
//        return (double) a / b;
//    }
    //day la check
    private static double divide(int a, int b) throws IOException {
        if (b == 0) {
            throw new IOException("Không thể chia cho 0");
        }
        return (double) a / b;
    }
}
