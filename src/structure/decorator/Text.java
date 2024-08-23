package structure.decorator;

// Base Component
interface Text {
    String getContent();
}

// Concrete Component
class PlainText implements Text {
    private final String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

// Base Decorator
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text text) {
        this.decoratedText = text;
    }

    @Override
    public String getContent() {
        return decoratedText.getContent();
    }
}

// Concrete Decorators
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<u>" + super.getContent() + "</u>";
    }
}

class TextFormattingDemo {
    public static void main(String[] args) {
        // Create a plain text
        Text text = new PlainText("Hello, Decorator Pattern!");
        System.out.println("Plain text: " + text.getContent());

        // Apply bold formatting
        text = new BoldDecorator(text);
        System.out.println("Bold text: " + text.getContent());

        // Apply italic formatting to the bold text
        text = new ItalicDecorator(text);
        System.out.println("Bold and italic text: " + text.getContent());

        // Apply underline formatting to the bold and italic text
        text = new UnderlineDecorator(text);
        System.out.println("Bold, italic, and underlined text: " + text.getContent());

        // Create a new text with different combination of decorators
        Text anotherText = new UnderlineDecorator(
                new ItalicDecorator(
                        new PlainText("Another example")
                )
        );
        System.out.println("Underlined and italic text: " + anotherText.getContent());
    }
}

/*
Plain text: Hello, Decorator Pattern!
Bold text: <b>Hello, Decorator Pattern!</b>
Bold and italic text: <i><b>Hello, Decorator Pattern!</b></i>
Bold, italic, and underlined text: <u><i><b>Hello, Decorator Pattern!</b></i></u>
Underlined and italic text: <u><i>Another example</i></u>
 */