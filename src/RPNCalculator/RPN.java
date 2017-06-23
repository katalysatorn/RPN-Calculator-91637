/**
 * Created by katalysatorn on 18/5/17.
 */

package RPNCalculator;
import java.util.*;

public class RPN
{
    public static String DoWork(String expression) throws ArithmeticException, EmptyStackException
    {
        Stack<Double> stack = new Stack<>();
        String ans;

        for (String token : expression.split("\\s+"))
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
        ans = stack.toString();
        ans = ans.replace("[", "");
        ans = ans.replace("]", "");

        return ans;
    }
    public static void main(String[] args)
    {
        if(args.length > 0)
        {
            System.out.println(DoWork(args[0]));
        }
        else
        {
            System.out.println("No arguments supplied");
            System.out.println("This class needs an expression as an argument.");
        }
    }
}
