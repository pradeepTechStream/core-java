package duplicate.value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateValueExample {

    public static void main(String[] args) {

	List<Integer> values = new ArrayList<>();
	values.add(10);
	values.add(20);
	values.add(30);
	values.add(30);

	Set<Integer> valueSet = new HashSet<>();
	Set<Integer> duplicateSet = new HashSet<>();
	for (Integer value : values) {
	    if (!valueSet.contains(value)) {
		valueSet.add(value);
	    }else{
		duplicateSet.add(value);
	    }
	}
	
	System.out.println(duplicateSet);
	System.out.println(valueSet);
    }

}
