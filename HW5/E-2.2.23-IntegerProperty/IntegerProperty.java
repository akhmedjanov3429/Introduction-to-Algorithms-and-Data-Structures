import java.util.*;

public class IntegerProperty
{
    public static void main(String[] args)
    {
        // don't change this 
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        System.out.println("a: "+ a);
        System.out.println("b: "+ b);
        System.out.println("isPrime(a): "+ isPrime(a));
        System.out.println("isPrime(b): "+ isPrime(b));
        System.out.println("isRelativePrime(a+b): " + isRelativePrime(a, b));
        
        System.out.print("distinct factors of (a): ");
        for (int f : factor(a)) 
            System.out.print(f + " "); 
        System.out.println();
                
        System.out.print("distinct factors of (b): ");
        for (int f : factor(b)) 
            System.out.print(f + " "); 
        System.out.println();

        System.out.println("gcd(a+b): " + gcd(a, b));
        System.out.println("lcm(a+b): "+ lcm(a, b));
        System.out.println("phi(a): "+ phi(a));
        System.out.println("phi(b): "+ phi(b));
    }

    // Exercise 2.2.23 IntegerProperty
    // create the functions below: isPrime(), isRelativePrime(), factor(), gcd(), lcm(), phi()
    
    public static boolean isPrime(int x) // is prime?
    {
        // Complete the code here, see README on course website for problem description and instructions.
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
    public static boolean isRelativePrime(int a, int b) // is relative prime?
    { // Complete the code here, see README on course website for problem description and instructions.
        return gcd(a, b) == 1;
    }
    public static int[] factor(int x) // get all distinct factors
    {// Complete the code here, see README on course website for problem description and instructions.
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= x / i; i++) {
                if (x%i==0) {factors.add(i);}
                while(x % i == 0){ x/=i; }

            }
        
        if (x > 1) {
            factors.add(x);
        }
        return factors.stream().mapToInt(i -> i).toArray();
    }   
    public static int gcd(int a, int b) // greatest common divisor
    { // Complete the code here, see README on course website for problem description and instructions.
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static long lcm(int a, int b) // least common multiplier
    {// Complete the code here, see README on course website for problem description and instructions.
        return (long) a * b / gcd(a, b);
    }
    public static long phi(int x) // Euler's totient function
    {
        // Complete the code here, see README on course website for problem description and instructions.
        long result = x;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                while (x % i == 0) {
                    x /= i;
                }
                result -= result / i;
            }
        }
        if (x > 1) {
            result -= result / x;
        }
        return result;
    }

}