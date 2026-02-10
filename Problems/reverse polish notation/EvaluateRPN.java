import java.util.Stack;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If operator
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // truncates toward zero
                        break;
                }

                stack.push(result);
            }
            // If number
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // Main method (VS Code ready)
    public static void main(String[] args) {

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(tokens1)); // 9
        System.out.println(evalRPN(tokens2)); // 6
        System.out.println(evalRPN(tokens3)); // 22
    }
}
