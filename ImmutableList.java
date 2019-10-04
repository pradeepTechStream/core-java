package immutable.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableList {

    private final List<String> list = new ArrayList<>();

    private ImmutableList() {
        this.list.add("A");
        this.list.add("B");
    }

    private List<String> getImmutableList() {
        final List<String> finalList = new ArrayList<>();
        this.list.forEach(s -> finalList.add(s));
        return finalList;
    }

    public static void main(String[] args) {
        // 1st Way :
        final ImmutableList obj = new ImmutableList();
        System.out.println("Before :" + obj.getImmutableList());
        obj.getImmutableList()
            .add("C");
        System.out.println("After :" + obj.getImmutableList());

        // 2nd Way :

        final List<String> stringList = new ArrayList<>();
        stringList.add("a");
        System.out.println("Old List :" + stringList);
        stringList.add("b");
        System.out.println("New List :" + stringList);

        final List<String> aaaaaaa = Collections.unmodifiableList(stringList);

        // Java 9 has different approach to create immutable List

    }

}
