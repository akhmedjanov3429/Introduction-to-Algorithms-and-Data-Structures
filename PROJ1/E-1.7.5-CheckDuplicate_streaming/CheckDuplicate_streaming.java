import java.util.*;
class CheckDuplicate_streaming { 

    public static void main(String args[]){


        boolean [] a = new boolean [ args.length ];   // same as previous exercise


        boolean foundDuplicate = false;
        
        for (int i = 0; i <  args.length ; i++) { // same as previous exercise


            int v = Integer.parseInt(args[i]);
            
            
            if ( a[v-1] ) { 
                
                foundDuplicate = true;
                
                break;

            } 
            
            a[v-1] = true ;

        }

        System.out.println(Arrays.toString(a));

        if (! foundDuplicate) 
            System.out.println("There is no duplicate value");
        else
            System.out.println("There are duplicate values");

    }

}


