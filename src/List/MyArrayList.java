package List;

public class MyArrayList {
    private final int[] emptyArray = {};
    private int capacity;
    private int[] arr;
    private int size;

    public MyArrayList() {
        arr = emptyArray;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }

    public int size() {
        return size;
    }

    // Thêm phần tử tại vị trí cuối cùng
    public void add(int element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }

        if (size == capacity) {
            this.capacity *= 1.5;
            if (size == capacity) {// Tránh trường hợp capacity = 0 hoặc 1
                capacity++;
            }

            // Tạo một mảng mới có kích thước là capacity
            int[] brr = new int[this.capacity];

            // Copy phần tử
            if (size >= 0) System.arraycopy(arr, 0, brr, 0, size);

            // Cho arr tham chiếu đến vùng nhớ mới
            arr = brr;
        }

        arr[size] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }
        return stringBuilder.toString();
    }
}
