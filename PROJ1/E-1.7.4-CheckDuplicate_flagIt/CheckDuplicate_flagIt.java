import java.util.*;

class CheckDuplicate_flagIt{ 

    public static void main(String args[]){


        int[] a = new int[ args.length ]; 

        boolean foundDuplicate = false;

        for (int i = 0; i <  args.length ; i++) { 

            a[i] = Integer.parseInt(args[i]);

        }

        System.out.println(Arrays.toString(a));

        for ( int i=0;i<args.length;i++){

            if ( a[Math.abs(a[i])-1] < 0) { 
              
                foundDuplicate = true;

                break;

            } else {
                
                a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
                
            }

        }


        System.out.println(Arrays.toString(a));

        if (! foundDuplicate) 
            System.out.println("There is no duplicate value");
        else
            System.out.println("There are duplicate values");
    }

}


