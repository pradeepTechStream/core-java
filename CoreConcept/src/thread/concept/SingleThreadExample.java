package thread.concept;

public class SingleThreadExample {

    public static void main(String[] args) {

	//thread-1
	Runnable runnable1 = () -> {
	    System.out.println("Entering 1st thread");

	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    
	    System.out.println("Exiting the 1st Thread");
	};

	//thread-2
		Runnable runnable2 = () -> {
		    System.out.println("Entering 2nd thread");

		    try {
			Thread.sleep(4000);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    
		    System.out.println("Exiting 2nd Thread");
		};

	
	
	Thread thread = new Thread(runnable1);
	thread.start();

	try {
	    thread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	Thread thread2 = new Thread(runnable2);
	thread2.start();
	
	

    }

}
