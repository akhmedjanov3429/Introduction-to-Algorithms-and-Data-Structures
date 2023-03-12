public class BinaryRepresentation
{

    public static int recur_depth = 0 ;
    public static void main(String[] args)   {
        int n = Integer.parseInt(args[0]);
        String output = ConvertToBinary(n, recur_depth);
        System.out.println("Result: " + n + " -> " + output);
    }

    public static String ConvertToBinary(int n, int depth) {
        String s; 
        depth++;
        if (n==0){
        System.out.println(" ".repeat (2*depth-2) + "O --> 0");
        return "0";}
        else if (n==1) {
        System.out.println(" ".repeat(2*depth-2) + "1 --> 1");
        return "1";
        }
        else {
        s = ConvertToBinary (n/2, depth) + n%2;
        System.out.printf(" ".repeat(2*depth-2) + "%d --> %s\n", n, s);
        return s;
        }
    }
}
