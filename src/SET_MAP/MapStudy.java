package SET_MAP;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStudy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đoạn văn bản:");
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
    }
}
//        Map<Integer, String> map = new HashMap<>();
//
//        map.put(1, "Nguyễn Văn A");
//        map.put(2, "Nguyễn Văn B");
//        map.put(3, "Nguyễn Văn C");
//        map.put(4, "Nguyễn Văn d");
//        map.put(5, "Nguyễn Văn C");
//
//
//        System.out.println(map.get(5));
//
//
//        /// Duyệt qua các phần tử của map???
//        Set<Integer> set = map.keySet();
//        for (Integer key : set) {
//            System.out.println(key + " - " + map.get(key));
//        }
//    }

