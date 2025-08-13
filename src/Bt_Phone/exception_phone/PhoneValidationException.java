package Bt_Phone.exception_phone;

public class PhoneValidationException extends Exception {
    public PhoneValidationException(String message) {
        super(message);
    }

    public PhoneValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
