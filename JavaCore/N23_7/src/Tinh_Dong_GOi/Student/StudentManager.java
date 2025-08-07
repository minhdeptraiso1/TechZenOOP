package Tinh_Dong_GOi.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        Student newStudent = new Student();
        newStudent.input();
        students.add(newStudent);
        System.out.println("✅ Thêm học viên thành công!\n");
    }

    public static void displayStudents(ArrayList<Student> list) {
        System.out.println("\n============= Danh sách sinh viên =============");
        System.out.printf("%-5s | %-20s | %-5s | %-8s\n", "ID", "Tên", "Tuổi", "Điểm TB");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static ArrayList<Student> findByName(String keyword) {
        ArrayList<Student> list = new ArrayList<>();
        if (isEmptyList()) return list;

        for (Student student : students) {
            if (student.getName().trim().toLowerCase().contains(keyword)) {
                list.add(student);
            }
        }

        return list;
    }

    private static boolean isEmptyList() {
        if (students.isEmpty()) {
            System.out.println("⚠️ Chưa có học viên nào trong danh sách.\n");
            return true;
        }
        return false;
    }

    private static ArrayList<Student> findStudentMaxScore() {
        ArrayList<Student> result = new ArrayList<>();
        if (isEmptyList()) return result;

        double maxScore = students.get(0).getAvgScore();
        for (Student s : students) {
            if (s.getAvgScore() > maxScore) {
                maxScore = s.getAvgScore();
                result.clear();
                result.add(s);
            } else if (s.getAvgScore() == maxScore) {
                result.add(s);
            }
        }

        return result;
    }

    private static ArrayList<Student> findStudentAvgScore() {
        ArrayList<Student> result = new ArrayList<>();
        if (isEmptyList()) return result;

        for (Student s : students) {
            if (s.getAvgScore() < 5) {
                result.add(s);
            }
        }
        return result;
    }

    public static void displayMenu() {
        System.out.println(">> ===== LỰA CHỌN CHỨC NĂNG ===== <<");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm sinh viên theo tên");
        System.out.println("4. Hiển thị tổng số sinh viên");
        System.out.println("5. Sinh viên có điểm cao nhất");
        System.out.println("6. Sinh viên có điểm dưới trung bình (<5)");
        System.out.println("7. Thoát chương trình");
        System.out.print("→ Nhập lựa chọn của bạn: ");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choiceStr = sc.nextLine();

            switch (choiceStr) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    if (!isEmptyList()) {
                        displayStudents(students);
                    }
                    break;
                case "3":
                    System.out.print("🔍 Nhập tên cần tìm: ");
                    String keyword = sc.nextLine().trim().toLowerCase();
                    ArrayList<Student> listByName = findByName(keyword);

                    if (listByName.isEmpty()) {
                        System.out.println("❌ Không tìm thấy sinh viên nào tên chứa \"" + keyword + "\"\n");
                    } else {
                        displayStudents(listByName);
                    }
                    break;
                case "4":
                    System.out.println("📌 Tổng sinh viên hiện có: " + Student.getCountStudent() + "\n");
                    break;
                case "5":
                    ArrayList<Student> studentsMax = findStudentMaxScore();
                    if (!studentsMax.isEmpty()) {
                        System.out.println("🏆 Sinh viên có điểm cao nhất:");
                        displayStudents(studentsMax);
                    }
                    break;
                case "6":
                    ArrayList<Student> studentsLow = findStudentAvgScore();
                    if (!studentsLow.isEmpty()) {
                        System.out.println("📉 Sinh viên có điểm dưới trung bình:");
                        displayStudents(studentsLow);
                    }
                    break;
                case "7":
                    System.out.print("❓ Chắc chắn muốn thoát chương trình? (C/K): ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("C")) {
                        System.out.println("👋 Tạm biệt!");
                        return;
                    }
                    break;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ! Vui lòng nhập từ 1-7.\n");
            }
        }
    }
}
