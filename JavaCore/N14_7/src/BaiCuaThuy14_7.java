import java.util.Arrays;
import java.util.Scanner;
public class BaiCuaThuy14_7 {
    static boolean isPrimeNumber(int n) {
        if (n <= 1 || n % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void enterArray(int[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập các phần từ thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println();
    }

    static void spilitArrayIntoTwoArray(int[] a) {
        int positiveNumberCount = 0;
        int remainingNumberCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) positiveNumberCount++;
            else remainingNumberCount++;
        }

        int[] b, c;
        b = new int[positiveNumberCount];
        c = new int[remainingNumberCount];

        int bIndex = 0, cIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                b[bIndex++] = a[i];
            } else {
                c[cIndex++] = a[i];
            }
        }

        System.out.println("Bài 2: Tách mảng a thành 2 mảng b, c");
        System.out.println("Mảng a: " + Arrays.toString(a));
        System.out.println("Mảng b (số dương): " + Arrays.toString(b));
        System.out.println("Mảng c (số còn lại): " + Arrays.toString(c));
    }

    static void printArray(int[] arr, int baiSo) {
        switch (baiSo) {
            case 1 ->
                    System.out.println("Bài 1: Tách các số nguyên tố trong mảng đưa vào mảng b - Kết quả: " + Arrays.toString(arr));
            case 3 -> System.out.println("Bài 3: Sắp xếp mảng giảm dần - Kết quả: " + Arrays.toString(arr));
//            case 4 -> System.out.println("Bài 4: " + Arrays.toString(arr));
            case 5 -> System.out.println("Bài 5: Đảo ngược mảng - Kết quả: " + Arrays.toString(arr));
            default -> System.out.println("In mảng: " + Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập độ dài phần tử trong mảng: ");
        int length = sc.nextInt();
        int[] a = new int[length];

        enterArray(a, sc);
        printArray(a, 0);

        // a.
        int[] b1 = new int[length];
        for (int i = 0; i < a.length; i++) {
            if (isPrimeNumber(a[i])) b1[i] = a[i];
        }
        printArray(b1, 1);

        // b.
        spilitArrayIntoTwoArray(a);

        // c.
        sortDESC(a);
        printArray(a, 3);

        // d.

        // e.
        printArray(reverseArray(a), 5);

        // f.
        String checkSymmetricalArray = isSymmetricalArray(a) ? "Có" : "Không";
        System.out.println("Bài 6: Kiểm tra mảng đối xứng - Kết quả: " + checkSymmetricalArray);

        // g.
        System.out.println("Bài 7: Đếm cặp số đối xứng trong mảng - Kết quả: " + countPairSymmetrical(a));
    }

    static void sortDESC(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static int[] reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return arr;
    }

    static boolean isSymmetricalArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static int countPairSymmetrical(int[] arr) {
        int count = 0;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] == arr[right]) {
                count++;
            }
            left++;
            right--;
        }
        return count;
    }

    }