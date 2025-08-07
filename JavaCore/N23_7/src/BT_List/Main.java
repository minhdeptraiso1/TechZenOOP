package BT_List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KIỂM TRA MyArrayList ===");
        testMyArrayList();

        System.out.println("\n=== KIỂM TRA MyLinkedList ===");
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        MyArraylist list = new MyArraylist();

        // Test 1: addlast và toString
        System.out.println("1. Kiểm tra addlast và toString:");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Danh sách sau khi thêm 10, 20, 30: " + list);
        System.out.println("Kích thước: " + list.size());

        // Test 2: add tại index
        System.out.println("\n2. Kiểm tra add tại vị trí index:");
        list.add(15, 1); // Thêm 15 tại vị trí 1
        System.out.println("Sau khi thêm 15 tại vị trí 1: " + list);

        // Test 3: get
        System.out.println("\n3. Kiểm tra get:");
        System.out.println("Phần tử tại vị trí 0: " + list.get(0));
        System.out.println("Phần tử tại vị trí 2: " + list.get(2));
        System.out.println("Phần tử tại vị trí không hợp lệ 10: " + list.get(10));

        // Test 4: set
        System.out.println("\n4. Kiểm tra set:");
        list.set(25, 2);
        System.out.println("Sau khi đặt vị trí 2 thành 25: " + list);

        // Test 5: indexOf và lastIndexOf
        System.out.println("\n5. Kiểm tra indexOf và lastIndexOf:");
        list.add(15); // Thêm phần tử trùng lặp
        list.add(40);
        list.add(15); // Thêm phần tử trùng lặp khác
        System.out.println("Danh sách có phần tử trùng lặp: " + list);
        System.out.println("Vị trí đầu tiên của 15: " + list.indexOf(15));
        System.out.println("Vị trí cuối cùng của 15: " + list.lastIndexOf(15));
        System.out.println("Vị trí của phần tử không tồn tại 100: " + list.indexOf(100));

        // Test 6: remove by index
        System.out.println("\n6. Kiểm tra xóa theo vị trí:");
        list.remove(1);
        System.out.println("Sau khi xóa vị trí 1: " + list);

        // Test 7: removeElement
        System.out.println("\n7. Kiểm tra removeElement:");
        list.removeElement(15);
        System.out.println("Sau khi xóa tất cả phần tử 15: " + list);
        list.removeElement(999); // Element không tồn tại

        // Test 8: Constructor với capacity
        System.out.println("\n8. Kiểm tra constructor với capacity:");
        MyArraylist list2 = new MyArraylist(5);
        list2.add(1);
        list2.add(2);

        System.out.println("Danh sách mới với capacity ban đầu là 5: " + list2);
    }

    public static void testMyLinkedList() {
        MyLinkedList list = new MyLinkedList();

        // Test 1: addFirst và toString
        System.out.println("1. Kiểm tra addFirst và toString:");
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("Danh sách sau khi thêm 30, 20, 10 (addFirst): " + list);

        // Test 2: addLast
        System.out.println("\n2. Kiểm tra addLast:");
        list.addLast(40);
        list.addLast(50);
        System.out.println("Sau khi thêm 40, 50 (addLast): " + list);

        // Test 3: add at index
        System.out.println("\n3. Kiểm tra add tại vị trí index:");
        list.add(2, 25); // Thêm 25 tại vị trí 2
        System.out.println("Sau khi thêm 25 tại vị trí 2: " + list);

        // Test 4: get methods
        System.out.println("\n4. Kiểm tra các phương thức get:");
        System.out.println("Phần tử đầu tiên: " + list.getFist());
        System.out.println("Phần tử cuối cùng: " + list.getLast());
        list.get(0); // Sẽ in phần tử tại vị trí 0
        list.get(3); // Sẽ in phần tử tại vị trí 3
        list.get(10); // Vị trí không hợp lệ

        // Test 5: set
        System.out.println("\n5. Kiểm tra set:");
        list.set(1, 99);
        System.out.println("Sau khi đặt vị trí 1 thành 99: " + list);

        // Test 6: indexOf và lastIndexOf
        System.out.println("\n6. Kiểm tra indexOf và lastIndexOf:");
        list.addLast(25); // Thêm phần tử trùng lặp
        System.out.println("Danh sách có phần tử trùng lặp 25: " + list);
        list.indexOf(25);
        list.lastIndexOf(25);
        list.indexOf(999); // Không tìm thấy

        // Test 7: remove methods
        System.out.println("\n7. Kiểm tra các phương thức remove:");
        System.out.println("Đã xóa phần tử đầu: " + list.removeFirst());
        System.out.println("Sau khi removeFirst: " + list);

        System.out.println("Đã xóa phần tử cuối: " + list.removeLast());
        System.out.println("Sau khi removeLast: " + list);

        list.remove(1); // Xóa tại vị trí 1
        System.out.println("Sau khi xóa vị trí 1: " + list);

        // Test 8: Edge cases
        System.out.println("\n8. Kiểm tra các trường hợp đặc biệt:");
        MyLinkedList emptyList = new MyLinkedList();
        System.out.println("Thao tác trên danh sách rỗng:");
        emptyList.getFist();
        emptyList.getLast();
        emptyList.get(0);
        emptyList.indexOf(10);

        // Test single element list
        MyLinkedList singleList = new MyLinkedList();
        singleList.addFirst(100);
        System.out.println("Danh sách có một phần tử: " + singleList);
        System.out.println("Xóa từ danh sách có một phần tử: " + singleList.removeFirst());
        System.out.println("Sau khi xóa: " + singleList);
    }
}