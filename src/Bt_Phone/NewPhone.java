package Bt_Phone;

import Bt_Phone.exception_phone.InvalidPhoneDataException;
import Bt_Phone.exception_phone.PhoneValidationException;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int phoneNumber; // so luong dien thoai

    // ==================== CONSTRUCTORS ====================

    public NewPhone() {
        super();
    }

    public NewPhone(String phoneId, String phoneName, double phonePrice,
                    String phoneWarranty, String phoneType, String phoneCompany,
                    int phoneNumber) throws InvalidPhoneDataException {
        super(phoneId, phoneName, phonePrice, phoneWarranty, phoneType, phoneCompany);
        try {
            this.setPhoneNumber(phoneNumber);
        } catch (IllegalArgumentException e) {
            throw new InvalidPhoneDataException("Lỗi khởi tạo NewPhone: " + e.getMessage(), e);
        }
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) throws IllegalArgumentException {
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Số lượng điện thoại phải lớn hơn 0!");
        }
        if (phoneNumber > 10000) {
            throw new IllegalArgumentException("Số lượng quá lớn! Tối đa 10,000 chiếc.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void input(Scanner sc) {
        // Gọi phương thức input của lớp cha để nhập thông tin cơ bản
        super.input(sc);

        // Nhập số lượng điện thoại với try-catch
        while (true) {
            try {
                System.out.print("Nhập số lượng điện thoại: ");
                String numberInput = sc.nextLine().trim();

                // Kiểm tra rỗng
                if (numberInput.isEmpty()) {
                    throw new Exception("Số lượng không được để trống!");
                }

                // Kiểm tra định dạng số
                if (!numberInput.matches("\\d+")) {
                    throw new Exception("Số lượng phải là số nguyên dương!");
                }

                int number = Integer.parseInt(numberInput);

                // Sử dụng setter để validate
                this.setPhoneNumber(number);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Số lượng phải là số nguyên!");
                System.out.println("Vui lòng nhập lại!\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }

    // ==================== OUTPUT METHOD ====================

    @Override
    public void output() {
        try {
            super.output();
            System.out.println("Số lượng: " + this.phoneNumber + " chiếc");
            System.out.println("Tổng giá trị: " + String.format("%,.0f VND", this.phonePrice()));
            System.out.println("============================");
        } catch (ArithmeticException e) {
            System.err.println("Lỗi tính toán tổng giá: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khi in thông tin NewPhone: " + e.getMessage());
        }
    }

    // ==================== PRICE CALCULATION ====================

    @Override
    public double phonePrice() throws ArithmeticException {
        try {
            if (phoneNumber <= 0) {
                throw new ArithmeticException("Số lượng phải lớn hơn 0 để tính tổng giá!");
            }

            double unitPrice = this.getPhonePrice();
            if (unitPrice <= 0) {
                throw new ArithmeticException("Giá đơn vị phải lớn hơn 0!");
            }

            // Kiểm tra overflow khi nhân
            if (phoneNumber > Double.MAX_VALUE / unitPrice) {
                throw new ArithmeticException("Tổng giá trị quá lớn! Vượt quá giới hạn tính toán.");
            }

            return phoneNumber * unitPrice;

        } catch (Exception e) {
            throw new ArithmeticException("Lỗi tính toán tổng giá: " + e.getMessage());
        }
    }

    // ==================== COMPARABLE ====================

    @Override
    public int compareTo(Phone other) {
        if (other == null) {
            throw new NullPointerException("Không thể so sánh với null!");
        }

        try {
            // So sánh theo tổng giá trị (quantity * price)
            double thisTotalPrice = this.phonePrice();
            double otherTotalPrice = other.phonePrice();

            return Double.compare(thisTotalPrice, otherTotalPrice);

        } catch (ArithmeticException e) {
            System.err.println("Lỗi khi so sánh giá: " + e.getMessage());
            // Fallback: so sánh theo giá đơn vị
            return Double.compare(this.getPhonePrice(), other.getPhonePrice());
        }
    }

    // ==================== VALIDATION METHOD ====================

    /**
     * Kiểm tra tính hợp lệ của NewPhone object
     *
     * @throws PhoneValidationException nếu có lỗi validation
     */
    @Override
    public void validate() throws PhoneValidationException {
        // Validate lớp cha trước
        super.validate();

        // Validate riêng cho NewPhone
        if (phoneNumber <= 0) {
            throw new PhoneValidationException("Số lượng điện thoại phải lớn hơn 0!");
        }
        if (phoneNumber > 10000) {
            throw new PhoneValidationException("Số lượng quá lớn! Tối đa 10,000 chiếc.");
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Tính giá trung bình mỗi chiếc
     *
     * @return giá trung bình
     */
    public double getAveragePrice() {
        if (phoneNumber <= 0) {
            return 0;
        }
        return this.phonePrice() / phoneNumber;
    }

    /**
     * Kiểm tra có phải là lô hàng lớn không (>= 100 chiếc)
     *
     * @return true nếu là lô lớn
     */
    public boolean isBulkOrder() {
        return phoneNumber >= 100;
    }

    /**
     * Tính discount cho lô hàng lớn
     *
     * @return tổng giá sau discount
     */
    public double getPriceWithDiscount() {
        try {
            double totalPrice = this.phonePrice();

            if (isBulkOrder()) {
                // Giảm 5% cho lô hàng >= 100 chiếc
                return totalPrice * 0.95;
            }

            return totalPrice;

        } catch (ArithmeticException e) {
            System.err.println("Lỗi tính discount: " + e.getMessage());
            return 0;
        }
    }

    // ==================== EQUALS & HASHCODE ====================

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof NewPhone newPhone)) return false;
        return phoneNumber == newPhone.phoneNumber;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), phoneNumber);
    }

    // ==================== TO STRING ====================

    @Override
    public String toString() {
        return String.format("NewPhone{%s, quantity=%d, totalValue=%.0f}",
                super.toString().replace("Phone{", "").replace("}", ""),
                phoneNumber,
                phonePrice());
    }
}
