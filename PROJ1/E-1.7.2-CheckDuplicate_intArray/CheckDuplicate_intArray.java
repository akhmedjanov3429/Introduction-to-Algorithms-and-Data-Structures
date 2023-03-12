import java.util.*;

class CheckDuplicate_intArray{

    public static void main(String args[]){
        
        // Fill in the blanks

        int[] a = new int[args.length];// same as previous exercise


        for (int i = 0; i <args.length; i++) { // same as previous exercise


            a[i] = Integer.parseInt(args[i]); // same as previous exercise


        }

        int [] counter = new int[a.length];


        for ( int i = 0; i < a.length; i++) {


            counter[Math.abs(a[i])-1] += 1;

        }

        System.out.println(Arrays.toString(counter));

        for (int i = 0; i < counter.length; i++) {


            if (counter[i] > 1 ) {


                System.out.println("There are duplicate values");


                return;

            }
        }

        System.out.println("There is no duplicate value");
    }
}
