package thread.concept;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
	System.out.println("Extends Thread Class.."+Thread.currentThread().getName());
    }
}
