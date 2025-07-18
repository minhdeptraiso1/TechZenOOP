import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class N14_7_b4_tulam {
    public static void main(String[] args) {
//        Bài tập 2*: Xử lý điểm thi nhiều môn
//        Yêu cầu:
//        Nhập số lượng sinh viên n.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong hoc sinh :");
        int n = sc.nextInt();
        sc.nextLine();
//        Với mỗi sinh viên, lưu các thông tin sau bằng mảng:
//        fullNames[]: Họ tên sinh viên
        String [] fullNames = new String[n];
//        mathScores[]: Điểm Toán (0–10)
        double [] mathScores = new double[n];
//        englishScores[]: Điểm Anh văn (0–10)
        double [] englishScores = new double[n];
//        itScores[]: Điểm Tin học (0–10)
        double [] itScores = new double[n];
//        averages[]: Điểm trung bình 3 môn (sẽ tính sau)
        double [] averages = new double[n];
        //goi ham nhap xuat
//        Tính điểm trung bình mỗi sinh viên và lưu vào mảng averages.
        enterStudientInfor(sc,n,fullNames,averages,mathScores,englishScores,itScores);
//        In bảng điểm (họ tên, từng điểm, điểm trung bình).
        printStudientInfor(n,fullNames,averages,mathScores,englishScores,itScores);
//                Tìm và in sinh viên có điểm trung bình cao nhất.
        findAndPrintTopStudent(n,fullNames,averages);
//        Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần.
        sortStudentsByAverage(n,fullNames,mathScores,englishScores,itScores,averages);
    }
    private static void enterStudientInfor(Scanner sc, int n, String[] fullNames,double [] averages,
                                           double[] mathScores, double[] englishScores, double[] itScores ){
        for (int i = 0 ; i < n ; i ++){
        System.out.println("Nhap ho va ten :");
        fullNames[i] = sc.nextLine();
        System.out.println("Diem toan :");
        mathScores[i] = sc.nextDouble();
        sc.nextLine();
        System.out.println("Diem anh :");
        englishScores[i] = sc.nextDouble();
        sc.nextLine();
        System.out.println("Diem tin :");
        itScores[i] = sc.nextDouble();
        sc.nextLine();
        averages[i] = (mathScores[i] + englishScores[i]+itScores[i])/3;
        }

    }
    private static void printStudientInfor(int n,String[] fullNames,double [] averages,
                                           double[] mathScores, double[] englishScores, double[] itScores){
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
    private static void findAndPrintTopStudent(int n,String[] fullNames,double [] averages){
        int maxIndex = 0;
        for (int i = 1 ; i < n ; i++){
            double max = averages[0];
            if(max < averages[i]){
                max = averages[i];
            }
            maxIndex = i;
        }
        System.out.println("\nSinh viên có điểm trung bình cao nhất:");
        System.out.println("Họ tên: " + fullNames[maxIndex]);
        System.out.println("Điểm trung bình: " + averages[maxIndex]);
    }
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
