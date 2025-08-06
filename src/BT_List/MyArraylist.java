package BT_List;

public class MyArraylist {
    private final int[] emptyArray = {};
    private int[] arr;
    private int capacity;//kich thuoc toi da
    private int size;//kich thuoc hien tai

    public MyArraylist() {
        arr = emptyArray;
    }

    public MyArraylist(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    //add vao cuoi chuoi
    public void add(int element) {
        int newCapacity;
        if (this.size == this.capacity) {
            if (this.capacity == 0) {
                newCapacity = 1;
            } else if (this.capacity == 1) {
                newCapacity = 2;
            } else {
                newCapacity = (int) (this.capacity * 1.5);
            }
            int[] newArr = new int[newCapacity];
            System.arraycopy(this.arr, 0, newArr, 0, this.size);
            this.arr = newArr;
            this.capacity = newCapacity;
        }
        this.arr[this.size] = element;
        this.size++;
    }

    //in ra
    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.arr[i]);
            if (i < this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // them phan tu vao vi tri index
    public void add(int element, int index) {
        if (index > this.size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        //tang kich thuoc mang de chen
        if (this.size == this.capacity) {
            int newCapacity;
            if (this.capacity == 0) {
                newCapacity = 1;
            } else if (this.capacity == 1) {
                newCapacity = 2;
            } else {
                newCapacity = (int) (this.capacity * 1.5);
            }
            int[] newArr = new int[newCapacity];
            System.arraycopy(this.arr, 0, newArr, 0, this.size);
            this.arr = newArr;
            this.capacity = newCapacity;
        }
        for (int i = this.size - 1; i >= index; i--) {
            this.arr[i + 1] = this.arr[i];
        }
        this.arr[index] = element;

        this.size++;
    }

    public void set(int element, int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        this.arr[index] = element;
    }

    public Integer get(int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return null;
        }
        return this.arr[index];
    }

    public Integer indexOf(int element) {
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == element) {
                index = i;
                return i;
            }
        }
        return null;
    }

    public Integer lastIndexOf(int element) {
        int index = 0;
        for (int i = this.size; i >= 0; i--) {
            if (this.arr[i] == element) {
                index = i;
                return i;
            }
        }
        return null;

    }

    public void remove(int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        for (int i = index; i < this.size; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        size--;
    }

    public void removeElement(int emlement) {
        boolean defau = false;
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == emlement) {
                remove(i);
                defau = true;
            }
        }
        if (!defau) {
            System.out.println("Khong co phan tu nao = " + emlement + " trong mang de xoa");
        } else {
            System.out.println("da xoa tat ca  phan tu  = " + emlement + " trong mang ");
        }
    }

    public int size() {
        return size;
    }
}
