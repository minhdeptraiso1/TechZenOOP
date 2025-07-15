import java.util.Scanner;

public class N14_7_b4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số lượng sinh viên
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        // Khai báo các mảng để lưu thông tin
        String[] fullNames = new String[n];
        double[] mathScores = new double[n];
        double[] englishScores = new double[n];
        double[] itScores = new double[n];
        double[] averages = new double[n];

        // Nhập thông tin sinh viên
        enterStudentInfo(sc, n, fullNames, mathScores, englishScores, itScores);

        // Tính điểm trung bình
        calculateAverages(n, mathScores, englishScores, itScores, averages);

        // In bảng điểm
        printScoreTable(n, fullNames, mathScores, englishScores, itScores, averages);

        // Tìm và in sinh viên có điểm trung bình cao nhất
        findAndPrintTopStudent(n, fullNames, averages);

        // Sắp xếp danh sách theo điểm trung bình giảm dần
        sortStudentsByAverage(n, fullNames, mathScores, englishScores, itScores, averages);

        // In lại bảng điểm sau khi sắp xếp
        System.out.println("\nDanh sách sau khi sắp xếp theo điểm trung bình giảm dần:");
        printScoreTable(n, fullNames, mathScores, englishScores, itScores, averages);
    }

    // Hàm nhập thông tin sinh viên
    private static void enterStudentInfo(Scanner sc, int n, String[] fullNames,
                                         double[] mathScores, double[] englishScores, double[] itScores) {
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Họ tên: ");
            fullNames[i] = sc.nextLine();

            // Nhập điểm Toán (0-10)
            mathScores[i] = enterValidScore(sc, "Toán");

            // Nhập điểm Anh văn (0-10)
            englishScores[i] = enterValidScore(sc, "Anh văn");

            // Nhập điểm Tin học (0-10)
            itScores[i] = enterValidScore(sc, "Tin học");
        }
    }

    // Hàm nhập điểm hợp lệ (0-10)
    private static double enterValidScore(Scanner sc, String subject) {
        double score;
        do {
            System.out.print("Điểm " + subject + " (0-10): ");
            score = Double.parseDouble(sc.nextLine());
            if (score < 0 || score > 10) {
                System.out.println("Điểm phải từ 0 đến 10. Vui lòng nhập lại.");
            }
        } while (score < 0 || score > 10);
        return score;
    }

    // Hàm tính điểm trung bình
    private static void calculateAverages(int n, double[] mathScores,
                                          double[] englishScores, double[] itScores, double[] averages) {
        for (int i = 0; i < n; i++) {
            averages[i] = (mathScores[i] + englishScores[i] + itScores[i]) / 3;
        }
    }

    // Hàm in bảng điểm
    private static void printScoreTable(int n, String[] fullNames,
                                        double[] mathScores, double[] englishScores,
                                        double[] itScores, double[] averages) {
        System.out.println("\nBẢNG ĐIỂM SINH VIÊN");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %-10s %-10s %-10s %-10s\n",
                "Họ tên", "Toán", "Anh văn", "Tin học", "Trung bình");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-25s %-10.1f %-10.1f %-10.1f %-10.1f\n",
                    fullNames[i], mathScores[i], englishScores[i], itScores[i], averages[i]);
        }
        System.out.println("------------------------------------------------------------");
    }

    // Hàm tìm và in sinh viên có điểm trung bình cao nhất
    private static void findAndPrintTopStudent(int n, String[] fullNames, double[] averages) {
        int maxIndex = 0;
        double maxAverage = averages[0];

        for (int i = 1; i < n; i++) {
            if (averages[i] > maxAverage) {
                maxAverage = averages[i];
                maxIndex = i;
            }
        }

        System.out.println("\nSinh viên có điểm trung bình cao nhất:");
        System.out.println("Họ tên: " + fullNames[maxIndex]);
        System.out.println("Điểm trung bình: " + averages[maxIndex]);
    }

    // Hàm sắp xếp sinh viên theo điểm trung bình giảm dần (sử dụng bubble sort)
    private static void sortStudentsByAverage(int n, String[] fullNames,
                                              double[] mathScores, double[] englishScores,
                                              double[] itScores, double[] averages) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    // Hoán đổi điểm trung bình
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    // Hoán đổi họ tên
                    String tempName = fullNames[j];
                    fullNames[j] = fullNames[j + 1];
                    fullNames[j + 1] = tempName;

                    // Hoán đổi điểm Toán
                    double tempMath = mathScores[j];
                    mathScores[j] = mathScores[j + 1];
                    mathScores[j + 1] = tempMath;

                    // Hoán đổi điểm Anh văn
                    double tempEng = englishScores[j];
                    englishScores[j] = englishScores[j + 1];
                    englishScores[j + 1] = tempEng;

                    // Hoán đổi điểm Tin học
                    double tempIT = itScores[j];
                    itScores[j] = itScores[j + 1];
                    itScores[j + 1] = tempIT;
                }
            }
        }
    }
}