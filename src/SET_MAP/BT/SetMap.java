package SET_MAP.BT;

import java.util.*;


public class SetMap {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        Integer[] b = {1, 2, 3, 4, 5};
        Integer[] c = {7, 2, 6, 4, 5};
        HashSet<Integer> clearDouble = new HashSet<>();
        clearDouble.addAll(List.of(a));
        ArrayList<Integer> newA = new ArrayList<>();
        for (Integer item : clearDouble) {
            newA.add(item);
        }
        System.out.println("cau a");
        for (Integer element : newA) {
            System.out.println(element + "  ");
        }
        int sum = 0;
        for (Integer element : newA) {
            sum += element;
        }
        System.out.println("cau b");
        System.out.println("Tong cac phan tu : " + sum);

        System.out.println("cau c");
        System.out.println("Phan tu chung cua 2 mang la:");
        HashSet<Integer> doubleValue = new HashSet<>();
        doubleValue.addAll(List.of(b));
        for (Integer element : c) {
            if (!doubleValue.add(element)) {
                System.out.println(element + " ");
            }
        }
        System.out.println("cau d");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer element : clearDouble) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println("so lon nhat : " + max);
        System.out.println("so nho nhat : " + min);

        System.out.println("Bai tap MAP");
        System.out.println("cau a");
        System.out.println("Nhập đoạn văn bản:");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Số lần xuất hiện của từng từ:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("'" + entry.getKey() + "' xuất hiện " + entry.getValue() + " lần.");
        }
        System.out.println("cau b");
        List<String> names = new ArrayList<>();

        String check2 = "";
        do {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                names.add(name.toLowerCase()); // chuyển thành chữ thường để không phân biệt hoa/thường
            } else {
                System.out.println("Tên không được để trống, vui lòng nhập lại.");
                continue;
            }
            System.out.print("Nhập 'y' để tiếp tục nhập tên, hoặc ký tự khác để dừng: ");
            check2 = sc.nextLine().trim();
        } while (check2.equalsIgnoreCase("y"));

        // Dùng Map để đếm số lần xuất hiện từng tên
        Map<String, Integer> nameCount = new HashMap<>();
        for (String n : names) {
            nameCount.put(n, nameCount.getOrDefault(n, 0) + 1);
        }

        // Tạo 2 danh sách chứa tên duy nhất và tên trùng
        List<String> uniqueNames = new ArrayList<>();
        List<String> duplicateNames = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueNames.add(entry.getKey());
            } else {
                duplicateNames.add(entry.getKey());
            }
        }

        // In kết quả
        System.out.println("\nTên duy nhất (xuất hiện 1 lần):");
        if (!uniqueNames.isEmpty()) {
            for (String uName : uniqueNames) {
                System.out.println("- " + uName);
            }
        } else {
            System.out.println("Không có tên nào duy nhất.");
        }

        System.out.println("\nTên trùng (xuất hiện nhiều lần):");
        if (!duplicateNames.isEmpty()) {
            for (String dName : duplicateNames) {
                System.out.println("- " + dName + " (số lần xuất hiện: " + nameCount.get(dName) + ")");
            }
        } else {
            System.out.println("Không có tên nào trùng.");
        }


//        ArrayList<Integer> arrInt = new ArrayList<>();
//        ArrayList<Integer> arrInt2 = new ArrayList<>();
//        ArrayList<Integer> arrInt3 = new ArrayList<>();
//
//        //a
//        clearValueDoubleA(arrInt);
//        //b
//        clearValueDouble(arrInt2);
//        //c
//        findValueOverlap(arrInt, arrInt2);
//        //d
//        findBigestAndSmallest(arrInt3);
    }

    //a
    private static void clearValueDoubleA(ArrayList<Integer> arr) {
        HashSet<Integer> valueSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String kt = "";

        do {
            System.out.print("Nhập số nguyên: ");
            int n;
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, mời nhập lại.");
                continue;
            }
            valueSet.add(n);
            System.out.print("Nhập 'y' để tiếp tục thêm, hoặc ký tự khác để dừng: ");
            kt = sc.nextLine().trim();

        } while (kt.equalsIgnoreCase("y"));
        arr.addAll(valueSet);
        System.out.println("Tổng các phần tuwr : " + valueSet);
    }

    //b
    private static void clearValueDouble(ArrayList<Integer> arr) {
        HashSet<Integer> valueSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String kt = "";

        do {
            System.out.print("Nhập số nguyên: ");
            int n;
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, mời nhập lại.");
                continue;
            }
            valueSet.add(n);
            System.out.print("Nhập 'y' để tiếp tục thêm, hoặc ký tự khác để dừng: ");
            kt = sc.nextLine().trim();

        } while (kt.equalsIgnoreCase("y"));
        arr.addAll(valueSet);
        System.out.println("Tổng các giá trị : " + sumValueSet(valueSet));
    }

    private static int sumValueSet(HashSet<Integer> set) {
        int sum = 0;
        for (Integer item : set) {
            sum += item;
        }
        return sum;
    }

    //c
    private static void findValueOverlap(ArrayList<Integer> arr, ArrayList<Integer> arr2) {
        HashSet<Integer> arrSet = new HashSet<>(arr);
        HashSet<Integer> duplicates = new HashSet<>();

        for (Integer element : arr2) {
            if (arrSet.contains(element)) {
                duplicates.add(element);
            }
        }

        System.out.println("Các phần tử trùng nhau:");
        for (Integer element : duplicates) {
            System.out.println(element);
        }
    }


    //d
    private static void findBigestAndSmallest(ArrayList<Integer> arr) {
        HashSet<Integer> valueSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String kt = "";

        do {
            System.out.print("Nhập số nguyên: ");
            int n;
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, mời nhập lại.");
                continue;
            }
            valueSet.add(n);
            System.out.print("Nhập 'y' để tiếp tục thêm, hoặc ký tự khác để dừng: ");
            kt = sc.nextLine().trim();

        } while (kt.equalsIgnoreCase("y"));
        arr.addAll(valueSet);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer item : valueSet) {
            if (max < item) max = item;
            if (min > item) min = item;
        }
        System.out.println("So lon nhat : " + max + " vàsooso be nhat : " + min);
    }
}
