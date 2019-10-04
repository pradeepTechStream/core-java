import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {

    /*
     * Check String has unique character or not.
     */

    public static void main(String[] args) {
        if (UniqueCharacter.isUnique("abc")) {
            System.out.println("All characters of String are unique");
        }
        else {
            System.out.println("All characters of String are not unique");
        }
    }

    private static boolean isUnique(String input) {
        final Set<Character> set = new HashSet<>();

        final char[] characterArray = input.toCharArray();
        for (final char value : characterArray) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

}
