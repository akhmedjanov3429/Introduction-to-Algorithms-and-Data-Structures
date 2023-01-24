public class OrderCheck
{
    public static void main(String[] args)
    {
        // Exercise 1.2.28 OrderCheck
        // check if the three arguments are strictly ascending or descending 

        // Complete the code here, see README on course website for problem description and instructions.
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);
    
        boolean ascending = (x < y && y < z);
        boolean descending = (x > y && y > z);
        boolean result = ascending || descending;
    
        System.out.println(result);





        return;
    }
}