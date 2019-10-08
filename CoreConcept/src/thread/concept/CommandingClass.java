package thread.concept;

public class CommandingClass {

    public static void main(String[] args) {

	System.out.println("----------Extends Thread Class---------");
	ExtendsThread obThread=new ExtendsThread();
	obThread.start();
	obThread.setName("Thread-1");

	System.out.println(obThread.getId());
	System.out.println(obThread.getName());
	System.out.println(obThread.getPriority());
	System.out.println(obThread.getState());
	
	System.out.println("----------Implements Runnable Interface---------");
	InterfaceExample example=new InterfaceExample();
	Thread obThread2=new Thread(example, "RunnExample");
	obThread2.start();
	
	
	
    }

}
