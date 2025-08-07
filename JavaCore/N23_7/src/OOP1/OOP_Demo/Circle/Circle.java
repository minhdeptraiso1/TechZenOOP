package OOP1.OOP_Demo.Circle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle {
    double radius;
    double centerX;
    double centerY;

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Nhập bán kính: ");
                radius = sc.nextDouble();
                if (radius <= 0) {
                    System.out.println("❌ Bán kính phải lớn hơn 0!");
                    continue;
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("❌ Bán kính phải là số thực!");
                sc.nextLine();
            }
        }

        while (true){
            try {
                System.out.print("Nhập tọa độ tâm X: ");
                centerX = sc.nextDouble();
                System.out.print("Nhập tọa độ tâm Y: ");
                centerY = sc.nextDouble();
                break;
            } catch (InputMismatchException e){
                System.out.println("❌ Tọa độ tâm phải là số thực!");
                sc.nextLine();
            }
        }
    }

    public void output(){
        System.out.println("🟢 Hình tròn có:");
        System.out.println("- Bán kính: " + radius);
        System.out.println("- Tâm: (" + centerX + ", " + centerY + ")");
        System.out.printf("- Chu vi: %.2f\n", getPerimeter());
        System.out.printf("- Diện tích: %.2f\n", getArea());
    }
}