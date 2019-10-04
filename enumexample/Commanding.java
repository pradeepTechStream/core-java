package enumexample;

public class Commanding {

    public static void main(String[] args) {
        final int aaaa = Level.MWDIUM.getLevel();
        System.out.println("1:" + aaaa);

        System.out.println("2:" + Level.HIGH);
        System.out.println("2:" + Level.HIGH.asLowerCase());

        final Level[] aaaaaa = Level.values();
        System.out.println(aaaaaa[2]);

        // For parag
        final Level level = Level.HIGH;
        level.add();
        level.getLevel();
        level.asLowerCase();

        /*
         * 1-Enum has private constructor. 2-Object can be created for Enum. 3-Enum can implement Interface. 4-Enum can also have a bastract method, but
         * abstract method need to be implemented by every Enum.
         */
    }

}
