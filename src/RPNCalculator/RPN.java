package RPNCalculator;

import java.util.*;

/**
 * Created by katalysatorn on 18/5/17.
 */
public class RPN
{
    public static String DoWork(String expr) throws ArithmeticException, EmptyStackException
    {
        Stack<Double> stack = new Stack<>();

        for (String token : expr.split("\\s+"))
        {
            switch (token)
            {
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
        return stack.toString();
    }
}
