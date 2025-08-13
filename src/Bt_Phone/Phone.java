package Bt_Phone;

import Bt_Phone.exception_phone.InvalidPhoneDataException;
import Bt_Phone.exception_phone.PhoneValidationException;

import java.util.Objects;
import java.util.Scanner;

abstract class Phone implements Comparable<Phone> {
    private String phoneId;         // id
    private String phoneName;       // ten dien thoai
    private double phonePrice;      // gia
    private String phoneWarranty;   // thoi gian bao hanh
    private String phoneType;       // loai dien thoai : Android/iOS
    private String phoneCompany;    // hãng dien thoai : iPhone/Xiaomi


    public Phone() {
    }

    public Phone(String phoneId, String phoneName, double phonePrice,
                 String phoneWarranty, String phoneType, String phoneCompany)
            throws InvalidPhoneDataException {
        try {
            this.setPhoneId(phoneId);
            this.setPhoneName(phoneName);
            this.setPhonePrice(phonePrice);
            this.setPhoneWarranty(phoneWarranty);
            this.setPhoneType(phoneType);
            this.setPhoneCompany(phoneCompany);
        } catch (IllegalArgumentException e) {
            throw new InvalidPhoneDataException("Lỗi khởi tạo Phone: " + e.getMessage(), e);
        }
    }


    public void input(Scanner sc) {
        // Nhập tên điện thoại
        try {
            while (true) {
                try {
                    System.out.print("Nhập tên điện thoại: ");
                    this.phoneName = sc.nextLine().trim();
                    if (this.phoneName.isEmpty()) {
                        throw new Exception("Tên điện thoại không được để trống!");
                    }
                    if (!this.phoneName.matches("[a-zA-ZÀ-ỹ0-9\\s]+")) {
                        throw new Exception("Tên không hợp lệ! Chỉ được chứa chữ cái, số và khoảng trắng.");
                    }
                    if (this.phoneName.length() < 2 || this.phoneName.length() > 100) {
                        throw new Exception("Tên điện thoại phải từ 2-100 ký tự!");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                    System.out.println("Vui lòng nhập lại!\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }

        // Nhập giá điện thoại
        while (true) {
            try {
                System.out.print("Nhập giá của điện thoại (VND): ");
                String p = sc.nextLine().trim();

                if (p.isEmpty()) {
                    throw new Exception("Giá không được để trống!");
                }

                if (!p.matches("\\d+")) {
                    throw new Exception("Giá phải là số nguyên dương!");
                }

                double price = Double.parseDouble(p);

                if (price <= 0) {
                    throw new Exception("Giá phải lớn hơn 0!");
                }
                if (price > 100000000) {
                    throw new Exception("Giá quá cao! Vui lòng kiểm tra lại.");
                }

                this.phonePrice = price;
                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá phải là số nguyên!");
                System.out.println("Vui lòng nhập lại!\n");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }

        // Nhập thời gian bảo hành
        while (true) {
            try {
                System.out.print("Nhập thời gian bảo hành (tháng): ");
                String warrantyInput = sc.nextLine().trim();

                if (warrantyInput.isEmpty()) {
                    throw new Exception("Thời gian bảo hành không được để trống!");
                }

                if (!warrantyInput.matches("\\d{1,2}")) {
                    throw new Exception("Thời gian bảo hành phải là số nguyên 1-2 chữ số!");
                }

                int warranty = Integer.parseInt(warrantyInput);

                if (warranty < 1 || warranty > 60) {
                    throw new Exception("Thời gian bảo hành từ 1 đến 60 tháng!");
                }

                this.phoneWarranty = warrantyInput;
                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Thời gian bảo hành phải là số nguyên!");
                System.out.println("Vui lòng nhập lại!\n");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }

        // Nhập loại hệ điều hành
        while (true) {
            try {
                System.out.println("Loại điện thoại:");
                System.out.println("1. Hệ điều hành iOS");
                System.out.println("2. Hệ điều hành Android");
                System.out.print("Lựa chọn của bạn (1-2): ");

                String choice = sc.nextLine().trim();

                if (choice.isEmpty()) {
                    throw new Exception("Vui lòng chọn loại hệ điều hành!");
                }

                if (choice.equals("1")) {
                    this.phoneType = "iOS";
                    break;
                } else if (choice.equals("2")) {
                    this.phoneType = "Android";
                    break;
                } else {
                    throw new Exception("Lựa chọn không hợp lệ! Chỉ chọn 1 hoặc 2.");
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }

        // Nhập hãng điện thoại
        while (true) {
            try {
                System.out.print("Nhập hãng điện thoại: ");
                this.phoneCompany = sc.nextLine().trim();

                if (this.phoneCompany.isEmpty()) {
                    throw new Exception("Tên hãng không được để trống!");
                }

                if (!this.phoneCompany.matches("[a-zA-ZÀ-ỹ\\s]+")) {
                    throw new Exception("Tên hãng chỉ được chứa chữ cái và khoảng trắng!");
                }

                if (this.phoneCompany.length() < 2) {
                    throw new Exception("Tên hãng phải có ít nhất 2 ký tự!");
                }
                if (this.phoneCompany.length() > 50) {
                    throw new Exception("Tên hãng không được quá 50 ký tự!");
                }

                break;

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }


    /**
     * Kiểm tra tính hợp lệ của toàn bộ object Phone
     *
     * @throws PhoneValidationException nếu có lỗi validation
     */
    public void validate() throws PhoneValidationException {
        StringBuilder errors = new StringBuilder();

        if (phoneId == null || phoneId.trim().isEmpty()) {
            errors.append("- ID không được rỗng\n");
        }
        if (phoneName == null || phoneName.trim().isEmpty()) {
            errors.append("- Tên không được rỗng\n");
        }
        if (phonePrice <= 0) {
            errors.append("- Giá phải > 0\n");
        }
        if (phoneWarranty == null || phoneWarranty.trim().isEmpty()) {
            errors.append("- Thời gian bảo hành không được rỗng\n");
        }
        if (phoneType == null || phoneType.trim().isEmpty()) {
            errors.append("- Loại điện thoại không được rỗng\n");
        }
        if (phoneCompany == null || phoneCompany.trim().isEmpty()) {
            errors.append("- Hãng điện thoại không được rỗng\n");
        }

        if (errors.length() > 0) {
            throw new PhoneValidationException("Dữ liệu không hợp lệ:\n" + errors);
        }
    }


    /**
     * Tính toán giá cuối cùng của điện thoại (có thể bao gồm thuế, giảm giá...)
     *
     * @return giá cuối cùng
     * @throws ArithmeticException nếu tính toán có lỗi
     */
    public abstract double phonePrice() throws ArithmeticException;

    // ==================== OUTPUT METHOD ====================

    public void output() {
        try {
            System.out.println("=== THÔNG TIN ĐIỆN THOẠI ===");
            System.out.println("ID: " + (phoneId != null ? phoneId : "Chưa có"));
            System.out.println("Tên: " + (phoneName != null ? phoneName : "Chưa có"));
            System.out.println("Giá: " + String.format("%,.0f VND", phonePrice));
            System.out.println("Bảo hành: " + (phoneWarranty != null ? phoneWarranty + " tháng" : "Chưa có"));
            System.out.println("Loại: " + (phoneType != null ? phoneType : "Chưa có"));
            System.out.println("Hãng: " + (phoneCompany != null ? phoneCompany : "Chưa có"));
            System.out.println("Giá cuối: " + String.format("%,.0f VND", phonePrice()));
            System.out.println("============================");
        } catch (ArithmeticException e) {
            System.err.println("Lỗi tính toán giá: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khi in thông tin: " + e.getMessage());
        }
    }

    // ==================== COMPARABLE ====================

    @Override
    public int compareTo(Phone other) {
        if (other == null) {
            throw new NullPointerException("Không thể so sánh với null!");
        }
        return Double.compare(this.phonePrice, other.phonePrice);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone phone)) return false;
        return Objects.equals(phoneId, phone.phoneId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phoneId);
    }

    // ==================== GETTER & SETTER WITH VALIDATION ====================

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) throws IllegalArgumentException {
        if (phoneId == null || phoneId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID điện thoại không được rỗng!");
        }
        if (phoneId.length() < 3 || phoneId.length() > 20) {
            throw new IllegalArgumentException("ID phải từ 3-20 ký tự!");
        }
        this.phoneId = phoneId.trim();
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) throws IllegalArgumentException {
        if (phoneName == null || phoneName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên điện thoại không được rỗng!");
        }
        if (!phoneName.matches("[a-zA-ZÀ-ỹ0-9\\s]+")) {
            throw new IllegalArgumentException("Tên không hợp lệ! Chỉ chứa chữ cái, số và khoảng trắng.");
        }
        if (phoneName.length() < 2 || phoneName.length() > 100) {
            throw new IllegalArgumentException("Tên phải từ 2-100 ký tự!");
        }
        this.phoneName = phoneName.trim();
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(double phonePrice) throws IllegalArgumentException {
        if (phonePrice <= 0) {
            throw new IllegalArgumentException("Giá điện thoại phải lớn hơn 0!");
        }
        if (phonePrice > 100000000) {
            throw new IllegalArgumentException("Giá quá cao! Phải nhỏ hơn 100 triệu.");
        }
        this.phonePrice = phonePrice;
    }

    public String getPhoneWarranty() {
        return phoneWarranty;
    }

    public void setPhoneWarranty(String phoneWarranty) throws IllegalArgumentException {
        if (phoneWarranty == null || phoneWarranty.trim().isEmpty()) {
            throw new IllegalArgumentException("Thời gian bảo hành không được rỗng!");
        }
        if (!phoneWarranty.matches("\\d{1,2}")) {
            throw new IllegalArgumentException("Thời gian bảo hành phải là số 1-2 chữ số!");
        }
        try {
            int warranty = Integer.parseInt(phoneWarranty);
            if (warranty < 1 || warranty > 60) {
                throw new IllegalArgumentException("Thời gian bảo hành từ 1-60 tháng!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Thời gian bảo hành phải là số!");
        }
        this.phoneWarranty = phoneWarranty;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) throws IllegalArgumentException {
        if (phoneType == null || phoneType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại điện thoại không được rỗng!");
        }
        if (!phoneType.equals("iOS") && !phoneType.equals("Android")) {
            throw new IllegalArgumentException("Loại điện thoại chỉ được là 'iOS' hoặc 'Android'!");
        }
        this.phoneType = phoneType;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) throws IllegalArgumentException {
        if (phoneCompany == null || phoneCompany.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hãng không được rỗng!");
        }
        if (!phoneCompany.matches("[a-zA-ZÀ-ỹ\\s]+")) {
            throw new IllegalArgumentException("Tên hãng chỉ chứa chữ cái và khoảng trắng!");
        }
        if (phoneCompany.length() < 2 || phoneCompany.length() > 50) {
            throw new IllegalArgumentException("Tên hãng từ 2-50 ký tự!");
        }
        this.phoneCompany = phoneCompany.trim();
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Tạo bản sao an toàn của Phone object
     */
    public Phone createSafeCopy() throws InvalidPhoneDataException {
        try {
            Phone copy = this.getClass().getDeclaredConstructor().newInstance();
            copy.phoneId = this.phoneId;
            copy.phoneName = this.phoneName;
            copy.phonePrice = this.phonePrice;
            copy.phoneWarranty = this.phoneWarranty;
            copy.phoneType = this.phoneType;
            copy.phoneCompany = this.phoneCompany;
            return copy;
        } catch (Exception e) {
            throw new InvalidPhoneDataException("Không thể tạo bản sao: " + e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return String.format("Phone{id='%s', name='%s', price=%.0f, warranty='%s', type='%s', company='%s'}",
                phoneId, phoneName, phonePrice, phoneWarranty, phoneType, phoneCompany);
    }
}
