package de.bonprix.vaadin.example.modules.intrservchrge;

import java.util.List;

import de.bonprix.vaadin.example.model.BankAccountInfo;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.mvp.MvpModuleViewObserver;

public interface IntrServChrgView extends MvpModuleView<IntrServChrgPresenter> {

	public interface Observer extends MvpModuleViewObserver {
		public List getAllBankNames();

		public List getAllAccType();

		public BankAccountInfo searchRecords(String Name,String accType);

		public void updateRecords(String name,String accType,float interestRate,float ServiceCharge);
	}

}
