package string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DifferentWayToIteratList {

    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Using For Loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Using For Each:");
        for (final Integer value : list) {
            System.out.println(value);
        }

        System.out.println("Using Iterator :");
        final Iterator<Integer> iterate = list.iterator();
        while (iterate.hasNext()) {
            System.out.println(iterate.next());
        }

        System.out.println("Using List Iterator :");
        final ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        list.forEach(e -> System.out.print(e));

    }
}
