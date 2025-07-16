import java.util.Scanner;

public class Bt_Chieu_Mang_2_Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua mang : ");//chieu ngang
        int x = sc.nextInt();
        System.out.println("Nhap so cot cua mang : ");//chieu doc
        int y = sc.nextInt();
        System.out.println("Mang co " + x + " hang va " + y +" cot !");
        int[][] arr = new int[x][y];
        //nhap mang
        importArray(arr,sc);
        //in mang
        printArray(arr);
        System.out.println("Nhap kich thuoc hinh vuong");
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
}


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