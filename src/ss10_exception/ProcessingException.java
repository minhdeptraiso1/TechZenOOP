package ss10_exception;

public class ProcessingException {
    static boolean check = false;

    public static void main(String[] args) {
        if (check) {
            System.out.println("dang xu ly");
            return;
        }
        try {
            /// Thêm dòng lệnh gây exception thì điều gì xảy ra???
            String str = null;
            str.length();

            /// Xử lý ArithmeticException
            int a = 1 / 0;
            System.out.println(">>>>> Chạy tiếp"); // Có in ra 2 dòng này không???
            System.out.println(">>>>> Chạy tiếp");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(">>>>> Lỗi chia cho 0");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(">>>>> Lỗi tham chiếu đến đối tượng null");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(">>>>> Lỗi hệ thống ...");
        } finally {
            System.out.println(">>>>> Khối finally");
            check = false;
        }

        /// Nếu đưa luôn các dòng lệnh trong khối finally ra ngoài khối try/catch thì sao???
        ///khi gap return van chay khoi finally
        System.out.println(">>>>> Khối finally");


        System.out.println(">>>>> Chương trình xịn xò kết thúc KHÔNG LỖI");
    }
}
