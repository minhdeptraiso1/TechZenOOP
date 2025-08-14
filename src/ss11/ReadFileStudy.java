package ss11;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFileStudy {
    private static final Logger logger = Logger.getLogger(ReadFileStudy.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("src/ss11/data/input.txt");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("src/ss11/data/input.txt", true));
            System.out.println("Nhap :");
            String inputFile = sc.nextLine();
            bufferedWriter.write(inputFile);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close(); // ✅ Đóng writer - tự động flush
                }
            } catch (IOException e) {
                System.err.println("Lỗi đóng file: " + e.getMessage());
            }
        }

        /// Có thể sử dụng try-with-resources để java tự tự động gọi close() cho tất cả tài nguyên khai báo trong (...)
        /// -> không cần viết finally { bufferedReader.close(); } thủ công
//        try (BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = bufferedReader2.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException f) {
//            logger.log(Level.SEVERE, "Lỗi file ko tồn tại", f);
//        } catch (IOException e) {
//            logger.log(Level.SEVERE, ">>>>> Lỗi đọc file", e);
//        }
// Không cần finally block vì try-with-resources tự động đóng


        try {//
            bufferedReader = new BufferedReader(new FileReader(file));
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine()); // -> Kết quả???

//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            logger.log(Level.SEVERE, ">>>>> Lỗi đọc file", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, ">>>>> Lỗi khi đóng BufferedReader", e);
            }
        }
    }
}
