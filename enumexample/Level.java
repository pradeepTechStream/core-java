package enumexample;

public enum Level implements MyInterface {

    HIGH(3) {
        @Override
        public String asLowerCase() {
            return "high";
        }
    },
    LOW(2) {
        @Override
        public String asLowerCase() {
            return "low";
        }
    },
    MWDIUM(1) {
        @Override
        public String asLowerCase() {
            return "medium";
        }
    };

    final int level;

    // private construcctor
    private Level(int level) {
        this.level = level;
    }

    // global access point
    public int getLevel() {
        return this.level;
    }

    @Override
    public void add() {
        System.out.println("Interface method");
    }

    // abstract method
    public abstract String asLowerCase();

}
