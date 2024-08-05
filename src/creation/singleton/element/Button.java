package creation.singleton.element;

import creation.singleton.theme.Theme;

public class Button {

    private final String label;

    public Button(String label) {
        this.label = label;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Button [" + label + "] displayed in " + themeColor + " theme.");
    }
}
