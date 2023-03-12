public class EulerFunction{
    // Complete the code here, see README on course website for problem description and instructions.
    public static int euler(int n) {
        int result = n;
        for (int i = 2; i <= n / i; i++) {
        if (n % i == 0) {
        while (n % i == 0) {
        n /= i;
        }
        result -= result / i;
        }
        }
        if (n > 1) {
        result -= result / n;
        }
        return result;
        }



    public static void main(String[] args) {
        // Do not change this
        int n=Integer.parseInt(args[0]);
        System.out.println(euler(n));
    }
	
}
