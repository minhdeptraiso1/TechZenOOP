package Tinh_Dong_GOi.TeacherManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class teacher {
    private int id;
    private String name;
    private int age;
    private String subject;
    private double time;
    private static int count;
    public teacher() {
        count++;
        this.id = count;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập tên giáo viên: ");
                this.name = sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn không được nhập số và kí tự đặc biệt!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }

        while (true) {
            try {
                int age;
                System.out.print("Nhập tuổi: ");
                age = sc.nextInt();
                sc.nextLine(); // Xoá bộ đệm

                if (age < 0) {
                    System.out.println("Tuổi không thể nhỏ hơn 0! Nhập lại.");
                    continue;
                }

                this.age = age; // Gán khi hợp lệ
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một nguyên!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
        while (true) {
            try {
                System.out.print("Nhập môn học : ");
                this.subject = sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn không thể nhập kí tự đặc biệt!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
        while (true) {
            try {
                System.out.print("Nhập thời gian làm việc: ");
                this.time = sc.nextDouble();
                sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số thực!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
    }
    public void output(){
        System.out.println("Id giảng viên : "+id );
        System.out.println("Tên giảng viên : "+name );
        System.out.println("Tuổi giảng viên : "+age +" tuooir");
        System.out.println("Giảng viên môn : "+subject );
        System.out.println("Thơi gian làm việc : "+time +" giờ / tháng");
        System.out.println("===============================================");

    }
    //tim theo ten



    // thêm giảng viên


}
