package creation.abstract_factory.product.button;

import creation.abstract_factory.product.Button;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style");
    }
}
