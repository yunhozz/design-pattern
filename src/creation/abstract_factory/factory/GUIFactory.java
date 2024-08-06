package creation.abstract_factory.factory;

import creation.abstract_factory.product.Button;
import creation.abstract_factory.product.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
