package behavior.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Abstract Expression
interface Expression {
    void interpret(Map<String, Integer> context);
}

// Terminal Expression for Integer Values
class IntegerExpression implements Expression {
    private final int value;

    public IntegerExpression(int value) {
        this.value = value;
    }

    @Override
    public void interpret(Map<String, Integer> context) {
        // Do nothing, value is already set
    }

    public int getValue() {
        return value;
    }
}

// Terminal Expression for Variables
class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public void interpret(Map<String, Integer> context) {
        // Do nothing, variable will be looked up when needed
    }

    public String getName() {
        return name;
    }
}

// Non-terminal Expression for Assignment
class AssignmentExpression implements Expression {
    private final VariableExpression variable;
    private final Expression value;

    public AssignmentExpression(VariableExpression variable, Expression value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public void interpret(Map<String, Integer> context) {
        if (value instanceof IntegerExpression) {
            context.put(variable.getName(), ((IntegerExpression) value).getValue());
        } else if (value instanceof VariableExpression) {
            String varName = ((VariableExpression) value).getName();
            context.put(variable.getName(), context.get(varName));
        }
    }
}

// Non-terminal Expression for Print
class PrintExpression implements Expression {
    private final Expression expression;

    public PrintExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void interpret(Map<String, Integer> context) {
        if (expression instanceof IntegerExpression) {
            System.out.println(((IntegerExpression) expression).getValue());
        } else if (expression instanceof VariableExpression) {
            String varName = ((VariableExpression) expression).getName();
            System.out.println(context.get(varName));
        }
    }
}

// Program class to represent a sequence of statements
class Program implements Expression {
    private final List<Expression> expressions = new ArrayList<>();

    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    @Override
    public void interpret(Map<String, Integer> context) {
        for (Expression expression : expressions) {
            expression.interpret(context);
        }
    }
}

// Interpreter class
class Interpreter {
    public static void interpret(String input) {
        Map<String, Integer> context = new HashMap<>();
        Program program = new Program();
        String[] lines = input.split(";");

        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("print")) {
                String varName = line.split(" ")[1];
                program.addExpression(
                        new PrintExpression(
                                new VariableExpression(varName)
                        )
                );
            } else if (line.contains("=")) {
                String[] parts = line.split("=");
                String varName = parts[0].trim();
                String value = parts[1].trim();

                if (value.matches("\\d+")) {
                    program.addExpression(
                            new AssignmentExpression(
                                    new VariableExpression(varName),
                                    new IntegerExpression(Integer.parseInt(value))
                            )
                    );
                } else {
                    program.addExpression(
                            new AssignmentExpression(
                                    new VariableExpression(varName),
                                    new VariableExpression(value)
                            )
                    );
                }
            }
        }
        program.interpret(context);
    }
}

// Client code
class InterpreterProgramDemo {
    public static void main(String[] args) {
        String program = """
            x = 5;
            y = 10;
            z = x;
            print x;
            print y;
            print z
            """;
        Interpreter.interpret(program);
    }
}