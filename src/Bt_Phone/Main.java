package Bt_Phone;

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

    public static void main(String[] args) {
        //menu chinh

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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        break;
                }

            } while (choose < 1 || choose > 9);
        }
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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                    default:
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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;


                    default:
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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;


                    default:
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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                    default:
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }

    public static void menuFindIn() {
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

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                    default:
                        break;
                }

            } while (choose < 1 || choose > 4);
        }
    }
    //menu case 7-8 ko can tao

    //method hiển thị
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


}
