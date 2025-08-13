package BT_1_8.chieu;

import BT_1_8.chieu.exception.InvalidAgeException;
import BT_1_8.chieu.exception.InvalidEmailException;
import BT_1_8.chieu.exception.NullOrEmptyException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Person> persons = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static LinkedList<Schedule> schedules = new LinkedList<>();
    static HashMap<Schedule, Lecturer> manage = new HashMap<>();

// Thay thế method initializeSampleData() trong Main.java bằng code này

    private static void initializeSampleData() {
        System.out.println("🔄 Đang khởi tạo dữ liệu test toàn diện...");

        // ==================== TẠO LECTURERS TRƯỚC ====================
        System.out.println("📚 Tạo danh sách Giảng viên...");

        Lecturer lecturer1 = new Lecturer("L001", "Dr. Nguyễn Văn An", 45, "nva@techzen.edu.vn", 40, "Java Programming");
        Lecturer lecturer2 = new Lecturer("L002", "Prof. Trần Thị Bình", 38, "ttb@techzen.edu.vn", 35, "Web Development");
        Lecturer lecturer3 = new Lecturer("L003", "Dr. Lê Minh Cường", 42, "lmc@techzen.edu.vn", 38, "Database Management");
        Lecturer lecturer4 = new Lecturer("L004", "MSc. Phạm Thị Dung", 35, "ptd@techzen.edu.vn", 30, "Mobile Development");
        Lecturer lecturer5 = new Lecturer("L005", "Dr. Hoàng Văn Em", 50, "hve@techzen.edu.vn", 25, "System Architecture");

        persons.add(lecturer1);
        persons.add(lecturer2);
        persons.add(lecturer3);
        persons.add(lecturer4);
        persons.add(lecturer5);

        // ==================== TẠO BACKEND STUDENTS ====================
        System.out.println("💻 Tạo danh sách Học viên Backend...");

        // Nhóm học viên giỏi
        persons.add(new StudentBE("BE001", "Nguyễn Minh Anh", 22, "nma@student.edu.vn", 8.7, 45, "Java"));
        persons.add(new StudentBE("BE002", "Trần Văn Bách", 23, "tvb@student.edu.vn", 8.2, 42, "Python"));
        persons.add(new StudentBE("BE003", "Lê Thị Cẩm", 21, "ltc@student.edu.vn", 9.1, 48, "Java"));
        persons.add(new StudentBE("BE004", "Phạm Minh Đức", 24, "pmd@student.edu.vn", 8.9, 46, "C#"));

        // Nhóm học viên khá
        persons.add(new StudentBE("BE005", "Hoàng Thị Lan", 22, "htl@student.edu.vn", 7.2, 40, "Python"));
        persons.add(new StudentBE("BE006", "Vũ Văn Nam", 25, "vvn@student.edu.vn", 6.8, 38, "Java"));
        persons.add(new StudentBE("BE007", "Đặng Thị Oanh", 23, "dto@student.edu.vn", 7.5, 43, "C#"));

        // Nhóm học viên trung bình
        persons.add(new StudentBE("BE008", "Ngô Văn Phong", 26, "nvp@student.edu.vn", 5.5, 35, "Python"));
        persons.add(new StudentBE("BE009", "Bùi Thị Quỳnh", 24, "btq@student.edu.vn", 6.2, 39, "Java"));
        persons.add(new StudentBE("BE010", "Mai Văn Sơn", 22, "mvs@student.edu.vn", 5.8, 36, "C#"));

        // ==================== TẠO FULLSTACK STUDENTS ====================
        System.out.println("🌐 Tạo danh sách Học viên Fullstack...");

        // Nhóm học viên giỏi (>= 2 projects và >= 8 điểm)
        persons.add(new StudentFS("FS001", "Đỗ Minh Tuấn", 23, "dmt@student.edu.vn", 8.3, 50, 3));
        persons.add(new StudentFS("FS002", "Lý Thị Uyên", 22, "ltu@student.edu.vn", 8.8, 52, 4));
        persons.add(new StudentFS("FS003", "Trịnh Văn Việt", 25, "tvv@student.edu.vn", 8.5, 48, 2));
        persons.add(new StudentFS("FS004", "Chu Thị Xuân", 24, "ctx@student.edu.vn", 9.0, 55, 5));

        // Nhóm học viên khá (>= 6.5 điểm)
        persons.add(new StudentFS("FS005", "Đinh Văn Yến", 23, "dvy@student.edu.vn", 7.9, 47, 2));
        persons.add(new StudentFS("FS006", "Phan Thị Anh", 26, "pta@student.edu.vn", 7.2, 44, 1));
        persons.add(new StudentFS("FS007", "Lương Văn Bình", 24, "lvb@student.edu.vn", 6.8, 41, 0));

        // Nhóm học viên trung bình (< 6.5 điểm)
        persons.add(new StudentFS("FS008", "Tô Thị Cúc", 25, "ttc@student.edu.vn", 6.5, 40, 1));
        persons.add(new StudentFS("FS009", "Võ Văn Đạt", 22, "vvd@student.edu.vn", 5.9, 35, 0));
        persons.add(new StudentFS("FS010", "Hồ Thị Nga", 27, "htn@student.edu.vn", 6.1, 38, 1));

        // ==================== TẠO TEACHING ASSISTANTS ====================
        System.out.println("👨‍🏫 Tạo danh sách Trợ giảng...");

        TeachingAssistant ta1 = new TeachingAssistant("TA001", "Nguyễn Thành An", 26, "nta@techzen.edu.vn", 20, 15);
        ta1.addLecture(lecturer1); // Hỗ trợ Dr. Nguyễn Văn An
        ta1.addLecture(lecturer2); // Hỗ trợ Prof. Trần Thị Bình

        TeachingAssistant ta2 = new TeachingAssistant("TA002", "Lê Minh Bảo", 25, "lmb@techzen.edu.vn", 18, 12);
        ta2.addLecture(lecturer2); // Hỗ trợ Prof. Trần Thị Bình
        ta2.addLecture(lecturer3); // Hỗ trợ Dr. Lê Minh Cường

        TeachingAssistant ta3 = new TeachingAssistant("TA003", "Phạm Thị Cẩm", 27, "ptc@techzen.edu.vn", 22, 18);
        ta3.addLecture(lecturer1); // Hỗ trợ Dr. Nguyễn Văn An
        ta3.addLecture(lecturer4); // Hỗ trợ MSc. Phạm Thị Dung
        ta3.addLecture(lecturer5); // Hỗ trợ Dr. Hoàng Văn Em

        TeachingAssistant ta4 = new TeachingAssistant("TA004", "Trần Văn Dũng", 24, "tvd@techzen.edu.vn", 15, 10);
        ta4.addLecture(lecturer3); // Chỉ hỗ trợ Dr. Lê Minh Cường

        persons.add(ta1);
        persons.add(ta2);
        persons.add(ta3);
        persons.add(ta4);

        // ==================== TẠO COURSES VÀ PHÂN LỚP ====================
        System.out.println("🏫 Tạo danh sách Khóa học và phân lớp...");

        // Khóa học 1: Java Backend
        Course course1 = new Course("C-001", "Java Backend Development");
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE001")); // Nguyễn Minh Anh
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE003")); // Lê Thị Cẩm
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE004")); // Phạm Minh Đức
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE006")); // Vũ Văn Nam
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE009")); // Bùi Thị Quỳnh
        courses.add(course1);

        // Khóa học 2: Python Backend
        Course course2 = new Course("C-002", "Python Backend Development");
        course2.setStudents((StudentBE) findPersonById("HVBE-00BE002")); // Trần Văn Bách
        course2.setStudents((StudentBE) findPersonById("HVBE-00BE005")); // Hoàng Thị Lan
        course2.setStudents((StudentBE) findPersonById("HVBE-00BE008")); // Ngô Văn Phong
        courses.add(course2);

        // Khóa học 3: Fullstack Web Development
        Course course3 = new Course("C-003", "Fullstack Web Development");
        course3.setStudents((StudentFS) findPersonById("HVFS-00FS001")); // Đỗ Minh Tuấn
        course3.setStudents((StudentFS) findPersonById("HVFS-00FS002")); // Lý Thị Uyên
        course3.setStudents((StudentFS) findPersonById("HVFS-00FS003")); // Trịnh Văn Việt
        course3.setStudents((StudentFS) findPersonById("HVFS-00FS004")); // Chu Thị Xuân
        course3.setStudents((StudentFS) findPersonById("HVFS-00FS005")); // Đinh Văn Yến
        courses.add(course3);

        // Khóa học 4: Advanced Fullstack
        Course course4 = new Course("C-004", "Advanced Fullstack Development");
        course4.setStudents((StudentFS) findPersonById("HVFS-00FS006")); // Phan Thị Anh
        course4.setStudents((StudentFS) findPersonById("HVFS-00FS007")); // Lương Văn Bình
        course4.setStudents((StudentFS) findPersonById("HVFS-00FS008")); // Tô Thị Cúc
        courses.add(course4);

        // Khóa học 5: Mobile Development (để test không có học viên)
        Course course5 = new Course("C-005", "Mobile App Development");
        courses.add(course5);

        // ==================== TẠO LỊCH GIẢNG DẠY ====================
        System.out.println("📅 Tạo lịch giảng dạy...");

        // Tháng 8/2025
        schedules.add(new Schedule(LocalDate.of(2025, 8, 12), "Giới thiệu Java OOP - Lớp Backend"));
        schedules.add(new Schedule(LocalDate.of(2025, 8, 13), "Database Design - Lớp Backend"));
        schedules.add(new Schedule(LocalDate.of(2025, 8, 14), "HTML/CSS Fundamentals - Lớp Fullstack"));
        schedules.add(new Schedule(LocalDate.of(2025, 8, 15), "JavaScript ES6+ - Lớp Fullstack"));
        schedules.add(new Schedule(LocalDate.of(2025, 8, 16), "Spring Boot Framework - Lớp Backend"));

        // Tháng 8/2025 - Thêm lịch trùng để test chức năng 17
        schedules.add(new Schedule(LocalDate.of(2025, 8, 13), "Python Flask Workshop - Lớp Python")); // TRÙNG NGÀY
        schedules.add(new Schedule(LocalDate.of(2025, 8, 15), "React.js Components - Lớp Fullstack")); // TRÙNG NGÀY

        // Tháng 9/2025
        schedules.add(new Schedule(LocalDate.of(2025, 9, 2), "Microservices Architecture"));
        schedules.add(new Schedule(LocalDate.of(2025, 9, 5), "Docker & Kubernetes"));
        schedules.add(new Schedule(LocalDate.of(2025, 9, 10), "CI/CD Pipeline Setup"));

        // ==================== TẠO DỮ LIỆU ĐỂ TEST EDGE CASES ====================
        System.out.println("⚠️ Tạo dữ liệu test các trường hợp đặc biệt...");

        // Thêm học viên có tên trùng để test chức năng 16
        persons.add(new StudentBE("BE011", "Nguyễn Minh Anh", 25, "nma2@student.edu.vn", 7.0, 40, "Java")); // TRÙNG TÊN
        persons.add(new StudentFS("FS011", "Lê Thị Cẩm", 24, "ltc2@student.edu.vn", 8.0, 45, 2)); // TRÙNG TÊN

        // Thêm vào cùng lớp để test duplicate trong class
        course1.setStudents((StudentBE) findPersonById("HVBE-00BE011")); // Thêm Nguyễn Minh Anh thứ 2 vào lớp Java Backend

        System.out.println("✅ Khởi tạo dữ liệu test hoàn tất!");
        System.out.println("📊 Thống kê dữ liệu test:");
        System.out.println("   👨‍🎓 Học viên BE: " + getList(StudentBE.class).size());
        System.out.println("   👩‍💻 Học viên FS: " + getList(StudentFS.class).size());
        System.out.println("   👨‍🏫 Giảng viên: " + getList(Lecturer.class).size());
        System.out.println("   👨‍💼 Trợ giảng: " + getList(TeachingAssistant.class).size());
        System.out.println("   🏫 Khóa học: " + courses.size());
        System.out.println("   📅 Lịch dạy: " + schedules.size());
        System.out.println("   ⚠️ Lịch trùng ngày: 2 ngày (13/08 và 15/08)");
        System.out.println("   ⚠️ Học viên trùng tên: 2 cặp");
        System.out.println();
    }

    // Helper method để tìm person theo ID
    private static Person findPersonById(String id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    private static void mainMenu() {


        System.out.println("===== Màn Hình =====");
        System.out.println("Hệ Thống Quản Lý Academy");
        System.out.println("1. Thêm thành viên");
        System.out.println("2. Hiển thị danh sách thành viên");
        System.out.println("3. Tìm kiếm thành viên theo tên hoặc email");
        System.out.println("4. Cập nhật thông tin cho thành viên");
        System.out.println("5. Xóa thành viên");
        System.out.println("6. Sắp xếp học viên theo điểm trung bình");
        System.out.println("7. Tính học phí của học viên");
        System.out.println("8. Tính  lương của  giảng viên");
        System.out.println("9. Tìm kếm giảng viên có bao nhiêu trợ giảng");
        System.out.println("10. Tạo lớp học");
        System.out.println("11. Thêm học viên vào lớp học");
        System.out.println("12. Học viên có điểm trung bình cao nhất trong lớp");
        System.out.println("13. Thêm buổi giảng mới");
        System.out.println("14. Xóa buổi giảng theo ngày");
        System.out.println("15. Hiển thị toàn bộ lịch");
        System.out.println("16. Kiểm tra học viên trùng tên");
        System.out.println("17. Kiểm tra lịch học trùng ngày");
        System.out.println("18. Tra cứu lớp học");
        System.out.println("19. Quản lý lịch giảng dạy");
        System.out.println("20. Thoát chương trình");
    }

    // 1 Quân
    private static void menuAdd() {
        System.out.println("===== Màn Hình =====");
        System.out.println("Thêm thành viên");
        System.out.println("1. Học viên BE");
        System.out.println("2. Học viên FS");
        System.out.println("3. Giảng viên");
        System.out.println("4. Trợ giảng");
        System.out.println("5. Thoát...");
    }

    private static void processAdd() throws NullOrEmptyException {
        int choice;

        while (true) {
            menuAdd();
            System.out.print("Bạn muốn thêm thành viên nào: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    StudentBE newStudentBE = new StudentBE();
                    addNewPerson(newStudentBE);
                    break;
                case 2:
                    StudentFS newStudentFS = new StudentFS();
                    addNewPerson(newStudentFS);
                    break;
                case 3:
                    Lecturer newLecturer = new Lecturer();
                    addNewPerson(newLecturer);
                    break;
                case 4:
                    TeachingAssistant newTeachingAssistant = new TeachingAssistant();
                    addNewPerson(newTeachingAssistant);
                    addLecturerForAssistant(newTeachingAssistant);
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
            }
        }
    }

    private static String getRandomIdentify() {
        int number = (int) (Math.random() * 1000);
        return String.format("%03d", number);
    }

    private static boolean checkIdentify(String id) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends Person> void addNewPerson(T person) throws NullOrEmptyException {
        do {
            person.setId(getRandomIdentify());
        } while (!checkIdentify(person.getId()));
        person.input();
        persons.add(person);
        System.out.println("Thêm thành viên mới thành công!\n");
    }

    private static void addLecturerForAssistant(TeachingAssistant teachingAssistant) {
        ArrayList<Lecturer> lecturers = getList(Lecturer.class);

        if (lecturers.isEmpty()) {
            System.out.println("Hiện tại chưa có giảng viên!\n");
            return;
        }

        while (!lecturers.isEmpty()) {
            System.out.println("Giảng viện hổ trợ: ");
            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                System.out.println((i + 1) + ". " + lecturer.getId() + ": " + lecturer.getFullName());
            }
            System.out.println((lecturers.size() + 1) + ". " + "Dừng chọn.");

            System.out.println("Chọn GV: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == lecturers.size() + 1) {
                break;
            }

            if (choice < 1 || choice > lecturers.size() + 1) {
                System.out.println("Lựa chọn không hợp lệ!\n");
                continue;
            }

            teachingAssistant.addLecture(lecturers.get(choice - 1));
            lecturers.remove(choice - 1);
        }
    }

    // 2 Quân
    private static void menuShowPerson() {
        System.out.println("===== Màn Hình =====");
        System.out.println("Hiển thị thành viên");
        System.out.println("1. Học viên BE");
        System.out.println("2. Học viên FS");
        System.out.println("3. Giảng viên");
        System.out.println("4. Trợ giảng");
        System.out.println("5. Tất cả");
        System.out.println("6. Thoát...");
    }

    private static void processShowPerson() {
        int choice;

        while (true) {
            menuShowPerson();

            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> displayList(getList(StudentBE.class));
                case 2 -> displayList(getList(StudentFS.class));
                case 3 -> displayList(getList(Lecturer.class));
                case 4 -> displayList(getList(TeachingAssistant.class));
                case 5 -> displayList(persons);
                case 6 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
            }
        }
    }

    private static <T extends Person> ArrayList<T> getList(Class<T> type) {
        ArrayList<T> list = new ArrayList<>();

        for (Person person : persons) {
            if (type.isInstance(person)) {
                list.add(type.cast(person));
            }
        }

        return list;
    }

    private static <T extends Person> void displayList(ArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Thông tin người thứ " + (i + 1));
            System.out.println(list.get(i));
        }
    }

    // 3 Như
    public static void findPerson() {
        System.out.print("Nhập từ khóa cần tìm (họ tên hoặc email): ");
        String keyword = sc.nextLine().trim().toLowerCase();

        ArrayList<Person> ketQua = new ArrayList<>();
        String kieuTimKiem = "";

        if (isValidEmail(keyword)) {
            for (Person p : persons) {
                if (p.getEmail().equalsIgnoreCase(keyword)) {
                    ketQua.add(p);
                }
            }
            kieuTimKiem = "email";
        } else if (isValidName(keyword)) {
            for (Person p : persons) {
                if (p.getFullName().toLowerCase().contains(keyword)) {
                    ketQua.add(p);
                }
            }
            kieuTimKiem = "tên";
        } else {
            System.out.println("Từ khóa không hợp lệ. Vui lòng nhập tên hoặc email đúng định dạng.\n");
            return;
        }

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy thành viên nào với " + kieuTimKiem + " \"" + keyword + "\"" + "\n");
        } else {
            System.out.println("Kết quả tìm kiếm theo " + kieuTimKiem + ":");
            displayList(ketQua);
        }
    }

    public static boolean isValidName(String keyword) {
        return keyword.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidEmail(String keyword) {
        return keyword.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$");
    }

    // 4 Như
    private static void menuUpdate() throws NullOrEmptyException {
        System.out.println("===== Màn Hình 2 =====");
        System.out.print("Nhập vào ID muốn cập nhật thông tin: ");
        String id = sc.nextLine().trim();

        boolean isFound = false;

        for (Person person : persons) {
            if (person.getId().equalsIgnoreCase(id)) {
                isFound = true;

                System.out.println("Chọn thông tin cần cập nhật:");
                System.out.println("1. Tên");
                System.out.println("2. Tuổi");
                System.out.println("3. Email");
                System.out.print("Lựa chọn của bạn (1-3): ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine().trim();
                        person.setFullName(newName);
                        System.out.println("Đã cập nhật tên thành công!");
                        break;
                    case 2:
                        System.out.print("Nhập tuổi mới: ");
                        try {
                            int newAge = Integer.parseInt(sc.nextLine().trim());
                            try {
                                person.setAge(newAge);
                            } catch (InvalidAgeException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Đã cập nhật tuổi thành công!");
                        } catch (NumberFormatException e) {
                            System.out.println("Tuổi không hợp lệ!");
                        }
                        break;
                    case 3:
                        System.out.print("Nhập email mới: ");
                        String newEmail = sc.nextLine().trim();
                        try {
                            person.setEmail(newEmail);
                        } catch (InvalidEmailException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Đã cập nhật email thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
                break;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy ID muốn cập nhật!");
        }
    }

    // 5 - như
    private static void menuDelete() {
        System.out.println("===== Màn Hình 2 =====\nXÓA THÔNG TIN THÀNH VIÊN");
        System.out.print("Nhập vào ID muốn xóa: ");
        String id = sc.nextLine().trim();

        Person personToDelete = null;

        for (Person person : persons) {
            if (person.getId().equalsIgnoreCase(id)) {
                personToDelete = person;
                break;
            }
        }

        if (personToDelete == null) {
            System.out.println("Không tìm thấy ID.");
            return;
        }

        if (personToDelete instanceof Lecturer) {
            for (Person p : persons) {
                if (p instanceof TeachingAssistant ta) {
                    ta.removeLecture((Lecturer) personToDelete);
                }
            }
        }
        persons.remove(personToDelete);

        System.out.println("Đã xóa thành viên thành công.");
    }

    // 6 Minh Sắp xếp danh sách theo điểm trung bình
    private static void menuSortByAVG() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 4 =====\nSẮP XẾP THEO ĐIỂM TRUNG BÌNH");
                System.out.println("1. Học viên backend");
                System.out.println("2. Học viên fullstack");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        sortAllStudentsUtil(StudentBE.class);
                        break;
                    case 2:
                        sortAllStudentsUtil(StudentFS.class);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static <T extends Student> void sortAllStudentsUtil(Class<T> type) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (Person person : persons) {
            if (type.isInstance(person)) {
                filteredList.add(type.cast(person));
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("Không có học viên nào !");
            return;
        }

        System.out.println("1. Tăng dần theo điểm trung bình");
        System.out.println("2. Giảm dần theo điểm trung bình");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(filteredList, true);
        } else if (choose == 2) {
            sortByFor(filteredList, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo điểm trung bình -----");
        int count = 1;
        for (T student : filteredList) {
            System.out.println("Học viên thứ " + count++);

            System.out.println("ID: " + student.getId());
            System.out.println("Tên: " + student.getFullName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Điểm trung bình: " + student.getAvgScore());
            System.out.println("Xếp loại: " + student.getClassify());
            System.out.println("----------------------------");
        }
    }

    private static <T extends Student> void sortByFor(ArrayList<T> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double avgI = list.get(i).getAvgScore();
                double avgJ = list.get(j).getAvgScore();

                boolean needSwap = ascending ? avgI > avgJ : avgI < avgJ;
                if (needSwap) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    // 7. Minh
    private static void tuitionStudent() {
        System.out.println("Bạn muốn tính học phí cho học viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        System.out.println("3. Tất cả");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1 -> System.out.println("Tong hoc phi backend" + totalTuition(StudentBE.class));
                case 2 -> System.out.println("Tong hoc phi Fullend" + totalTuition(StudentFS.class));
                case 3 -> System.out.println("Tong tat hoc phi " + totalTuition(Student.class));
                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 2.");
            }
        } while (choose < 1 || choose > 3);
    }

    private static <T extends Student> long totalTuition(Class<T> type) {
        long sum = 0;
        for (Person person : persons) {
            if (type.isInstance(person)) {
                T student = type.cast(person);
                sum += student.tuitionFee();
            }
        }
        return sum;
    }

    // 8. Thủy
    private static void calculateSalary() {
        System.out.println("Hãy lựa chọn: ");
        System.out.println("1. Giảng viên");
        System.out.println("2. Trợ giảng");
        System.out.print("Mời bạn nhập: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                double totalSalaryLecturer = 0;
                int count = 0;
                for (Person p : persons) {
                    if (p instanceof Lecturer lecturer) {
                        totalSalaryLecturer += lecturer.getSalary();
                        count++;
                    }
                }
                System.out.println("=> Số giảng viên: " + count);
                System.out.println("=> Tổng lương các giảng viên: " + String.format("%,.0f", totalSalaryLecturer) + " VND");

            } else if (choice == 2) {
                double totalSalaryTA = 0;
                int count = 0;
                for (Person p : persons) {
                    if (p instanceof TeachingAssistant ta) {
                        totalSalaryTA += ta.getSalary();
                        count++;
                    }
                }
                System.out.println("=> Số trợ giảng: " + count);
                System.out.println("=> Tổng lương các trợ giảng: " + String.format("%,.0f", totalSalaryTA) + " VND");

            } else {
                System.out.println("Lựa chọn không hợp lệ! Chỉ chọn 1 hoặc 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số nguyên!");
        }
    }

    // 9. Thủy
    private static void findSupportsOfTeacherByName() {
        sc.nextLine();
        System.out.print("Nhập id giảng viên cần tra cứu: ");
        String id = sc.nextLine().trim();

        Lecturer foundLecturer = null;

        // Tìm giảng viên theo ID
        for (Person p : persons) {
            if (p instanceof Lecturer && id.equals(p.getId())) {
                foundLecturer = (Lecturer) p;
                break;
            }
        }
        // Nếu không tìm thấy
        if (foundLecturer == null) {
            System.out.println("Không tìm thấy giảng viên với ID: " + id);
            return;
        }
        // Duyệt toàn bộ danh sách để tìm các trợ giảng hỗ trợ giảng viên này
        ArrayList<TeachingAssistant> teachingAssistants = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof TeachingAssistant ta) {
                for (Lecturer supported : ta.getLecturers()) {
                    if (supported.equals(foundLecturer)) {
                        teachingAssistants.add(ta);
                        break;
                    }
                }
            }
        }
        // In kết quả
        System.out.println("Giảng viên: \n" + foundLecturer);
        System.out.println("Số lượng trợ giảng hỗ trợ: " + teachingAssistants.size());

        if (teachingAssistants.isEmpty()) {
            System.out.println("Không có trợ giảng nào hỗ trợ giảng viên này.");
        } else {
            System.out.println("Danh sách trợ giảng:");
            for (TeachingAssistant ta : teachingAssistants) {
                System.out.println(" - " + ta);
            }
        }
    }

    // 10. Thêm khóa học - Như
    private static void addNewCourse() {
        Course newCourse = new Course();
        do {
            newCourse.setId(getRandomIdentify());
        } while (!checkIdentify(newCourse.getId()));
        newCourse.input();
        courses.add(newCourse);
        System.out.println("Thêm mới lớp học thành công!");
    }

    // 11. Thêm học viên vào lớp học - Như
    public static void addStudentToClass() {
        ArrayList<Student> students = getList(Student.class);
        if (courses.isEmpty()) {
            System.out.println("Hiện chưa có lớp học nào.");
            return;
        }

        System.out.println("=== DANH SÁCH LỚP HỌC ===");
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d. %s - %s\n", i + 1, courses.get(i).getId(), courses.get(i).getName());
        }

        int choice;
        while (true) {
            try {
                System.out.print("Chọn lớp học để thêm học viên: ");
                choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > courses.size()) {
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        Course selectedCourse = courses.get(choice - 1);

        // học viên chưa có lớp
        ArrayList<Student> studentInAllClasses = new ArrayList<>();
        for (Student s : selectedCourse.getStudents()) {
            studentInAllClasses.add(s);
        }
        // studentInAllClasses.addAll(selectedCourse.getStudents());

        ArrayList<Student> studentsNotInClass = new ArrayList<>();
        for (Student s : students) {
            if (!studentInAllClasses.contains(s)) {
                studentsNotInClass.add(s);
            }
        }

        if (studentsNotInClass.isEmpty()) {
            System.out.println("Tất cả học viên đã có lớp.");
            return;
        }

        while (true) {
            System.out.println("=== DANH SÁCH HỌC VIÊN CHƯA VÀO LỚP ===");
            for (int i = 0; i < studentsNotInClass.size(); i++) {
                System.out.printf("%d. %s - %s\n", i + 1, studentsNotInClass.get(i).getId(), studentsNotInClass.get(i).getFullName());
            }

            System.out.print("Chọn học viên để thêm: ");
            int studentChoice = Integer.parseInt(sc.nextLine());
            if (studentChoice < 1 || studentChoice > studentsNotInClass.size()) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }

            Student selectedStudent = studentsNotInClass.get(studentChoice - 1);
            selectedCourse.setStudents(selectedStudent);
            studentsNotInClass.remove(selectedStudent);
            System.out.printf("Đã thêm học viên %s vào lớp %s.\n", selectedStudent.getFullName(), selectedCourse.getName());
            System.out.println("Muốn tiếp tục chọn hay không ? (Y/N)");
            String choose = sc.nextLine();
            if (choose.equalsIgnoreCase("Y")) {
                continue;
            }
            System.out.println("Hoàn thành thêm học viên.");
            break;
        }
    }

    // 12. Tìm học viên điểm cao nhất - Quân
    private static void findStudentMaxScore() {
        if (courses.isEmpty()) {
            System.out.println("Hiện tại chưa có lớp học!");
            return;
        }

        System.out.println("===== DANH SÁCH LỚP HỌC =====");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getId() + " - " + courses.get(i).getName());
        }

        ArrayList<Student> students;
        while (true) {
            try {
                System.out.print("Chọn lớp: ");
                int choiceCourse = Integer.parseInt(sc.nextLine());

                if (choiceCourse < 0 || choiceCourse > courses.size()) {
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
                }

                students = courses.get(choiceCourse - 1).getStudents();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên!");
            }
        }

        if (students.isEmpty()) {
            System.out.println("Hiện tại lớp chưa có học viên nào!");
            return;
        }

        ArrayList<Student> listMaxScore = new ArrayList<>();
        double max = students.get(0).getAvgScore();
        for (Student student : students) {
            if (student.getAvgScore() > max) {
                max = student.getAvgScore();
                listMaxScore.clear();
                listMaxScore.add(student);
            } else if (student.getAvgScore() == max) {
                listMaxScore.add(student);
            }
        }

        System.out.println("Danh sách sinh viên có điểm cao nhất trong lớp: ");
        displayList(listMaxScore);
    }

    // 13. Thêm buổi giảng dạy - Thủy
    private static void addSchedule() {
        Schedule newSchedule = new Schedule();
        newSchedule.input();
        System.out.print("Nhập ID giảng viên phụ trách: ");
        String lecturerId = sc.nextLine();
        Lecturer assignedLecturer = findLecturerById(lecturerId);
        if (assignedLecturer != null) {
            manage.put(newSchedule, assignedLecturer);
            System.out.println("Thêm lịch giảng thành công!");
        } else {
            System.out.println("Không tìm thấy giảng viên với ID này.");
        }

    }

    //14. Xóa lịch dạy - Minh
    private static void deleteSchedule() {
        LocalDate dateToDelete = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String keyword;

        while (true) {
            System.out.println("Nhập ngày-tháng-năm cần xóa (dd/MM/yyyy):");
            keyword = sc.nextLine().trim();
            try {
                dateToDelete = LocalDate.parse(keyword, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày nhập không hợp lệ! Vui lòng nhập lại.\n");
            }
        }

        boolean found = false;
        for (Schedule s : schedules) {
            if (s.getDay() != null && s.getDay().equals(dateToDelete)) {
                schedules.remove(s);
                found = true;
            }
        }
        if (found) {
            System.out.println("Đã xóa lịch có ngày " + keyword);
        } else {
            System.out.println("Không tìm thấy lịch có ngày " + keyword);
        }
//        Iterator<Schedule> i = schedules.iterator();
//        boolean found = false;
//
//
//        while (i.hasNext()) {
//            Schedule s = i.next();
//            if (s.getDay() != null && s.getDay().equals(dateToDelete)) {
//                i.remove();
//                found = true;
//            }
//        }

//        if (found) {
//            System.out.println("Đã xóa lịch có ngày " + keyword);
//        } else {
//            System.out.println("Không tìm thấy lịch có ngày " + keyword);
//        }
    }

    //15. Hiển thị lịch dạy - Minh
    private static void displaySchedule() {
        if (manage.isEmpty()) {
            System.out.println("Chưa có lịch giảng nào.");
        } else {
            System.out.println("\n=== DANH SÁCH LỊCH GIẢNG ===");
            int count = 1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Map.Entry<Schedule, Lecturer> entry : manage.entrySet()) {
                Schedule schedule = entry.getKey();
                Lecturer lecturer = entry.getValue();

                System.out.println("Lịch thứ " + count++ + ":");
                System.out.println("  Ngày: " + schedule.getDay().format(formatter));
                System.out.println("  Nội dung: " + schedule.getContent());
                System.out.println("  Giảng viên: " + lecturer.getFullName() + " (" + lecturer.getId() + ")");
                System.out.println("-------------------");
            }
        }
    }

    //add to class
    // 16. Kiểm tra lớp học có đảm bảo không có học viên trùng
    private static void checkClassHasDuplicateStudent() {
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Person p : persons) {
            if (p instanceof Student) {
                if (!uniqueNames.add(p.getFullName())) {
                    duplicates.add(p.getFullName());
                }
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("Không có danh sách trùng!");
        } else {
            System.out.println("Tên bị trùng: " + duplicates);
        }
    }

    //17
    private static void checkClassHasDuplicateSchedule() {
        Set<LocalDate> uniqueDay = new HashSet<>();
        Set<LocalDate> duplicates = new HashSet<>();

        for (Schedule p : schedules) {
            LocalDate day = p.getDay();
            if (day != null) {
                // Nếu add trả về false nghĩa là đã tồn tại trong uniqueDay → trùng
                if (!uniqueDay.add(day)) {
                    duplicates.add(day);
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (duplicates.isEmpty()) {
            System.out.println("Không có ngày trùng trong lịch!");
        } else {
            System.out.print("Các ngày bị trùng: ");
            for (LocalDate d : duplicates) {
                System.out.print(d.format(formatter) + "  ");
            }
            System.out.println();
        }
    }

    //18
    private static void lookUpClass() {
        HashMap<String, Course> courseMap = new HashMap<>();
        for (Course c : courses) {
            courseMap.put(c.getId().toLowerCase(), c); // Lưu key là lowercase
        }

        System.out.print("Nhập mã lớp: ");
        String searchId = sc.nextLine().trim().toLowerCase(); // Convert input to lowercase

        Course foundCourse = courseMap.get(searchId);
        if (foundCourse != null) {
            System.out.println("Tìm thấy lớp:");
            System.out.println(foundCourse);
        } else {
            System.out.println("Không tìm thấy lớp có mã: " + searchId.toUpperCase());
        }


//        System.out.println("\nDanh sách tất cả các lớp:");
//        for (Map.Entry<String, ArrayList<Student>> entry : courseMap.entrySet()) {
//            System.out.println("Mã lớp: " + entry.getKey());
//            System.out.println("Danh sách sinh viên:");
//            for (Student s : entry.getValue()) {
//                if (s != null) {
//                    System.out.println(" - " + s);
//                }
//            }
//            System.out.println("-------------------------");
//        }
    }


    //19
    private static void manageTeachingSchedule() {


        while (true) {
            System.out.println("\n=== QUẢN LÝ LỊCH GIẢNG DẠY ===");
            System.out.println("1. Thêm lịch giảng mới");
            System.out.println("2. Hiển thị toàn bộ lịch và giảng viên");
            System.out.println("3. Tìm lịch dạy của giảng viên");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addSchedule();
                    break;
                case 2:
                    displaySchedule();
                    break;
                case 3:
                    ArrayList<Lecturer> lecturers = getList(Lecturer.class);

                    if (lecturers.isEmpty()) {
                        System.out.println("Hiện tại chưa có giảng viên nào!");
                        break;
                    }

                    // Hiển thị danh sách giảng viên để chọn
                    System.out.println("===== DANH SÁCH GIẢNG VIÊN =====");
                    for (int i = 0; i < lecturers.size(); i++) {
                        Lecturer lecturer = lecturers.get(i);
                        System.out.println((i + 1) + ". " + lecturer.getId() + " - " + lecturer.getFullName() + " (" + lecturer.getSubject() + ")");
                    }

                    // Cho user chọn giảng viên
                    Lecturer selectedLecturer = null;
                    while (true) {
                        try {
                            System.out.print("Chọn giảng viên: ");
                            int choiceLecturer = Integer.parseInt(sc.nextLine());

                            if (choiceLecturer < 1 || choiceLecturer > lecturers.size()) {
                                System.out.println("Lựa chọn không hợp lệ!");
                                continue;
                            }

                            selectedLecturer = lecturers.get(choiceLecturer - 1);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập một số nguyên!");
                        }
                    }

                    // Tìm và hiển thị tất cả lịch dạy của giảng viên được chọn
                    System.out.println("\n=== LỊCH DẠY CỦA GIẢNG VIÊN: " + selectedLecturer.getFullName() + " ===");

                    boolean foundSchedule = false;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    int scheduleCount = 1;

                    for (Map.Entry<Schedule, Lecturer> entry : manage.entrySet()) {
                        Lecturer lecturer = entry.getValue();

                        if (lecturer.getId().equals(selectedLecturer.getId())) {
                            Schedule schedule = entry.getKey();
                            System.out.println("Buổi dạy thứ " + scheduleCount++ + ":");
                            System.out.println("  Ngày: " + schedule.getDay().format(formatter));
                            System.out.println("  Nội dung: " + schedule.getContent());
                            System.out.println("  Giảng viên: " + lecturer.getFullName() + " - " + lecturer.getSubject());
                            System.out.println("-------------------");
                            foundSchedule = true;
                        }
                    }

                    if (!foundSchedule) {
                        System.out.println("Giảng viên " + selectedLecturer.getFullName() + " chưa có lịch dạy nào.");
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình quản lý lịch giảng.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static Lecturer findLecturerById(String id) {
        for (Person p : persons) {
            if (p instanceof Lecturer lecturer && lecturer.getId().equalsIgnoreCase(id)) {
                return lecturer;
            }
        }
        return null;
    }


    private static void exit() {
        System.out.println("Xác nhận thoát (Y/N)");
        String confirm = sc.nextLine().trim().toLowerCase();
        if (confirm.equalsIgnoreCase("y")) {
            System.exit(0);
        }
    }


    public static void main(String[] args) throws NullOrEmptyException {
        initializeSampleData();
        int choice;
        while (true) {
            mainMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> processAdd();
                case 2 -> processShowPerson();
                case 3 -> findPerson();
                case 4 -> menuUpdate();
                case 5 -> menuDelete();
                case 6 -> menuSortByAVG();
                case 7 -> tuitionStudent();
                case 8 -> calculateSalary();
                case 9 -> findSupportsOfTeacherByName();
                case 10 -> addNewCourse();
                case 11 -> addStudentToClass();
                case 12 -> findStudentMaxScore();
                case 13 -> addSchedule();
                case 14 -> deleteSchedule();
                case 15 -> displaySchedule();
                case 16 -> checkClassHasDuplicateStudent();
                case 17 -> checkClassHasDuplicateSchedule();
                case 18 -> lookUpClass();
                case 19 -> manageTeachingSchedule();
                case 20 -> exit();
                default -> System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
            }
        }
    }
}
