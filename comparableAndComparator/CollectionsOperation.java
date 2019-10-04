package comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsOperation {

    public static void main(String[] args) {

        final StudentComparable student1 = new StudentComparable(10, "pradeep");
        final StudentComparable student2 = new StudentComparable(11, "ajay");
        final StudentComparable student3 = new StudentComparable(12, "mumbai");

        final List<StudentComparable> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student3);
        studentList.add(student2);

        System.out.println("------------Comprable Sorting  Example-----------");
        System.out.println("Before---:" + studentList);
        Collections.sort(studentList);
        System.out.println("After---:" + studentList);

        System.out.println("\n");

        final StudentComparator student4 = new StudentComparator(10, "p");
        final StudentComparator student5 = new StudentComparator(11, "a");
        final StudentComparator student6 = new StudentComparator(12, "m");

        System.out.println("------------Comprator Sorting  Example-----------");
        final List<StudentComparator> stcomList = new ArrayList<>();
        stcomList.add(student4);
        stcomList.add(student5);
        stcomList.add(student6);

        System.out.println("Before---:" + stcomList);
        final List<StudentComparator> aaaa = stcomList.stream()
            .sorted((o1, o2) -> o1.getName()
                .compareTo(o2.getName()))
            .collect(Collectors.toList());

        System.out.println("After---:" + aaaa);

    }

}
