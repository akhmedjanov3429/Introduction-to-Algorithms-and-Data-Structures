import java.util.Stack;

public class InfixToPostfix {

    public static int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (isOperator(s)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(s)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (s.equals("(")) {
                stack.push(s);
            } else {
                postfix.append(s).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        System.out.println(postfix.toString());
    }

}
