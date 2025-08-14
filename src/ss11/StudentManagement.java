package ss11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentManagement {
    private static final Logger logger = Logger.getLogger(StudentManagement.class.getName());

    private static final String PATH_STUDENT_FILE = "src/ss11/data/student.csv";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        showList();
        create();
        update();
        delete();
        showList();
    }

    public static List<Phone> readFile(String path) {
        File file = new File(path);
        List<Phone> students = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine(); // Đọc ra để loại bỏ dòng header

            Phone student;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                student = new Phone();
                student.setId(data[0]);
                student.setName(data[1]);
                student.setScore(Double.parseDouble(data[2]));

                students.add(student);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, ">>>>> Lỗi khi đọc file", e);
        }

        return students;
    }

    public static void showList() {
        List<Phone> students = readFile(PATH_STUDENT_FILE);
        for (Phone s : students) {
            System.out.println("\nThông tin sinh viên với ID: " + s.getId());
            s.output();
        }
    }

    private static void writeFile(List<Phone> students) {
        StringBuilder stringBuilder = new StringBuilder("id,name,score");
        for (Phone s : students) {
            stringBuilder.append("\n").append(s.toString());
        }

        File file = new File(PATH_STUDENT_FILE);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            logger.log(Level.SEVERE, ">>>>> Lỗi khi ghi file", e);
        }
    }

    public static void create() {
        List<Phone> students = readFile(PATH_STUDENT_FILE);

        Phone student = new Phone();
        student.input(true);
        students.add(student);

        writeFile(students);
    }


    /// Hãy viết phương thức cập nhật dữ liệu một sinh viên theo ID
    public static void update() {
        List<Phone> students = readFile(PATH_STUDENT_FILE);

        System.out.println("Nhap ID :");
        String id = sc.nextLine();

        boolean findStudentById = false;
        for (Phone s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.input(false);
                findStudentById = true;
            }
        }
        if (!findStudentById) {
            System.out.println("Ko tim thay");
        }
        writeFile(students);


    }

    /// Hãy viết phương thức xóa sinh viên theo ID
    public static void delete() {
        List<Phone> students = readFile(PATH_STUDENT_FILE);

        System.out.println("Nhap ID :");
        String id = sc.nextLine();
        int indexDelete = -1;

        boolean findStudentById = false;
//        for (Student s : students) {
//            if (s.getId().equalsIgnoreCase(id)) {
//                students.remove(s);
//                findStudentById = true;
//            }
//        }loi runtime khi chay forEach thì ko nên xóa gây lỗi
        //viet Lambda
        //students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        ////                ↑    ↑
        ////            parameter  body (điều kiện xóa)
        //students.removeIf(student -> student.getId().equalsIgnoreCase(id));
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                findStudentById = true;
                indexDelete = i;
            }
        }
        if (!findStudentById) {
            System.out.println("Ko tim thay");
        } else {
            students.remove(indexDelete);
            System.out.println("Da xoa");
        }
        writeFile(students);

    }
}
