package Tinh_Dong_GOi.TeacherManager;

import java.util.ArrayList;
import java.util.Scanner;

public class teacherManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<teacher> listOfTeacher = new ArrayList<>();
        int choice;



        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách giảng viên");
            System.out.println("2. In danh sách giảng viên");
            System.out.println("3. Tìm giảng viên theo tên");
            System.out.println("4. Thêm giảng viên mới");
            System.out.println("5. Đếm số lượng giảng viên");
            System.out.println("6. Giảng viên có số giờ lớn nhất");
            System.out.println("7. Số lượng giảng viên dạy < 20h");
            System.out.println("8. tìm theo kí tự");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");

            // Kiểm tra nhập đúng số nguyên không
            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số từ 1 đến 9: ");
                sc.next(); // bỏ giá trị sai
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    importTeacher(sc, listOfTeacher);
                    break;

                case 2:
                    printTeacher(listOfTeacher);
                    break;

                case 3:
                    findByName(sc, listOfTeacher);
                    break;

                case 4:
                    addTeacher(listOfTeacher);
                    break;

                case 5:
                    System.out.println("Danh sách có " + teacher.getCount() + " giảng viên");
                    break;
                case 6:
                    biggestTime(listOfTeacher);
                    break;
                case 7:
                    smallestTime20Hour(listOfTeacher);
                    break;
                case 8:
                    findByText(sc,listOfTeacher);
                    break;
                case 9:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;


                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại!");
                    break;
            }

        } while (choice != 9);
    }

    public static void importTeacher(Scanner sc, ArrayList<teacher> listOfTeacher) {

        System.out.print("Bạn muốn nhập bao nhiêu giảng viên? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            addTeacher(listOfTeacher);
        }
    }

    public static void printTeacher(ArrayList<teacher> listOfTeacher) {
        if (listOfTeacher.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            System.out.println("=== Danh sách giảng viên ===");
            for (int i = 0; i < listOfTeacher.size(); i++) {
                System.out.println("==========Giảng viên thứ " + (i + 1) + "==========");
                listOfTeacher.get(i).output();
            }
        }
    }

    public static void findByName(Scanner sc, ArrayList<teacher> listOfTeacher) {
        System.out.print("Nhập tên cần tìm: ");
        String x = sc.nextLine().trim();
        boolean found = false;
        for (teacher t : listOfTeacher) {
            if (t.getName().trim().equalsIgnoreCase(x)) {
                System.out.println("=> Đã tìm thấy:");
                t.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy giảng viên nào tên là " + x);
        }
    }

    public static void addTeacher(ArrayList<teacher> listOfTeacher) {
        System.out.println("Nhập thông tin giảng viên mới:");
        teacher newTeacher = new teacher();
        newTeacher.input();
        listOfTeacher.add(newTeacher);
        System.out.println("Thêm thành công!");
        System.out.println("Danh sách có " + teacher.getCount() + " giảng viên");

    }

    public static void biggestTime(ArrayList<teacher> listOfTeacher) {
        double max = 0;
        int index = -1;

        for (int i = 0; i < listOfTeacher.size(); i++) {
            if (listOfTeacher.get(i).getTime() > max) {
                max = listOfTeacher.get(i).getTime();
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("Giảng viên dạy nhiều nhất là:");
            listOfTeacher.get(index).output();
        }
    }

    public static void smallestTime20Hour(ArrayList<teacher> listOfTeacher) {
        System.out.println("Giảng viên dạy < 20h là:");
        for (int i = 0; i < listOfTeacher.size(); i++) {
            if (listOfTeacher.get(i).getTime() < 20) {
                listOfTeacher.get(i).output();
            }
        }
    }

    public static void findByText(Scanner sc, ArrayList<teacher> listOfTeacher) {
        System.out.print("Nhập từ khóa cần tìm trong tên: ");
        String keyword = sc.nextLine().trim().toLowerCase();
        boolean found2 = false;

        for (teacher t : listOfTeacher) {
            String[] words = t.getName().toLowerCase().split(" "); // tách tên thành mảng từ
            for (String word : words) {
                if (word.startsWith(keyword)) {
                    System.out.println("=> Tìm thấy giảng viên:");
                    t.output();
                    found2 = true;
                    break;
                }
            }
        }

        if (!found2) {
            System.out.println("Không có giảng viên nào chứa từ '" + keyword + "' trong tên.");
        }
    }

}
