package OOP_Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager  {
    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        // Regex: số nguyên hoặc số thập phân (có thể âm)
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0; // Khai báo biến n

        while(true){
            System.out.print("Nhập số sinh viên muốn nhập: ");
            String input = sc.nextLine(); // Đọc input dưới dạng String

            if(isNumeric(input)){
                n = Integer.parseInt(input); // Parse thành int
                if(n > 0) { // Kiểm tra số dương
                    break;
                } else {
                    System.out.println("Vui lòng nhập số nguyên dương!");
                }
            } else {
                System.out.println("Nhập số nguyên!");
            }
        }




        ArrayList<Student> students = new ArrayList<>();
        Student student;

        for (int i = 0; i < n; i++) {
            System.out.printf("\n=== Nhập sinh viên thứ %d ===\n", i + 1);
            student = new Student();
            student.input();
            students.add(student);
        }

        // In danh sách đẹp
        System.out.println("\n\n\033[1;34m========== DANH SÁCH SINH VIÊN ==========\033[0m\n");

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("\033[1;33m--- Sinh viên thứ %d ---\033[0m\n", i + 1);
            students.get(i).output();
            System.out.println("=".repeat(35) + "\n");
        }
    }

    //BaiNhom1
//    static final String RESET = "\u001B[0m";
//    static final String CYAN = "\u001B[36m";
//    static final String GREEN = "\u001B[32m";
//    static final String YELLOW = "\u001B[33m";
//    static final String PURPLE = "\u001B[35m";
//
//    static Scanner sc = new Scanner(System.in);
//    static ArrayList<Student> students = new ArrayList<>();
//
//    public static void addStudent() {
//        Student student = new Student();
//        student.input(sc);
//        students.add(student);
//    }
//
//    public static void displayStudents() {
//        for (Student student : students) {
//            System.out.println(CYAN + "++ ----------------------------------------- ++");
//            student.output();
//            System.out.println(CYAN + "++ ----------------------------------------- ++\n" + RESET);
//        }
//    }
//
//    public static void displayMenu() {
//        System.out.println(CYAN + ">> LỰA CHỌN TÍNH NĂNG <<" + RESET);
//        System.out.println(CYAN + "++ ----------------------------------------- ++");
//        System.out.println(GREEN + "| 1. Thêm sinh viên                           |");
//        System.out.println(YELLOW + "| 2. In danh sách sinh viên                   |");
//        System.out.println(PURPLE + "| 3. Kết thúc                                 |");
//        System.out.println(CYAN + "++ ----------------------------------------- ++" + RESET);
//    }
//
//
//
//    public static void main(String[] args) {
//        while (true) {
//            displayMenu();
//            System.out.print(YELLOW + "Your choice: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    System.out.print(CYAN + "Enter the number of students to input: ");
//                    int n =  Integer.parseInt(sc.nextLine());
//
//                    for (int i = 0; i < n; i++) {
//                        System.out.println(PURPLE + "Enter information for student #" + (i + 1) + RESET);
//                        addStudent();
//                    }
//                    break;
//                case 2:
//                    displayStudents();
//                    break;
//                default:
//                    System.out.print("Are u sure exit program (Y/N): ");
//                    String exit = sc.nextLine();
//                    if (exit.equalsIgnoreCase("y")) {
//                        return;
//                    }
//                    break;
//            }
//        }
//    }
}
