package ss10_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ExceptionClassification {
    /// Các loại Exception bên ExceptionStudy thuộc loại nào???


    public static void main(String[] args) {
        /// Checked Exception
        File fileWrong = new File("src/data/study.java"); // Học ở bài sau
        File file = new File("src/ss10_exception/ExceptionStudy.java");

        // FileNotFoundException là loại checked
        // -> báo lỗi "Unhandled exception" ở compile time
        // -> bắt buộc phải xử lý

        try {
            FileReader fileReader = new FileReader(fileWrong);
        } catch (FileNotFoundException e) {
            e.getMessage();
            //throw new RuntimeException(e);
        }


    }
}
