package de.bonprix.vaadin.example.modules.manageaccounts.ui;

import java.util.List;

import org.vaadin.gridutil.cell.GridCellFilter;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.bonprix.vaadin.example.model.UserAccount;
import de.bonprix.vaadin.example.modules.manageaccounts.ManageAccPresenter;
import de.bonprix.vaadin.example.modules.manageaccounts.ManageAccView;
import de.bonprix.vaadin.mvp.AbstractMvpModuleView;
import de.bonprix.vaadin.spring.SpringView;

@SpringView
public class ManageAccViewImpl extends
		AbstractMvpModuleView<ManageAccPresenter, Component> implements
		ManageAccView {

	private Grid grid;
	private BeanItemContainer<UserAccount> container;
	private GridCellFilter filter;

	private HorizontalLayout horizontalLayout;
	private FormLayout componentVerticalLayout;
	private VerticalLayout verticalLayout;

	private TextField txtffirstName;
	private TextField txtflastName;
	private TextField txtfage;
	private ComboBox cmbBankName;
	private ComboBox cmbAccountType;
	private TextArea txtaddress;
	private TextField txtfbalance;
	private Button btnCreate;
	private Button btnAllRecord;

	@Override
	protected void initializeUI() {
		horizontalLayout = new HorizontalLayout();
		componentVerticalLayout = new FormLayout();

		txtffirstName = new TextField("First Name:");
		txtflastName = new TextField("Last Name:");
		txtfage = new TextField("Age");
		txtaddress = new TextArea("Address");
		cmbBankName = new ComboBox("Bank Name:");
		cmbAccountType = new ComboBox("Account Type:");
		txtfbalance = new TextField("Balance");
		btnCreate = new Button("New");
		btnAllRecord = new Button("All record List");

		List<String> bankList = getObserver().getAllBankNames();
		for (int i = 0; i < bankList.size(); i++) {
			cmbBankName.addItem(bankList.get(i));
		}
		List<String> accTypList = getObserver().getAllAccType();
		for (int i = 0; i < accTypList.size(); i++) {
			cmbAccountType.addItem(accTypList.get(i));
		}

		componentVerticalLayout.addComponent(txtffirstName);
		componentVerticalLayout.addComponent(txtflastName);
		componentVerticalLayout.addComponent(txtfage);
		componentVerticalLayout.addComponent(txtfbalance);
		componentVerticalLayout.addComponent(cmbBankName);
		componentVerticalLayout.addComponent(cmbAccountType);
		componentVerticalLayout.addComponent(txtaddress);

		componentVerticalLayout.addComponent(btnCreate);

		btnCreate.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getObserver().createNewUserAccount(
						txtffirstName.getValue().toString(),
						txtflastName.getValue().toString(),
						Integer.parseInt(txtfage.getValue()),
						txtaddress.getValue(),
						cmbBankName.getValue().toString(),
						cmbAccountType.getValue().toString(),
						Float.parseFloat(txtfbalance.getValue()));
				getObserver().onRecordInsrt();
			}
		});
		btnAllRecord.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getObserver().getAllRecord();

			}
		});

		verticalLayout = new VerticalLayout();
		Grid finalGrid = genGrid();
		finalGrid.setSizeFull();
		finalGrid.setWidth("950px");
		finalGrid.setHeight("730px");
		verticalLayout.addComponent(btnAllRecord, 0);
		verticalLayout.setComponentAlignment(btnAllRecord,
				Alignment.MIDDLE_CENTER);
		verticalLayout.addComponent(finalGrid, 1);
		verticalLayout.setSpacing(true);
		horizontalLayout.addComponent(componentVerticalLayout, 0);
		componentVerticalLayout.setSpacing(true);
		horizontalLayout.addComponent(verticalLayout, 1);
		horizontalLayout.setSpacing(true);
		horizontalLayout.setMargin(true);

		setCompositionRoot(horizontalLayout);
		setSizeFull();
	}

	public Grid genGrid() {
		grid = new Grid();
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.SINGLE);
		grid.setEditorEnabled(true);
		container = new BeanItemContainer<UserAccount>(UserAccount.class);
		grid.setContainerDataSource(container);
		grid.setColumnOrder("firstName", "lastName", "age", "bankName",
				"accType");
		for (Column c : this.grid.getColumns()) {
			c.setHidable(true);
		}
		grid.getColumn("id").setHidden(true);
		grid.getColumn("userId").setHidden(true);
		grid.getColumn("bankId").setHidden(true);
		grid.getColumn("accTypId").setHidden(true);

		grid.getColumn("firstName").setEditable(false);
		grid.getColumn("lastName").setEditable(false);
		grid.getColumn("bankName").setEditable(false);
		grid.getColumn("accType").setEditable(false);
		grid.getColumn("age").setEditable(false);
		grid.setEditorFieldGroup(getFieldGroup());
		grid.setColumnReorderingAllowed(true);
		initFilter(grid);
		return this.grid;

	}

	private FieldGroup getFieldGroup() {
		BeanFieldGroup<UserAccount> beanFieldGroup = new BeanFieldGroup<UserAccount>(
				UserAccount.class);
		beanFieldGroup.addCommitHandler(new CommitHandler() {
			@Override
			public void preCommit(final CommitEvent commitEvent)
					throws CommitException {

			}

			@Override
			public void postCommit(final CommitEvent commitEvent)
					throws CommitException {
				Notification.show("Saved Successfully!!",
						Type.TRAY_NOTIFICATION);

				BeanItem<UserAccount> selectedBean = ManageAccViewImpl.this.container
						.getItem(ManageAccViewImpl.this.grid.getEditedItemId());
				UserAccount changedGridItem = selectedBean.getBean();

				getObserver().saveGridChanges(changedGridItem);
			}
		});

		return beanFieldGroup;
	}

	@Override
	public void setGrid(final List<UserAccount> list) {
		this.container.removeAllItems();
		this.container.addAll(list);
	}

	private void initFilter(final Grid grid) {
		filter = new GridCellFilter(grid);
		filter.setTextFilter("firstName", true, false, null);
		filter.setTextFilter("lastName", true, false, null);
		//filter.setTextFilter("age", true, true);
		filter.setNumberFilter("age","From","To");
	}

	public void gridRefresh() {
		ManageAccViewImpl.this.grid.setRowStyleGenerator(null);
	}

	@Override
	public void getAllRecord(UserAccount userAcc) {
		this.container.removeAllItems();
		this.container.addBean(userAcc);

	}
}
