package BT_1_8.chieu;

import BT_1_8.chieu.exception.InvalidAgeException;
import BT_1_8.chieu.exception.InvalidEmailException;
import BT_1_8.chieu.exception.NullOrEmptyException;

import java.util.Objects;
import java.util.Scanner;

public abstract class Person {
    private String id;
    private String fullName;
    private int age;
    private String email;

    public Person() {
    }

    public Person(String id, String fullName, int age, String email) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void input() throws NullOrEmptyException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhập ID: ");
                this.id = sc.nextLine().trim();
                if (this.id.isEmpty()) {
                    throw new NullOrEmptyException("ID không được để trống");
                }
                break;
            } catch (NullOrEmptyException e) {
                System.out.println("Lỗi: " + e.getMessage() + "\n");
            }
        }

        // --- Nhập tên ---
        while (true) {
            try {
                System.out.print("Nhập tên: ");
                this.fullName = sc.nextLine().trim();
                if (this.fullName.isEmpty()) {
                    throw new NullOrEmptyException("Tên không được để trống");
                }
                if (!this.fullName.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
                    throw new Exception("Tên không hợp lệ! Không chứa số hoặc ký tự đặc biệt.");
                }
                break;
            } catch (NullOrEmptyException e) {
                System.out.println("Lỗi: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage() + "\n");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                String ageInput = sc.nextLine().trim();
                if (ageInput.isEmpty()) {
                    throw new NullOrEmptyException("Tuổi không được để trống");
                }
                int inputAge = Integer.parseInt(ageInput);
                this.setAge(inputAge);
                break;
            } catch (NullOrEmptyException e) {
                System.out.println("Lỗi: " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Tuổi không hợp lệ! Vui lòng nhập số nguyên.\n");
            } catch (InvalidAgeException e) {
                System.out.println("Lỗi: Tuổi không hợp lệ! " + e.getMessage() + ". Tuổi hợp lệ từ 17 đến 100.\n");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập email: ");
                String inputEmail = sc.nextLine().trim();
                if (inputEmail.isEmpty()) {
                    throw new NullOrEmptyException("Email không được để trống");
                }
                this.setEmail(inputEmail);
                break;
            } catch (NullOrEmptyException e) {
                System.out.println("Lỗi: " + e.getMessage() + "\n");
            } catch (InvalidEmailException e) {
                System.out.println("Cảnh báo! " + e.getMessage());
                System.out.println("Vui lòng nhập đúng định dạng (vd: ten@gmail.com).\n");
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws NullOrEmptyException {
        if (id == null || id.trim().isEmpty()) {
            throw new NullOrEmptyException("ID không được để trống");
        }
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws NullOrEmptyException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new NullOrEmptyException("Tên không được để trống");
        }
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 17 || age > 100) {
            throw new InvalidAgeException("Tuổi không hợp lệ: " + age);
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException, NullOrEmptyException {
        if (email == null || email.trim().isEmpty()) {
            throw new NullOrEmptyException("Email không được để trống");
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidEmailException("Email không đúng định dạng: " + email);
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Họ tên: " + fullName + "\n"
                + "Tuổi: " + age + "\n"
                + "Email: " + email + "\n";
    }
}