import java.util.Scanner;

public class DeQuy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap gia tri n");
        int n = sc.nextInt();
        //b1
//        int ints1 = giaiThua(n);
        //b2
//        int ints1 = thapPhanSangNhiPhan(n);
        //b3
//         int ints1 = inDaoNguoc(n);
        //b4
//        int ints1 = soFibonacci(n);
        //b5
//        int ints1 = tinhTongSn(n);
        //b6
//        int ints1 = tinhTongSn2(n);
        //b7
//        int ints1 = tinhTichPn(n);
        //b8
//        int ints1 = tinhBinhPhuongSn(n);
        //b9
//        int ints1 = demSoNguyenDuong(n);
        //b10
        int ints1 = thapPhanSangNhiPhan(n);
        System.out.println(ints1);

    }
    //b13 s = 1/n + 2/(n-1) +...+n/1
    //b12 kiem tra mang toan chan ko
    //b11 tim chu so lon nhat 123 = 3

    //b10 dem so luong so le cua so nguyen duong
    public static int demSoLe(int n){
        if ( n % 2 == 0) return 0;
        return 1 + demSoLe( n / 10);
    }
    //b9 dem so luong chu so nguyen duong
    public static int demSoNguyenDuong(int n){
        if( n <= 9 ) return 1;
        return 1 + demSoNguyenDuong(n / 10);
    }
    //b8 tinh S(n)= 1^2+2^2+...+n^2
    public static int tinhBinhPhuongSn(int n){
        if( n == 1) return 1;
        return ( n * n ) + tinhBinhPhuongSn(n - 1);
    }
    //b7 tinh tich cac so P(n) = 1*3*5*...*(2n+1)
    public static int tinhTichPn(int n){
        if (n == 0 ) return 1;
        return ((n * 2 ) + 1) * tinhTichPn(n - 1);
    }
    //b6 tinh tong S(n) = 1 + 3 + 5 ... (2*n+1)
    public static int tinhTongSn2(int n){
        if( n== 0) return 1;
        return ( n * 2 ) + 1 + tinhTongSn2((n-1));
    }
    //b5 Tinh tong S(n)= 1 + 2 + 3 +...+n
    public static int tinhTongSn(int n){
        if(n == 1 ) return 1;
        return  n + tinhTongSn(n - 1);
    }
    // b4 tinh so Fibonacci biet f(n) = (fn-1)+(fn-2),f(1) = 1,f(0) = 0;
    public  static int soFibonacci(int n){
        if(n == 0 ) return 0;
        if(n==1) return 1;
        return soFibonacci(n-1) + soFibonacci(n - 2);
    }
    //b3 In dao nguoc so n nguyen duong 123=321 !!chua lam dc
    public static int inDaoNguoc(int n){
        if (n < 10) return n; // Điều kiện dừng

        // Tính số chữ số của phần còn lại (n/10)
        int digits = (int) Math.log10(n / 10) + 1;
        int multiplier = (int) Math.pow(10, digits);

        return (n % 10) * multiplier + inDaoNguoc(n / 10);
    }
    //b2 Ham doi so thap phan sang nhi phan Chia lan luot cho 2 de lay du  = 0 / 1
    public static  int thapPhanSangNhiPhan(int n){
        if(n == 0 ) return 0;
        return  (n%2) + 10 * thapPhanSangNhiPhan(n / 2);
    }
    // b1 Tinh giai thua N!
    public static int giaiThua(int n){
        if(n == 0) return 1;
        return n + giaiThua(n - 1);
    }
}
