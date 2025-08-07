package List2;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public static void main(String[] args) {
        
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
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
        if (head == null) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        Node<E> current = head;
        while (current != null) {
            System.out.println("[ " + current.value + " ]");
            current = current.next;
        }
    }

    @Override
    public String toString() {
        if (head == null)
            return "[]";
        StringBuilder result = new StringBuilder("[");
        Node<E> temp = head;
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

    public void addLast(E value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node<E> newNode = new Node<>(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<E> temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node<E> newNode = new Node<>(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E value = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return value;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        E value = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = head;
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
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public E getFirst() {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        return head.value;
    }

    public E getLast() {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        return tail.value;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index không hợp lệ!");
            return null;
        }
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return null;
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println("Vị trí " + index + " có giá trị : " + temp.value);
        return temp.value;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = element;
    }

    public int indexOf(E value) {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return -1;
        }
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (temp.value == null) {
                    System.out.println("Đã tìm thấy đầu tiên null ở vị trí thứ: " + i);
                    return i;
                }
            } else if (value.equals(temp.value)) {
                System.out.println("Đã tìm thấy đầu tiên " + value + " ở vị trí thứ: " + i);
                return i;
            }
            temp = temp.next;
        }
        System.out.println("Không tìm thấy " + value + " trong danh sách liên kết");
        return -1;
    }

    public int lastIndexOf(E value) {
        if (head == null) {
            System.out.println("Danh sách liên kết rỗng!");
            return -1;
        }
        Node<E> temp = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (temp.value == null) {
                    lastIndex = i;
                }
            } else if (value.equals(temp.value)) {
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

    public int size() {
        return size;
    }

    public static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }
}
