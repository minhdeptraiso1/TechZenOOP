package Fraction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fraction {
     int numerator;     //tu so
     int denominator;   // mau so
    public void checkFraction(Fraction a){
        if(a.numerator > 0 && a.denominator > 0){
            System.out.println("la phan so duong");
        }
        else if(a.numerator == 0 ){
            System.out.println("la phan so = 0");
        }
        else{
            System.out.println("la phan so am");
        }
    }
    public Fraction sum(Fraction f1 , Fraction f2){
        Fraction sumFraction = new Fraction();
        sumFraction.numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        sumFraction.denominator = f1.denominator * f2.denominator;
        sumFraction.simplify();
        return sumFraction;
    }
    public Fraction subtraction(Fraction f1 , Fraction f2){
        Fraction subtractionFraction = new Fraction();
        subtractionFraction.numerator = f1.numerator * f2.denominator - f2.numerator * f1.denominator;
        subtractionFraction.denominator = f1.denominator * f2.denominator;
        subtractionFraction.simplify();
        return subtractionFraction;
    }
    public Fraction division(Fraction f1 , Fraction f2){
        Fraction divisionFraction = new Fraction();
        divisionFraction.numerator = f1.numerator * f2.denominator;
        divisionFraction.denominator = f1.denominator * f2.numerator;
        divisionFraction.simplify();
        return divisionFraction;
    }
    public Fraction multiplication(Fraction f1 , Fraction f2){
        Fraction multiplicationFraction = new Fraction();
        multiplicationFraction.numerator = f1.numerator * f2.numerator;
        multiplicationFraction.denominator = f1.denominator * f2.denominator;
        multiplicationFraction.simplify();
        return multiplicationFraction;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập tử số: ");
                numerator = sc.nextInt();
                sc.nextLine(); // Xóa bộ đệm
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số nguyên!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
        while (true) {
            try {
                System.out.print("Nhập mẫu số (khác 0): ");
                denominator = sc.nextInt();
                sc.nextLine(); // Xóa bộ đệm

                if (denominator == 0) {
                    System.out.println("Lỗi: Mẫu số không thể bằng 0!");
                    continue; // Yêu cầu nhập lại
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số nguyên!");
                sc.nextLine(); // Xóa bộ đệm nhập sai
            }
        }
    }
    //uoc chung lon nhat
    public int largestCommon(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
//so rut gon
    public void simplify() {
        int ucln = largestCommon(numerator, denominator);
        numerator /= ucln;
        denominator /= ucln;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public void output() {
        simplify();
        if (denominator == 1) {
            System.out.println(numerator); // In số nguyên nếu mẫu = 1
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }









    //----sai---chưa in ra kết quả rút gọn
//    public ArrayList<Integer> divisor(int a){
//        ArrayList<Integer> arr = new ArrayList<>();
//        if (a < 0 ){
//            a *= -1;
//        }
//        for (int i = a ; i > 0 ; i--){
//            if (a % i == 0){
//                arr.add(i);
//            }
//        }
//        return arr;
//    }
//    public int largestCommon(int a , int b) {
//        int indexNumerator = divisor(a).size();
//        int indexDenominator = divisor(b).size();
//        int uCLN = 1;
//        for (int i = 0; i < indexNumerator; i++) {
//            for (int j = 0; j < indexDenominator; j++) {
//                if (divisor(a).get(i).equals(divisor(b).get(j)))  {
//                    uCLN = divisor(a).get(i);
//                    break;
//                }
//            }
//        }
//        return uCLN;
//    }
//    public void output(){
//            int ucln = largestCommon(numerator, denominator);
//            int x = numerator / ucln;
//            int y = denominator / ucln;
//            System.out.println(x + "/" + y);
//    }





}
