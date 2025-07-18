import java.util.Scanner;

public class Bt_Chieu_Mang_2_Chieu_B2 {
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
                {4, 5, 6},
                {7, 8, 9}
        };
        //nhap mang
        // importArray(arr, sc);
        //in mang
        //printArray(arr);
        int [][] a = xoayMang(arr2,3,3);
        printArray(a);
        chuyenViTrenChinhMaTran(arr2);
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
    //c1
    public static int[][] xoayMang(int[][] arr, int x, int y) {
        int[][] temp = new int[x][y];
        int a = 0 ;
        for (int j = 0; j < arr.length; j++) {
            int b = 0;
            for (int i = arr.length-1; i >= 0; i--) {
                temp[a][b] = arr[i][j];
                b++;
            }
            a++;
        }
        return temp;

    }
    //c2
    public static void chuyenViTrenChinhMaTran(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        printArray(matrix);
    }

}

