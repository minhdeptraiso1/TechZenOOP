package Bt_Phone;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int phoneNumber; // so luong dien thoai

    public NewPhone() {
    }

    public NewPhone(String phoneId, String phoneName, double phonePrice, String phoneWarranty, String phoneType, String phoneCompany, int phoneNumber) {
        super(phoneId, phoneName, phonePrice, phoneWarranty, phoneType, phoneCompany);
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        String a;
        while (true) {
            System.out.println("Nhập số lượng :");
            a = sc.nextLine();
            if (a.matches("\\d+")) {
                if (Integer.parseInt(a) < 0) {
                    System.out.println("Phải là số nguyên dương");
                    continue;
                }
                this.phoneNumber = Integer.parseInt(a);
                break;
            } else {
                System.out.println("Không hợp lệ! \n Vui lòng nhập lại!");
            }
        }
    }


    @Override
    public void output() {
        super.output();
        System.out.println("Số lượng : " + this.phoneNumber + " cái");
    }

    @Override
    public double phonePrice() {
        return this.getPhoneNumber() * this.getPhonePrice();
    }

}
