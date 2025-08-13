package BT_1_8.chieu;

import BT_1_8.chieu.exception.NullOrEmptyException;

import java.util.HashSet;
import java.util.Scanner;

public class Lecturer extends Teacher {
    private String subject;
    private HashSet<Schedule> scheduleLecturer = new HashSet<>();

    public Lecturer() {
    }

    public Lecturer(String id, String fullName, int age, String email, double teachingHours, String subject) {
        super(id, fullName, age, email, teachingHours);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HashSet<Schedule> getScheduleLecturer() {
        
        return scheduleLecturer;
    }

    public void setScheduleLecturer(HashSet<Schedule> scheduleLecturer) {
        this.scheduleLecturer = scheduleLecturer;
    }

    @Override
    public void setId(String id) throws NullOrEmptyException {
        super.setId("GV-00" + id);
    }

    @Override
    public void input() throws NullOrEmptyException {
        Scanner sc = new Scanner(System.in);

        super.input();

        while (true) {
            System.out.print("Nhập bộ môn giảng dạy: ");
            this.subject = sc.nextLine().trim();
            if (this.subject.matches("[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+")) {
                break;
            } else {
                System.out.println("Tên môn học không hợp lệ! Không ký tự đặc biệt.\n");
            }
        }
    }

    @Override
    public double getSalary() {
        return this.getTeachingHours() * 200000 * 1.1;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Môn giảng dạy: " + this.subject + "\n";
    }
}
