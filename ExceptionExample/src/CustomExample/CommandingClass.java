package CustomExample;

public class CommandingClass {

    public static void main(String[] args) {

	try {
	    System.out.println("Starting of try Block.....");
	    throw new CustomException("This is my Error Message");
	} catch (Exception e) {
	    System.out.println("Catch Block...");
	    System.out.println(e);

	}
    }

}
