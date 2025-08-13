package Bt_Phone;

import java.util.Comparator;

public class PhoneComperator implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        try {
            // So sánh giảm dần theo giá đã tính toán
            return Double.compare(p2.phonePrice(), p1.phonePrice());
        } catch (ArithmeticException e) {
            // Fallback: so sánh theo giá gốc nếu có lỗi
            return Double.compare(p2.getPhonePrice(), p1.getPhonePrice());
        }
    }
}
