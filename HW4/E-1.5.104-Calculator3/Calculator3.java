
public class Calculator3
{
    public static void main(String[] args)
    {
        // Complete the code here, see README on course website for problem description and instructions.
 while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            char op1 = StdIn.readString().charAt(0);
            int b = StdIn.readInt();
            char op2 = StdIn.readString().charAt(0);
            int c = StdIn.readInt();

            boolean result = true;
            if (op2 == '%' || op2 == '/' || op2 == '*') {
                if (op1 == '*' || op1 == '/' || op1 == '%'){
                result = true;
            } else {
                result = false;
            }
        }else{
            result = true;
        }
        if(!result){
            int bc = calculate(b, op2, c) ;
            int abc = calculate(a, op1, bc);
            System.out.println(a+" "+op1+" "+b+" "+op2+" "+c+" = "+abc);
        }else{
            int ab = calculate(a, op1, b) ;
            int abc = calculate(ab, op2, c);
            System.out.println(a + " " + op1 + " " +b+ " " + op2 + " " +c+ " = " +abc);
        }

        }
    }
   
    public static int calculate(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            default:
                return 0;
        }
    }
    
        
}

