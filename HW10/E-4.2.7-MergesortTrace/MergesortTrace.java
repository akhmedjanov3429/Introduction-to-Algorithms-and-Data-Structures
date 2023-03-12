public class MergesortTrace {
    // Complete the code here, see README on course website for problem description and instructions.
    public static void main(String[] args) {
        String[] list = StdIn.readAllStrings();
        printR(list);
        sort(list);      
    }
    public static void printR(String[] row){
        for (int i = 0; i < row.length; i++) {
            StdOut.print(row[i]+" ");
        }
        StdOut.println();
    }
    public static void sort(String[] a){
        String[] aux = new String[a.length];
        sort(a,aux,0,a.length);
    }
    public static void sort(String[] a, String[] aux,int lo, int hi){
        if(hi-lo<=1) return;
        int mid=lo+(hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid,hi);
        int i=lo,j=mid;
        for(int k=lo;k<hi;k++){
            if(i==mid) aux[k]=a[j++];
            else if(j==hi) aux[k]=a[i++];
            else if(a[j].compareTo(a[i])<0) aux[k]=a[j++];
            else aux[k]=a[i++];
        }
        System.out.print(" ".repeat(lo*a[0].length())+" ".repeat(lo));
        for(int k=lo;k<hi;k++){
            a[k]=aux[k];
            System.out.print(aux[k]+" ");
        }
        System.out.println();
    }
}