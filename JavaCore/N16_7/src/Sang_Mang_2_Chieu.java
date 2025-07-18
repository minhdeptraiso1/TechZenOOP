import java.util.Arrays;
import java.util.Scanner;
public class Sang_Mang_2_Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua mang : ");//chieu ngang
        int x = sc.nextInt();
        System.out.println("Nhap so cot cua mang : ");//chieu doc
        int y = sc.nextInt();
        System.out.println("Mang co " + x + " hang va " + y +" cot !");
        int[][] arr = new int[x][y];
        //arr[chieu cao][chieu rong]
        //nhap mang
        importArray(arr,sc);
        //in mang
        printArray(arr);
        //kiem tra mang chi so so chan
        System.out.println((checkForEvenNumbers(arr)) == true? "Mang toan chan" : "Mang co so le");
        //in ra so lon nhat tung hang cua mnag 2 chieu
        int[] ints = printLargestIn2DArray(arr);
        System.out.println(Arrays.toString(ints));
        // hoan doi 2 cot cua mang 2 chieu .nhap vi tri can hoan doi tu
        int[][] ints2 = swapArrays(arr,sc);
        printArray(ints2);


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
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    //kiem tra mang toan chan
    public static boolean checkForEvenNumbers(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 != 0) return false;
            }
        }
        return true;
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
    //hoan doi mang 2 dong tu chon
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
    //hoan doi dong
    public static void swapRows(int[][]arr,int a ,int b){
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
