import java.util.Arrays;
import java.util.Scanner;

public class KiemTraModule {
    public static void main(String[] args) {
        //Nguyễn Quang Minh
        Scanner sc = new Scanner(System.in);

        int n = 9;

        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 9, 3, 4, 9, 8};
        int[] arr4 = {9, 9, 9};
        String k = "abcxy";
        String l = ("aBcXy");
        //bai 1 chua xong
        inRaHinhTamGiac(n);
        //bai2
        tinhHieuCuaTongCacSoChanLe(arr);
        //bai3
        demKyTuinHoa(k);
        demKyTuinHoa(l);
        //bai4
        System.out.println("Mang cac so nguyen to :" + Arrays.toString(mangSoNguyenTo(arr2)));
        //bai5
        soLonThu2(arr3);
        soLonThu2(arr4);
    }
    public static void soLonThu2(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max1 = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (max2 < arr[i]) {
                int temp = max2;
                max2 = arr[i];
                if (max2 == max1) {
                    max2 = temp;
                }
            }
        }
        if (max2 == Integer.MIN_VALUE) {
            System.out.println("Khong tim thay so lon thu 2!");
        } else {
            System.out.println("So lon thu hai trong mang la :"+max2);
        }
    }
    private static int[] mangSoNguyenTo(int[] arr){
        int soLuongSoNguyenTo = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if(kiemTraSoNguyenTo(arr[i])){
                soLuongSoNguyenTo++;
            }
        }
        int[] mangNguyenTo = new int[soLuongSoNguyenTo];
        int index = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if(kiemTraSoNguyenTo(arr[i])){
                mangNguyenTo[index] = arr[i];
                index++;
            }
        }
        return mangNguyenTo;
    }
    private static boolean kiemTraSoNguyenTo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;

    }
    public static void demKyTuinHoa(String a){
        String chuoiInHoa = a.toUpperCase();
        int soKiTuInHoa = 0;
        for (int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) == chuoiInHoa.charAt(i)){
                soKiTuInHoa++;
            }
        }
        if (soKiTuInHoa > 0){
            System.out.println("Chuoi co "+soKiTuInHoa +" ki tu in hoa");
        }
        else {
            System.out.println("Chuoi ki tu in thuong");
        }
    }
    public static void tinhHieuCuaTongCacSoChanLe(int[] arr){
        int tongSoChan = 0;
        int tongSoLe=0;
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 2 == 0){
                tongSoChan += arr[i];
            }
            else {
                tongSoLe += arr[i];
            }
        }
        int hieuSo = tongSoChan - tongSoLe;
        //cach 2 ko can bien tong chan va le
        int hieuSo2 =0;
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 2 == 0){
                hieuSo2 += arr[i];
            }
            else {
                hieuSo2 -= arr[i];
            }
        }
        System.out.println("Hieu cua tong so chan va le la :" +hieuSo2);

        //System.out.println("Hieu cua tong so chan va le la :"+tongSoChan +" - " +tongSoLe+" = " +hieuSo);
    }
    public static void inRaHinhTamGiac(int n){
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n+i+2 ; j++){
                if( j > n - i ){
                    System.out.print("*");
                    if( j == n + i + 1) {
                        System.out.print("\n");
                        break;
                    }
                } else{
                    System.out.print(" ");
                }
            }
        }
    }
}
