package creation.abstract_factory.product.checkbox;

import creation.abstract_factory.product.Checkbox;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style");
    }
}
