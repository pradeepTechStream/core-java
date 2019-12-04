package de.bonprix.vaadin.example.model;

public class LoanEnquiry {

	private String bankName;
	private String accountType;
	private float accruedAmmount;
	private float interestRate;
	private int serviceCharge;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getAccruedAmmount() {
		return accruedAmmount;
	}

	public void setAccruedAmmount(float accruedAmmount) {
		this.accruedAmmount = accruedAmmount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@Override
	public String toString() {
		return "LoanEnquiry [ bankName=" + bankName + ", accountType="
				+ accountType + ", accruedAmmount=" + accruedAmmount
				+ ", interestRate=" + interestRate + ", serviceCharge="
				+ serviceCharge + "]";
	}

}
