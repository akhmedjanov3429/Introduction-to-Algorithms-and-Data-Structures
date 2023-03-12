public class BinaryRepresentation2
{

    // code-begin
    public static int recur_depth = 0 ;
    public static void main(String[] args)   {
        int n = Integer.parseInt(args[0]);
        String output = ConvertToBinary(n);
        System.out.printf("Result: %d -> %s\n", n, output);
    }
    
    public static String ConvertToBinary(int n){
        String s;
            if (n==0) {
            System.out.println("O --> 0");
                return "0";
            }
            else if (n==1) {
            System.out.println("1 --> 1");
            return "1";
}
            else {
        s = ConvertToBinary (n/2) + n%2;
        System.out.printf(" ".repeat (2*((int)Math.floor (Math.log(n)/Math.log(2)))) +"%d --> %s\n", n, s) ;
        return s;
    }
    // code-end

    }}