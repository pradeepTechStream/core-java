package de.bonprix.vaadin.example.modules.manageaccounts;

import javax.annotation.Resource;

import de.bonprix.vaadin.FontBonprix;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.navigation.AbstractModule;
import de.bonprix.vaadin.spring.SpringModule;

@SpringModule(id = "manageaccounts.mod", icon = FontBonprix.DATABASE, roles = {}, sorting = 100
)
public class ManageAccModule extends AbstractModule{

	@Resource
	ManageAccPresenter presenter;
	
	@Override
	public MvpModuleView<?> getUIView() {
		
		return presenter.getView();
	}

}
