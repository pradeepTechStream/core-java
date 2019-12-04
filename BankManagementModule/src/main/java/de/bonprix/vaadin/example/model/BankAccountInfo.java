package de.bonprix.vaadin.example.model;




public class BankAccountInfo {
private int id;
private String accountType;
private String Description;
private float interest;
private float serviceCharge;
private String name;
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
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public float getInterest() {
	return interest;
}
public void setInterest(float interest) {
	this.interest = interest;
}
public float getServiceCharge() {
	return serviceCharge;
}
public void setServiceCharge(float serviceCharge) {
	this.serviceCharge = serviceCharge;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "BankAccountInfo [id=" + id + ", accountType=" + accountType
			+ ", Description=" + Description + ", interest=" + interest
			+ ", serviceCharge=" + serviceCharge + ", name=" + name + "]";
}


}
