package de.bonprix.vaadin.example.modules.intrservchrge;

import javax.annotation.Resource;

import de.bonprix.vaadin.FontBonprix;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.navigation.AbstractModule;
import de.bonprix.vaadin.spring.SpringModule;

@SpringModule(id = "mod.intrservchrge", icon = FontBonprix.DATABASE, roles = {}, sorting = 100)
public class IntrServChrgModule extends AbstractModule {

	@Resource
	private IntrServChrgPresenter presenter;

	@Override
	public MvpModuleView<?> getUIView() {

		return this.presenter.getView();
	}

}
