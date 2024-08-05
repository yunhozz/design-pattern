package creation.singleton;

import creation.singleton.element.Button;
import creation.singleton.element.Label;
import creation.singleton.element.TextField;
import creation.singleton.theme.Theme;

public class Main {

    public static void main(String[] args) {
        Button button = new Button("Submit");
        TextField textField = new TextField("Enter your name");
        Label label = new Label("Username");

        button.display();
        textField.display();
        label.display();

        Theme.getInstance().setThemeColor("dark");

        button.display();
        textField.display();
        label.display();
    }
}
