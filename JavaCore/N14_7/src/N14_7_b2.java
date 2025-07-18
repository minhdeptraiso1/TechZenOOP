import java.util.Arrays;
import java.util.Scanner;
public class N14_7_b2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap kich thuoc cua mang a: ");
        int n = sc.nextInt();
        System.out.println("Nhap vi tri can xoa cua mang a: ");
        int x = sc.nextInt();
        System.out.println("Nhap vi tri can chen cua mang a: ");
        int y = sc.nextInt();
        System.out.println("Nhap gia tri can chen cua mang a: ");
        int z = sc.nextInt();
        int[] a = new int[n];
        NhapMang(n, a);
        System.out.println("Mang vua nhap la : " + Arrays.toString(a));

        //a
        int[] thaySo = ThaySoNguyenTo(Arrays.copyOf(a, a.length));
        System.out.println("Mang sau khi thay doi :" + Arrays.toString(thaySo));
        //b
        int[] chenSo = ChenSo0VaoMang(Arrays.copyOf(a, a.length));
        System.out.println("Mang sau khi thay doi :" + Arrays.toString(chenSo));
        //c
        int[] xoaSo = XoaSoTheoViTri(x, Arrays.copyOf(a, a.length));
        System.out.println("Mang sau khi xoa la : " + Arrays.toString(xoaSo));
        //d
        int[] xoaSoNguyenTo = XoaSoNguyenTo(Arrays.copyOf(a, a.length));
        System.out.println("Mang sau khi xoa so nguyen to :" + Arrays.toString(xoaSoNguyenTo));
        //e
        int [] chenSoVaoViTri = ChenSoVaoViTri(y,z,Arrays.copyOf(a,a.length));
        System.out.println("Mang sau khi chen : "+Arrays.toString(chenSoVaoViTri));

    }

    private static boolean KiemTraSoNguyenTo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;

    }

    private static void NhapMang(int n, int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap gia tri cua mang vi tri thu" + i + ":");
            arr[i] = sc.nextInt();
        }
    }

    private static int[] ThaySoNguyenTo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (KiemTraSoNguyenTo(arr[i])) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    private static int[] ChenSo0VaoMang(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (KiemTraSoNguyenTo(arr[i])) {
                index++;
            }
        }
        int newIdenx = arr.length + index;
        int[] newArr = new int[newIdenx];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (KiemTraSoNguyenTo(arr[i])) {
                newArr[j++] = arr[i];
                newArr[j++] = 0;
            } else {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    private static int[] XoaSoTheoViTri(int n, int[] arr) {
        int[] newArr = new int[arr.length - 1];
        if (n >= 0 && n < arr.length - 1) {
            for (int i = 0, j = 0; i < arr.length; i++) {
                //if(arr [i] != arr[n]){
                if (i != n) {
                    newArr[j++] = arr[i];
                }
            }
        }
        return newArr;
    }

    private static int[] XoaSoNguyenTo(int[] arr) {
        int soLuongNguyenTo = 0;
        for (int i = 0; i < arr.length; i++) {
            if (KiemTraSoNguyenTo(arr[i])) {
                soLuongNguyenTo++;
            }
        }
        int[] newArr = new int[arr.length - soLuongNguyenTo];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (!KiemTraSoNguyenTo(arr[i])) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    private static int[] ChenSoVaoViTri(int n, int m, int[] arr) {
        int[] newArr = new int[arr.length];
        if (n >= 0 && n < arr.length - 1) {
            for (int i = 0, j = 0; i < newArr.length; i++) {
                if (i != n) {
                    newArr[j++] = arr[i];
                }
                else {
                    newArr[j++] = m;
                }
            }
        }
        return newArr;
    }
}
