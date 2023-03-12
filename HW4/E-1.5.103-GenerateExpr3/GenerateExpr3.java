import java.util.*;
public class GenerateExpr3
{
    public static void main(String[] args)
    {
        int n = args.length>0?  Integer.parseInt(args[0]) : 10;
        int maxValue = 100 ; // Integer.MAX_VALUE;
        char []ops = { '+', '-', '*', '/', '%'};
        
            // use a seeded random generator, call r.nextDouble()
    Random r = new Random(n);
    
    // Complete the code here, see README on course website for problem description and instructions.
    int i;
    for (i = 0; i < n; i++) {
        int a = (int)(maxValue * r.nextDouble());
        int b = (int)(maxValue * r.nextDouble());
        int c = (int)(maxValue * r.nextDouble());

        char  op1 = ops[(int)(ops.length * r.nextDouble())];
        char  op2 = ops[(int)(ops.length * r.nextDouble())];

        if (op1 == '/' || op1 == '%') {
            if (b == 0) {
                i--;
                continue;
            }
        }

        if (op2 == '/' || op2 == '%') {
            if (c == 0) {
                i--;
                continue;
            }
        }
        System.out.println(a + " " + op1 + " " + b + " " + op2 + " " + c);
    }
}



    }
