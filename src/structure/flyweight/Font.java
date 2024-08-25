package structure.flyweight;

import java.util.HashMap;

// Flyweight interface
interface Font {
    void apply(String text);
}

// ConcreteFlyweight class
class ConcreteFont implements Font {
    private final String font;
    private final int size;
    private final String color;

    public ConcreteFont(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    @Override
    public void apply(String text) {
        System.out.println("Text: '" + text + "' with Font: " + font + ", Size: " + size + ", Color: " + color);
    }
}

// Flyweight Factory class
class FontFactory {
    private static final HashMap<String, Font> fontMap = new HashMap<>();

    public static Font getFont(String font, int size, String color) {
        String key = font + size + color;
        Font fontObject = fontMap.get(key);
        if (fontObject == null) {
            fontObject = new ConcreteFont(font, size, color);
            fontMap.put(key, fontObject);
            System.out.println("Creating font: " + key);
        }
        return fontObject;
    }
}

class FontDemo {
    public static void main(String[] args) {
        Font font1 = FontFactory.getFont("Arial", 12, "Black");
        font1.apply("Hello, World!");

        Font font2 = FontFactory.getFont("Arial", 12, "Black");
        font2.apply("Flyweight Pattern");

        Font font3 = FontFactory.getFont("Times New Roman", 14, "Blue");
        font3.apply("Design Patterns");

        Font font4 = FontFactory.getFont("Arial", 12, "Black");
        font4.apply("Another Text");

        // The output will show that the same font objects are being reused
    }
}