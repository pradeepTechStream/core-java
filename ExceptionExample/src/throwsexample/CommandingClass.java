package throwsexample;

public class CommandingClass {

    public static void main(String[] args) {

	ThrowExample obExample=new ThrowExample();
	try {
	    obExample.myMethod(1);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (ArithmeticException e) {
	    e.printStackTrace();
	}
    }

}
