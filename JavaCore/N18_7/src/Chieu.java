import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
//đề bai : thông tin của nhân viên bao gồm họ teen ,tuổi ,giới tính,mức lương cơ bản
//điểm trung bình tốt nghiệp đại học (theo thang điểm 10) mỗi thông tin sẽ dc lưu trong 1 arrayslist riêng
public class Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên");
        int numberOfEmployees = sc.nextInt();//số lượng nhân viên
        sc.nextLine();
        ArrayList<String> name = new ArrayList<>();//tên
        ArrayList<Integer> age = new ArrayList<>();//tuổi
        ArrayList<String> sex = new ArrayList<>();//giới tính
        ArrayList<Integer> wage = new ArrayList<>();//lương
        ArrayList<Integer> gradePoint = new ArrayList<>();//điểm trung bình đại học

        //Thêm thông tin nhân viên
        importArrayList(numberOfEmployees,sc,name,age,sex,wage,gradePoint);
        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);

//        //sap xep theo tuoi
//        sortEmplyeesByWage(name,age,sex,wage,gradePoint);
//        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);
//
//        //in ra 2 nhan vien diem cao nhat
//        findEmployeesByHighestGradePoint12(name,age,sex,wage,gradePoint);
//
//        //tim theo ten
//        findEmployeesByName(sc,name,age,sex,wage,gradePoint);
//
//        //Thêm 1 nhân viên mới
//        addEmployees(sc,name,age,sex,wage,gradePoint);
//        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);
//
//        //tìm kiếm theo vị trí
//        findEmployeesById(sc,name,age,sex,wage,gradePoint);
//        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);
//
//        //xóa nhân viên theo vị trí
//        deleteEmployeesById(sc,name,age,sex,wage,gradePoint);
//        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);
//
//        //đổi vị trí của nhân viên thứ i với nhân viên thứ j
//        swapEmplyeesById(sc,name,age,sex,wage,gradePoint);
//        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);

        //Cập nhật nhân viên tìm kiếm theo từ khóa là tên
        updateEmplyeesByName(sc,name,age,sex,wage,gradePoint);
        printArrayList(name.size(),sc,name,age,sex,wage,gradePoint);
    }
    public static void importArrayList(int n, Scanner sc , ArrayList<String> name , ArrayList<Integer>age
                                        , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ "+(i+1)+":");
            System.out.print("Nhập họ và tên: ");
            name.add(sc.nextLine());
            System.out.print("Nhập tuổi: ");
            age.add(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            sex.add(sc.nextLine());
            System.out.print("Nhập mức lương: ");
            wage.add(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập điểm trung bình đại học (hệ số 10): ");
            gradePoint.add(sc.nextInt());
            sc.nextLine();
        }
    }
    public static void printArrayList(int n,Scanner sc , ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("\n== Danh sách nhân viên ==");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhân viên " + (i + 1) + ":");
            System.out.println("Họ và tên: " + name.get(i));
            System.out.println("Tuổi: " + age.get(i));
            System.out.println("Giới tính: " + sex.get(i));
            System.out.println("Mức lương: " + wage.get(i));
            System.out.println("Điểm trung bình: " + gradePoint.get(i));
            System.out.println("-----------------------------");
        }
    }
    public static void addEmployees(Scanner sc , ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập thông tin cho nhân viên mới");
        System.out.print("Nhập họ và tên: ");
        name.add(sc.nextLine());
        System.out.print("Nhập tuổi: ");
        age.add(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập giới tính (Nam/Nữ): ");
        sex.add(sc.nextLine());
        System.out.print("Nhập mức lương: ");
        wage.add(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập điểm trung bình đại học (hệ số 10): ");
        gradePoint.add(sc.nextInt());
        sc.nextLine();
    }
    public static void findEmployeesById(Scanner sc , ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập Id nhân viên cần tìm!");
        int findEmployees = sc.nextInt();
        sc.nextLine();
        System.out.println("đã tìm thấy nhân viên có thông tin là");
        System.out.println("Nhân viên " + (findEmployees + 1) + ":");
        System.out.println("Họ và tên: " + name.get(findEmployees));
        System.out.println("Tuổi: " + age.get(findEmployees));
        System.out.println("Giới tính: " + sex.get(findEmployees));
        System.out.println("Mức lương: " + wage.get(findEmployees));
        System.out.println("Điểm trung bình: " + gradePoint.get(findEmployees));
        System.out.println("-----------------------------");

    }
    public static void findEmployeesByName(Scanner sc , ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập Tên nhân viên cần tìm!");
        String findEmployees = sc.nextLine();
        for(int i = 0 ; i < name.size() ; i++){
            if(name.get(i).equals(findEmployees)){
                System.out.println("Nhân viên " + (i + 1) + ":");
                System.out.println("Họ và tên: " + name.get(i));
                System.out.println("Tuổi: " + age.get(i));
                System.out.println("Giới tính: " + sex.get(i));
                System.out.println("Mức lương: " + wage.get(i));
                System.out.println("Điểm trung bình: " + gradePoint.get(i));
                System.out.println("-----------------------------");
            }
            else {
                System.out.println("Không tim thấy nhân viên nào tên :"+findEmployees);
            }
        }


    }

    public static void deleteEmployeesById(Scanner sc , ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập Id nhân viên cần xóa!");
        int deleteEmployees = sc.nextInt();
        sc.nextLine();
        int delete = deleteEmployees - 1;
        System.out.println("đã xóa nhân viên có thông tin là");
        System.out.println("Nhân viên " + (deleteEmployees + 1) + ":");
        System.out.println("Họ và tên: " + name.get(deleteEmployees));
        System.out.println("Tuổi: " + age.get(deleteEmployees));
        System.out.println("Giới tính: " + sex.get(deleteEmployees));
        System.out.println("Mức lương: " + wage.get(deleteEmployees));
        System.out.println("Điểm trung bình: " + gradePoint.get(deleteEmployees));
        System.out.println("-----------------------------");
        name.remove(delete );
        age.remove(delete);
        sex.remove(delete);
        wage.remove(delete);
        gradePoint.remove(delete);
    }
    public static void findEmployeesByHighestGradePoint12( ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint) {
        //tạo mảng mới giống mảng dùng để sắp xếp
        ArrayList<Integer> gradePointCopy = new ArrayList<>(gradePoint);
        Collections.sort(gradePointCopy);
        //tạo hai biến lưu giá trị sau sắp xếp
        int max1 = gradePointCopy.get(gradePointCopy.size() - 1);      // điểm cao nhất
        int max2 = gradePointCopy.get(gradePointCopy.size() - 2);      // điểm cao thứ 2
        //tìm vị trí của nó trong mảng chính (trường hợp điểm phải không trùng nhau)
        System.out.println("--- Nhân viên có điểm trung bình cao nhất ---");
        for (int i = 0; i < gradePoint.size(); i++) {
            if (gradePoint.get(i).equals(max1)) {
                System.out.println("Nhân viên " + (i + 1) + ":");
                System.out.println("Họ và tên: " + name.get(i));
                System.out.println("Tuổi: " + age.get(i));
                System.out.println("Giới tính: " + sex.get(i));
                System.out.println("Mức lương: " + wage.get(i));
                System.out.println("Điểm trung bình: " + gradePoint.get(i));
                System.out.println("-----------------------------");
            }
        }

        System.out.println("--- Nhân viên có điểm trung bình cao thứ hai ---");
        for (int i = 0; i < gradePoint.size(); i++) {
            if (gradePoint.get(i).equals(max2)) {
                System.out.println("Nhân viên " + (i + 1) + ":");
                System.out.println("Họ và tên: " + name.get(i));
                System.out.println("Tuổi: " + age.get(i));
                System.out.println("Giới tính: " + sex.get(i));
                System.out.println("Mức lương: " + wage.get(i));
                System.out.println("Điểm trung bình: " + gradePoint.get(i));
                System.out.println("-----------------------------");
            }
        }
    }
    public static void sortEmplyeesByWage( ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint) {
        ArrayList<Integer> wageCopy = new ArrayList<>(wage);
        Collections.sort(wageCopy);

        for (int i = 0; i < wage.size(); i++) {
            Integer targetWage = wageCopy.get(i);  // Lương cần tìm ở vị trí i

            // Tìm vị trí của targetWage trong mảng gốc
            for (int j = i; j < wage.size(); j++) {  // Bắt đầu từ i để tránh swap lại
                if (wage.get(j).equals(targetWage)) {
                    // Swap tất cả mảng
                    Collections.swap(name, i, j);
                    Collections.swap(age, i, j);
                    Collections.swap(sex, i, j);
                    Collections.swap(wage, i, j);
                    Collections.swap(gradePoint, i, j);
                    break;  // Quan trọng: phải break để tránh swap nhiều lần
                }
            }
        }
    }
    public static void swapEmplyeesById(Scanner sc,ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập id nhân viên muốn đổi :");
        int i = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập id nhân viên muốn bị đổi :");
        int j = sc.nextInt();
        sc.nextLine();
        Collections.swap(name, i, j);
        Collections.swap(age, i, j);
        Collections.swap(sex, i, j);
        Collections.swap(wage, i, j);
        Collections.swap(gradePoint, i, j);
    }
    public  static void updateEmplyeesByName(Scanner sc,ArrayList<String>name , ArrayList<Integer>age
            , ArrayList<String>sex , ArrayList<Integer>wage , ArrayList<Integer>gradePoint){
        System.out.println("Nhập tên chủa nhân viên cần cap nhật");
        String nameEmplyees = sc.nextLine();
        for(int i = 0 ; i < name.size() ; i++){
            if(name.get(i).equals(nameEmplyees)){
                System.out.println("Thay đổi tên của " +name.get(i)+" thành :");
                String nameUpdate = sc.nextLine();
                name.set(i,nameUpdate);
                System.out.println("Thay đổi tuổi :");
                int ageUpdate = sc.nextInt();
                sc.nextLine();
                age.set(i,ageUpdate);
                System.out.println("Thay đổi giới tính:");
                String sexUpdate = sc.nextLine();
                sex.set(i,sexUpdate);
                System.out.println("Thay đổi mức lương:");
                int wageUpdate = sc.nextInt();
                sc.nextLine();
                wage.set(i,wageUpdate);
                System.out.println("Thay đổi điểm trung bình đại học:");
                int gradePointUpdate = sc.nextInt();
                sc.nextLine();
                name.set(i,nameUpdate);

            }
        }

    }

}
