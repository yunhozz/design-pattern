package creation.abstract_factory;

import creation.abstract_factory.client.Application;
import creation.abstract_factory.factory.GUIFactory;
import creation.abstract_factory.factory.MacOSFactory;
import creation.abstract_factory.factory.WindowsFactory;

public class Main {

    public static void main(String[] args) {
        // Create Windows GUI
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.paint();

        System.out.println();

        // Create MacOS GUI
        GUIFactory macOSFactory = new MacOSFactory();
        Application macApp = new Application(macOSFactory);
        macApp.paint();
    }
}
