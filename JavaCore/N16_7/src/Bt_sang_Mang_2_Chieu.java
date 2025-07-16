import java.util.Arrays;
import java.util.Scanner;

public class Bt_sang_Mang_2_Chieu {
    public static void main(String[] args) {
//        Xử lý Mảng 2 Chiều
//        Đề bài
//        Viết chương trình thực hiện các công việc sau:
//
//        a. Nhập/Xuất ma trận A (n dòng, n cột) gồm các phần tử kiểu int.
//                b. Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận.
//        c. Tạo ra mảng một chiều X với X[i] là các giá trị lớn nhất trên từng dòng i của ma trận A. In X ra.
//                d. Tính tổng các số là bội số của 5 nằm trên hàng cuối cùng của ma trận.
//        e. Tìm số lớn nhất trên đường chéo chính của ma trận.
//                f. Tìm số nhỏ nhất trên đường chéo phụ của ma trận.
//        g. Đếm số lượng số nguyên tố trong ma trận.
//                h. Hoán đổi 2 dòng của ma trận.
//        i. Hoán đổi 2 cột của ma trận.
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so dong cua mang : ");//chieu ngang
            int x = sc.nextInt();
            System.out.println("Nhap so cot cua mang : ");//chieu doc
            int y = sc.nextInt();
            System.out.println("Mang co " + x + " hang va " + y +" cot !");
            int[][] arr = new int[x][y];
            //a. Nhập/Xuất ma trận A (n dòng, n cột) gồm các phần tử kiểu int.
            importArray(arr,sc);
            printArray(arr);
            //b. Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận.
            int inits3 = productOfMultiplesOf3(arr);
            System.out.println("Tich cua cac so chia het cho 3 la :" +inits3);
            //c. Tạo ra mảng một chiều X với X[i] là các giá trị lớn nhất trên từng dòng i của ma trận A. In X ra.
            int[] ints = printLargestIn2DArray(arr);
            System.out.println(Arrays.toString(ints));
            //d. Tính tổng các số là bội số của 5 nằm trên hàng cuối cùng của ma trận.
            int inits4 = sumOfMultiplesOf5InLastRow(arr);
            System.out.println("Tong cua cac so dong cuoi chia het cho 5 la :" +inits4);
            //e. Tìm số lớn nhất trên đường chéo chính của ma trận.
            int inits5 = largestNumberOnMainDiagonal(arr);
            System.out.println("So lon nhat nam tren duong cheo chinh la :" +inits5);
            //f. Tìm số nhỏ nhất trên đường chéo phụ của ma trận.
            int inits6 = largestNumberOnTheSecondaryDiagonal(arr);
            System.out.println("So lon nhat nam tren duong cheo phu la :" +inits6);
            //g. Đếm số lượng số nguyên tố trong ma trận.
            int inits7 = totalNumberIsPrime(arr);
            System.out.println("Mang co " + inits7+" so nguyen to!");
            //h. Hoán đổi 2 dòng của ma trận.
            int[][] ints2 = swapArrays(arr,sc);
            printArray(ints2);
            //i. Hoán đổi 2 cột của ma trận.
            int[][] ints9 = swapArraysColum(arr,sc);
            printArray(ints9);



        }
        //nhap mang
        public static int[][] importArray(int[][] arr , Scanner sc){
            for(int i = 0 ; i < arr.length ; i ++){
                for(int j = 0 ; j < arr[i].length; j++){
                    System.out.println("Nhap gia tri thu arr[" + i + "][" + j + "]:");
                    arr[i][j] = sc.nextInt();
                }
            }
            return arr;
        }
        //in mang
        public static void printArray(int[][] arr){
            for (int i = 0; i < arr.length; i++) {
                System.out.print("{ ");
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }

                System.out.println("}");
            }
        }
        //in ra so lon nhat cua cac dong trong mang 2 chieu
        public static int[] printLargestIn2DArray(int [][] arr){
            int index = arr.length;
            int[] arrLargestNumber = new int[index];
            for (int i = 0 ; i < arr.length ; i++){
                int max = arr[i][0];
                for (int j = 1 ; j < arr[i].length ; j++){
                    if(max < arr[i][j]){
                        max = arr[i][j];
                    }
                }
                arrLargestNumber[i] = max;
            }
            return arrLargestNumber;
        }
        //hoan doi mang 2 chieu voi dong tu chon
        public static int[][] swapArrays(int[][]arr , Scanner sc){
            int row = arr.length;
            System.out.println("Nhap Hang muon doi vi tri( so < " +(row - 1 )+"):");
            int m = sc.nextInt();
            System.out.println("Nhap hang bi doi vi tri ( so < " +(row - 1 )+"):");
            int n = sc.nextInt();
            //kiem tra input
            if (m < 0 || m >= row || n < 0 || n >= row || m == n) {
                System.out.println("Chi so hang khong hop le!");
            } else {
                swapRows(arr, m, n);
            }
            return arr;
        }
    //hoan doi mang 2 chieu voi cot tu chon
    public static int[][] swapArraysColum(int[][] arr, Scanner sc) {
        int columnCount = arr[0].length;

        System.out.print("Nhap cot muon doi vi tri (so < " + columnCount + "): ");
        int m = sc.nextInt();

        System.out.print("Nhap cot bi doi vi tri (so < " + columnCount + "): ");
        int n = sc.nextInt();

        if (m < 0 || m >= columnCount || n < 0 || n >= columnCount || m == n) {
            System.out.println("Chi so cot khong hop le!");
        } else {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i][m];       //  Đổi theo từng dòng
                arr[i][m] = arr[i][n];
                arr[i][n] = temp;
            }
        }

        return arr;
    }

    //hoan doi dong
        public static void swapRows(int[][]arr,int a ,int b){
            int[] temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        // tich cac so chia het cho 3 o dong dau tien
        public static int productOfMultiplesOf3(int [][] arr){
        int numberOfMultiolesOf3 = 0;
        int accumulation = 1;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i][0] % 3 == 0){
                    numberOfMultiolesOf3++;
                    accumulation *= arr[i][0];
                }
            }
            System.out.println("Mang co " + numberOfMultiolesOf3 + " chia het cho 3!");
            return accumulation;
    }
        //tong cac so chia het cho 5 tren hang cuoi cung
        public static int sumOfMultiplesOf5InLastRow(int [][] arr){
        int lastRows = arr.length-1;
        int numberOfMultiolesOf5 = 0;
        int total = 0;
        for(int i = 0 ; i < lastRows + +1 ; i++){
            if(arr[lastRows][i] % 5 == 0){
                numberOfMultiolesOf5++;
                total += arr[lastRows][i];
            }
        }
        System.out.println("Mang co " + numberOfMultiolesOf5 + " chia het cho 5!");
        return total;
    }
        //e. Tìm số lớn nhất trên đường chéo chính của ma trận.
        private static int largestNumberOnMainDiagonal(int[][] arr){
            int max = 0;
            for(int i = 0 ; i < arr.length ; i ++){
                 max = arr[0][0];
                   if(max < arr[i][i]){
                       max = arr[i][i];
                   }
                }
            return max;
        }
        //f. Tìm số nhỏ nhất trên đường chéo phụ của ma trận.
        private static int largestNumberOnTheSecondaryDiagonal(int[][] arr){
            int n = arr.length;
            int max = arr[0][n - 1]; // Phần tử đầu tiên trên đường chéo phụ

            for (int i = 1; i < n; i++) {
                int j = n - 1 - i; // j giảm khi i tăng (i + j = n - 1)
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            return max;
        }
        //g. Đếm số lượng số nguyên tố trong ma trận.
        //kiem tra so nguyen to
        private static boolean isPrime(int n){
            if (n < 2) return false; // Số nhỏ hơn 2 không phải số nguyên tố

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false; // Có ước số khác 1 và chính nó
                }
            }

            return true; // Không chia hết cho số nào → là số nguyên tố
        }
        private static int totalNumberIsPrime(int[][] arr){
        int total = 0;
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                if(isPrime(arr[i][j])){
                    total++;
                }
            }
        }return total;
        }
    }