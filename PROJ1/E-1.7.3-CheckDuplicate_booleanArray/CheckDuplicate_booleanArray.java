
import java.util.*;
class CheckDuplicate_booleanArray{

    public static void main(String args[]){


        int[] a = new int[ args.length ];


        for (int i = 0; i < args.length; i++) {

            a[i] = Integer.parseInt(args[i]);

        }

        System.out.println(Arrays.toString(a));

        boolean  [] seen = new boolean[args.length];


        for (int i = 0; i < args.length; i++) {

            if (seen[a[i]-1] == true) {
                
                System.out.println(Arrays.toString(seen));
                
                System.out.println("There are duplicate values");
                
                return ;
                
            } 

            seen[a[i]-1] =true;

        } 

        System.out.println("There is no duplicate value");
        
    }

}


