public class Calculation
{
    public static void main(String[] args)
    {
        // Exercise 1.2.22 
        // Complete the code here, see README on course website for problem description and instructions.
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        double x0 = a;
        double v0 = b;
        double t = c;
        System.out.println(x0+v0*t-(9.80665*t*t)/2);
        




        return;
    }
}
