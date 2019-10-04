package string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringClassExample {

    public static void main(String[] args) {
        final String name1 = "abc";
        final String name2 = "abc";

        System.out.println("Reference :" + (name1 == name2));

        System.out.println("Content :" + name1.equals(name2));
        System.out.println("Name1 HashCode Value :" + name1.hashCode());
        System.out.println("Name2 HashCode Value :" + name2.hashCode());

        System.out.println("1:" + name1.concat("pqr"));
        System.out.println("2:" + name1);

        System.out.println("3:" + name2 + "pqr");
        System.out.println("4:" + name2);

        final String test = name2 + "pqr";
        System.out.println("Concat and Assign :" + test);

        final String name3 = " ";
        final String name4 = "abc";
        System.out.println("Empty Concat:" + name4.concat(name3));

        final String A = "abc";
        final String B = "abc";
        final String C = new String("abc");

        System.out.println("A HashCode :" + A.hashCode());
        System.out.println("B HashCode :" + B.hashCode());
        System.out.println("C HashCode :" + C.hashCode());

        final String D = new String("abc").intern();

        System.out.println("D HashCode :" + D.hashCode());

        System.out.println("A == B :" + (A == B));
        System.out.println("A == C :" + (A == C));
        System.out.println("A == D :" + (A == D));
        System.out.println("C == D :" + (C == D));

        System.out.println("abc".concat(" "));
        // System.out.println("abc".concat(null)); // gives Nullpointer

        String str1 = "hello";
        String str5 = "hello";

        final String str2 = new String("hello");
        final String str3 = new String(str1);

        System.out.println("str1 == str2 :" + (str1 == str2));
        System.out.println("str2 == str3 :" + (str2 == str3));
        System.out.println("str2 == str4 :" + (str2 == str3));
        System.out.println("str2 == str4 :" + (str1 == str5));

        System.out.println(str1.equals(str3));
        System.out.println(str1 == str3);

        System.out.println("Before :" + str1);
        str1 += 1;
        System.out.println("After  :" + str1);

        int i = 1;
        System.out.println("I Before :" + i);
        i += 1;
        System.out.println("I After  :" + i);

        int j = 1;
        System.out.println("J Before :" + j);
        j++;
        System.out.println("J After  :" + j);

        int k = 1;
        System.out.println("K Before :" + k);
        k = +1;
        System.out.println("K After  :" + k);

        int l = 1;
        System.out.println("L Before :" + l);
        l = l + 1;
        System.out.println("L After  :" + l);

        str5.concat("dss");
        System.out.println("str5 :" + str5);
        str5 = str5.concat("dss");
        System.out.println(str5);

        String str6 = "Best";
        str6 = str6 + 1;
        System.out.println(str6);

        StringBuffer buffer = new StringBuffer();// used to create mutable and thread safe
        System.out.println("Empty Capacity : " + buffer.capacity());

        final StringBuffer buffer2 = new StringBuffer("javaBooks");
        System.out.println("Capacity : " + buffer2.capacity());

        System.out.println("Original Value :" + buffer2);
        System.out.println("After Change :" + buffer2.append("A"));

        // Appends a subsequence of the specified CharSequence to this sequence
        buffer = new StringBuffer().append("javaguides", 0, 9);
        System.out.println("Appends a subsequence of the specified " + " CharSequence to this sequence. : " + buffer);

        final StringBuffer buffer3 = new StringBuffer("javaguides");
        System.out.println("Before set length to 0 : " + buffer3.length());
        System.out.println("Before : " + buffer3);
        buffer3.setLength(0);
        System.out.println("After set length to 0 : " + buffer3.length());
        System.out.println("After  : " + buffer3);

        final String str10 = "abc";
        System.out.println(str10.length());

        String buffer4 = new String("javaguides");
        System.out.println(buffer4.length());
        System.out.println(buffer4);

        buffer4 = "";
        System.out.println(buffer4.length());
        System.out.println(buffer4);

        final String object = "DSS.S";
        System.out.println("Character At :" + object.charAt(0));
        System.out.println(object.codePointAt(0));
        System.out.println(object.compareTo("DSS"));
        System.out.println(object.compareToIgnoreCase("dss"));
        System.out.println(object.contains("S"));
        System.out.println(object.contentEquals("DSS"));
        System.out.println(object.concat("LLP"));

        final StringBuffer bufferObject = new StringBuffer("Direction");
        System.out.println(bufferObject.append("LLP"));
        System.out.println(bufferObject.reverse());

        final char c = 'x';
        bufferObject.setCharAt(0, c);

        System.out.println(bufferObject);
        bufferObject.deleteCharAt(0);
        System.out.println(bufferObject);

        final List<String> values = new ArrayList<>();
        values.add("1");
        values.add("2");
        values.add("3");
        values.add("4");
        System.out.println(values);

        final StringJoiner joiner = new StringJoiner(":");
        values.forEach(e -> {
            joiner.add(e);
        });
        System.out.println(joiner);

    }

}
