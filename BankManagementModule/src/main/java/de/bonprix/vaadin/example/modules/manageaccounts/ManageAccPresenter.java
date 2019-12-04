package de.bonprix.vaadin.example.modules.manageaccounts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.vaadin.ui.Notification;

import de.bonprix.vaadin.example.dao.AccountTypeDao;
import de.bonprix.vaadin.example.dao.BankDao;
import de.bonprix.vaadin.example.dao.UserAccountDao;
import de.bonprix.vaadin.example.dao.UserDao;
import de.bonprix.vaadin.example.model.AccountType;
import de.bonprix.vaadin.example.model.Bank;
import de.bonprix.vaadin.example.model.User;
import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.mvp.AbstractMvpPresenter;
import de.bonprix.vaadin.spring.SpringPresenter;

@SpringPresenter
public class ManageAccPresenter extends AbstractMvpPresenter<ManageAccView>
		implements ManageAccView.Observer {

	@Resource
	private BankDao bankDao;

	@Resource
	private AccountTypeDao accTypDao;

	@Resource
	private UserAccountDao userAccDao;

	@Resource
	private UserDao userDao;

	@Resource
	private ManageAccView view;

	List<Bank> bankList = null;
	List<AccountType> accTypeList = null;
	String firstName, lastName, bankName, accType, address;
	float balance;
	int age;

	@Override
	public ManageAccView getView() {

		return this.view;
	}

	@PostConstruct
	public void postConstruct() {
		getView().setObserver(this);
	}

	@Override
	public List getAllBankNames() {
		bankList = bankDao.getAllBanks();
		List<String> bankName = new ArrayList<String>();
		for (int i = 0; i < bankList.size(); i++) {
			bankName.add(bankList.get(i).getBankName());

		}
		return bankName;
	}

	@Override
	public List getAllAccType() {

		accTypeList = accTypDao.getAccountType();
		List<String> accType = new ArrayList<String>();
		for (int i = 0; i < accTypeList.size(); i++) {
			accType.add(accTypeList.get(i).getAccountType());

		}
		return accType;
	}

	@Override
	public void saveGridChanges(final UserAccount value) {
		User user = new User();
		int userId = value.getUserId();
		String address = value.getAddress();
		user.setId(userId);
		user.setAddress(address);
		this.userDao.updateUserAddrss(user);
		this.userAccDao.updateUsrAccBal(value);
	}

	@Override
	protected void onViewInitialized() {
		getView().setGrid(this.userAccDao.getLatestRecordList());
	}

	@Override
	public void getAllRecord() {

		getView().setGrid(this.userAccDao.getAllUserRecords());
	}

	@Override
	public void onRecordInsrt() {
		UserAccount userAccount = new UserAccount();
		userAccount.setFirstName(firstName);
		userAccount.setLastName(lastName);
		userAccount.setAge(age);
		userAccount.setAddress(address);
		userAccount.setBalance(balance);
		userAccount.setBankName(bankName);
		userAccount.setAccType(accType);
		getView().getAllRecord(
				this.userAccDao.SearchForSingleRecord(userAccount));

	}

	@Override
	public void createNewUserAccount(String firstName, String lastName,
			int age, String address, String bankName, String accType,
			float balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.bankName = bankName;
		this.accType = accType;
		this.balance = balance;
		UserAccount usrAcc = new UserAccount();
		usrAcc.setFirstName(firstName);
		usrAcc.setLastName(lastName);
		usrAcc.setAge(age);
		usrAcc.setBankName(bankName);
		usrAcc.setAccType(accType);
		usrAcc = userAccDao.SearchForSingleRecord(usrAcc);

		System.out.println(usrAcc);

		User checkUserExistence = new User();
		checkUserExistence.setFirstName(firstName);
		checkUserExistence.setLastName(lastName);
		checkUserExistence.setAge(age);
		checkUserExistence = userDao.getUser(checkUserExistence);

		System.out.println("-------------------------" + checkUserExistence);

		if (usrAcc != null) {
			Notification.show(usrAcc.getFirstName() + " already have \n "
					+ usrAcc.getAccType() + " in " + usrAcc.getBankName());
		} else if (checkUserExistence != null
				&& (checkUserExistence.getFirstName().equals(firstName))
				&& (checkUserExistence.getLastName().equals(lastName))
				&& ((checkUserExistence.getAge()) == (age))) {

			UserAccount adduser = new UserAccount();
			adduser.setUserId(checkUserExistence.getId());
			int bankId = 0, accTypId = 0;

			for (int i = 0; i < bankList.size(); i++) {
				if (bankList.get(i).getBankName().equals(bankName))
					bankId = bankList.get(i).getBankId();
			}

			for (int i = 0; i < accTypeList.size(); i++) {
				if (accTypeList.get(i).getAccountType().equals(accType))
					accTypId = accTypeList.get(i).getId();

			}
			adduser.setBankId(bankId);
			adduser.setAccTypId(accTypId);
			adduser.setBalance(balance);
			userAccDao.addUserIntoAcc(adduser);
			Notification.show("User is created");
		}
		if (usrAcc == null && checkUserExistence == null) {
			// insert record into user table
			User createNewUser = new User();

			createNewUser.setFirstName(firstName);
			createNewUser.setLastName(lastName);
			createNewUser.setAge(age);
			createNewUser.setAddress(address);
			userDao.addUser(createNewUser);

			// get user information
			User getUserInfo = new User();
			User checkUserInfo = new User();
			checkUserInfo.setFirstName(firstName);
			checkUserInfo.setLastName(lastName);
			checkUserInfo.setAge(age);

			System.out.println("i am here before getUserInfo:" + getUserInfo);

			getUserInfo = userDao.getUser(checkUserInfo);
			System.out.println("i am here near getUserInfo:" + getUserInfo);
			UserAccount addNewCustomer = new UserAccount();
			System.out.println("i am here far getUserInfo:" + getUserInfo);

			int bankId = 0, accTypId = 0;

			for (int i = 0; i < bankList.size(); i++) {
				if (bankList.get(i).getBankName().equals(bankName))
					bankId = bankList.get(i).getBankId();
			}

			for (int i = 0; i < accTypeList.size(); i++) {
				if (accTypeList.get(i).getAccountType().equals(accType))
					accTypId = accTypeList.get(i).getId();

			}

			addNewCustomer.setUserId(getUserInfo.getId());
			addNewCustomer.setBankId(bankId);
			addNewCustomer.setAccTypId(accTypId);
			addNewCustomer.setBalance(balance);
			System.out.println(userAccDao.addUserIntoAcc(addNewCustomer));

		}

	}

}
