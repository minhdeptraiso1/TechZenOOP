package Tinh_Dong_GOi.Student;

import java.util.Scanner;

public class Student {
    private static int autoId = 1;
    private static int countStudent = 0;

    private int id;
    private String name;
    private int age;
    private double avgScore;

    public Student() {
        this.id = autoId++;
        countStudent++;
    }

    public Student(String name, int age, double avgScore) {
        this.id = autoId++;
        this.name = name;
        this.age = age;
        this.avgScore = avgScore;
        countStudent++;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm sinh viên với id #" + id);

        // Nhập tên
        while (true) {
            System.out.print("Nhập tên sinh viên: ");
            this.name = sc.nextLine().trim();
            if (this.name.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) break;
            else System.out.println("❌ Tên không hợp lệ! Không chứa số hoặc ký tự đặc biệt.");
        }

        // Nhập tuổi
        while (true) {
            System.out.print("Nhập tuổi: ");
            if (sc.hasNextInt()) {
                this.age = sc.nextInt();
                if (this.age < 0) {
                    System.out.println("❌ Tuổi không hợp lệ! Phải >= 0.");
                    continue;
                }
                sc.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("❌ Tuổi không hợp lệ! Nhập số nguyên.");
                sc.nextLine(); // Clear buffer
            }
        }

        // Nhập điểm trung bình
        while (true) {
            System.out.print("Nhập điểm trung bình: ");
            if (sc.hasNextDouble()) {
                this.avgScore = sc.nextDouble();
                if (this.avgScore < 0 || this.avgScore > 10) {
                    System.out.println("❌ Điểm không hợp lệ! Từ 0 đến 10.");
                    continue;
                }
                sc.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("❌ Điểm không hợp lệ! Nhập số thực từ 0 - 10.");
                sc.nextLine(); // Clear buffer
            }
        }
    }

    // ===== Getter =====
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public static int getCountStudent() {
        return countStudent;
    }

    // ===== Hiển thị thông tin =====
    public void output() {
        System.out.printf("%-5d | %-20s | %-5d | %-6.2f\n", id, name, age, avgScore);
    }

    // ===== toString (tuỳ chọn) =====
    @Override
    public String toString() {
        return String.format("%-5d | %-20s | %-5d | %-6.2f", id, name, age, avgScore);
    }
}
