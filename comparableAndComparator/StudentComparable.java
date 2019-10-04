package comparableAndComparator;

public class StudentComparable implements Comparable<StudentComparable> {

    private int id;
    private String name;

    public StudentComparable(int id, String name) {
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
    public int compareTo(StudentComparable o) {
        return this.id - o.id;
    }

}
