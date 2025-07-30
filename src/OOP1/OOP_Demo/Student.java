package OOP1.OOP_Demo;

import java.util.Scanner;

public class Student {
    String name;
    Double literature;
    Double math;

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tên sinh viên: ");
            name = sc.nextLine().trim();
            if (name.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) break;
            else System.out.println("❌ Tên không hợp lệ. Vui lòng nhập lại (chỉ chữ và khoảng trắng)!");
        }

        while (true) {
            System.out.print("Nhập điểm Văn (0.0–10.0): ");
            if (sc.hasNextDouble()) {
                literature = sc.nextDouble();
                sc.nextLine(); // Clear buffer
                if (literature >= 0 && literature <= 10) {
                    break; // Điểm hợp lệ -> thoát loop
                }
                // Điểm không trong khoảng 0-10 -> tiếp tục loop
            } else {
                sc.nextLine(); // Clear invalid input (ký tự, chữ, ký tự đặc biệt)
                // Tiếp tục loop để nhập lại
            }
            System.out.println("❌ Điểm không hợp lệ. Nhập lại!");
        }

        while (true) {
            System.out.print("Nhập điểm Văn (0.0–10.0): ");
            if (sc.hasNextDouble()) {
                math = sc.nextDouble();
                sc.nextLine(); // Clear buffer
                if (math >= 0 && math <= 10) {
                    break; // Điểm hợp lệ -> thoát loop
                }
                // Điểm không trong khoảng 0-10 -> tiếp tục loop
            } else {
                sc.nextLine(); // Clear invalid input (ký tự, chữ, ký tự đặc biệt)
                // Tiếp tục loop để nhập lại
            }
            System.out.println("❌ Điểm không hợp lệ. Nhập lại!");
        }}

    double calculateAverageScore() {
        return (math + literature) / 2;
    }

    public void output() {
        System.out.printf("%-20s : %s\n", "👤 Tên", name);
        System.out.printf("%-20s : %.2f\n", "📘 Điểm Toán", math);
        System.out.printf("%-20s : %.2f\n", "📗 Điểm Văn", literature);
        System.out.printf("\u001B[31m%-20s  : %.2f\n", "📊 Điểm Trung Bình \u001B[0m", calculateAverageScore());
    }

//    //baiNhom1
//    private String fullName;
//    private float mathScore;
//    private float literatureScore;
//
//
//    public void input(Scanner sc) {
//        System.out.print("Enter full name: ");
//        String name = sc.nextLine();
//
//        float math;
//        float literature;
//
//        do {
//            System.out.print("Enter math score: ");
//            math = Float.parseFloat(sc.nextLine());
//
//            if (math < 0 || math > 10) {
//                System.out.println("\u001B[31m" + "Invalid math score. Please enter a score between 0 and 10." + "\u001B[0m");
//                continue;
//            }
//            break;
//        } while (true);
//
//        do {
//            System.out.print("Enter literature score: ");
//            literature = Float.parseFloat(sc.nextLine());
//
//            if (literature < 0 || literature > 10) {
//                System.out.println("\u001B[31m" + "Invalid literature score. Please enter a score between 0 and 10." +  "\u001B[0m");
//                continue;
//            }
//            break;
//        } while (true);
//
//        this.fullName = name;
//        this.mathScore = math;
//        this.literatureScore = literature;
//    }
//
//    public float calculateAverageScore(float mathScore, float literatureScore) {
//        return (mathScore + literatureScore) / 2;
//    }
//
//    public void output() {
//        final String CYAN = "\u001B[36m";
//        final String YELLOW = "\u001B[33m";
//        final String GREEN = "\u001B[32m";
//        final String PURPLE = "\u001B[35m";
//
//        System.out.println(CYAN + "Full name: " + this.fullName);
//        System.out.printf(YELLOW + "Math score: " + "%.1f\n", this.mathScore);
//        System.out.printf(GREEN + "Literature score: " + "%.1f\n", this.literatureScore);
//        System.out.printf(PURPLE + "GPA: " + "%.1f\u001B[0m\n", calculateAverageScore(this.mathScore, this.literatureScore));
//
//    }


}
