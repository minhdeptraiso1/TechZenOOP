import java.util.ArrayList;

public class Sang_ArraysList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        //cac phuong thuc cua arraylist
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);                // Thêm vào cuối danh sách
        list.add(1, 99);             // Thêm 99 vào vị trí 1
        list.set(0, 123);            // Cập nhật giá trị tại vị trí 0
        list.remove(1);             // Xóa phần tử vị trí 1
        list.get(0);                // Lấy giá trị tại vị trí 0
        list.contains(123);         // Kiểm tra xem có chứa 123 không

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Danh sách: " + numbers);

        numbers.remove(Integer.valueOf(20));
        System.out.println("Sau khi xóa 20: " + numbers);

        numbers.set(0, 99);
        System.out.println("Sau khi thay phần tử đầu: " + numbers);

        if (numbers.contains(30)) {
            System.out.println("Danh sách có chứa 30");
        }
    }
}
