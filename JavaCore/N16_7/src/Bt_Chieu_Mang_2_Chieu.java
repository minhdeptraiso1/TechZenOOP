import java.util.Arrays;
import java.util.Scanner;

public class Bt_Chieu_Mang_2_Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap so hang cua mang : ");//chieu ngang
//        int x = sc.nextInt();
//        System.out.println("Nhap so cot cua mang : ");//chieu doc
//        int y = sc.nextInt();
//        System.out.println("Mang co " + x + " hang va " + y + " cot !");
//        int[][] arr = new int[x][y];
        int[][] arr2 = new int[][]{
                {1, 2, 3},
                {3, 4, 4},
                {5, 6, 5}
        };
        //nhap mang
       // importArray(arr, sc);
        //in mang
      //  printArray(arr);
        System.out.println("Nhap kich thuoc hinh vuong");
        int k = sc.nextInt();
        int i = totalArrays(arr2);
        System.out.println(i);
//        int[][] ax = findLargestSquare(arr2,k);
//        printArray(ax);
        findLargestSquareOptimized(arr2,k);
    }

    //nhap mang
    public static int[][] importArray(int[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhap gia tri thu arr[" + i + "][" + j + "]:");
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    //in mang
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //tong mang 2 chieu
    private static int totalArrays(int[][] arr) {
        int totalArr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                totalArr += arr[i][j];
            }
        }
        return totalArr;
    }
    //tach hinh vuong
    public static int[][] tachHinhVuongTuMang(int[][] arr ,int k){
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = 0; j <= arr[i].length - k; j++) {

            }
        }
        return arr;
    }
    //tim hinh vuong trong ma tran
    public static int[][] findLargestSquare(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int currentSum = 0;

                // Tính tổng hình vuông k×k bắt đầu tại [i][j]
                for (int a = 0; a < k; a++) {
                    for (int b = 0; b < k; b++) {
                        currentSum += arr[i + a][j + b];
                    }
                }

                // Nếu tìm được tổng lớn hơn thì lưu lại
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Tạo và trả mảng con k×k lớn nhất
        int[][] result = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                result[i][j] = arr[maxRow + i][maxCol + j];
            }
        }

        System.out.println("Tong lon nhat: " + maxSum);
        System.out.println("Toa do bat dau: (" + maxRow + ", " + maxCol + ")");
        return result;
    }
    public static int[][] findLargestSquareOptimized(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        // Bước 1: Xây dựng mảng prefix sum (thêm hàng/cột 0)
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = arr[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        // Bước 2: Duyệt qua các vị trí bắt đầu
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                // Tính tổng hình vuông k×k trong O(1)
                int r1 = i, c1 = j;               // Góc trái trên
                int r2 = i + k, c2 = j + k;       // Góc phải dưới (dùng prefix index)

                int currentSum = prefix[r2][c2]
                        - prefix[r1][c2]
                        - prefix[r2][c1]
                        + prefix[r1][c1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Trả về kết quả (giống bản gốc)
        int[][] result = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                result[i][j] = arr[maxRow + i][maxCol + j];
            }
        }

        System.out.println("Tong lon nhat: " + maxSum);
        System.out.println("Toa do bat dau: (" + maxRow + ", " + maxCol + ")");
        return result;
    }
}

//shift delete
//trl shift v


//📝 Bài 1: Tìm hình vuông con có tổng lớn nhất
//
//Mô tả:
//Cho một ma trận số nguyên kích thước MxN. Viết chương trình tìm hình vuông con có kích thước k×k
//(với k do người dùng nhập vào, k ≤ min(M, N)) sao cho tổng các phần tử trong hình vuông đó là lớn nhất.
//
//Yêu cầu:
//Xuất tổng lớn nhất và tọa độ của hình vuông con tương ứng (dòng, cột bắt đầu).
//
//Gợi ý:
//Với mỗi ô [i][j], bạn hãy xem xét hình vuông con có kích thước k×k bắt đầu tại [i][j].
//Duyệt qua tất cả các vị trí có thể đặt hình vuông k×k (tức là i ≤ M - k, j ≤ N - k).
//Tính tổng các phần tử trong hình vuông k×k này bằng cách lặp lồng trong k dòng và k cột.