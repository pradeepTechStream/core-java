package de.bonprix.vaadin.example.modules.enquiry;

import java.util.List;

import de.bonprix.vaadin.example.model.BankAccountInfo;
import de.bonprix.vaadin.example.model.LoanEnquiry;
import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.mvp.MvpModuleViewObserver;

public interface EnquiryView extends MvpModuleView<EnquiryPresenter> {
	void setResult(final List<LoanEnquiry> searchResult);
	public float accrudAmount(float interestRate,float serviceCharge);

	public interface Observer extends MvpModuleViewObserver {
		public void onEnquiryClick(UserAccount userAccount);
		
	}

}
