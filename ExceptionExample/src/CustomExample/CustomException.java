package CustomExample;

public class CustomException extends Exception{
    private static final long serialVersionUID = -6939055439586822608L;
    
    private String str;

    CustomException(String str) {
	this.str = str;
    }
    
    public String toString(){
	return "MyException : "+str;
    }
    

}
