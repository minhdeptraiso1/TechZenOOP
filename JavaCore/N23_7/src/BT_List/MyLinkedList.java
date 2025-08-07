package BT_List;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void output() {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.printf("[ %d ]\n", current.value);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node temp = head;
        for (int i = 0; i < size; i++) {
            result.append(temp.value);
            if (i < size - 1) {
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public Integer removeFirst() {
        if (head == null) {
            return null;
        }

        int value = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return value;
    }

    public Integer removeLast() {
        if (head == null) {
            return null;
        }

        int value = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
        size--;
        return value;
    }

    public void remove(int index) {
        if (head == null || index < 0 || index >= size) {
            System.out.println("Index không hợp lệ hoặc danh sách rỗng!");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nodeToRemove = temp.next;
            temp.next = nodeToRemove.next;
            size--;
        }
    }

    public Integer getFist() {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        return head.value;
    }

    public Integer getLast() {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        if (head == tail) {
            return getFist();
        }
        return tail.value;
    }

    public Integer get(int index) {

        if (index >= size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return null;
        }
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println("Vị trí " + index + " có giá trị : " + temp.value);
        return temp.value;
    }

    public void set(int index, int element) {

        if (index >= size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = element;
    }

    public int indexOf(int value) {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return -1; // FIX: Trả về -1 thay vì 0
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                System.out.println("Đã tìm thấy đầu tiên " + value + " ở vị trí thứ: " + i);
                return i;
            }
            temp = temp.next;
        }
        System.out.println("Không tìm thấy " + value + " trong danh sách liên kết");
        return -1;
    }

    public int lastIndexOf(int value) {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return -1;
        }
        Node temp = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                lastIndex = i;
            }
            temp = temp.next;
        }
        if (lastIndex != -1) {
            System.out.println("Đã tìm thấy cuối cùng " + value + " ở vị trí thứ: " + lastIndex);
        } else {
            System.out.println("Không tìm thấy " + value + " trong danh sách liên kết");
        }
        return lastIndex;
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}