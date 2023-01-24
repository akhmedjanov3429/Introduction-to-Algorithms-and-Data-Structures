public class PrimeFactor {
    // task: Write a program PrimeCounter that takes an integer
    // command-line argument n and finds all primes less than or equal to
    // n.
    public static void main(String[] args) {
        // Complete the code here, see README on course website for problem description and instructions.
        long n = Long.parseLong(args[0]);
        int a = 0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                a+=1; 
            }
            while(n%i == 0){
                n=n/i;    
            }       
        }
        if (n!=1){
            a+=1;
        }
        System.out.println(args[0]+" has "+a+ " distinct prime factors.");
    }
}


//public class PrimeFactor {
    // task: Write a program PrimeCounter that takes an integer
    // command-line argument n and finds all primes less than or equal to
    // n.
    
   // public static void main(String[] args) {
        
        // Complete the code here, see README on course website for problem description and instructions. 
        //long n = Long.parseLong(args[0]);   
       // int a = 0;   
       // for(int i=2;i<=Math.sqrt(n);i++){
      //      if(n % i == 0){
       //        a+=1; 
       //     }
     //       while(n%i == 0){
       //         n=n/i;    
      //      }       
       //                       }       
        //                if (n != 1) a=a+1;     
                        
        //                System.out.println(args[0] + " has " + a + " distinct prime factors.");
       //             }
       //              }