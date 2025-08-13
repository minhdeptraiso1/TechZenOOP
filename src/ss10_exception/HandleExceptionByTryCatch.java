package ss10_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleExceptionByTryCatch {
    // Sửa tên class cho đúng
    private static final Logger logger = Logger.getLogger(HandleExceptionByTryCatch.class.getName());

    public static void main(String[] args) {
        File fileWrong = new File("src/data/study.java");
        File file = new File("src/ss10_exception/ExceptionStudy.java");

        // Test với file không tồn tại
        testReadFile(fileWrong, "file KHÔNG tồn tại");

        // Test với file tồn tại
        testReadFile(file, "file TỒN TẠI");

        System.out.println(">>>>> Chương trình kết thúc KHÔNG LỖI");
    }

    private static void testReadFile(File file, String description) {
        System.out.println("\n--- Test với " + description + " ---");
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            System.out.println(">>>>> Mở file thành công: " + file.getPath());
            // Có thể đọc dữ liệu từ file ở đây

        } catch (FileNotFoundException e) {
            // Cách 1: Dùng logger
            logger.log(Level.SEVERE, ">>>>> Không tìm thấy file: " + file.getPath(), e);

            // Cách 2: In ra console
            // e.printStackTrace();
            // System.out.println(">>>>> Flow đi vào khối catch FileNotFoundException");

        } finally {
            // Đảm bảo đóng file trong mọi trường hợp
            if (fileReader != null) {
                try {
                    fileReader.close();
                    System.out.println(">>>>> Đã đóng FileReader");
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Lỗi khi đóng FileReader", e);
                }
            }
        }
    }
}
