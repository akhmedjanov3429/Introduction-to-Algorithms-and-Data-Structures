import java.util.Arrays;

public class MergeSort {

    int [] aux;

    //---------------------------------------------------
    // Top level mergeSort routine
    //---------------------------------------------------
    public void mergeSort(int[] a) {


        // Step 1. Allocate the aux array


        aux = new int[a.length];



        int len = 1 ;
        

        
        /* Step 2. By the merge sort, we are generating the following
          range in the nested loop
          
            [0,1), [1,2), [2,3), [3,4)
            [0,2), [2,4), [4,6), [6,8), [8,10), [10,12) ...
            [0,4), [4,8), [8,12), [12,16), ....
            [0,8), [8,16), [16,24), [24,32) ...
            
            And call merge on each of the ranges
        */
        while (len < a.length)  {
            

            
            for (int i = 0; i < a.length - len; i += 2*len ) {



                int lo = i, mid = i + len, hi = Math.min(a.length, i + 2*len);

                // call merge
                merge( a, lo, mid, hi) ;
            }
            

            len = len * 2 ;
        }
    }

    //---------------------------------------------------
    // Merge two already sorted regions: a[i:i+len] and a[i+len:a+len*2]
    //---------------------------------------------------
    public void merge(int[] a, int lo, int mid, int hi) {

        // Exactly the same as in the textbook, except modify it to
        // consider mid and hi can be out-of array length.

        mid = Math.min(a.length, mid);
        hi = Math.min(a.length, hi);

        // The rest of the code is the same as in the textbook for the
        // merge(int[]a, int i, int len);
        
        // Merge a[lo, mid) with a[mid, hi) into aux[0, hi-lo).
        int i = lo, j = mid, N = hi - lo;
        
        for (int k = 0; k < N; k++)
            {
                if      (i == mid) aux[k] = a[j++];
                else if (j == hi)  aux[k] = a[i++];
                else if (a[j]< a[i]) aux[k] = a[j++];
                else    aux[k] = a[i++];
            }
        // Copy back into a[lo, hi)
        for (int k = 0; k < N; k++)
            a[lo + k] = aux[k];
    }


    //---------------------------------------------------
    // Test Client : Don't modify anything below this line. 
    //---------------------------------------------------
    public static void main(String args[]) {
        MergeSort mer = new MergeSort();
        int[] arr = StdIn.readAllInts();
        System.out.println("OriginalArray:" + Arrays.toString(arr));
        mer.mergeSort(arr);
        System.out.println("SortedArray:" + Arrays.toString(arr));
    }
    
}

