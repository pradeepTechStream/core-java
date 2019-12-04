package de.bonprix.vaadin.example.modules.enquiry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import de.bonprix.vaadin.FontBonprix;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.navigation.AbstractModule;
import de.bonprix.vaadin.spring.SpringModule;

@SpringModule(id = "enquiry.mod", icon = FontBonprix.DATABASE, roles = {}, sorting = 100)
public class EnquiryModule extends AbstractModule {

	
	@Resource
	EnquiryPresenter presenter;
	@Override
	public MvpModuleView<?> getUIView() {

		return this.presenter.getView();
	}

	
}
