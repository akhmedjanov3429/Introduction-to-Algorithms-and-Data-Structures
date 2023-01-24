import java.util.Random;

public class UniformRandom
{
    public static void main(String[] args)
    {
        // Exercise 1.2.30 UniformRandom
        // generate random number and print average, min and max
        
        // Get the random seed from command line options or default to 0
        int rand_seed = 0;
        if (args.length>0) rand_seed = Integer.parseInt(args[0]);

        // Initialize a random generator with a seed, to generate a
        // deterministic random sequence given the same seed.
        Random r = new Random(rand_seed);

        // Generate 3 random numbers: Instead of using Math.random(),
        // here we use r.nextDouble() to generate 3 random dobule
        // value.
        double a = r.nextDouble(), b = r.nextDouble(), c = r.nextDouble();
        

        // Now, compute Average, Min, Max of a, b, and c
        double min = Math.min(a, Math.min(b, c));
        double max = Math.max(a, Math.max(b, c));
        double Average = (a+b+c)/3;
        // Complete the code here, see README on course website for problem description and instructions.
        System.out.println("Average: " + Average);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);




        return;
    }
}