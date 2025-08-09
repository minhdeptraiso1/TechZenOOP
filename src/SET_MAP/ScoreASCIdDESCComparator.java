package SET_MAP;


import java.util.Comparator;

public class ScoreASCIdDESCComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getId(), o2.getId());
    }
}
