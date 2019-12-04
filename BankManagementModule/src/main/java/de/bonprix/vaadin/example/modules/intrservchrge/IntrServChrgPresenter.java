package de.bonprix.vaadin.example.modules.intrservchrge;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import de.bonprix.vaadin.example.dao.AccountTypeDao;
import de.bonprix.vaadin.example.dao.BankDao;
import de.bonprix.vaadin.example.dao.BankInfoDao;
import de.bonprix.vaadin.example.model.AccountType;
import de.bonprix.vaadin.example.model.Bank;
import de.bonprix.vaadin.example.model.BankAccountInfo;
import de.bonprix.vaadin.mvp.AbstractMvpPresenter;
import de.bonprix.vaadin.spring.SpringPresenter;

@SpringPresenter
public class IntrServChrgPresenter extends
		AbstractMvpPresenter<IntrServChrgView> implements
		IntrServChrgView.Observer {

	@Resource
	private BankDao bankDao;

	@Resource
	private AccountTypeDao accTypDao;

	@Resource
	private BankInfoDao bankInfoDao;
	
	
	@Resource
	private IntrServChrgView view;

	@Override
	public IntrServChrgView getView() {

		return this.view;
	}

	@PostConstruct
	public void postConstruct() {
		getView().setObserver(this);
	}

	@Override
	public List getAllBankNames() {
		List<Bank> bankList = bankDao.getAllBanks();
		List<String> bankName = new ArrayList<String>();
		for (int i = 0; i < bankList.size(); i++) {
			bankName.add(bankList.get(i).getBankName());

		}
		return bankName;
	}

	@Override
	public List getAllAccType() {

		List<AccountType> accTypeList = accTypDao.getAccountType();
		List<String> accType = new ArrayList<String>();
		for (int i = 0; i < accTypeList.size(); i++) {
			accType.add(accTypeList.get(i).getAccountType());

		}
		return accType;
	}

	@Override
	public BankAccountInfo searchRecords(String name, String accountType) {
		BankAccountInfo bankAcc=new BankAccountInfo();
		bankAcc.setName(name);
		bankAcc.setAccountType(accountType);
	BankAccountInfo bankAccountInfo=bankInfoDao.getIntrSrvcChrg(bankAcc);
		
		return bankAccountInfo ;
	}

	@Override
	public void updateRecords(String name, String accType, float interestRate,
			float ServiceCharge) {
		BankAccountInfo bankAcc=new BankAccountInfo();
		bankAcc.setName(name);
		bankAcc.setAccountType(accType);
		bankAcc.setInterest(interestRate);
		bankAcc.setServiceCharge(ServiceCharge);
		System.out.println(bankInfoDao.updateIntrSrvcChrge(bankAcc));
		
	}

}
