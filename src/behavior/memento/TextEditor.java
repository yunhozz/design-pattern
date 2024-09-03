package behavior.memento;

import java.util.ArrayList;

// Originator: The object whose state needs to be saved and restored
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Create a Memento containing the current state
    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    // Restore state from a Memento
    public void restore(TextEditorMemento memento) {
        this.text = memento.getSavedText();
    }
}

// Memento: The object that stores the state of the Originator
class TextEditorMemento {
    private final String text;

    public TextEditorMemento(String textToSave) {
        text = textToSave;
    }

    public String getSavedText() {
        return text;
    }
}

// Caretaker: Keeps track of multiple Mementos
class History {
    private final ArrayList<TextEditorMemento> states = new ArrayList<>();

    public void push(TextEditorMemento state) {
        states.add(state);
    }

    public TextEditorMemento pop() {
        if (states.isEmpty()) {
            return null;
        }
        TextEditorMemento lastState = states.getLast();
        states.removeLast();
        return lastState;
    }
}

// Client code to demonstrate the usage
class TextEditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // First change
        editor.setText("This is the first version.");
        history.push(editor.save());

        // Second change
        editor.setText("This is the second version.");
        history.push(editor.save());

        // Third change
        editor.setText("This is the third version.");

        System.out.println("Current text: " + editor.getText());

        // Undo to second version
        editor.restore(history.pop());
        System.out.println("First undo: " + editor.getText());

        // Undo to first version
        editor.restore(history.pop());
        System.out.println("Second undo: " + editor.getText());
    }
}