import java.util.Arrays;

public class Reverse
{
    public static void main(String[] args)
    {

        int n = args.length;
        
        String[] arr ;          // declare an array variable
        arr = new String[n];      // initialization               
        for(int i=0; i<n; i++){
            arr[i]=args[n-i-1];
        }

        // Complete the code here, see README on course website for problem description and instructions.



        
        // Print out the array elements
        for (int i=0;i < arr.length; i++) {
            System.out.print(arr[i] + '\n');
        }
        System.out.println();

        return;
    }
}