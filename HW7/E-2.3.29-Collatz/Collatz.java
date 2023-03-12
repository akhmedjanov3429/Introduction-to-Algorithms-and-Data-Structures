public class Collatz
{
   	// Exercise 2.3.29 Collatz
       public static long [] memo = new long [40000000] ;
       // Complete the code here, see README on course website for problem description and instructions.
       public static int count = 0;
       public static void collatz2(long n)
       {
           System.out.print(n + " ");
           if (n == 1) return; 
           if (n % 2 == 0) collatz(n / 2);
           else collatz(3*n + 1);
       }
       public static void collatz(long n)
       {
           if (n == 1) {return;} 
           count++;
   
           if(n<40000000)
           if(memo[(int)n]!=0){
               count+=memo[(int)n]-1;
               return;
           }
           if (n % 2 == 0) {
               long tar = n / 2;
               collatz(tar);
               return;
           }
           else {
   
               long tar = 3*n + 1;
               collatz(tar);
               return;
           }
       }
       public static void main(String[] args) {
   
           long n = Integer.parseInt(args[0]);
           int max = 0;
           int tar = 0;
           //System.out.println(n);
           for(int i = 1; i<=n; i++)
           {       
               count = 0;
               collatz(i);
               memo[i] = count;
               if(count>max){
                   max = count;
                   //System.out.println(i+" "+max);
                   tar = i;
               }
           }
           System.out.println(tar);
           // Complete the code here, see README on course website for problem description and instructions.
       } }