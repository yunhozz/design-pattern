package creation.singleton;

class Theme {
    private static Theme instance;
    private String themeColor;

    private Theme() {
        this.themeColor = "light"; // Default theme
    }

    public static Theme getInstance() {
        if (instance == null) {
            instance = new Theme();
        }
        return instance;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
}

class Button {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Button [" + label + "] displayed in " + themeColor + " theme.");
    }
}

class TextField {
    private final String text;

    public TextField(String text) {
        this.text = text;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("TextField [" + text + "] displayed in " + themeColor + " theme.");
    }
}

class Label {
    private final String text;

    public Label(String text) {
        this.text = text;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Label [" + text + "] displayed in " + themeColor + " theme.");
    }
}

class ThemeDemo {
    public static void main(String[] args) {
        Button button = new Button("Submit");
        TextField textField = new TextField("Enter your name");
        Label label = new Label("Username");

        button.display();
        textField.display();
        label.display();

        Theme.getInstance().setThemeColor("dark");
        System.out.println();

        button.display();
        textField.display();
        label.display();
    }
}

/*
Button [Submit] displayed in light theme.
TextField [Enter your name] displayed in light theme.
Label [Username] displayed in light theme.

Button [Submit] displayed in dark theme.
TextField [Enter your name] displayed in dark theme.
Label [Username] displayed in dark theme.
 */