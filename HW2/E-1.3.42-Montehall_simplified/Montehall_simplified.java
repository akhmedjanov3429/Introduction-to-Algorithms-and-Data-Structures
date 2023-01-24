import java.text.DecimalFormat;
import java.util.Random;
public class Montehall_simplified {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        float percentage1 = 0;
        float percentage2 = 0;
        DecimalFormat df = new DecimalFormat("##.##");// for formating percentage to 2 decimal places
        
        int seed = Integer.parseInt(args[0]);
        Random generator = new Random(seed);
        
        // Note: use generator.nextDouble() to generate a random number
        // between 0 and 1.
        
        // Complete the code here, see README on course website for problem description and instructions.
        int prize=0;
        for(int i=0; i<n; i++){
            int first = generator.nextInt(3);
            if(first==prize){percentage1+=100/(float)n;}
            int second = first==prize ? generator.nextInt(2)+1 :prize;
            if(second==prize){percentage2+=100/(float)n;}
        }
        
        System.out.println("Sucess rate of no switch: " + df.format(percentage1) + "%");
        System.out.println("Sucess rate of switching gate: " + df.format(percentage2) + "%");
        
    }
}