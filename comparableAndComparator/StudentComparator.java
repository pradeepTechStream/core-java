package comparableAndComparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentComparator> {

    private int id;
    private String name;

    public StudentComparator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + this.id + ", name=" + this.name + "]";
    }

    @Override
    public int compare(StudentComparator o1, StudentComparator o2) {
        return o1.getName()
            .compareTo(o2.getName());
    }

}
