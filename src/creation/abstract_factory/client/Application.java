package creation.abstract_factory.client;

import creation.abstract_factory.factory.GUIFactory;
import creation.abstract_factory.product.Button;
import creation.abstract_factory.product.Checkbox;

public class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
