package de.bonprix.vaadin.example.modules.intrservchrge.ui;

import java.util.List;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.bonprix.vaadin.builder.FluentUI;
import de.bonprix.vaadin.example.model.BankAccountInfo;
import de.bonprix.vaadin.example.modules.intrservchrge.IntrServChrgPresenter;
import de.bonprix.vaadin.example.modules.intrservchrge.IntrServChrgView;
import de.bonprix.vaadin.mvp.AbstractMvpModuleView;
import de.bonprix.vaadin.spring.SpringView;

@SpringView
public class IntrServChrgViewImpl extends
		AbstractMvpModuleView<IntrServChrgPresenter, Component> implements
		IntrServChrgView {

	private Button btnSearch;
	private Button btnUpdate;
	private ComboBox cmbBankName;
	private ComboBox cmbAccountType;
	private TextField txtfIntrRate;
	private TextField txtfServChrge;
	private VerticalLayout verticalLayout;
	private HorizontalLayout buttonInRowLayout;
	
	
	@Override
	protected void initializeUI() {
		verticalLayout = new VerticalLayout();
		buttonInRowLayout = new HorizontalLayout();
		
		
		cmbBankName = new ComboBox("Bank Name:");
		cmbAccountType = new ComboBox("Account Type:");
		txtfIntrRate = new TextField("Interest Rate:");
		txtfServChrge = new TextField("Service Charge:");
		btnSearch = new Button("Search");
		btnUpdate = new Button("Update");

		List<String> bankList = getObserver().getAllBankNames();
		for (int i = 0; i < bankList.size(); i++) {
			cmbBankName.addItem(bankList.get(i));
		}
		List<String> accTypList = getObserver().getAllAccType();
		for (int i = 0; i < accTypList.size(); i++) {
			cmbAccountType.addItem(accTypList.get(i));
		}

		btnSearch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String bankName = String.valueOf(cmbBankName.getValue());
				String accTyp = String.valueOf(cmbAccountType.getValue());

				System.out.println(bankName + " " + accTyp);
				BankAccountInfo bankAccountInfo = getObserver().searchRecords(
						bankName, accTyp);
				txtfIntrRate.setValue(String.valueOf(bankAccountInfo
						.getInterest()));
				txtfServChrge.setValue(String.valueOf(bankAccountInfo
						.getServiceCharge()));

			}
		});

		btnUpdate.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String bankName = String.valueOf(cmbBankName.getValue());
				String accTyp = String.valueOf(cmbAccountType.getValue());
				Float interestRate = Float.parseFloat(txtfIntrRate.getValue());
				Float serviceCharge = Float.parseFloat(txtfServChrge.getValue());
				getObserver().updateRecords(bankName, accTyp, interestRate,
						serviceCharge);
				Notification.show("Record Updated Successfully !!!");
			}
		});

		verticalLayout.addComponent(cmbBankName);
		verticalLayout.addComponent(cmbAccountType);
		verticalLayout.addComponent(txtfIntrRate);
		verticalLayout.addComponent(txtfServChrge);
		buttonInRowLayout.addComponent(btnSearch);
		buttonInRowLayout.addComponent(btnUpdate);
		buttonInRowLayout.setSpacing(true);
		verticalLayout.addComponent(buttonInRowLayout);
		verticalLayout.setSpacing(true);
		verticalLayout.setMargin(true);

		setCompositionRoot(FluentUI.vertical().add(verticalLayout).get());
		setSizeFull();
	}

}
