package behavior.interpreter;

interface CalculateExpression {
    int interpret();
}

class Number implements CalculateExpression {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return this.number;
    }
}

class Add implements CalculateExpression {
    private final CalculateExpression leftExpression;
    private final CalculateExpression rightExpression;

    public Add(CalculateExpression leftExpression, CalculateExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class Subtract implements CalculateExpression {
    private final CalculateExpression leftExpression;
    private final CalculateExpression rightExpression;

    public Subtract(CalculateExpression leftExpression, CalculateExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

class CalculatorDemo {
    public static void main(String[] args) {
        // (5 + 2) - 3
        CalculateExpression five = new Number(5);
        CalculateExpression two = new Number(2);
        CalculateExpression three = new Number(3);

        CalculateExpression addExpression = new Add(five, two); // 5 + 2

        CalculateExpression subtractExpression = new Subtract(addExpression, three); // (5 + 2) - 3

        System.out.println("(5 + 2) - 3 = " + subtractExpression.interpret());
    }
}