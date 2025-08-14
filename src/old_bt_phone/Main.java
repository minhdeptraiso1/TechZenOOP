package old_bt_phone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    //bien chon
    static int choose;
    //bien dem
    static int count;
    //arraylist tong
    static ArrayList<Phone> phones = new ArrayList<>();
    //tao
    static boolean create = true;

    public static void main(String[] args) {
        //test
        OldPhone x = new OldPhone();
        x.add4();//defau method Interface có thể overide hoặc ko/ ko yêu cầu triển khai
        x.promote(2);//ko co body yeu cau overide bởi tất cả các con //buộc phải triển khai
        Promotion.add3();//static method Interface // tương tự default nhưng ko Overide được
        //menu chinh
        initSampleData();
        while (true) {
            do {
                System.out.println("========================================MENU CHÍNH - CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI========================================");
                System.out.println("1. Xem danh sách điện thoại");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp theo giá");
                System.out.println("6. Tìm kiếm");
                System.out.println("7. Tính tổng tiền");
                System.out.println("8. Giảm giá cho điện thoại cũ");
                System.out.println("9. Thoát");

                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        menuShow();//xong
                        break;
                    case 2:
                        menuAdd();//xong
                        break;
                    case 3:
                        menuUpdate();//xong
                        break;
                    case 4:
                        menuDelete();//xong
                        break;
                    case 5:
                        menuSort();//xong
                        break;
                    case 6:
                        menuFind();//xong
                        break;
                    case 7:
                        menuSumTotal2();//xong
                        break;
                    case 8:
                        menuVocherO();//chưa
                        break;
                    case 9:
                        System.out.print("Bạn có chắc chắn muốn thoát (Y/N)? ");
                        String confirm = sc.nextLine().trim().toLowerCase();
                        if (confirm.equalsIgnoreCase("y")) {
                            return;
                        } else {
                            System.out.println("Hủy thoát.");
                        }
                        break;
                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại!");
                        break;
                }

            } while (choose < 1 || choose > 9);
        }
    }

    //test
    private static void initSampleData() {
        // Thêm một số điện thoại mẫu
        phones.add(new NewPhone("DTM000", "iPhone 15", 25000000, "12/2025", "iOS", "Apple", 5));
        phones.add(new NewPhone("DTM001", "Samsung Galaxy S24", 20000000, "06/2025", "Android", "Samsung", 3));
        phones.add(new OldPhone("DTC000", "iPhone 12", 15000000, "12/2024", "iOS", "Apple", 85));
        phones.add(new OldPhone("DTC001", "Samsung Note 20", 12000000, "08/2024", "Android", "Samsung", 70));
    }

    //menu case1
    public static void menuShow() {
        while (true) {
            do {
                System.out.println("========================================XEM DANH SÁCH ĐIỆN THOẠI========================================");
                System.out.println("1. Xem danh sách tất cả điện thoại ");
                System.out.println("2. Xem danh sách tất cả điện thoại cũ ");
                System.out.println("3. Xem danh sách tất cả điện thoại mới ");
                System.out.println("4. Quay lại menu chính ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        showListAll();
                        break;
                    case 2:
                        showListOld();
                        break;
                    case 3:
                        showListNew();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại!");
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }

    //menu case2
    public static void menuAdd() {
        while (true) {
            do {
                System.out.println("========================================THÊM MỚI ĐIỆN THOẠI========================================");
                System.out.println("1. Thêm điện thoại cũ ");
                System.out.println("2. Thêm điện thoại mới ");
                System.out.println("3. Quay lại menu chính ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        addOldPhone();
                        break;
                    case 2:
                        addNewPhone();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại!");
                        break;
                }

            } while (choose < 1 || choose > 3);
        }
    }

    //case3-4 ko can tao menu
    // menu case 5
    public static void menuSort() {
        while (true) {
            do {
                System.out.println("========================================SẮP XẾP ĐIỆN THOẠI========================================");
                System.out.println("1. Tăng dần ");
                System.out.println("2. Giảm dần ");
                System.out.println("3. Quay lại menu chính ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        sortByFor(phones, true);
                        break;
                    case 2:
                        sortByFor(phones, false);
                        break;
                    case 3:
                        return;


                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại");
                        break;
                }

            } while (choose < 1 || choose > 3);
        }
    }

    //menu case6
    public static void menuFind() {
        while (true) {
            do {
                System.out.println("========================================TÌM KIẾM ĐIỆN THOẠI========================================");
                System.out.println("1. Tìm kiếm tất cả điện thoại ");
                System.out.println("2. Tìm kiếm điện thoại cũ ");
                System.out.println("3. Tìm kiếm điện thoại mới ");
                System.out.println("4. Quay lại menu chính ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        menuFindInAll();
                        break;
                    case 2:
                        menuFindInOld();
                        break;
                    case 3:
                        menuFindInNew();
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại");
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }

    public static void menuFindInAll() {
        while (true) {
            do {
                System.out.println("========================================TÌM KIẾM ĐIỆN THOẠI========================================");
                System.out.println("1. Tìm kiếm theo giá");//nhap khoang 90-999 nhap 2 so
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Quay lại menu tìm kiếm ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        findByPrice(Phone.class);
                        break;
                    case 2:
                        findByName(Phone.class);
                        break;
                    case 3:
                        findByCompany(Phone.class);
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại");
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }

    public static void menuFindInOld() {
        while (true) {
            do {
                System.out.println("========================================TÌM KIẾM ĐIỆN THOẠI========================================");
                System.out.println("1. Tìm kiếm theo giá");//nhap khoang 90-999 nhap 2 so
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Quay lại menu tìm kiếm ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        findByPrice(OldPhone.class);
                        break;
                    case 2:
                        findByName(OldPhone.class);
                        break;
                    case 3:
                        findByCompany(OldPhone.class);
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại");
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }

    public static void menuFindInNew() {
        while (true) {
            do {
                System.out.println("========================================TÌM KIẾM ĐIỆN THOẠI========================================");
                System.out.println("1. Tìm kiếm theo giá");//nhap khoang 90-999 nhap 2 so
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Quay lại menu tìm kiếm ");


                System.out.print("Mời bạn lựa chọn : ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        findByPrice(NewPhone.class);
                        break;
                    case 2:
                        findByName(NewPhone.class);
                        break;
                    case 3:
                        findByCompany(NewPhone.class);
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Không hợp lệ vui lòng nhập lại");
                        break;
                }
            } while (choose < 1 || choose > 4);
        }
    }
    //menu case 7-8 ko can tao

    //method hiển thị case1
    public static void showListAll() {
        if (phones.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            count = 0;
            System.out.println("==============================Danh sách tất cả điện thoại==============================");
            for (Phone p : phones) {
                System.out.println("Điện thoại thứ " + ++count);
                p.output();
            }
        }
    }

    public static void showListOld() {
        if (phones.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            count = 0;
            System.out.println("==============================Danh sách điện thoại cũ==============================");
            for (Phone p : phones) {
                if (p instanceof OldPhone) {
                    System.out.println("Điện thoại thứ " + ++count);
                    p.output();
                }
            }
        }
    }

    public static void showListNew() {
        if (phones.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            count = 0;
            System.out.println("==============================Danh sách điện thoại mới==============================");
            for (Phone p : phones) {
                if (p instanceof NewPhone) {
                    System.out.println("Điện thoại thứ " + ++count);
                    p.output();
                }
            }
        }
    }

    // method them dt
    //tao id
    //private static String getRandomIdentify() {
    //        int number = (int) (Math.random() * 1000);
    //        return String.format("%03d", number);
    //    }
    //
    //    private static boolean checkIdentify(String id) {
    //        for (Person person : persons) {
    //            if (person.getId().equals(id)) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    // Điện thoại mới: DTMXXX (với XXX là số tự động tăng từ 000 đến 999)
    // Điện thoại cũ: DTCXXX (với XXX là số tự động tăng từ 000 đến 999)
//    public static String getIdentityId(String prefix, Class<?> clazz) {
//        Random random = new Random();
//        ArrayList<Integer> existingIds = new ArrayList<>();
//
//        // Thu thập các số id đã tồn tại
//        for (Phone e : phones) {
//            if (clazz.isInstance(e)) {
//                String idStr = e.getPhoneId().substring(prefix.length());
//                existingIds.add(Integer.parseInt(idStr));
//            }
//        }
//
//        int id;
//        int attempts = 0;
//        do {
//            id = random.nextInt(1000); // random số từ 0 đến 999
//            attempts++;
//            if (attempts > 1000) {
//                throw new RuntimeException("Không thể tìm được ID ngẫu nhiên không trùng sau 1000 lần thử");
//            }
//        } while (existingIds.contains(id));
//
//        return String.format("%s%03d", prefix, id);
//    }
    //them case2
    private static String getIdentityId(String prefix, Class<?> clazz) {
        int max = 0;

        for (Phone e : phones) {
            if (clazz.isInstance(e)) {
                String idStr = e.getPhoneId().substring(prefix.length());
                int id = Integer.parseInt(idStr);
                if (id > max) {
                    max = id;
                }
            }
        }
        ++max;
        // truong hop id tu dong tang den 1000 thi se kiem tra con id nao chua dung tu 000 den 999 ko
        if (max > 999) {
            // Thu thập các ID đã có vào Set để kiểm tra nhanh
            ArrayList<Integer> existingIds = new ArrayList<>();
            for (Phone e : phones) {
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
                    create = true;
                    break;
                }
            }

            if (max == -1) {
                create = false;

            }
        }

        return String.format("%s%03d", prefix, max);


    }

    public static void addNewPhone() {
        NewPhone newPhone = new NewPhone();
        newPhone.input(sc);
        newPhone.setPhoneId(getIdentityId("DTM", NewPhone.class));
        if (create) {
            phones.add(newPhone);
            System.out.println("Thêm điện thoại mới thành công!");
        } else {
            System.out.println("Thêm điện thoại mới thất bại!");
        }
    }

    public static void addOldPhone() {
        OldPhone oldPhone = new OldPhone();
        oldPhone.input(sc);
        oldPhone.setPhoneId(getIdentityId("DTC", OldPhone.class));
        if (create) {
            phones.add(oldPhone);
            System.out.println("Thêm điện thoại mới thành công!");
        } else {
            System.out.println("Thêm điện thoại mới thất bại!");
        }
    }

    //sua case3
    public static void menuUpdate() {
        System.out.println("========================================CẬP NHẬT ĐIỆN THOẠI========================================");
        String id;
        while (true) {
            System.out.print("Nhập vào ID điện thoại muốn cập nhật thông tin: ");
            id = sc.nextLine().trim();
            if (!(id.startsWith("DTC") || id.startsWith("DTM")) || id.length() != 6) {
                System.out.println("Lỗi: ID không đúng định dạng. ID phải bắt đầu bằng DTC hoặc DTM và có 6 ký tự.");
            } else {
                break;
            }
        }
        boolean isFound = false;

        for (Phone p : phones) {
            if (p.getPhoneId().equalsIgnoreCase(id)) {
                isFound = true;
                p.input(sc);
                System.out.println("Cập nhật thành công!");
                break;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy ID muốn cập nhật!");
        }
    }

    //xoa case4
    public static void menuDelete() {
        System.out.println("========================================XÓA ĐIỆN THOẠI========================================");
        String id;
        while (true) {
            System.out.print("Nhập vào ID điện thoại muốn xóa: ");
            id = sc.nextLine().trim();
            if (!(id.startsWith("DTC") || id.startsWith("DTM")) || id.length() != 6) {
                System.out.println("Lỗi: ID không đúng định dạng. ID phải bắt đầu bằng DTC hoặc DTM và có 6 ký tự.");
            } else {
                break;
            }
        }
        boolean isFound = false;
        for (int i = 0; i < phones.size(); i++) {
            Phone p = phones.get(i);
            if (p.getPhoneId().equalsIgnoreCase(id)) {
                isFound = true;

                System.out.print("Bạn có chắc chắn muốn xóa điện thoại (Y/N)? ");
                String confirm = sc.nextLine().trim().toLowerCase();
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
    }

    //sap xep danh sách case5
    public static void sortByFor(ArrayList<Phone> phones, boolean ascending) {
        for (int i = 0; i < phones.size() - 1; i++) {
            for (int j = i + 1; j < phones.size(); j++) {
                double salaryI = phones.get(i).getPhonePrice();
                double salaryJ = phones.get(j).getPhonePrice();

                boolean needSwap = ascending
                        ? salaryI > salaryJ
                        : salaryI < salaryJ;
                if (needSwap) {
                    Phone temp = phones.get(i);
                    phones.set(i, phones.get(j));
                    phones.set(j, temp);
                }
            }
        }
        count = 0;
        for (Phone p : phones) {
            System.out.println("Điện thoại thứ " + ++count);
            p.output();

        }
    }

    //tim kiem case6
    // khoang xxx den yyy
    public static void findByPrice(Class<?> clazz) {
        double maxPrice, minPrice;
        boolean fond = false;
        System.out.println("NHập giá từ : ");
        minPrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập giá đến : ");
        maxPrice = sc.nextDouble();
        sc.nextLine();
        //kiem tra neu min  > max sẽ lỗi ở iff
        if (minPrice > maxPrice) {
            double temp = maxPrice;
            maxPrice = minPrice;
            minPrice = temp;
        }
        for (Phone p : phones) {
            if (clazz.isInstance(p) && p.getPhonePrice() >= minPrice && p.getPhonePrice() <= maxPrice) {
                p.output();
                fond = true;
            }
        }
        if (!fond) {
            System.out.printf("Không tìm thấy điện thoại nằm trong khoảng %.0f VND đến %.0f VND", minPrice, maxPrice);

        }
    }

    //tim kiem theo ten
    public static void findByName(Class<?> clazzz) {
        String keyword;
        boolean fond = false;
        System.out.println("Nhập tên cần tìm");
        keyword = sc.nextLine().trim().toLowerCase();
        for (Phone p : phones) {
            if (clazzz.isInstance(p)) {
                if (p.getPhoneName().trim().toLowerCase().equals(keyword)) {
                    p.output();
                    fond = true;
                }
            }
        }
        if (!fond) {
            System.out.printf("Không tìm thấy điện thoại có tên %s:", keyword);

        }
    }

    //tim kiem theo hang
    public static void findByCompany(Class<?> clazzz) {
        String keyword;
        boolean fond = false;
        System.out.println("Nhập hãng điện thoại cần tìm");
        keyword = sc.nextLine().trim().toLowerCase();
        for (Phone p : phones) {
            if (clazzz.isInstance(p)) {
                if (p.getPhoneName().trim().toLowerCase().contains(keyword)) {
                    p.output();
                    fond = true;
                }
            }
        }
        if (!fond) {
            System.out.printf("Không tìm thấy điện thoại của hãng điện thoại %s:", keyword);

        }
    }

    //tong gia case7
    public static void menuSumTotal2() {
        double sumAllTotalNew = 0, sumAllTotalOld = 0;
        for (Phone p : phones) {
            if (p instanceof OldPhone o) {
                sumAllTotalOld += o.phonePrice();
            } else if (p instanceof NewPhone n) {
                sumAllTotalNew += n.phonePrice();
            }
        }

        System.out.println("Tổng giá của tất cả điện thoại cũ là : " + sumAllTotalOld + "vnd");
        System.out.println("Tổng giá của tất cả điện thoại mới là : " + sumAllTotalNew + "vnd");
        System.out.println("Tổng giá của tất cả điện thoại là : " + (sumAllTotalOld + sumAllTotalNew) + "vnd");


    }

    //lac de
    public static void menuSumTotal() {
        double sumAllTotalNew = 0, sumAllTotalOld = 0;
        for (Phone p : phones) {
            if (p instanceof OldPhone o) {
                sumAllTotalOld += o.getPhonePrice();
            } else if (p instanceof NewPhone n) {
                sumAllTotalNew += n.getPhonePrice();
            }
        }

        System.out.println("Tổng giá của điện thoại cũ là : " + sumAllTotalOld + "vnd");
        System.out.println("Tổng giá của điện thoại mới là : " + sumAllTotalNew + "vnd");
        System.out.println("Tổng giá của tất cả điện thoại là : " + (sumAllTotalOld + sumAllTotalNew) + "vnd");


    }

    // mã giảm giá case8
    public static void menuVocherO() {
        int vocher;
        while (true) {
            System.out.println("Nhap ti lệ giảm giá cho điện thoại cũ");
            vocher = sc.nextInt();
            sc.nextLine();
            if (vocher < 0 || vocher > 100) {
                System.out.println("Sai tỷ lệ giảm giá! Vui lòng nhập từ 0-100%");
            } else {
                break;
            }
        }
        for (Phone p : phones) {
            if (p instanceof OldPhone o) {
                o.promote(vocher);
            }
        }
        System.out.println("Đã áp dụng giảm giá " + vocher + " % cho điện thoại cũ.");

    }

}
