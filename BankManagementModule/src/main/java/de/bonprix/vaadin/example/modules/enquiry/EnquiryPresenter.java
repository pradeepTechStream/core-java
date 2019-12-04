package de.bonprix.vaadin.example.modules.enquiry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import de.bonprix.vaadin.example.dao.BankInfoDao;
import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.mvp.AbstractMvpPresenter;
import de.bonprix.vaadin.spring.SpringPresenter;

@SpringPresenter
public class EnquiryPresenter extends AbstractMvpPresenter<EnquiryView>
		implements EnquiryView.Observer {

	@Resource
	EnquiryView view;
	
	@Resource
	BankInfoDao dao;

	@Override
	public EnquiryView getView() {

		return this.view;
	}

	@PostConstruct
	public void postConstruct() {
		getView().setObserver(this);
	}

	@Override
	public void onEnquiryClick(UserAccount userAccount) {
		getView().setResult(this.dao.getLoanInfo(userAccount));		
	}

}
