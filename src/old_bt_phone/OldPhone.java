package old_bt_phone;

import java.util.Scanner;

public class OldPhone extends Phone implements Promotion {
    private int batteryStatus;  //tinh trang pin : 0-100%

    public OldPhone() {
    }

    public OldPhone(String phoneId, String phoneName, double phonePrice, String phoneWarranty, String phoneType, String phoneCompany, int batteryStatus) {
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
            if (a.matches("\\d+")) {
                if (Integer.parseInt(a) < 0 || Integer.parseInt(a) > 100) {
                    System.out.println("Phải nằm trong khoảng 0-100 ");
                    continue;
                }
                this.batteryStatus = Integer.parseInt(a);
                break;
            } else {
                System.out.println("Không hợp lệ! \n Vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void promote(int ratio) {
        double currentPrice = getPhonePrice();
        double newPrice = currentPrice * (1 - ratio / 100.0);
        setPhonePrice(newPrice);
    }


    @Override
    public void output() {
        super.output();
        System.out.println("Tình trạng pin : " + this.batteryStatus + " %");
    }

    @Override
    public double phonePrice() {
        return this.getBatteryStatus() * this.getPhonePrice();
    }
}
