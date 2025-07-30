package Tinh_Ke_Thua.BaiTaps1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        int choose;
        while (true) {
            do {
                System.out.println("\n===== Màn Hình =====\nDANH SÁCH THÀNH VIÊN");
                System.out.println("1. Thêm thành viên (Trợ giảng hoặc giảng viên.)");
                System.out.println("2. Hiển thị danh sách thành viên");
                System.out.println("3. Tìm kiếm thành viên theo tên");
                System.out.println("4. Thống kê  số lượng thành viên:");
                System.out.println("5. Tìm thành viên có số giờ làm cao nhất ");
                System.out.println("6. Tìm thành viên có số giờ làm việc < 20 giờ/tháng");
                System.out.println("7. Hiển thị lương của từng thành viên(Tên,Lương)");
                System.out.println("8. Thoát...");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1 -> addPerson();
                    case 2 -> printPerson(persons);
                    case 3 -> searchByName();
                    case 4 -> statistics();
                    case 5 -> findMostWorkingHours();
                    case 6 -> findUnder20Hours();
                    case 7 -> printSalaries();
                    case 8 -> {return;}
                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 8);
        }
    }


    static Scanner sc = new Scanner(System.in);
    static ArrayList<PersonB1> persons = new ArrayList<>();

    private static String getIdentityId(Class<?> clazz) {
        int max = 0;
        String prefix = "";

        if (clazz == TeacherB1.class) {
            prefix = "TC0";
        } else if (clazz == TeacherSuport.class) {
            prefix = "TCS";
        }

        for (PersonB1 p : persons) {
            if (clazz.isInstance(p)) {
                String idStr = p.getId().substring(prefix.length());
                int id = Integer.parseInt(idStr);
                if (id > max) {
                    max = id;
                }
            }
        }

        int numDigits = 10 - prefix.length();
        return String.format("%s%0" + numDigits + "d", prefix, max + 1);
    }



    private static void addPerson() {
        System.out.println("Bạn muốn thêm thành viên nào?");
        System.out.println("1. Trợ giảng");
        System.out.println("2. Giảng viên");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1 -> add(TeacherSuport.class);
                case 2 -> add(TeacherB1.class);
                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 2.");
            }
        } while (choose < 1 || choose > 2);
    }

    private static void add(Class<?> clazz) {
        String id = getIdentityId(clazz);
        System.out.println("Thêm thành viên với id #" + id);

        PersonB1 person = null;

        if (clazz == TeacherB1.class) {
            person = new TeacherB1();
        } else if (clazz == TeacherSuport.class) {
            person = new TeacherSuport();
        }

        if (person != null) {
            person.setId(id);
            person.input(sc);
            persons.add(person);
            System.out.println("Thêm thành công !!!");
        } else {
            System.out.println("Không xác định loại thành viên.");
        }
    }

    public static void printHeader() {
        System.out.println("====================================================================================================================");
        System.out.printf("| %-6s | %-20s | %-8s | %-25s | %-15s | %-15s |\n",
                "ID", "Tên", "Tuổi", "Thời gian làm việc", "Môn dạy", "Lương (VND)");
        System.out.println("====================================================================================================================");
    }
    private static void printPerson(ArrayList<PersonB1> persons) {
        boolean hasTeacherB1 = false;
        boolean hasTeacherSuport = false;

        for (PersonB1 p : persons) {
            if (p instanceof TeacherB1) hasTeacherB1 = true;
            else if (p instanceof TeacherSuport) hasTeacherSuport = true;
        }

        if (hasTeacherB1) {
            System.out.println("============================================ Danh sách giảng viên ===========================================");
            printHeader();
            for (PersonB1 p : persons) {
                if (p instanceof TeacherB1) {
                    System.out.println(p);
                }
            }
            System.out.println("====================================================================================================================");
        }

        if (hasTeacherSuport) {
            System.out.println("\n========================================== Danh sách trợ giảng =============================================");
            for (PersonB1 p : persons) {
                if (p instanceof TeacherSuport) {
                    System.out.println(p);
                }
            }
            System.out.println("====================================================================================================================");
        }

        if (!hasTeacherB1 && !hasTeacherSuport) {
            System.out.println("❌ Không có dữ liệu để hiển thị.");
        }
    }

    private static void searchByName() {
        System.out.print("Nhập tên cần tìm: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;
        for (PersonB1 p : persons) {
            if (p.getName().toLowerCase().contains(name)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("❌ Không tìm thấy thành viên nào.");
    }

    private static void statistics() {
        int countTeacher = 0;
        int countSupport = 0;
        for (PersonB1 p : persons) {
            if (p instanceof TeacherB1) countTeacher++;
            if (p instanceof TeacherSuport) countSupport++;
        }
        System.out.println("Số giảng viên: " + countTeacher);
        System.out.println("Số trợ giảng: " + countSupport);
        System.out.println("Tổng số thành viên: " + persons.size());
    }

    private static void findMostWorkingHours() {
        if (persons.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        PersonB1 max = persons.stream().max(Comparator.comparingDouble(PersonB1::getWorkingTime)).orElse(null);
        System.out.println("Thành viên có số giờ làm cao nhất:");
        System.out.println(max);
    }

    private static void findUnder20Hours() {
        boolean found = false;
        for (PersonB1 p : persons) {
            if (p.getWorkingTime() < 20) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Không có ai làm dưới 20 giờ.");
    }

    private static void printSalaries() {
        System.out.printf("%-20s | %.20s\n", "Teen ", "Luong");
        for (PersonB1 p : persons) {
            System.out.printf("%-20s | %.2f VND\n", p.getName(), p.wagePerson().doubleValue());
        }
    }
}
