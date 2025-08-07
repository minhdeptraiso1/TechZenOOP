package Bt_Phone;

public interface Promotion {
    static void add3() {
        System.out.println("x");
    }

    void promote(int ratio);

    default void add4() {
        System.out.println("x");
    }
}
