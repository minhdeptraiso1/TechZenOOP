package ss5_polymorphism.employee_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    /// Đặt break point debug ở đầu các method:
    /// menuAddNew() -> khi add nhân viên quản lý & add nhân viên sản xuất
    /// menuShowList() -> case 1 & case 3

    /*
    Chương trình quản lý nhân viên của 1 công ty
        + Nhân viên quản lý:
            - Mã (QLYYY, với Y là 1 số => phải tự động tăng)
            - Họ tên
            - Ngày sinh
            - Địa chỉ
            - Lương cơ bản
            - Hệ số lương
        + Nhân viên sản xuất:
            - Mã (QLYYY, với Y là 1 số => phải tự động tăng)
            - Họ tên
            - Ngày sinh
            - Địa chỉ
            - Số sản phẩm



    CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN
        1. Thêm mới
            1.1. Nhân viên quản lý
            1.2. Nhân viên sản xuất
            1.3. Trở về menu chính
        2. Cập nhật thông tin
        3. Xem danh sách
            3.1. Nhân viên quản lý
            3.2. Nhân viên sản xuất
            3.3. Tất cả nhân viên
            3.4. Trở về menu chính
        4. Sắp xếp theo lương
            4.1. Nhân viên quản lý
                - Tăng dần
                - Giảm dần
            4.2. Nhân viên sản xuất
                - Tăng dần
                - Giảm dần
            4.3. Tất cả nhân viên
                - Tăng dần
                - Giảm dần
            4.4. Trở về menu chính
        5. Thoát
     */


    static Scanner sc = new Scanner(System.in);

//    static ArrayList<ManagementEmployee> managementEmployees = new ArrayList<>();
//    static ArrayList<ProductionEmployee> productionEmployees = new ArrayList<>();

    static ArrayList<Person> employees = new ArrayList<>();

    public static void main(String[] args) {
        int choose;

        /// Tại sao dùng while (true) & làm sao dừng được nó
        while (true) {
            do {
                System.out.println("===== Màn Hình Menu Chính =====\nCHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN");
                System.out.println("1. Thêm mới");
                System.out.println("2. Cập nhật thông tin");
                System.out.println("3. Xem danh sách");
                System.out.println("4. Sắp xếp theo lương");
                System.out.println("5. Thoát");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        menuAddNew();
                        break;
                    case 2:
                        menuUpdate();
                        break;
                    case 3:
                        menuShowList();
                        break;
                    case 4:
                        menuSortBySalary();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                        break;
                }
            } while (choose < 1 || choose > 4);
        }
    }


    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 1 =====\nTHÊM MỚI NHÂN VIÊN");
                System.out.println("1. Nhân viên quản lý");
                System.out.println("2. Nhân viên sản xuất");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        ManagementEmployee managementEmployee = new ManagementEmployee();
                        managementEmployee.input();
                        managementEmployee.setId(getIdManagement());
                        employees.add(managementEmployee);
                        System.out.println("Thêm nhân viên quản lý mới thành công");
                        break;
                    case 2:
                        ProductionEmployee productionEmployee = new ProductionEmployee();
                        productionEmployee.input();
                        productionEmployee.setId(getIdProduction());
                        employees.add(productionEmployee);
                        System.out.println("Thêm nhân viên sản xuất mới thành công");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static ArrayList<ManagementEmployee> getManagementEmployee() {
        ArrayList<ManagementEmployee> managementEmployees = new ArrayList<>();
        for (Person employee : employees) {
            if (employee instanceof ManagementEmployee) {
                managementEmployees.add((ManagementEmployee) employee);
            }
        }

        return managementEmployees;
    }

    private static ArrayList<ProductionEmployee> getProductionEmployee() {
        ArrayList<ProductionEmployee> productionEmployees = new ArrayList<>();
        for (Person employee : employees) {
            if (employee instanceof ProductionEmployee) {
                productionEmployees.add((ProductionEmployee) employee);
            }
        }

        return productionEmployees;
    }

    private static String getIdManagement() {
        ArrayList<ManagementEmployee> managementEmployees = getManagementEmployee();

        if (managementEmployees.isEmpty()) return "QL001";

        int max = Integer.parseInt(managementEmployees.getFirst().getId().substring(2));

        for (ManagementEmployee managementEmployee : managementEmployees) {
            int id = Integer.parseInt(managementEmployee.getId().substring(2));
            if (max < id) {
                max = id;
            }
        }

        return String.format("QL%3d", max + 1).replace(" ", "0");
    }

    private static String getIdProduction() {
        ArrayList<ProductionEmployee> productionEmployees = getProductionEmployee();

        if (productionEmployees.isEmpty()) return "SX001";

        int max = Integer.parseInt(productionEmployees.getFirst().getId().substring(2));

        for (ProductionEmployee productionEmployee : productionEmployees) {
            int id = Integer.parseInt(productionEmployee.getId().substring(2));
            if (max < id) {
                max = id;
            }
        }

        return String.format("SX%3d", max + 1).replace(" ", "0");
    }

    private static void menuUpdate() {
        System.out.println("===== Màn Hình 2 =====\nCẬP NHẬT THÔNG TIN NHÂN VIÊN");
        System.out.println("Nhập vào ID muốn cập nhật thông tin");
        String id = sc.nextLine();

        if (id.startsWith("QL")) {
            System.out.println("Da tim thay nhan vien voi id :" + id);
            boolean isExistEmployee = false;
            for (Person employee : employees) {
                if (employee instanceof ManagementEmployee && employee.getId().equals(id)) {
                    isExistEmployee = true;
                    employee.input();
                    System.out.println("Cập nhật thành công");
                    break;
                }
            }

            if (!isExistEmployee) {
                System.out.println("Không tìm thấy ID muốn cập nhật!");
            }
        } else if (id.startsWith("SX")) {
            System.out.println("Da tim thay nhan vien voi id :" + id);
            updateEmployeeById(id, ProductionEmployee.class);
        } else {
            System.out.println("ID không hợp lệ!");
        }
    }

    private static void menuShowList() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 3 =====\nDANH SÁCH NHÂN VIÊN");
                System.out.println("1. Nhân viên quản lý");
                System.out.println("2. Nhân viên sản xuất");
                System.out.println("3. Tất cả nhân viên");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
//                        int count = 1;
//                        for (Employee employee : employees) {
//                            if (employee instanceof ManagementEmployee) {
//                                System.out.println("Thông tin nhân viên thứ " + count++);
//                                employee.output();
//                            }
//                        }
                        printList(employees, ManagementEmployee.class);
                        break;
                    case 2:
                        // logic show danh sách nhân viên sản xuất
                        for (Person e : employees) {
                            if (e instanceof ProductionEmployee x) {
                                x.output();
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < employees.size(); i++) {
                            System.out.println("Thông tin nhân viên thứ " + (i + 1));
                            employees.get(i).output();
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSortBySalary() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 4 =====\nSẮP XẾP THEO LƯƠNG");
                System.out.println("1. Nhân viên quản lý");
                System.out.println("2. Nhân viên sản xuất");
                System.out.println("3. Tất cả nhân viên");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        // logic sắp xếp theo lương cho nhân viên quản lý
                        //sortAllEmployeesManager();
                        //util
                        sortAllEmployeesUtil2(ManagementEmployee.class, employees);
                        break;
                    case 2:
                        // logic sắp xếp theo lương cho nhân viên sản xuất
                        // sortAllEmployeesProduct();
                        //util
                        sortAllEmployeesUtil(ProductionEmployee.class, employees);
                        break;
                    case 3:
                        //sortAllEmployees();
                        //util
                        sortAllEmployeesUtil(Person.class, employees);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void sortAllEmployeesManager() {
        ArrayList<Person> x = new ArrayList<>();
        for (Person e : employees) {
            if (e instanceof ManagementEmployee me) {
                x.add(me);
            }
        }

        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(x, true);
//            employees.sort((a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        } else if (choose == 2) {
            sortByFor(x, false);
//            employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        int count = 1;
        for (Person employee : x) {
            System.out.println("Thông tin nhân viên thứ " + count++);
            employee.output();
            System.out.println("Lương: " + employee.getSalary());
            System.out.println();
        }
    }

    private static void sortAllEmployeesProduct() {
        ArrayList<Person> x = new ArrayList<>();
        for (Person e : employees) {
            if (e instanceof ProductionEmployee me) {
                x.add(me);
            }
        }

        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(x, true);
//            employees.sort((a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        } else if (choose == 2) {
            sortByFor(x, false);
//            employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        int count = 1;
        for (Person employee : x) {
            System.out.println("Thông tin nhân viên thứ " + count++);
            employee.output();
            System.out.println("Lương: " + employee.getSalary());
            System.out.println();
        }
    }


    private static void sortAllEmployees() {
        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(employees, true);
//            employees.sort((a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        } else if (choose == 2) {
            sortByFor(employees, false);
//            employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        int count = 1;
        for (Person employee : employees) {
            System.out.println("Thông tin nhân viên thứ " + count++);
            employee.output();
            System.out.println("Lương: " + employee.getSalary());
            System.out.println();
        }
    }


    //sort list util1
    private static <q extends Person> void sortAllEmployeesUtil(Class<q> clazz, ArrayList<Person> employees) {
        ArrayList<Person> arraylistTemp;

        if (clazz == Person.class) {
            arraylistTemp = new ArrayList<>(employees);
        } else {
            // Nếu là class con thì lọc theo class con
            arraylistTemp = new ArrayList<>();
            for (Person e : employees) {
                if (clazz.isInstance(e)) {
                    arraylistTemp.add(e);
                }
            }
        }
        if (arraylistTemp.isEmpty()) {
            System.out.println("Không có nhân viên nào !");
            return;
        }


        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(arraylistTemp, true);
        } else if (choose == 2) {
            sortByFor(arraylistTemp, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        int count = 1;
        for (Person employee : arraylistTemp) {
            System.out.println("Thông tin nhân viên thứ " + count++);
            employee.output();
            System.out.println("Lương: " + employee.getSalary());
            System.out.println();
        }
    }

    //sort list util2
    private static <T extends Person> void sortList(List<T> employeeList) {
        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(employeeList, true);
        } else if (choose == 2) {
            sortByFor(employeeList, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        int count = 1;
        for (T employee : employeeList) {
            System.out.println("Thông tin nhân viên thứ " + count++);
            employee.output();
            System.out.println("Lương: " + employee.getSalary());
            System.out.println();
        }
    }

    //sort list util3
    private static <q extends Person> void sortAllEmployeesUtil2(Class<q> clazz, ArrayList<Person> employees) {
        ArrayList<Person> arraylistTemp;

        if (clazz == Person.class) {
            arraylistTemp = new ArrayList<>(employees);
        } else {
            // Nếu là class con thì lọc theo class con
            arraylistTemp = new ArrayList<>();
            for (Person e : employees) {
                if (clazz.isInstance(e)) {
                    arraylistTemp.add(e);
                }
            }
        }
        if (arraylistTemp.isEmpty()) {
            System.out.println("Không có nhân viên nào !");
            return;
        }


        System.out.println("1. Tăng dần theo lương");
        System.out.println("2. Giảm dần theo lương");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(arraylistTemp, true);
        } else if (choose == 2) {
            sortByFor(arraylistTemp, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo lương -----");
        printList(arraylistTemp, clazz);
    }

    private static <T extends Person> void sortByFor(List<T> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double salaryI = list.get(i).getSalary();
                double salaryJ = list.get(j).getSalary();

                boolean needSwap = ascending
                        ? salaryI > salaryJ
                        : salaryI < salaryJ;
                if (needSwap) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    //in ra
    private static <T extends Person> void printList(List<T> list, Class<?> clazz) {
        int count = 1;
        for (T l : list) {
            if (clazz.isInstance(l)) {
                System.out.println("Nhan vien thu " + count);
                l.output();
                count++;
            }
        }
    }

    //update
    private static <T extends Person> void updateEmployeeById(String id, Class<T> clazz) {
        boolean found = false;

        for (Person e : employees) {
            if (clazz.isInstance(e) && e.getId().equals(id)) {
                System.out.println("Nhập thông tin mới cho nhân viên:" + e.getId());
                e.input();
                System.out.println("✅ Cập nhật thành công!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + id);
        }
    }

    //update2
    private static void updateEmployeeById2(String id) {
        Class<? extends Person> clazz = getClassFromIdPrefix(id);

        if (clazz == null) {
            System.out.println("❌ Mã ID không hợp lệ hoặc không xác định được loại nhân viên!");
            return;
        }

        boolean found = false;
        for (Person e : employees) {
            if (clazz.isInstance(e) && e.getId().equals(id)) {
                System.out.println("Nhập thông tin mới cho nhân viên: " + e.getId());
                e.input();
                System.out.println("✅ Cập nhật thành công!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + id);
        }
    }

    private static Class<? extends Person> getClassFromIdPrefix(String id) {
        if (id.startsWith("QL")) {
            return ManagementEmployee.class;
        } else if (id.startsWith("KT")) {
            return ProductionEmployee.class;
        } else {
            return null;
        }
    }


    //add
    private static <T extends Person> void addEmployee(Class<T> clazz, String prefix) {
        try {
            // Khởi tạo object mới bằng reflection
            T newMember = clazz.getDeclaredConstructor().newInstance();//getDeclaredContructor phai co trong truy vi khoi tao contructer rong nhung ko ton tai se loi

            // Nhập thông tin và gán ID
            newMember.input();
            newMember.setId(getIdentityId(prefix, clazz));

            employees.add(newMember);
            System.out.println("✅ Thêm nhân viên mới thành công!");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi tạo đối tượng: " + e.getMessage());
        }
    }

    //get id
    private static String getIdentityId(String prefix, Class<?> clazz) {
        int max = 0;

        for (Person e : employees) {
            if (clazz.isInstance(e)) {
                String idStr = e.getId().substring(prefix.length());
                int id = Integer.parseInt(idStr);
                if (id > max) {
                    max = id;
                }
            }
        }

        return String.format("%s%03d", prefix, max + 1);

    }

    //lay danh sach con trong list chung
    private static <T extends Person> ArrayList<T> filterEmployee(Class<T> type) { // type = ManagementEmployee.class
        ArrayList<T> result = new ArrayList<>();
        for (Person employee : employees) {
            if (type.isInstance(employee)) {
                result.add(type.cast(employee));
            }
        }
        return result;
    }

}

