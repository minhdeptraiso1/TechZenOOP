import java.util.Arrays;
import  java.util.Scanner;
public class N14_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Nhap kich thuoc cua mang a: ");
        int [] a = new int[n];
        NhapMang(n,a);
        System.out.println("Mang vua nhap la : " +Arrays.toString(a));

        int[] soNguyenTo = TachSoNguyenToSangMang(a);
        System.out.println("Mang cac so nguyen to: " + Arrays.toString(soNguyenTo));

        int[][] tach = TachSoThanhHaiMang(a);
        System.out.println("Mang cac so nguyen duong: " + Arrays.toString(tach[0]));
        System.out.println("Mang cac so con lai: " + Arrays.toString(tach[1]));
        int [] xepmang = SapXepGiamDanMang(Arrays.copyOf(a,a.length));
        System.out.println("Mang sap xep giam dan : " +Arrays.toString(xepmang));
        int [] xepDuongAm0 = SapXepDuongAm0(Arrays.copyOf(a,a.length));
        System.out.println("Mang Duong Am 0" + Arrays.toString(xepDuongAm0));
        int [] daoMang = DaoMang(Arrays.copyOf(a,a.length));
        System.out.println("Mang sau khi dao la"  +Arrays.toString(daoMang));
        System.out.println(KiemTraMangDoiXung(a) == true ? "La mang doi xung " : "Khong la mang doi xung");
        int soLuongSoNgichDao = CapSoNgichDao(a);
        System.out.println("So cap so ngich dao la : " +soLuongSoNgichDao);
    }

    private static void NhapMang(int n ,int [] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++) {
            System.out.println("Nhap gia tri cua mang vi tri thu" + i + ":");
            arr[i] = sc.nextInt();
        }
    }
    private static int CapSoNgichDao(int [] arr){
        int soNgichDao = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[arr.length - 1 - i]) {
                soNgichDao++;

            }
        }
        return soNgichDao;
    }
    private static boolean KiemTraSoNguyenTo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;

    }
    private static boolean KiemTraMangDoiXung(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;

            }
        }
        return true;
    }

    private static int[] DaoMang(int [] arr){
        int [] daoMang = new int[arr.length];
        for (int i = arr.length - 1 , j = 0 ; i >= 0 ; i--){
            daoMang[j++] = arr[i];
        }
        return daoMang;
    }
    private static int[] SapXepDuongAm0(int[] arr) {
        int indexDuong = 0;
        int indexAm = 0;
        int indexSo0 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) indexDuong++;
            else if (arr[i] < 0) indexAm++;
            else indexSo0++;
        }

        int[] SoDuong = new int[indexDuong];
        int[] SoAm = new int[indexAm];
        int[] So0 = new int[indexSo0];

        for (int i = 0, j = 0, k = 0, l = 0; i < arr.length; i++) {
            if (arr[i] > 0) SoDuong[j++] = arr[i];
            else if (arr[i] < 0) SoAm[k++] = arr[i];
            else So0[l++] = arr[i];
        }
        SapXepGiamDanMang(SoDuong);
        SapXepTangDanMang(SoAm);

        for (int i = 0, j = 0, k = 0, l = 0; i < arr.length; i++) {
            if (j < SoDuong.length) {
                arr[i] = SoDuong[j++];
            } else if (k < SoAm.length) {
                arr[i] = SoAm[k++];
            } else {
                arr[i] = So0[l++];
            }
        }

        return arr;
    }

    private static int[] TachSoNguyenToSangMang(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (KiemTraSoNguyenTo(arr[i])) {
                index += 1;
            }
        }
        int [] arrNew = new int [index];
        for( int i = 0 ,j = 0 ; i < arr.length ; i++){
            if(KiemTraSoNguyenTo(arr[i])){
                arrNew[j] = arr[i];
                j++;
            }
        }
        return arrNew;
    }
    private static int[] SapXepGiamDanMang(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    private static int[] SapXepTangDanMang(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    private  static int[][] TachSoThanhHaiMang(int[] arr){
        int soLuongNguyenDuong = 0;
        for( int i = 0 ; i < arr.length ; i++){
            if( arr[i] > 0 ){
                soLuongNguyenDuong +=1;
            }
        }
        int [] b = new int[soLuongNguyenDuong];
        int soLuongConLaiTrongMang = arr.length - soLuongNguyenDuong;
        int [] c = new int [soLuongConLaiTrongMang];
        for (int i = 0 , j = 0 , k = 0; i < arr.length ; i++){
            if(arr[i] > 0 ){
                b[j] = arr[i];
                j++;
            }
            else {
                c[k] = arr[i];
                k++;
            }
        }
        return new int[][] { b, c };
    }

}
