public class Generator {
    public static String 
        randomString(int L, String alpha) {
        char[] a = new char[L];

        // random sample of L chars
        for (int i = 0; i < L; i++) {
            int t = 
                StdRandom.uniform(alpha.length());
            a[i] = alpha.charAt(t);
        }
        return new String(a);
    }
    public static void main(String[] args)
    {
        // number of strings
        int N = Integer.parseInt(args[0]); 
        
        // length of the string
        int L = Integer.parseInt(args[1]); 
        
        // alphabet
        String alpha = args[2];
        
        for (int i = 0; i < N; i++){
            StdOut.println(randomString(L, alpha));
        }
    }
}

// Generate 100 strings from ABC with length=10
// python3 ~/cjava.py Generator.java 100 10 ACTG
