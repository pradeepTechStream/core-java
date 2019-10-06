package overloadin;

public class OverloadingExample {

    public void add(String object) {
	System.out.print("String");
    }

   public void add(Object object) {
	System.out.println("object");
    }
   
    public void add(Integer integer) {
	System.out.println("integer");
    }
    

    public static void main(String[] args) {
	OverloadingExample example = new OverloadingExample();
	//example.add(null);//ambiguty error
    }

}
