package Bt_Phone;

public interface Promotion {
    // Static method - không thể override
    static void add3() {
        System.out.println("📊 Static promotion method - không thể override!");
    }

    // Abstract method - bắt buộc phải implement
    void promote(int ratio) throws IllegalArgumentException, ArithmeticException;

    // Default method - có thể override hoặc không
    default void add4() {
        System.out.println("🎁 Default promotion method - có thể override!");
    }
}
