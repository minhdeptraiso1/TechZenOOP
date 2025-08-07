package ss5_polymorphism;

import java.util.Objects;

public class Student {// Java tự ngầm định extends Object
    private int id;
    private String name;
    private double score;

    /// Hoặc tự viết lại toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return id == student.id && Double.compare(score, student.score) == 0 && Objects.equals(name, student.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, score);
//    }

    /// Tạo constructor + getter & setter -> Hãy tự tạo lại
    public Student() {
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    /// Cách 2: dùng instanceof -> Cách này có gì khác với cách trên???
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Student student)) return false;
//        return id == student.id && Objects.equals(name, student.name);
//    }


    /// Override lại phương thức toString() của lớp Object
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", score=" + score +
//                '}';
//    }

}


/// Override equals() sử dụng instanceof
class GraduateStudent extends Student {
    String thesis;

    public GraduateStudent(int id, String name, double score) {
        super(id, name, score);
    }
}
