
public class Newton {

    // task: use newtons method to find the kth root of n

    public static void main(String[] args) {

        // Raed n,k from command line
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        
        // initial_guess
        double initial_guess = Math.random() * 100; // initial value

        // smaller epsilon, denotes more accuracy
        double epsilon = 0.000001;

        // keep the result here
        double kth_root_of_n = initial_guess;
        while(true){
            double sap =kth_root_of_n;
            kth_root_of_n = (k-1)*kth_root_of_n/k + n/(k * Math.pow(kth_root_of_n, k-1));

            if (Math.abs(kth_root_of_n - sap)<epsilon) break;

        }

        // Complete the code here, see README on course website for problem description and instructions.




        
        // Don't touch from here
        
        // only print 5 digits after the decimal point (precision-wise)
        System.out.printf("%sth root of %s is %.5f\n", k, n, kth_root_of_n); 
    }
}