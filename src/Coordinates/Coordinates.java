package Coordinates;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Coordinates {
    double x;
    double y;

    public static double distanceTo(Coordinates f1, Coordinates f2){
        double dx = f2.x - f1.x;
        double dy = f2.y - f1.y;
        return Math.sqrt(dx * dx + dy * dy);
        // công thức AB= căn bậc 2 (xB−xA)^2+(yB−yA)^2
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập tọa độ x: ");
                x = sc.nextDouble();
                sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số thực!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
        while (true) {
            try {
                System.out.print("Nhập tọa độ y: ");
                x = sc.nextDouble();
                sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số thực!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }

    }
    public void output(){
        System.out.println("Toa do x : " + x+" toa do y: " + y);
    }
}
