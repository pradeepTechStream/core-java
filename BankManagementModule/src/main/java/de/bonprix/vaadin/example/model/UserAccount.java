package de.bonprix.vaadin.example.model;



public class UserAccount {
	private int id;
	private int userId;
	private int bankId;
	private int accTypId;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String bankName;
	private String accType;
	private float balance;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getAccTypId() {
		return accTypId;
	}
	public void setAccTypId(int accTypId) {
		this.accTypId = accTypId;
	}
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", userId=" + userId + ", bankId="
				+ bankId + ", accTypId=" + accTypId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age
				+ ", address=" + address + ", bankName=" + bankName
				+ ", accType=" + accType +  ", balance=" + balance + "]";
	}
	
	
	

	
}
