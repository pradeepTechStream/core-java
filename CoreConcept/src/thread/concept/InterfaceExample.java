package thread.concept;

public class InterfaceExample implements Runnable {
    @Override
    public void run() {
	System.out.print("Implements Runnable Interface"+Thread.currentThread().getName());
    }
}
