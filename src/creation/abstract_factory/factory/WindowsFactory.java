package creation.abstract_factory.factory;

import creation.abstract_factory.product.Button;
import creation.abstract_factory.product.Checkbox;
import creation.abstract_factory.product.button.WindowsButton;
import creation.abstract_factory.product.checkbox.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
