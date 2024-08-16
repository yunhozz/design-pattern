package creation.builder;

// Product class
class Pizza {
    private final String dough;
    private final String sauce;
    private final String topping;

    // Private constructor to enforce the use of Builder
    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
    }

    @Override
    public String toString() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, and " + topping + " topping.";
    }

    // Builder class
    public static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String topping;

        // Methods to set pizza attributes
        public PizzaBuilder dough(String dough) {
            this.dough = dough;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder topping(String topping) {
            this.topping = topping;
            return this;
        }

        // Build method to create Pizza instance
        public Pizza build() {
            return new Pizza(this);
        }
    }
}

class PizzaBuilderDemo {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .dough("thin crust")
                .sauce("tomato")
                .topping("cheese")
                .build();

        System.out.println(pizza);
    }
}