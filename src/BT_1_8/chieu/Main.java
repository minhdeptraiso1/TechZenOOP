package BT_1_8.chieu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        int choose;
        while (true) {
            do {
                System.out.println("\n===== Màn Hình =====\nHệ Thống Quản Lý Academy");
                System.out.println("1. Thêm thành viên");
                System.out.println("2. Hiển thị danh sách thành viên");
                System.out.println("3. Tìm kiếm thành viên theo tên hoặc email");
                System.out.println("4. Cập nhật thông tin cho thành viên");
                System.out.println("5. Xóa thành viên");
                System.out.println("6. Sắp xếp học viên theo điểm trung bình");
                System.out.println("7. Tính học phí của học viên");
                System.out.println("8. Tính  lương của  giảng viên");
                System.out.println("9. Tìm kếm giảng viên có bao nhiêu trợ giảng");
                System.out.println("10. Thoát...");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1 -> addPerson();

                    case 2 -> printPerson();

                    case 3 -> findPerson();
                    case 4 -> updatePerson();
                    case 5 -> deletePerson();
                    case 6 -> menuSortByAVG();
                    case 7 -> tuitionStudent();
                    case 8 -> tuitionTeacher();
                    case 9 -> findTeacherByTeacherSuport();

                    case 10 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 7);
        }
    }

    private static void addPerson() {
        System.out.println("Bạn muốn thêm thành viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        System.out.println("3. Giảng viên");
        System.out.println("4. Trợ giảng");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
//                case 1 -> ;
//                case 2 -> ;
//                case 3 -> ;
//                case 4 -> ;
                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 4.");
            }
        } while (choose < 1 || choose > 4);
    }

    private static void printPerson() {
        System.out.println("Bạn muốn hiển thị danh sách thành viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        System.out.println("3. Giảng viên");
        System.out.println("4. Trợ giảng");
        System.out.println("5. Taats cả");

        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
//                case 1 -> ;
//                case 2 -> ;
//                case 3 -> ;
//                case 4 -> ;
//                case 5 -> ;
                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 5.");
            }
        } while (choose < 1 || choose > 5);
    }

    private static void findPerson() {

    }

    private static void updatePerson() {

    }

    private static void deletePerson() {

    }

    private static void menuSortByAVG() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 4 =====\nSẮP XẾP THEO ĐIỂM TRUNG BÌNH");
                System.out.println("1. Học viên backend");
                System.out.println("2. Học viên fullstack");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:

                        break;
                    case 2:

                        break;

                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static void tuitionStudent() {
        System.out.println("Bạn muốn tính học phí cho học viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
//                case 1 -> ;
//                case 2 -> ;

                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 2.");
            }
        } while (choose < 1 || choose > 2);
    }

    private static void findTeacherByTeacherSuport() {

    }

    private static void tuitionTeacher() {
        System.out.println("Bạn muốn tính học phí cho giảng viên nào?");
        System.out.println("1. Giảng viên chính");
        System.out.println("2. Trợ giảng");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
//                case 1 -> ;
//                case 2 -> ;

                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 2.");
            }
        } while (choose < 1 || choose > 2);
    }


    //6---------------------------------------------------------------------------------------
    private static <T extends Person & IStudent> void sortAllStudentsUtil(Class<T> clazz, List<T> persons) {
        List<T> filteredList = new ArrayList<>();
        for (T e : persons) {
            if (clazz.isInstance(e)) {
                filteredList.add(e);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("Không có học viên nào !");
            return;
        }

        System.out.println("1. Tăng dần theo điểm trung bình");
        System.out.println("2. Giảm dần theo điểm trung bình");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(filteredList, true);
        } else if (choose == 2) {
            sortByFor(filteredList, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo điểm trung bình -----");
        int count = 1;
        for (T l : persons) {
            System.out.println("Học viên thứ " + count++);

            System.out.println("ID: " + l.getId());
            System.out.println("Tên: " + l.getName());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Điểm trung bình: " + l.getDiemTrungBinh());
            System.out.println("Xếp loại: " + l.xepLoai());
            System.out.println("----------------------------");
        }
    }

    // Sắp xếp danh sách theo điểm trung bình
    private static <T extends Person & IStudent> void sortByFor(List<T> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double avgI = list.get(i).getDiemTrungBinh();
                double avgJ = list.get(j).getDiemTrungBinh();

                boolean needSwap = ascending ? avgI > avgJ : avgI < avgJ;
                if (needSwap) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    //7  In danh sách
    private static <T extends Person & IStudent> void printList(List<T> list) {
        int count = 1;
        for (T l : list) {
            if (l instanceof StudentBE) {
                System.out.println("Học viên backend thứ " + count++);
            } else if (l instanceof StudentFT) {
                System.out.println("Học viên fullstack thứ " + count++);
            }

            System.out.println("ID: " + l.getId());
            System.out.println("Tên: " + l.getName());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Điểm trung bình: " + l.getDiemTrungBinh());
            System.out.println("Xếp loại: " + l.xepLoai());
            System.out.println("Học phí: " + l.getTuition() + " VND");
            System.out.println("----------------------------");
        }
    }


    //---------------------------------------------------------------------------------------
    private static <T extends Student & IStudent> ArrayList<T> filterStudent(Class<T> type) { // type = ManagementEmployee.class
        ArrayList<T> result = new ArrayList<>();
        for (Person student2 : persons) {
            if (type.isInstance(student2)) {
                result.add(type.cast(student2));
            }
        }
        return result;
    }


}
