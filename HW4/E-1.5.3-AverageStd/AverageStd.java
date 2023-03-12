

public class AverageStd {
    public static void main(String[] args) {
        
        double[] input = StdIn.readAllDoubles();
        
        int n = input.length;
        StdOut.println("Total number read: " + n);
        double sum = 0;
        for (double i : input) {
            sum += i;
        }
        double avg = sum / n;
        StdOut.println("Average: " + avg);
        double stdDev = 0;
        for (double i : input) {
            stdDev += (i - avg) * (i - avg);
        }
        stdDev = Math.sqrt(stdDev / (n - 1));
        StdOut.println("Standard Deviation: " + stdDev);
    }
}
