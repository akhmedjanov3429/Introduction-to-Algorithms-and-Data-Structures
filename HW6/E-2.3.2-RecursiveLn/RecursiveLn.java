public class RecursiveLn{
    
    public static double recursiveLn(int n){
        // 
        // Complete the code here, see README on course website for problem description and instructions.
        if(n == 1) return 0;
        else return Math.log(n) + recursiveLn(n-1);



    }
    
    public static void  main(String[] args){
        // Do not change this part
        int n = Integer.parseInt(args[0]);
        System.out.println(recursiveLn(n));
    }
}