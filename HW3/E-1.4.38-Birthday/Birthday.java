import java.util.*;
public class Birthday
{
    public static void main(String[] args)
    {
        int n_tests = Integer.parseInt(args[0]);
        Random gen = new Random(n_tests);
        // Reminder : use (int) (gen.nextDouble() * 365) to generate a
        // random day instead of Math.random(), otherwise, you result
        // might be off from the SAG solution
        double temp0=0;
        boolean[] temp1;
        for (int i=0;i<n_tests;i++){
            temp1= new boolean[365];
            while (true){
                int a=(int) (gen.nextDouble() * 365);
                if (!temp1[a]){
                    temp1[a]=true;
                    temp0=temp0+1;
                }else{
                    break;
                }
            }
        }
        System.out.println("Average number students before having a duplicate birthday: "+(temp0/n_tests));
        // Complete the code here, see README on course website for problem description and instructions.
        return;
    }
}