package BT_1_8.chieu;

import java.util.ArrayList;

public class TeacherSupport extends Person implements ITeacher {
    private final ArrayList<Teacher> teachers = new ArrayList<>();
    private int soBuoiThucHanh;

    @Override
    public double getSalary() {
        return 0;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teacher) {
        this.teachers.add(teacher);
    }
}
