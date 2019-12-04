package de.bonprix.vaadin.example;



import de.bonprix.context.i18n.I18N;
import de.bonprix.vaadin.ModuleBasedBonprixUI;
import de.bonprix.vaadin.spring.SpringUI;

/**
 * Main class for UI.
 *
 * @author cthiel
 *
 */
@SpringUI
public class ExampleUI extends ModuleBasedBonprixUI {

    static {
        I18N.GetI18NExecutor()
            .addBundleName("i18n/example-messages");
    }
}