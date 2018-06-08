/**
 * Code for the RPN function of the program
 * 
 * @author katalysatorn, Blair Burton <blair.burton@outlook.com>
 * @since 1.0
 */
package RPNCalculator;

import java.util.*;

public class RPN {
    /**
     * Works an RPN expression
     * 
     * @param {String} expression Expression to be worked out
     * 
     * @throws ArithmeticException
     * @throws EmptyStackException
     * 
     * @returns {String} Answer to the question
     */
    public static String DoWork (String expression) throws ArithmeticException, EmptyStackException {
        Stack<Double> stack = new Stack<>();
        String ans;

        for (String token : expression.split("\\s+")) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;

                case "^":
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;

                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        ans = stack.toString();
        ans = ans.replace("[", "");
        ans = ans.replace("]", "");

        return ans;
    }

    public static void main (String[] args) {
        if (args.length > 0) {
            System.out.println( DoWork(args[0]) );
        } else {
            System.out.println("No arguments supplied");
            System.out.println("This class needs an expression as an argument.");
        }
    }
}
