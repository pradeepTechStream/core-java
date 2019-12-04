package de.bonprix.vaadin.example.dao;

import java.util.List;

import de.bonprix.vaadin.example.model.UserAccount;

public interface UserAccountDao {
	public boolean addUserIntoAcc(UserAccount userAccount);

	public boolean updateUsrAccBal(UserAccount userAccount);

	public UserAccount SearchForSingleRecord(UserAccount userAccount);

	public List<UserAccount> getLatestRecordList();

	public List<UserAccount> getAllUserRecords();

	public List<UserAccount> displaySearchRecord(String firstName,
			String lastName, int age);

	public List<UserAccount> getAllDetails(String bankName, String AccountName);

}
