import java.util.*;
class CheckDuplicate_sortInPlace{
    public static void Swap(int []a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]){

        int [] a = new int [args.length+1];

        // read in the inputs
        
        for (int i = 0; i < args.length; i++) 

             a[i+1] = Integer.parseInt(args[i]);


        for (int i = 1; i < a.length ; i++) { // same as previous exercise

            if (  a[i] > a[i-1] ) continue;

            if ( a[i] == a[i-1]) {

                System.out.println(Arrays.toString(a));

                System.out.println("There are duplicate values");

                return;
            }

            Swap(a, i , i-1 ) ;

            i=0;       // hint: do something with i here
        }

        System.out.println(Arrays.toString(a));
        System.out.println("There is no duplicate value");
    }
}
