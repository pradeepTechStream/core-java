package duplicate.from.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Commanding {

    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
        System.out.println("List with duplicate value :" + list);

        // 1 way
        final List<Integer> uniqValueList = new ArrayList<>();
        final List<Integer> duplicateValue = new ArrayList<>();

        for (final Integer value : list) {
            if (!uniqValueList.contains(value)) {
                uniqValueList.add(value);
            }
            else {
                if (uniqValueList.contains(value)) {
                    duplicateValue.remove(value);
                    duplicateValue.add(value);
                }
            }
        }
        System.out.println("Unique Value List :" + uniqValueList);
        System.out.println("duplicate Value List :" + duplicateValue);

        // 2-nd way but sort data
        final Set<Integer> uniqueSet = new HashSet<>();
        uniqueSet.addAll(list);

        /*
         * for (final Integer value : list) { if (!uniqueSet.contains(value)) { uniqueSet.add(value); } }
         */
        final boolean aaaa = uniqueSet.add(52);
        System.out.println(aaaa);
        System.out.println("Unique value with Set" + uniqueSet);

        // 3rd way but not sort data
        final Set<Integer> set = new LinkedHashSet<>();
        set.addAll(list);
        System.out.println("Unique value with LinkedHashSet " + set);

        final List<Integer> uniqueValues = list.stream()
            .distinct()
            .collect(Collectors.toList());

        System.out.println("UniqueValues using stream :" + uniqueValues);

    }

}
