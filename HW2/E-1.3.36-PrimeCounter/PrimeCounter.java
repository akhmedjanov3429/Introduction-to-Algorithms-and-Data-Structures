public class PrimeCounter {
    // task: Write a program PrimeCounter that takes an integer
    // command-line argument n and finds all primes less than or equal to
    // n.
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // Complete the code here, see README on course website for problem description and instructions.
        for (int i = 2; i <= n; i++) {
            boolean a = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                System.out.print(i + " ");
            }
        }
    }
}
