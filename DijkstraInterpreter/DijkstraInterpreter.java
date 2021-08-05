package DijkstraInterpreter;

import java.util.Stack;

public class DijkstraInterpreter {
    public Stack<Double> number;
    public Stack<String> sign;

    DijkstraInterpreter() {
        number  = new Stack<>();
        sign = new Stack<>();
    }

    public Double getResult() {
        return this.number.pop();
    }
    public void evaluateExpression(String expression) {
        String[] arrayOfElements = expression.split(" ");
        for (String s: arrayOfElements) {
            switch (s) {
                case "(":
                    // do nothing
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    this.sign.push(s);
                    break;
                case ")":
                    String operation = this.sign.pop();
                    Double d1 = this.number.pop();
                    Double d2 = this.number.pop();
                    switch (operation) {
                        case "+" -> this.number.push(d1 + d2);
                        case "*" -> this.number.push(d1 * d2);
                        case "/" -> this.number.push(d2 / d1);
                        case "-" -> this.number.push(d2 - d1);
                    }
                    break;
                default:
                    this.number.push(Double.parseDouble(s));
                    break;
            }
        }
    }
}
