package de.bonprix.vaadin.example.modules.manageaccounts;

import java.util.List;

import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.mvp.MvpModuleViewObserver;

public interface ManageAccView extends MvpModuleView<ManageAccPresenter> {

	public interface Observer extends MvpModuleViewObserver {
		public void saveGridChanges(final UserAccount value);

		public void createNewUserAccount(String fName, String lName, int age,
				String address, String bankName, String accType, float balance);

		public List getAllBankNames();

		public void getAllRecord();

		public List getAllAccType();

		public void onRecordInsrt();
	}

	public void getAllRecord(UserAccount userAcc);

	public void setGrid(final List<UserAccount> list);
}
