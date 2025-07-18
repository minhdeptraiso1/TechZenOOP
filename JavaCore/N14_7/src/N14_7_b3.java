import java.util.Scanner;

public class N14_7_b3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so nhan vien :");
        // tao bien nhap so nhan vien
        int NumberOfEmployees = Integer.parseInt(sc.nextLine());

        // Thêm mảng cho mã nhân viên
        String[] employeeIDs = new String[NumberOfEmployees];
        String[] fullNames = new String[NumberOfEmployees];
        int[] ages = new int[NumberOfEmployees];
        String[] genders = new String[NumberOfEmployees];
        double[] salaries = new double[NumberOfEmployees];
        double[] averageScore = new double[NumberOfEmployees];

        // nhap thong tin
        enterInformation(sc, NumberOfEmployees, employeeIDs, fullNames, ages, genders, salaries, averageScore);

        // hien thi danh sach
        printing(NumberOfEmployees, employeeIDs, fullNames, ages, genders, salaries, averageScore);

        // Tìm kiếm nhân viên theo mã
        searchByID(sc, NumberOfEmployees, employeeIDs, fullNames, ages, genders, salaries, averageScore);

        // Sắp xếp theo tuổi
        sortByAge(NumberOfEmployees, employeeIDs, fullNames, ages, genders, salaries, averageScore);
        System.out.println("\nDanh sach sau khi sap xep theo tuoi:");
        printing(NumberOfEmployees, employeeIDs, fullNames, ages, genders, salaries, averageScore);
    }

    private static void enterInformation(Scanner sc, int NumberOfEmployees, String[] employeeIDs,
                                         String[] fullNames, int[] ages, String[] genders,
                                         double[] salaries, double[] averageScore) {
        for (int i = 0; i < NumberOfEmployees; i++) {
            System.out.println("Nhap thong tin cho nhan vien thu " + (i + 1) + ":");

            System.out.print("Ma nhan vien: ");
            employeeIDs[i] = sc.nextLine();

            System.out.print("Ho ten: ");
            fullNames[i] = sc.nextLine();

            System.out.print("Tuoi: ");
            ages[i] = Integer.parseInt(sc.nextLine());

            System.out.print("Gioi tinh (Nam/Nu): ");
            genders[i] = sc.nextLine();

            System.out.print("Luong: ");
            salaries[i] = Double.parseDouble(sc.nextLine());

            System.out.print("GPA: ");
            averageScore[i] = Double.parseDouble(sc.nextLine());

            System.out.println();
        }
    }

    private static void printing(int n, String[] employeeIDs, String[] fullNames, int[] ages,
                                 String[] genders, double[] salaries, double[] averageScore) {
        System.out.println("\n== Danh sach nhan vien ==");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhan vien " + (i + 1) + ":");
            System.out.println("Ma NV      : " + employeeIDs[i]);
            System.out.println("Ho ten     : " + fullNames[i]);
            System.out.println("Tuoi       : " + ages[i]);
            System.out.println("Gioi tinh  : " + genders[i]);
            System.out.println("Luong      : " + salaries[i]);
            System.out.println("GPA        : " + averageScore[i]);
            System.out.println();
        }
    }

    private static void searchByID(Scanner sc, int n, String[] employeeIDs, String[] fullNames,
                                   int[] ages, String[] genders, double[] salaries, double[] averageScore) {
        System.out.print("\nNhap ma nhan vien can tim: ");
        String searchID = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (employeeIDs[i].equalsIgnoreCase(searchID)) {
                System.out.println("\nTim thay nhan vien:");
                System.out.println("Ma NV      : " + employeeIDs[i]);
                System.out.println("Ho ten     : " + fullNames[i]);
                System.out.println("Tuoi       : " + ages[i]);
                System.out.println("Gioi tinh  : " + genders[i]);
                System.out.println("Luong      : " + salaries[i]);
                System.out.println("GPA        : " + averageScore[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co ma " + searchID);
        }
    }

    private static void sortByAge(int n, String[] employeeIDs, String[] fullNames, int[] ages,
                                  String[] genders, double[] salaries, double[] averageScore) {
        // Sử dụng bubble sort để sắp xếp theo tuổi tăng dần
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ages[j] > ages[j + 1]) {
                    // Hoán đổi tuổi
                    int tempAge = ages[j];
                    ages[j] = ages[j + 1];
                    ages[j + 1] = tempAge;

                    // Hoán đổi mã NV
                    String tempID = employeeIDs[j];
                    employeeIDs[j] = employeeIDs[j + 1];
                    employeeIDs[j + 1] = tempID;

                    // Hoán đổi họ tên
                    String tempName = fullNames[j];
                    fullNames[j] = fullNames[j + 1];
                    fullNames[j + 1] = tempName;

                    // Hoán đổi giới tính
                    String tempGender = genders[j];
                    genders[j] = genders[j + 1];
                    genders[j + 1] = tempGender;

                    // Hoán đổi lương
                    double tempSalary = salaries[j];
                    salaries[j] = salaries[j + 1];
                    salaries[j + 1] = tempSalary;

                    // Hoán đổi GPA
                    double tempGPA = averageScore[j];
                    averageScore[j] = averageScore[j + 1];
                    averageScore[j + 1] = tempGPA;
                }
            }
        }
    }
}