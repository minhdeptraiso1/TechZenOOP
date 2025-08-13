package Bt_Phone;

import Bt_Phone.exception_phone.InvalidPhoneDataException;
import Bt_Phone.exception_phone.PhoneValidationException;

import java.util.Scanner;

public class OldPhone extends Phone implements Promotion {
    private int batteryStatus;  // tình trạng pin: 0-100%

    // ==================== CONSTRUCTORS ====================

    public OldPhone() {
        super();
    }

    public OldPhone(String phoneId, String phoneName, double phonePrice,
                    String phoneWarranty, String phoneType, String phoneCompany,
                    int batteryStatus) throws InvalidPhoneDataException {
        super(phoneId, phoneName, phonePrice, phoneWarranty, phoneType, phoneCompany);
        try {
            this.setBatteryStatus(batteryStatus);
        } catch (IllegalArgumentException e) {
            throw new InvalidPhoneDataException("Lỗi khởi tạo OldPhone: " + e.getMessage(), e);
        }
    }

    // ==================== GETTER & SETTER WITH VALIDATION ====================

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) throws IllegalArgumentException {
        if (batteryStatus < 0 || batteryStatus > 100) {
            throw new IllegalArgumentException("Tình trạng pin phải từ 0-100%!");
        }
        this.batteryStatus = batteryStatus;
    }

    // ==================== INPUT METHOD ====================

    @Override
    public void input(Scanner sc) {
        // Gọi phương thức input của lớp cha
        super.input(sc);

        // Nhập tình trạng pin với try-catch
        while (true) {
            try {
                System.out.print("Nhập tình trạng pin hiện tại (0-100%): "); // ✅ Sửa "Nhâp" -> "Nhập"
                String batteryInput = sc.nextLine().trim();

                // Kiểm tra rỗng
                if (batteryInput.isEmpty()) {
                    throw new Exception("Tình trạng pin không được để trống!");
                }

                // Kiểm tra định dạng số
                if (!batteryInput.matches("\\d+")) {
                    throw new Exception("Tình trạng pin phải là số nguyên!");
                }

                int battery = Integer.parseInt(batteryInput);

                // Sử dụng setter để validate
                this.setBatteryStatus(battery);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Tình trạng pin phải là số nguyên!");
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

    // ==================== PROMOTION INTERFACE ====================

    @Override
    public void promote(int ratio) throws IllegalArgumentException, ArithmeticException {
        if (ratio < 0 || ratio > 100) {
            throw new IllegalArgumentException("Tỷ lệ khuyến mãi phải từ 0-100%!");
        }

        try {
            double currentPrice = getPhonePrice();
            if (currentPrice <= 0) {
                throw new ArithmeticException("Giá hiện tại phải lớn hơn 0 để áp dụng khuyến mãi!");
            }

            double discountAmount = currentPrice * (ratio / 100.0);
            double newPrice = currentPrice - discountAmount;

            // Đảm bảo giá sau khuyến mãi không âm
            if (newPrice <= 0) {
                throw new ArithmeticException("Giá sau khuyến mãi không thể bằng 0 hoặc âm!");
            }

            this.setPhonePrice(newPrice);

            System.out.println("✅ Đã áp dụng khuyến mãi " + ratio + "%:");
            System.out.println("   Giá cũ: " + String.format("%,.0f VND", currentPrice));
            System.out.println("   Giảm: " + String.format("%,.0f VND", discountAmount));
            System.out.println("   Giá mới: " + String.format("%,.0f VND", newPrice));

        } catch (IllegalArgumentException e) {
            throw new ArithmeticException("Không thể set giá mới: " + e.getMessage());
        }
    }

    // ==================== OUTPUT METHOD ====================

    @Override
    public void output() {
        try {
            super.output();
            System.out.println("Tình trạng pin: " + this.batteryStatus + "%");
            System.out.println("Đánh giá pin: " + getBatteryStatusText());
            System.out.println("Giá đã điều chỉnh: " + String.format("%,.0f VND", this.phonePrice()));
            System.out.println("============================");
        } catch (ArithmeticException e) {
            System.err.println("Lỗi tính toán giá điều chỉnh: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khi in thông tin OldPhone: " + e.getMessage());
        }
    }

    // ==================== PRICE CALCULATION ====================

    @Override
    public double phonePrice() throws ArithmeticException {
        try {
            double basePrice = this.getPhonePrice();
            if (basePrice <= 0) {
                throw new ArithmeticException("Giá gốc phải lớn hơn 0!");
            }

            // ✅ SỬA LOGIC: Giá giảm theo tình trạng pin, không phải nhân
            // Pin tốt (80-100%): giữ nguyên giá
            // Pin trung bình (50-79%): giảm 10-30%
            // Pin yếu (20-49%): giảm 30-50%
            // Pin rất yếu (0-19%): giảm 50-70%

            double adjustmentRatio;
            if (batteryStatus >= 80) {
                adjustmentRatio = 1.0; // Giữ nguyên 100%
            } else if (batteryStatus >= 50) {
                adjustmentRatio = 0.9 - (80 - batteryStatus) * 0.02 / 30.0; // 90% - 70%
            } else if (batteryStatus >= 20) {
                adjustmentRatio = 0.7 - (50 - batteryStatus) * 0.02 / 30.0; // 70% - 50%
            } else {
                adjustmentRatio = 0.5 - batteryStatus * 0.02 / 20.0; // 50% - 30%
            }

            return basePrice * adjustmentRatio;

        } catch (Exception e) {
            throw new ArithmeticException("Lỗi tính toán giá điều chỉnh: " + e.getMessage());
        }
    }

    // ==================== COMPARABLE ====================

    @Override
    public int compareTo(Phone other) {
        if (other == null) {
            throw new NullPointerException("Không thể so sánh với null!");
        }

        try {
            // ✅ SỬA: So sánh theo giá đã điều chỉnh (phonePrice()), không phải giá gốc
            double thisAdjustedPrice = this.phonePrice();
            double otherPrice = other.phonePrice();

            return Double.compare(thisAdjustedPrice, otherPrice);

        } catch (ArithmeticException e) {
            System.err.println("Lỗi khi so sánh giá: " + e.getMessage());
            // Fallback: so sánh theo giá gốc
            return Double.compare(this.getPhonePrice(), other.getPhonePrice());
        }
    }

    // ==================== VALIDATION METHOD ====================

    @Override
    public void validate() throws PhoneValidationException {
        // Validate lớp cha trước
        super.validate();

        // Validate riêng cho OldPhone
        if (batteryStatus < 0 || batteryStatus > 100) {
            throw new PhoneValidationException("Tình trạng pin phải từ 0-100%!");
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Lấy mô tả tình trạng pin
     *
     * @return mô tả pin
     */
    public String getBatteryStatusText() {
        if (batteryStatus >= 80) {
            return "Rất tốt";
        } else if (batteryStatus >= 50) {
            return "Tốt";
        } else if (batteryStatus >= 20) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    /**
     * Kiểm tra pin có cần thay không
     *
     * @return true nếu pin cần thay (< 20%)
     */
    public boolean needBatteryReplacement() {
        return batteryStatus < 20;
    }

    /**
     * Tính tỷ lệ giảm giá do pin
     *
     * @return tỷ lệ giảm (0-70%)
     */
    public double getBatteryDiscountRatio() {
        try {
            double originalPrice = this.getPhonePrice();
            double adjustedPrice = this.phonePrice();
            return ((originalPrice - adjustedPrice) / originalPrice) * 100;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    /**
     * Áp dụng khuyến mãi dựa trên tình trạng pin
     */
    public void applyBatteryBasedPromotion() {
        try {
            if (batteryStatus < 50) {
                int extraDiscount = Math.max(5, (50 - batteryStatus) / 5);
                promote(extraDiscount);
                System.out.println("🔋 Áp dụng khuyến mãi đặc biệt do pin yếu!");
            }
        } catch (Exception e) {
            System.err.println("Không thể áp dụng khuyến mãi pin: " + e.getMessage());
        }
    }

    // ==================== EQUALS & HASHCODE ====================

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof OldPhone oldPhone)) return false;
        return batteryStatus == oldPhone.batteryStatus;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), batteryStatus);
    }

    // ==================== TO STRING ====================

    @Override
    public String toString() {
        return String.format("OldPhone{%s, battery=%d%%, adjustedPrice=%.0f}",
                super.toString().replace("Phone{", "").replace("}", ""),
                batteryStatus,
                phonePrice());
    }
}
