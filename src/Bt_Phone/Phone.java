package Bt_Phone;

import java.util.Scanner;

abstract class Phone {
    private String phoneId;         //id
    private String phoneName;       //ten dien thoai
    private String phonePrice;      //gia
    private String phoneWarranty;   //thoi gian bao hanh
    private String phoneType;       //loai dien thoai : androi/ios
    private String phoneCompany;    //hãng dien thoai : IPhone/xiaomi

    public Phone() {
    }

    public Phone(String phoneId, String phoneName, String phonePrice, String phoneWarranty, String phoneType, String phoneCompany) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneWarranty = phoneWarranty;
        this.phoneType = phoneType;
        this.phoneCompany = phoneCompany;
    }

    public void input(Scanner sc) {
        while (true) {
            System.out.println("Nhập tên điện thoại");
            this.phoneName = sc.nextLine().trim();
            if (this.phoneName.matches("[a-zA-Zà-ỹà-ỹ0-9\\s]")) {
                break;
            } else {
                System.out.println("Tên không hợp lệ! \n Vui lòn nhập lại!");
            }
        }
        while (true) {
            System.out.println("Nhập giá của điện thoại");
            this.phonePrice = sc.nextLine().trim();
            if (this.phonePrice.matches("[0-9\\s]")) {
                break;
            } else {
                System.out.println("Giá không hợp lệ! \n Vui lòng nhập lại!");
            }
        }
        while (true) {
            System.out.println("Nhập thời gian bảo hành");
            this.phoneWarranty = sc.nextLine().trim();
            if (this.phoneWarranty.matches("a-zA-Zà-ỹà-ỹ0-9\\s]")) {
                break;
            } else {
                System.out.println("Thời gian không hợp lệ!\n Vui lòng nhập lại!");
            }
        }
        while (true) {
            System.out.println("Loại điện thoại: \n 1. Hệ điều hành Ios \n 2. Hệ điều hành Androi");
            this.phoneType = sc.nextLine().trim();
            if (this.phoneType.equals("1")) {
                this.phoneType = "Ios";
                break;
            } else if (this.phoneType.equals("2")) {
                this.phoneType = "Androi";
                break;
            } else {
                System.out.println("Không hợp lệ! \n Vui lòng nhập lại!");
            }
        }
        while (true) {
            System.out.println("Nhập hãng điện thoại:");
            this.phoneCompany = sc.nextLine().trim();
            if (this.phoneCompany.matches("[a-zÀ-Ỹà-ỹA-Z\\s]")) {
                break;
            } else {
                System.out.println("Hãng không hợp lệ! \n Vui lòng nhập lại!");
            }

        }
    }

    public void output() {
        System.out.println("Id : " + this.phoneId);
        System.out.println("Tên điện thoại : " + this.phoneName);
        System.out.println("Giá điện thoại : " + this.phonePrice + " VND");
        System.out.println("Thời gian bảo hành : " + this.phoneWarranty);
        System.out.println("Loại điện thoại : " + this.phoneType);
        System.out.println("Hãng điện thoại : " + this.phoneCompany);
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(String phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneWarranty() {
        return phoneWarranty;
    }

    public void setPhoneWarranty(String phoneWarranty) {
        this.phoneWarranty = phoneWarranty;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }
}
