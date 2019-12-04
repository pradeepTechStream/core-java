package de.bonprix.vaadin.example.modules.enquiry.ui;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import de.bonprix.vaadin.builder.FluentUI;
import de.bonprix.vaadin.example.model.LoanEnquiry;
import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.example.modules.enquiry.EnquiryPresenter;
import de.bonprix.vaadin.example.modules.enquiry.EnquiryView;
import de.bonprix.vaadin.mvp.AbstractMvpModuleView;
import de.bonprix.vaadin.spring.SpringView;
import de.bonprix.vaadin.ui.table.BeanItemTable;

@SpringView
public class EnquiryViewImpl extends
		AbstractMvpModuleView<EnquiryPresenter, Component> implements
		EnquiryView {
	private HorizontalLayout horizontalLayout;
	private GridLayout gridForEnquiry;

	private TextField txtfFirstName;
	private TextField txtfLastName;
	private TextField txtfAge;
	private TextField txtfLoanAmount;
	private TextField txtfTenure;
	private Button btnEnquiry;

	private BeanItemTable<LoanEnquiry> bankInfoTable;

	@Override
	protected void initializeUI() {
		this.horizontalLayout = new HorizontalLayout();
		this.gridForEnquiry = new GridLayout();
		this.txtfFirstName = new TextField("First Name:");
		this.txtfLastName = new TextField("Last Name:");
		this.txtfAge = new TextField("Age:");
		this.txtfLoanAmount = new TextField("Loan Amount:");
		this.txtfTenure = new TextField("Duration");
		this.btnEnquiry = new Button("Enquiry");
		this.btnEnquiry.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserAccount userAccount = new UserAccount();
				userAccount.setFirstName(txtfFirstName.getValue());
				userAccount.setLastName(txtfLastName.getValue());
				userAccount.setAge(Integer.parseInt(txtfAge.getValue()));
				getObserver().onEnquiryClick(userAccount);

			}
		});

		this.bankInfoTable = new BeanItemTable<>(LoanEnquiry.class);

		this.gridForEnquiry = new GridLayout(2, 4);
		this.gridForEnquiry.addComponent(txtfFirstName, 0, 0);
		this.gridForEnquiry.addComponent(txtfLoanAmount, 1, 0);
		this.gridForEnquiry.addComponent(txtfLastName, 0, 1);
		this.gridForEnquiry.addComponent(txtfTenure, 1, 1);
		this.gridForEnquiry.addComponent(txtfAge, 0, 2);
		this.gridForEnquiry.addComponent(btnEnquiry, 0, 3);
		this.gridForEnquiry.setSpacing(true);
		this.gridForEnquiry.setSizeFull();

		this.horizontalLayout.addComponent(gridForEnquiry, 0);
		this.horizontalLayout.addComponent(bankInfoTable, 1);
		this.horizontalLayout.setSpacing(true);
		setCompositionRoot(FluentUI.vertical().add(this.horizontalLayout).get());
	}

	@Override
	public void setResult(List<LoanEnquiry> searchResult) {
		this.bankInfoTable.removeAllItems();
		for (int i = 0; i < searchResult.size(); i++) {
			
			
			searchResult.get(i).setAccruedAmmount(accrudAmount(searchResult.get(i).getInterestRate(), searchResult.get(i).getServiceCharge()));
		}
		this.bankInfoTable.replaceAllBeans(searchResult);

	}

	@Override
	public float accrudAmount(float interestRate, float seviceCharge) {
		float accrudAmnt = 0.0f;
		interestRate = interestRate / 100;
		
		accrudAmnt =  (Float.parseFloat(txtfLoanAmount.getValue())* (1 + (interestRate * Integer.parseInt(txtfAge.getValue()))));

		return accrudAmnt + seviceCharge;
	}

}
