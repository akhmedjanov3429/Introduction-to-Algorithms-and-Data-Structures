
public class Transposing {
    public static void print_matrix( int[][] mat, String tag) {
        System.out.println(tag);
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", mat[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        // a is a valid nxn 2D array
        int  [][] a = StdArrayIO.readInt2D();
        print_matrix(a, "Before Transposing:");
        
        // Complete the code here, see README on course website for problem description and instructions.
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;



        
        
    }
}
print_matrix(a, "After Transposing:");
}

}