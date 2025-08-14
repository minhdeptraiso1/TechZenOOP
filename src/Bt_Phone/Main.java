package Bt_Phone;

import Bt_Phone.exception_phone.InvalidPhoneDataException;
import Bt_Phone.exception_phone.PhoneValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String PATH_PHONE_FILE = "src/Bt_Phone/phone.csv";
    static Scanner sc = new Scanner(System.in);
    static int choose;
    static int count;
    static ArrayList<Bt_Phone.Phone> phones = new ArrayList<>();

    public static void main(String[] args) {
        menuMain();
    }

    public static void menuMain() {
        initSampleData();
        // Menu chính với exception handling
        while (true) {
            try {
                showMainMenu();
                System.out.print("Mời bạn lựa chọn: ");
                choose = getValidChoice(1, 9);

                switch (choose) {
                    case 1 -> menuShow();
                    case 2 -> menuAdd();
                    //case 3 -> menuUpdate();
                    case 3 -> menuUpdateToFile();
                    //case 4 -> menuDelete();
                    case 4 -> menuDeleteToFile();
                    //case 5 -> menuSort();
                    case 5 -> menuSortToFile();
                    case 6 -> menuFind();
                    case 7 -> menuSumTotal2();
                    case 8 -> menuVoucherOld();
                    case 9 -> {
                        if (confirmExit()) {
                            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi không mong muốn: " + e.getMessage());
                System.out.println("Vui lòng thử lại!\n");
            }
        }
    }

    /**
     * Hiển thị menu chính
     */
    private static void showMainMenu() {
        System.out.println("=".repeat(100));
        System.out.println("                    MENU CHÍNH - CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI");
        System.out.println("=".repeat(100));
        System.out.println("1.Xem danh sách điện thoại");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Sắp xếp theo giá");
        System.out.println("6.Tìm kiếm");
        System.out.println("7.Tính tổng tiền");
        System.out.println("8.Giảm giá cho điện thoại cũ");
        System.out.println("9.Thoát");
        System.out.println("=".repeat(100));
    }

    /**
     * Lấy lựa chọn hợp lệ từ người dùng
     */
    private static int getValidChoice(int min, int max) {
        while (true) {
            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Lựa chọn không được để trống!");
                }

                int choice = Integer.parseInt(input);
                if (choice < min || choice > max) {
                    throw new IllegalArgumentException("Lựa chọn phải từ " + min + " đến " + max + "!");
                }

                return choice;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
                System.out.print("Nhập lại: ");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
    }

    /**
     * Xác nhận thoát chương trình
     */
    private static boolean confirmExit() {
        try {
            System.out.print("Bạn có chắc chắn muốn thoát (Y/N)? ");
            String confirm = sc.nextLine().trim();
            return confirm.equalsIgnoreCase("y");
        } catch (Exception e) {
            System.err.println("Lỗi xác nhận: " + e.getMessage());
            return false;
        }
    }

    // ==================== SAMPLE DATA ====================

    private static void initSampleData() {
        try {
            System.out.println("🔄 Đang khởi tạo dữ liệu mẫu...");

            phones.add(new NewPhone("DTM000", "iPhone 15 Pro Max", 25000000, "12", "iOS", "Apple", 5));
            phones.add(new NewPhone("DTM001", "Samsung Galaxy S24 Ultra", 20000000, "24", "Android", "Samsung", 3));
            phones.add(new OldPhone("DTC000", "iPhone 12 Pro", 15000000, "6", "iOS", "Apple", 85));
            phones.add(new OldPhone("DTC001", "Samsung Note 20", 12000000, "12", "Android", "Samsung", 70));

            System.out.println("Đã khởi tạo " + phones.size() + " điện thoại mẫu!\n");

        } catch (InvalidPhoneDataException e) {
            System.err.println("Lỗi khởi tạo dữ liệu: " + e.getMessage());
        }
    }

    // ==================== MENU SHOW (CASE 1) ====================

    public static void menuShow() {
        while (true) {
            try {
                System.out.println("=".repeat(80));
                System.out.println("                    XEM DANH SÁCH ĐIỆN THOẠI");
                System.out.println("=".repeat(80));
                System.out.println("1.Xem tất cả điện thoại");
                System.out.println("2.Xem điện thoại cũ");
                System.out.println("3.Xem điện thoại mới");
                System.out.println("4.Quay lại menu chính");
                System.out.println("=".repeat(80));

                System.out.print("Lựa chọn của bạn: ");
                choose = getValidChoice(1, 4);

                switch (choose) {
                    //case 1 -> showListAll();
                    case 1 -> showListAllFile();
                    //case 2 -> showListOld();
                    case 2 -> showListOldFile();
                    //case 3 -> showListNew();
                    case 3 -> showListNewFile();
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi menu hiển thị: " + e.getMessage());
            }
        }
    }

    public static void showListAll() {

        try {
            if (phones.isEmpty()) {
                System.out.println("📋 Danh sách điện thoại trống!");
                return;
            }

            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH TẤT CẢ ĐIỆN THOẠI");
            System.out.println("=".repeat(60));

            for (Bt_Phone.Phone p : phones) {
                System.out.println("Điện thoại thứ " + ++count);
                p.output();
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }


    public static void showListOld() {
        try {
            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH ĐIỆN THOẠI CŨ");
            System.out.println("=".repeat(60));

            for (Bt_Phone.Phone p : phones) {
                if (p instanceof OldPhone) {
                    System.out.println("Điện thoại cũ thứ " + ++count);
                    p.output();
                    System.out.println();
                }
            }

            if (count == 0) {
                System.out.println("Không có điện thoại cũ nào!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi hiển thị điện thoại cũ: " + e.getMessage());
        }
    }


    public static void showListNew() {
        try {
            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH ĐIỆN THOẠI MỚI");
            System.out.println("=".repeat(60));

            for (Bt_Phone.Phone p : phones) {
                if (p instanceof NewPhone) {
                    System.out.println("Điện thoại mới thứ " + ++count);
                    p.output();
                    System.out.println();
                }
            }

            if (count == 0) {
                System.out.println("Không có điện thoại mới nào!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi hiển thị điện thoại mới: " + e.getMessage());
        }
    }


    public static void menuAdd() {
        while (true) {
            try {
                System.out.println("=".repeat(80));
                System.out.println("                    THÊM MỚI ĐIỆN THOẠI");
                System.out.println("=".repeat(80));
                System.out.println("1.Thêm điện thoại cũ");
                System.out.println("2.Thêm điện thoại mới");
                System.out.println("3.Quay lại menu chính");
                System.out.println("=".repeat(80));

                System.out.print("Lựa chọn của bạn: ");
                choose = getValidChoice(1, 3);

                switch (choose) {
                    //case 1 -> addOldPhone();
                    case 1 -> addOldPhoneToFile();
                    //case 2 -> addNewPhone();
                    case 2 -> addNewPhoneToFile();
                    case 3 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi menu thêm: " + e.getMessage());
            }
        }
    }

    // ==================== ID GENERATION ====================

    private static String getIdentityId(String prefix, Class<?> clazz) {
        try {
            int max = -1;

            // Tìm ID cao nhất hiện có
            for (Bt_Phone.Phone e : phones) {
                if (clazz.isInstance(e)) {
                    String idStr = e.getPhoneId().substring(prefix.length());
                    int id = Integer.parseInt(idStr);
                    if (id > max) {
                        max = id;
                    }
                }
            }

            // Tăng lên 1
            max++;

            // Nếu vượt 999, tìm ID trống từ 000-999
            if (max > 999) {
                ArrayList<Integer> existingIds = new ArrayList<>();
                for (Bt_Phone.Phone e : phones) {
                    if (clazz.isInstance(e)) {
                        String idStr = e.getPhoneId().substring(prefix.length());
                        int id = Integer.parseInt(idStr);
                        existingIds.add(id);
                    }
                }

                max = -1;
                for (int i = 0; i <= 999; i++) {
                    if (!existingIds.contains(i)) {
                        max = i;
                        break;
                    }
                }

                if (max == -1) {
                    throw new RuntimeException("Đã hết ID có thể tạo! (0-999 đã đầy)");
                }
            }

            return String.format("%s%03d", prefix, max);

        } catch (Exception e) {
            throw new RuntimeException("Lỗi tạo ID: " + e.getMessage());
        }
    }

    public static void addNewPhone() {
        try {
            System.out.println("=".repeat(60));
            System.out.println("        THÊM ĐIỆN THOẠI MỚI");
            System.out.println("=".repeat(60));

            NewPhone newPhone = new NewPhone();
            newPhone.input(sc);

            String newId = getIdentityId("DTM", NewPhone.class);
            newPhone.setPhoneId(newId);

            // Validate trước khi thêm
            newPhone.validate();

            phones.add(newPhone);
            System.out.println("Thêm điện thoại mới thành công! ID: " + newId);

        } catch (PhoneValidationException e) {
            System.err.println("Lỗi validation: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Thêm điện thoại mới thất bại: " + e.getMessage());
        }
    }


    public static void addOldPhone() {
        try {
            System.out.println("=".repeat(60));
            System.out.println("        THÊM ĐIỆN THOẠI CŨ");
            System.out.println("=".repeat(60));

            OldPhone oldPhone = new OldPhone();
            oldPhone.input(sc);

            String newId = getIdentityId("DTC", OldPhone.class);
            oldPhone.setPhoneId(newId);

            // Validate trước khi thêm
            oldPhone.validate();

            phones.add(oldPhone);
            System.out.println("Thêm điện thoại cũ thành công! ID: " + newId); // ✅ SỬA: "cũ" thay vì "mới"

        } catch (PhoneValidationException e) {
            System.err.println("Lỗi validation: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Thêm điện thoại cũ thất bại: " + e.getMessage());
        }
    }


    // ==================== UPDATE (CASE 3) ====================

    public static void menuUpdate() {
        try {
            System.out.println("=".repeat(80));
            System.out.println("                    CẬP NHẬT ĐIỆN THOẠI");
            System.out.println("=".repeat(80));

            String id = getValidPhoneId("cập nhật thông tin");

            boolean isFound = false;
            for (Bt_Phone.Phone p : phones) {
                if (p.getPhoneId().equalsIgnoreCase(id)) {
                    isFound = true;
                    System.out.println("Tìm thấy điện thoại. Nhập thông tin mới:");
                    p.input(sc);
                    p.validate();
                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Không tìm thấy ID muốn cập nhật!");
            }

        } catch (Exception e) {
            System.err.println("Lỗi cập nhật: " + e.getMessage());
        }
    }

    public static void menuUpdateToFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.println("=".repeat(80));
            System.out.println("                    CẬP NHẬT ĐIỆN THOẠI");
            System.out.println("=".repeat(80));

            String id = getValidPhoneId("cập nhật thông tin");

            boolean isFound = false;
            for (Phone p : phones1) {
                if (p.getPhoneId().equalsIgnoreCase(id)) {
                    isFound = true;
                    System.out.println("📱 Tìm thấy điện thoại. Nhập thông tin mới:");
                    p.input(sc);
                    p.validate();
                    System.out.println("✅ Cập nhật thành công!");
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Không tìm thấy ID muốn cập nhật!");
            }

        } catch (Exception e) {
            System.err.println("Lỗi cập nhật: " + e.getMessage());
        }
        writeFile(phones1);
    }


    // ==================== DELETE (CASE 4) ====================

    public static void menuDelete() {
        try {
            System.out.println("=".repeat(80));
            System.out.println("                    XÓA ĐIỆN THOẠI");
            System.out.println("=".repeat(80));

            String id = getValidPhoneId("xóa");

            boolean isFound = false;
            for (int i = 0; i < phones.size(); i++) {
                Bt_Phone.Phone p = phones.get(i);
                if (p.getPhoneId().equalsIgnoreCase(id)) {
                    isFound = true;

                    System.out.println("Tìm thấy điện thoại:");
                    p.output();

                    System.out.print("Bạn có chắc chắn muốn xóa điện thoại này (Y/N)? ");
                    String confirm = sc.nextLine().trim();

                    if (confirm.equalsIgnoreCase("y")) {
                        phones.remove(i);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Hủy xóa.");
                    }
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Không tìm thấy ID muốn xóa!");
            }

        } catch (Exception e) {
            System.err.println("Lỗi xóa: " + e.getMessage());
        }
    }


    /**
     * Lấy ID điện thoại hợp lệ từ người dùng
     */
    private static String getValidPhoneId(String action) {
        while (true) {
            try {
                System.out.print("Nhập ID điện thoại muốn " + action + ": ");
                String id = sc.nextLine().trim().toUpperCase();

                if (id.isEmpty()) {
                    throw new IllegalArgumentException("ID không được để trống!");
                }

                if (!(id.startsWith("DTC") || id.startsWith("DTM")) || id.length() != 6) {
                    throw new IllegalArgumentException("ID không đúng định dạng! ID phải bắt đầu bằng DTC hoặc DTM và có 6 ký tự.");
                }

                return id;

            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    // ==================== SORT (CASE 5) ====================

    public static void menuSort() {
        while (true) {
            try {
                System.out.println("=".repeat(80));
                System.out.println("                    SẮP XẾP ĐIỆN THOẠI");
                System.out.println("=".repeat(80));
                System.out.println("1.Tăng dần theo giá");
                System.out.println("2.Giảm dần theo giá");
                System.out.println("3.Quay lại menu chính");
                System.out.println("=".repeat(80));

                System.out.print("Lựa chọn của bạn: ");
                choose = getValidChoice(1, 3);

                switch (choose) {
                    case 1 -> {
                        Collections.sort(phones);
                        System.out.println("Đã sắp xếp tăng dần theo giá!");
                        showListAll();
                    }
                    case 2 -> {
                        phones.sort(new PhoneComperator());
                        System.out.println("Đã sắp xếp giảm dần theo giá!");
                        showListAll();
                    }
                    case 3 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi sắp xếp: " + e.getMessage());
            }
        }
    }

    public static void menuSortToFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        while (true) {
            try {
                System.out.println("=".repeat(80));
                System.out.println("                    SẮP XẾP ĐIỆN THOẠI");
                System.out.println("=".repeat(80));
                System.out.println("1.Tăng dần theo giá");
                System.out.println("2.Giảm dần theo giá");
                System.out.println("3.Quay lại menu chính");
                System.out.println("=".repeat(80));

                System.out.print("Lựa chọn của bạn: ");
                choose = getValidChoice(1, 3);

                switch (choose) {
                    case 1 -> {
                        Collections.sort(phones1);
                        System.out.println("Đã sắp xếp tăng dần theo giá!");
                        showListAllFile();
                    }
                    case 2 -> {
                        phones1.sort(new PhoneComperator());
                        System.out.println("Đã sắp xếp giảm dần theo giá!");
                        showListAllFile();
                    }
                    case 3 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi sắp xếp: " + e.getMessage());
            }
            writeFile(phones1);
        }

    }

    // ==================== SEARCH (CASE 6) ====================

    public static void menuFind() {
        while (true) {
            try {
                System.out.println("=".repeat(80));
                System.out.println("                    TÌM KIẾM ĐIỆN THOẠI");
                System.out.println("=".repeat(80));
                System.out.println("1.Tìm trong tất cả điện thoại");
                System.out.println("2.Tìm trong điện thoại cũ");
                System.out.println("3.Tìm trong điện thoại mới");
                System.out.println("4.Quay lại menu chính");
                System.out.println("=".repeat(80));

                System.out.print("Lựa chọn của bạn: ");
                choose = getValidChoice(1, 4);

                switch (choose) {
                    //case 1 -> menuFindInAll();
                    case 1 -> menuFindInAllToFile();
                    // case 2 -> menuFindInOld();
                    case 2 -> menuFindInOldToFile();
                    //case 3 -> menuFindInNew();
                    case 3 -> menuFindInNewToFile();
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi menu tìm kiếm: " + e.getMessage());
            }
        }
    }

    // Các method menu tìm kiếm giữ nguyên nhưng thêm exception handling
    public static void menuFindInAll() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPrice(Bt_Phone.Phone.class);
                    case 2 -> findByName(Bt_Phone.Phone.class);
                    case 3 -> findByCompany(Bt_Phone.Phone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    public static void menuFindInOld() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPrice(OldPhone.class);
                    case 2 -> findByName(OldPhone.class);
                    case 3 -> findByCompany(OldPhone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    public static void menuFindInNew() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPrice(NewPhone.class);
                    case 2 -> findByName(NewPhone.class);
                    case 3 -> findByCompany(NewPhone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }


    // Các method menu tìm kiếm giữ nguyên nhưng thêm exception handling
    public static void menuFindInAllToFile() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPriceToFile(Bt_Phone.Phone.class);
                    case 2 -> findByNameToFile(Bt_Phone.Phone.class);
                    case 3 -> findByCompanyToFile(Bt_Phone.Phone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    public static void menuFindInOldToFile() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPriceToFile(OldPhone.class);
                    case 2 -> findByNameToFile(OldPhone.class);
                    case 3 -> findByCompanyToFile(OldPhone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    public static void menuFindInNewToFile() {
        while (true) {
            try {
                showSearchSubmenu();
                choose = getValidChoice(1, 4);

                switch (choose) {
                    case 1 -> findByPriceToFile(NewPhone.class);
                    case 2 -> findByNameToFile(NewPhone.class);
                    case 3 -> findByCompanyToFile(NewPhone.class);
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    private static void showSearchSubmenu() {
        System.out.println("=".repeat(60));
        System.out.println("        TÌM KIẾM ĐIỆN THOẠI");
        System.out.println("=".repeat(60));
        System.out.println("1.Tìm kiếm theo giá");
        System.out.println("2.Tìm kiếm theo tên");
        System.out.println("3.Tìm kiếm theo hãng");
        System.out.println("4.Quay lại menu tìm kiếm");
        System.out.println("=".repeat(60));
        System.out.print("Lựa chọn của bạn: ");
    }

    // ==================== SEARCH METHODS ====================

    public static void findByPrice(Class<?> clazz) {
        try {
            System.out.println("TÌM KIẾM THEO KHOẢNG GIÁ");
            System.out.println("-".repeat(40));

            double minPrice = getValidPrice("Nhập giá từ (VND): ");
            double maxPrice = getValidPrice("Nhập giá đến (VND): ");

            // Đảm bảo min <= max
            if (minPrice > maxPrice) {
                double temp = maxPrice;
                maxPrice = minPrice;
                minPrice = temp;
                System.out.println("Đã hoán đổi giá trị để minPrice <= maxPrice");
            }

            boolean found = false;
            count = 0;

            System.out.println("\nKết quả tìm kiếm:");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones) {
                if (clazz.isInstance(p) && p.getPhonePrice() >= minPrice && p.getPhonePrice() <= maxPrice) {
                    System.out.println(" Điện thoại thứ " + ++count);
                    p.output();
                    System.out.println();
                    found = true;
                }
            }

            if (!found) {
                System.out.printf(" Không tìm thấy điện thoại nằm trong khoảng %,.0f VND đến %,.0f VND\n",
                        minPrice, maxPrice);
            } else {
                System.out.println(" Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm theo giá: " + e.getMessage());
        }
    }

    public static void findByName(Class<?> clazz) {
        try {
            System.out.print("Nhập tên điện thoại cần tìm: ");
            String keyword = sc.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println(" Từ khóa tìm kiếm không được để trống!");
                return;
            }

            boolean found = false;
            count = 0;

            System.out.println("\n Kết quả tìm kiếm tên chứa: '" + keyword + "'");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones) {
                if (clazz.isInstance(p)) {
                    if (p.getPhoneName().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println("📱 Điện thoại thứ " + ++count);
                        p.output();
                        System.out.println();
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println(" Không tìm thấy điện thoại có tên chứa: '" + keyword + "'");
            } else {
                System.out.println(" Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm theo tên: " + e.getMessage());
        }
    }

    public static void findByCompany(Class<?> clazz) {
        try {
            System.out.print(" Nhập tên hãng điện thoại cần tìm: ");
            String keyword = sc.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println(" Tên hãng không được để trống!");
                return;
            }

            boolean found = false;
            count = 0;

            System.out.println("\n Kết quả tìm kiếm hãng chứa: '" + keyword + "'");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones) {
                if (clazz.isInstance(p)) {

                    if (p.getPhoneCompany().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println("Điện thoại thứ " + ++count);
                        p.output();
                        System.out.println();
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy điện thoại của hãng: '" + keyword + "'");
            } else {
                System.out.println("Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println("Lỗi tìm kiếm theo hãng: " + e.getMessage());
        }
    }

    /**
     * Lấy giá hợp lệ từ người dùng
     */
    private static double getValidPrice(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Giá không được để trống!");
                }

                double price = Double.parseDouble(input);

                if (price < 0) {
                    throw new IllegalArgumentException("Giá phải >= 0!");
                }

                return price;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    // ==================== TOTAL CALCULATION (CASE 7) ====================

    public static void menuSumTotal2() {
        try {
            double sumAllTotalNew = 0, sumAllTotalOld = 0;
            int countNew = 0, countOld = 0;

            for (Bt_Phone.Phone p : phones) {
                if (p instanceof OldPhone o) {
                    sumAllTotalOld += o.phonePrice();
                    countOld++;
                } else if (p instanceof NewPhone n) {
                    sumAllTotalNew += n.phonePrice();
                    countNew++;
                }
            }

            System.out.println("=".repeat(80));
            System.out.println("                    TỔNG KẾT GIÁ TRỊ ĐIỆN THOẠI");
            System.out.println("=".repeat(80));
            System.out.println("Điện thoại cũ:");
            System.out.println("   • Số lượng: " + countOld + " chiếc");
            System.out.println("   • Tổng giá trị: " + String.format("%,.0f VND", sumAllTotalOld));
            System.out.println();
            System.out.println("Điện thoại mới:");
            System.out.println("   • Số lượng: " + countNew + " chiếc");
            System.out.println("   • Tổng giá trị: " + String.format("%,.0f VND", sumAllTotalNew));
            System.out.println();
            System.out.println("TỔNG CỘNG TẤT CẢ:");
            System.out.println("   • Tổng số lượng: " + (countOld + countNew) + " chiếc");
            System.out.println("   • Tổng giá trị: " + String.format("%,.0f VND", (sumAllTotalOld + sumAllTotalNew)));
            System.out.println("=".repeat(80));

        } catch (Exception e) {
            System.err.println("Lỗi tính tổng tiền: " + e.getMessage());
        }
    }

    // ==================== DISCOUNT (CASE 8) ====================

    public static void menuVoucherOld() { // ✅ SỬA: Đổi tên từ menuVocherO
        try {
            System.out.println("=".repeat(80));
            System.out.println("                    GIẢM GIÁ CHO ĐIỆN THOẠI CŨ");
            System.out.println("=".repeat(80));

            // Đếm số điện thoại cũ
            int oldPhoneCount = 0;
            for (Bt_Phone.Phone p : phones) {
                if (p instanceof OldPhone) {
                    oldPhoneCount++;
                }
            }

            if (oldPhoneCount == 0) {
                System.out.println("Không có điện thoại cũ nào để áp dụng giảm giá!");
                return;
            }

            System.out.println("Tìm thấy " + oldPhoneCount + " điện thoại cũ");

            int discountRate = getValidDiscountRate();

            System.out.println("\nÁp dụng giảm giá " + discountRate + "% cho tất cả điện thoại cũ...");
            System.out.println("=".repeat(60));

            int appliedCount = 0;
            for (Bt_Phone.Phone p : phones) {
                if (p instanceof OldPhone o) {
                    try {
                        double oldPrice = o.getPhonePrice();
                        o.promote(discountRate);
                        double newPrice = o.getPhonePrice();

                        System.out.println("📱 " + o.getPhoneName() + " (" + o.getPhoneId() + "):");
                        System.out.println("   Giá cũ: " + String.format("%,.0f VND", oldPrice));
                        System.out.println("   Giá mới: " + String.format("%,.0f VND", newPrice));
                        System.out.println("   Tiết kiệm: " + String.format("%,.0f VND", oldPrice - newPrice));
                        System.out.println();

                        appliedCount++;
                    } catch (Exception e) {
                        System.err.println("Lỗi áp dụng giảm giá cho " + o.getPhoneId() + ": " + e.getMessage());
                    }
                }
            }

            System.out.println(" Đã áp dụng giảm giá " + discountRate + "% cho " + appliedCount + " điện thoại cũ!");

        } catch (Exception e) {
            System.err.println(" Lỗi giảm giá: " + e.getMessage());
        }
    }

    /**
     * Lấy tỷ lệ giảm giá hợp lệ
     */
    private static int getValidDiscountRate() {
        while (true) {
            try {
                System.out.print("Nhập tỷ lệ giảm giá cho điện thoại cũ (0-100%): ");
                String input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Tỷ lệ giảm giá không được để trống!");
                }

                int rate = Integer.parseInt(input);

                if (rate < 0 || rate > 100) {
                    throw new IllegalArgumentException("Tỷ lệ giảm giá phải từ 0-100%!");
                }

                return rate;

            } catch (NumberFormatException e) {
                System.out.println(" Lỗi: Vui lòng nhập số nguyên!");
            } catch (IllegalArgumentException e) {
                System.out.println(" Lỗi: " + e.getMessage());
            }
        }
    }


    /** FILE*/
    /**
     * xử lý file
     */
    public static List<Phone> readFile(String path) {
        File file = new File(path);
        List<Phone> phones1 = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            // Đọc và bỏ qua header
            String header = bufferedReader.readLine();
            if (header == null) {
                System.out.println(" File trống hoặc không đọc được!");
                return phones1;
            }
            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] data = line.split(",", -1); // -1 để giữ empty strings
                    if (data.length < 7) {
                        System.err.println(" Dòng " + lineNumber + " không đủ cột: " + line);
                        continue;
                    }
                    String id = data[0].trim();
                    if (id.startsWith("DTC")) {
                        OldPhone oldPhone = new OldPhone();

                        oldPhone.setPhoneId(data[0].trim());
                        oldPhone.setPhoneName(data[1].trim());
                        oldPhone.setPhonePrice(parseDouble(data[2].trim()));
                        oldPhone.setPhoneWarranty(data[3].trim());
                        String company = data[4].trim();
                        String phoneType = company.equalsIgnoreCase("Apple") ? "iOS" : "Android";
                        oldPhone.setPhoneType(phoneType);
                        oldPhone.setPhoneCompany(company);

                        if (!data[5].trim().isEmpty()) {
                            oldPhone.setBatteryStatus(Integer.parseInt(data[5].trim()));
                        } else {
                            oldPhone.setBatteryStatus(80);
                        }


                        phones1.add(oldPhone);


                    } else if (id.startsWith("DTM")) {

                        NewPhone newPhone = new NewPhone();

                        newPhone.setPhoneId(data[0].trim());
                        newPhone.setPhoneName(data[1].trim());
                        newPhone.setPhonePrice(parseDouble(data[2].trim()));
                        newPhone.setPhoneWarranty(data[3].trim());


                        String company = data[4].trim();
                        String phoneType = company.equalsIgnoreCase("Apple") ? "iOS" : "Android";
                        newPhone.setPhoneType(phoneType);
                        newPhone.setPhoneCompany(company);


                        if (data.length > 6 && !data[6].trim().isEmpty()) {
                            newPhone.setPhoneNumber(Integer.parseInt(data[6].trim()));
                        } else {
                            newPhone.setPhoneNumber(1);
                        }


                        phones1.add(newPhone);


                    } else {
                        System.err.println(" ID không hợp lệ ở dòng " + lineNumber + ": " + id);
                    }

                } catch (NumberFormatException e) {
                    System.err.println(" Lỗi parse số ở dòng " + lineNumber + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println(" Lỗi xử lý dòng " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println(" Không tìm thấy file: " + path);
            logger.log(Level.SEVERE, "File không tồn tại: " + path, e);
        } catch (IOException e) {
            System.err.println(" Lỗi đọc file: " + e.getMessage());
            logger.log(Level.SEVERE, "Lỗi khi đọc file", e);
        }

        return phones1;
    }

    /**
     * Parse double an toàn, xử lý scientific notation
     */
    private static double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        // Xử lý scientific notation như 2.0E7 → 20000000
        return Double.parseDouble(value);
    }


    public static void showList() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        for (Phone s : phones1) {
            System.out.println("\nThông tin sinh viên với ID: " + s.getPhoneId());
            s.output();
        }
    }

    private static void writeFile(List<Phone> phones1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID,Tên điện thoại,Giá bán,Thời gian bảo hành,Loại điện thoại,Hãng sản xuất,Tình trạng pin (%),Số lượng");

        for (Phone phone : phones1) {
            stringBuilder.append("\n");


            if (phone instanceof OldPhone oldPhone) {
                stringBuilder.append(String.format("%s,%s,%.0f,%s,%s,%s,%d,",
                        oldPhone.getPhoneId(),
                        oldPhone.getPhoneName(),
                        oldPhone.getPhonePrice(),
                        oldPhone.getPhoneWarranty(),
                        oldPhone.getPhoneType(),
                        oldPhone.getPhoneCompany(),
                        oldPhone.getBatteryStatus()
                ));
            } else if (phone instanceof NewPhone newPhone) {
                stringBuilder.append(String.format("%s,%s,%.0f,%s,%s,%s,,%d",
                        newPhone.getPhoneId(),
                        newPhone.getPhoneName(),
                        newPhone.getPhonePrice(),
                        newPhone.getPhoneWarranty(),
                        newPhone.getPhoneType(),
                        newPhone.getPhoneCompany(),
                        newPhone.getPhoneNumber()
                ));
            }
        }

        File file = new File(PATH_PHONE_FILE);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(stringBuilder.toString());
            System.out.println("Đã ghi file thành công!");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Lỗi khi ghi file", e);
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public static void showListAllFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            if (phones1.isEmpty()) {
                System.out.println(" Danh sách điện thoại trống!");
                return;
            }

            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH TẤT CẢ ĐIỆN THOẠI");
            System.out.println("=".repeat(60));

            for (Phone s : phones1) {
                System.out.println("\nThông tin điện thoại với ID: " + s.getPhoneId());
                s.output();

            }
        } catch (Exception e) {
            System.err.println(" Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }

    public static void showListNewFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            if (phones1.isEmpty()) {
                System.out.println(" Danh sách điện thoại trống!");
                return;
            }

            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH TẤT CẢ ĐIỆN THOẠI");
            System.out.println("=".repeat(60));

            for (Phone s : phones1) {
                if (s.getPhoneId().startsWith("DTM")) {
                    System.out.println("\nThông tin điện thoại với ID: " + s.getPhoneId());
                    s.output();
                }

            }
        } catch (Exception e) {
            System.err.println(" Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }

    public static void showListOldFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            if (phones1.isEmpty()) {
                System.out.println(" Danh sách điện thoại trống!");
                return;
            }

            count = 0;
            System.out.println("=".repeat(60));
            System.out.println("        DANH SÁCH TẤT CẢ ĐIỆN THOẠI");
            System.out.println("=".repeat(60));

            for (Phone s : phones1) {
                if (s.getPhoneId().startsWith("DTC")) {
                    System.out.println("\nThông tin điện thoại với ID: " + s.getPhoneId());
                    s.output();
                }

            }
        } catch (Exception e) {
            System.err.println(" Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }

    public static void addOldPhoneToFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.println("=".repeat(60));
            System.out.println("        THÊM ĐIỆN THOẠI MỚI");
            System.out.println("=".repeat(60));

            OldPhone oldPhone = new OldPhone();
            oldPhone.input(sc);

            String newId = getIdentityId("DTC", NewPhone.class);
            oldPhone.setPhoneId(newId);

            // Validate trước khi thêm
            oldPhone.validate();

            phones1.add(oldPhone);
            System.out.println(" Thêm điện thoại mới thành công! ID: " + newId);

        } catch (PhoneValidationException e) {
            System.err.println(" Lỗi validation: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Thêm điện thoại mới thất bại: " + e.getMessage());
        }

        writeFile(phones1);
    }

    public static void addNewPhoneToFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.println("=".repeat(60));
            System.out.println("        THÊM ĐIỆN THOẠI MỚI");
            System.out.println("=".repeat(60));

            NewPhone newPhone = new NewPhone();
            newPhone.input(sc);

            String newId = getIdentityId("DTM", NewPhone.class);
            newPhone.setPhoneId(newId);

            // Validate trước khi thêm
            newPhone.validate();

            phones1.add(newPhone);
            System.out.println(" Thêm điện thoại mới thành công! ID: " + newId);

        } catch (PhoneValidationException e) {
            System.err.println(" Lỗi validation: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Thêm điện thoại mới thất bại: " + e.getMessage());
        }

        writeFile(phones1);
    }

    public static void findByPriceToFile(Class<?> clazz) {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.println("TÌM KIẾM THEO KHOẢNG GIÁ");
            System.out.println("-".repeat(40));

            double minPrice = getValidPrice("Nhập giá từ (VND): ");
            double maxPrice = getValidPrice("Nhập giá đến (VND): ");

            // Đảm bảo min <= max
            if (minPrice > maxPrice) {
                double temp = maxPrice;
                maxPrice = minPrice;
                minPrice = temp;
                System.out.println("️ Đã hoán đổi giá trị để minPrice <= maxPrice");
            }

            boolean found = false;
            count = 0;

            System.out.println("\n Kết quả tìm kiếm:");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones1) {
                if (clazz.isInstance(p) && p.getPhonePrice() >= minPrice && p.getPhonePrice() <= maxPrice) {
                    System.out.println(" Điện thoại thứ " + ++count);
                    p.output();
                    System.out.println();
                    found = true;
                }
            }

            if (!found) {
                System.out.printf(" Không tìm thấy điện thoại nằm trong khoảng %,.0f VND đến %,.0f VND\n",
                        minPrice, maxPrice);
            } else {
                System.out.println(" Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm theo giá: " + e.getMessage());
        }
        writeFile(phones1);
    }

    public static void findByNameToFile(Class<?> clazz) {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.print(" Nhập tên điện thoại cần tìm: ");
            String keyword = sc.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println(" Từ khóa tìm kiếm không được để trống!");
                return;
            }

            boolean found = false;
            count = 0;

            System.out.println("\n Kết quả tìm kiếm tên chứa: '" + keyword + "'");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones1) {
                if (clazz.isInstance(p)) {
                    if (p.getPhoneName().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println(" Điện thoại thứ " + ++count);
                        p.output();
                        System.out.println();
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println(" Không tìm thấy điện thoại có tên chứa: '" + keyword + "'");
            } else {
                System.out.println(" Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm theo tên: " + e.getMessage());
        }
        writeFile(phones1);
    }

    public static void findByCompanyToFile(Class<?> clazz) {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.print(" Nhập tên hãng điện thoại cần tìm: ");
            String keyword = sc.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println(" Tên hãng không được để trống!");
                return;
            }

            boolean found = false;
            count = 0;

            System.out.println("\n Kết quả tìm kiếm hãng chứa: '" + keyword + "'");
            System.out.println("=".repeat(50));

            for (Bt_Phone.Phone p : phones1) {
                if (clazz.isInstance(p)) {
                    if (p.getPhoneCompany().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println(" Điện thoại thứ " + ++count);
                        p.output();
                        System.out.println();
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println(" Không tìm thấy điện thoại của hãng: '" + keyword + "'");
            } else {
                System.out.println(" Tìm thấy " + count + " điện thoại phù hợp!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm theo hãng: " + e.getMessage());
        }
        writeFile(phones1);
    }

    public static void menuDeleteToFile() {
        List<Phone> phones1 = readFile(PATH_PHONE_FILE);
        try {
            System.out.println("=".repeat(80));
            System.out.println("                    XÓA ĐIỆN THOẠI");
            System.out.println("=".repeat(80));

            String id = getValidPhoneId("xóa");

            boolean isFound = false;
            for (int i = 0; i < phones1.size(); i++) {
                Phone p = phones1.get(i);
                if (p.getPhoneId().equalsIgnoreCase(id)) {
                    isFound = true;

                    System.out.println(" Tìm thấy điện thoại:");
                    p.output();

                    System.out.print(" Bạn có chắc chắn muốn xóa điện thoại này (Y/N)? ");
                    String confirm = sc.nextLine().trim();

                    if (confirm.equalsIgnoreCase("y")) {
                        phones1.remove(i);
                        System.out.println(" Xóa thành công!");
                    } else {
                        System.out.println(" Hủy xóa.");
                    }
                    break;
                }
            }

            if (!isFound) {
                System.out.println(" Không tìm thấy ID muốn xóa!");
            }

        } catch (Exception e) {
            System.err.println(" Lỗi xóa: " + e.getMessage());
        }
        writeFile(phones1);
    }
}
