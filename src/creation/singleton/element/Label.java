package creation.singleton.element;

import creation.singleton.theme.Theme;

public class Label {

    private final String text;

    public Label(String text) {
        this.text = text;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Label [" + text + "] displayed in " + themeColor + " theme.");
    }
}
