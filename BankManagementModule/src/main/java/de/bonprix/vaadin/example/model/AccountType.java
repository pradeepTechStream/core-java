package de.bonprix.vaadin.example.model;







public class AccountType{
	private int id;
	private String accountType;
	private String accountDescription;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	@Override
	public String toString() {
		return "Accounttype [id=" + id + ", accountType=" + accountType
				+ ", accountDescription=" + accountDescription + "]";
	}
	
}
