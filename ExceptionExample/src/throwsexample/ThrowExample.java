package throwsexample;

public class ThrowExample {
    
    void myMethod(int num) throws ClassNotFoundException,ArithmeticException{
	if(num==1){
	    throw new ClassNotFoundException("IOException");
	}else{
	    throw new ArithmeticException("ArithMaticException");
	}
    }

}
