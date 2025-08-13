package Bt_Phone.exception_phone;

public class InvalidPhoneDataException extends Exception {
    public InvalidPhoneDataException(String message) {
        super(message);
    }

    public InvalidPhoneDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
