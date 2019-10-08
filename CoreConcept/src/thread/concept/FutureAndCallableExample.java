package thread.concept;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

	ExecutorService executorService = Executors.newSingleThreadExecutor();

	Callable<String> callableTask = () -> {
	    Thread.sleep(2000);
	    return "Value";
	};
	
	Future<String> future = executorService.submit(callableTask);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();

	
	
	
	
	

    }

}
