package de.bonprix.vaadin.example.dao;



import de.bonprix.vaadin.example.model.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean updateUserAddrss(User user);
	public User getUser(User user);
	//public List<User> getUser( int age,String firstName, String lastName);
}
