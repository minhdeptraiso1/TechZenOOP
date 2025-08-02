package Bt_Phone;

import java.util.Scanner;

public class OldPhone extends Phone {
    private int batteryStatus;  //tinh trang pin : 0-100%

    public OldPhone() {
    }

    public OldPhone(String phoneId, String phoneName, String phonePrice, String phoneWarranty, String phoneType, String phoneCompany, int batteryStatus) {
        super(phoneId, phoneName, phonePrice, phoneWarranty, phoneType, phoneCompany);
        this.batteryStatus = batteryStatus;
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        String a;
        while (true) {
            System.out.println("Nhâp tình trạng pin hiện tại :");
            a = sc.nextLine();
            if (a.matches("[0-9]+")) {
                this.batteryStatus = Integer.parseInt(a);
                break;
            } else {
                System.out.println("Không hợp lệ! \n Vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Tình trạng pin : " + this.batteryStatus + " %");
    }
}
