import java.util.Scanner;

public class Employee {
    private String name;
    private int age;
    private double time;
    private static int numberEmployee;

    public void input() {
        Scanner sc = new Scanner(System.in);
        // Nhập tên
        while (true) {
            System.out.print("Nhập tên sinh viên: ");
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

        // Nhập giờ làm
        while (true) {
            System.out.print("Nhập số giờ làm : ");
            if (sc.hasNextDouble()) {
                this.time = sc.nextDouble();
                if (this.age < 0 ) {
                    System.out.println("❌ Giờ làm không hợp lệ!.");
                    continue;
                }
                sc.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("❌ Giờ làm không hợp lệ!.");
                sc.nextLine(); // Clear buffer
            }
        }
    }
}
