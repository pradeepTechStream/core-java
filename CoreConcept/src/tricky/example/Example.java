package tricky.example;

public class Example {

	public static void main(String[] args) {
		
		//String length without using in-build function
		
		String str="CoreJava";
		
		System.out.println("In-Buid Function:"+str.length());
		System.out.println("In-Buid Function:"+str.lastIndexOf(""));
		
		char[] charArray = str.toCharArray();
		
		int count=0;
		for(char value:charArray) {
			count++;
		}
		System.out.println("String length:"+count);
	}

}
