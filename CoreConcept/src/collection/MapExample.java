package collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

	Map<String,String> normalMap=new HashMap<String, String>();
	
	normalMap.put("A", "1");
	normalMap.put("B", "2");
	normalMap.put("B", "3");
	
	System.out.println(normalMap.get("A"));
	System.out.println(normalMap.get("B")); //hashCode() and equal both is same for the key then override the value.
	
	Student student1=new Student("10","mumbai");
	Student student2=new Student("11","goa");
	Student student3=new Student("11","goa");
	
	
	Map<Student,String> map=new HashMap<Student, String>();
	map.put(student1, "v1");
	map.put(student2, "v2");
	map.put(student3, "v3");
	map.put(student3, "v4");
	
	System.out.println(map.get(student1));
	System.out.println(map.get(student2));
	System.out.println(map.get(student3));
	
	Book book1=new Book(10,"B1");
	Book book2=new Book(10,"B1");
	Map<Book,String> bookMap=new HashMap<Book, String>();
	bookMap.put(book1, "java");
	bookMap.put(book2, "c++");
	
	
	System.out.println(bookMap.get(book2));
	
	
	
	
    }

}
