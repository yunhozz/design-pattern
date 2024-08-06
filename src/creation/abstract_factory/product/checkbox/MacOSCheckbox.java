package creation.abstract_factory.product.checkbox;

import creation.abstract_factory.product.Checkbox;

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in MacOS style");
    }
}
