public class ParathesesCompleter {
    public static void main(String[] args)
    {
        Stack<String> elements = new Stack<>();
        Stack<String> operator = new Stack<>();
        String []sx = StdIn.readAllStrings();
        
        // Complete the code here, see README on course website for problem description and instructions.
        for (String token : sx) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("sqrt")) {operator.push(token);}
             else if (token.equals(")")) {
                String op = operator.pop();
                String e1 = elements.pop();
                String e2 = elements.pop();
                elements.push("(" + e2 + op + e1 + ")");
            } else {
                elements.push(token);
            }
        }

        System.out.println(elements.pop());
    



        return;
    }
}