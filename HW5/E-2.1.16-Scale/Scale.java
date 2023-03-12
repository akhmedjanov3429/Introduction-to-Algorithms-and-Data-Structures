import java.util.Arrays;

public class Scale {
    // textbook 2.1.16
    
    public static double max(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
    
            return Arrays.stream(arr).max().getAsDouble();
        }
        



    
    public static double min(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
            return Arrays.stream(arr).min().getAsDouble();
        
        



    }
    public static void scale(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
    
            double min = min(arr);
            double max = max(arr);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (arr[i] - min) / (max - min);
            }
        
        



    }

    public static void main(String[] args) {
        // Do not change this part
        double[] arr=StdIn.readAllDoubles();
        scale(arr);
        StdOut.println(Arrays.toString(arr));
    }
}