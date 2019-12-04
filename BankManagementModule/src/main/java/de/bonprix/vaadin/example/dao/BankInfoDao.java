package de.bonprix.vaadin.example.dao;

import java.util.List;

import de.bonprix.vaadin.example.model.BankAccountInfo;
import de.bonprix.vaadin.example.model.LoanEnquiry;
import de.bonprix.vaadin.example.model.UserAccount;

public interface BankInfoDao {
	public boolean updateIntrSrvcChrge(BankAccountInfo bankAccInfo);

	public BankAccountInfo getIntrSrvcChrg(BankAccountInfo bankAccountInfo);

	public List<LoanEnquiry> getLoanInfo(UserAccount userAcc);
}
