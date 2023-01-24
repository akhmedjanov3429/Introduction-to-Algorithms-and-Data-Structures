import java.util.Random;

public class NRandomValueAverage {
    public static void main(String[] args) {
        // Exercise 1.3.10 in textbook
        
        // Takes an Integer N as a command-line argument uses
        // Math.random() to print N uniform random values between 0
        // and 1 and then prints their average value.        
                
        int N = Integer.parseInt(args[0]);
        Random generator = new Random(N);

        // Note: use generator.nextDouble() to generate the next
        // random value for determinn istic grading
        
        // Complete the code here, see README on course website for problem description and instructions.
        double Average = 0.0;
        for(int i = 1; i <= N; i++){
            double next_value = generator.nextDouble();
            System.out.println(next_value);

            Average += next_value;
        }
        
        
        System.out.println("Average: " + Average/N);
        

        return;
    }
}
