package finctionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CommandingClass {

    public static void main(String[] args) {

        final Add aa = (int a, int b) -> a + b;
        final int sum = aa.add(10, 10);
        System.out.println("sum :" + sum);

        final Multiply mul = (int a) -> a * a;
        final int multiplication = mul.mul(10);
        System.out.println(multiplication);

        final List<String> names = Arrays.asList("Geek", "GeeksQuiz", "g1", "QA", "Geek2");
        final Predicate<String> p = (s) -> s.startsWith("G");

        for (final String name : names) {
            if (p.test(name)) {
                System.out.println("Name :-" + name);
            }

        }

    }

}
