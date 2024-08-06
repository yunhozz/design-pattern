package creation.abstract_factory.factory;

import creation.abstract_factory.product.Button;
import creation.abstract_factory.product.Checkbox;
import creation.abstract_factory.product.button.MacOSButton;
import creation.abstract_factory.product.checkbox.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}