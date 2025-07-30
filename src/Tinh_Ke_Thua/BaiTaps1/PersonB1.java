package Tinh_Ke_Thua.BaiTaps1;

import java.math.BigDecimal;
import java.util.Scanner;

public class PersonB1 {
    private String id; //id
    private String name;//họ tên
    private int age;//tuổi
    private double workingTime;//thời gian làm việc
    private int people;//số lượng
    public PersonB1() {
    }

    public PersonB1(String name, int age, double workingTime) {
        this.name = name;
        this.age = age;
        this.workingTime = workingTime;
    }

    public void input(Scanner sc) {

        // Nhập tên
        while (true) {
            System.out.print("Nhập tên: ");
            this.name = sc.nextLine().trim();
            if (this.name.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) break;
            else System.out.println("❌ Tên không hợp lệ! Không chứa số hoặc ký tự đặc biệt.");
        }

        // Nhập tuổi
        while (true) {
            System.out.print("Nhập tuổi: ");
            if (sc.hasNextInt()) {
                this.age = sc.nextInt();
                if (this.age < 0) {
                    System.out.println("❌ Tuổi không hợp lệ! Phải >= 0.");
                    continue;
                }
                sc.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("❌ Tuổi không hợp lệ! Nhập số nguyên.");
                sc.nextLine(); // Clear buffer
            }
        }
        // Nhập thời gian làm vic
        while (true) {
            System.out.print("Nhập Thời gian: ");
            if (sc.hasNextDouble()) {
                this.workingTime = sc.nextDouble();
                if (this.workingTime < 0) {
                    System.out.println("❌ Thời gian không hợp lệ! Phải >= 0.");
                    continue;
                }
                sc.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("❌ Thời gian không hợp lệ! Nhập số nguyên.");
                sc.nextLine(); // Clear buffer
            }
        }
    }

    @Override
    public String toString() {
        return String.format("| %-6s | %-20s | %-8d | %-25s", id, name, age, workingTime);
    }
    public BigDecimal wagePerson(){
        BigDecimal wage = BigDecimal.valueOf(this.workingTime * 1);
        return wage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkingTime(double workingTime) {
        this.workingTime = workingTime;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWorkingTime() {
        return workingTime;
    }

    public int getPeople() {
        return people;
    }
}

