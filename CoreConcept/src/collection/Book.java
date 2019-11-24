package collection;

public class Book {

    private int id;
    private String name;

    Book(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public boolean equals(Object arg0) {
	
	boolean value = this.name.equals(arg0);
	
	return value;
    }

    @Override
    public int hashCode() {
	System.out.println("hashCode :"+this.id+1);
	return this.id+1;
    }
}
