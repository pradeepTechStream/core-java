package thread.concept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMultipleThread {

    public static void main(String[] args) {
	System.out.println("Inside : " + Thread.currentThread().getName());

	System.out.println("Creating Executor Service...");

	ExecutorService executorService = Executors.newFixedThreadPool(3);

	System.out.println("Creating Runnable.....");
	Runnable task1 = () -> {
	    System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
	    try {
		TimeUnit.SECONDS.sleep(2);
	    } catch (InterruptedException ex) {
		throw new IllegalStateException(ex);
	    }
	};

	Runnable task2 = () -> {
	    System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
	    try {
		TimeUnit.SECONDS.sleep(4);
	    } catch (InterruptedException ex) {
		throw new IllegalStateException(ex);
	    }
	};

	Runnable task3 = () -> {
	    System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
	    try {
		TimeUnit.SECONDS.sleep(3);
	    } catch (InterruptedException ex) {
		throw new IllegalStateException(ex);
	    }
	};
	
	
        System.out.println("Submitting the tasks for execution...");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();


    }

}
