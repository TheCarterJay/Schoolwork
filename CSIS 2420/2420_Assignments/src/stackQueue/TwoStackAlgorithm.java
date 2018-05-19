package stackQueue;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implements the two-stack algorithm from Dijkstra to
 * evaluate expressions.
 * @author User
 *
 */
public class TwoStackAlgorithm {

    public static void main(String[] args) {
        String expression = "(4 + ((6 / 2) * (5 - 2)))";
        
        StdOut.print(evaluateExpression(expression));        
    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == ' ') {
                continue;
            } else if (c == '/' || c == '+' || c == '-' || c == '*') {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                values.push(Integer.parseInt("" + c));
            } else if (c == ')') {
                eval(values, operators.pop());
            }
        }
        return values.peek();
    }

    private static void eval(Stack<Integer> values, Character operator) {
        int firstNum = values.pop();
        int secondNum = values.pop();
        int finalValue;
        
        if (operator == '+') {
            finalValue = firstNum + secondNum;
        } else if (operator == '-' ) {
            finalValue = secondNum - firstNum;
        } else if (operator == '*') {
            finalValue = firstNum * secondNum;
        } else {
            finalValue = secondNum / firstNum;
        }
        values.push(finalValue);
    }

}