public class LRS_v2 {

    public static String lcp(LazyString s, LazyString t)    {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i).toString();
        return s.substring(0, N).toString();
    }
    
    public static String lrs(String s)
    {
        int N = s.length();
        LazyString[] suffixes = new LazyString[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = new LazyString(s, i, N);
    
        MergeLazyString.sort(suffixes);
        String lrs = "";
        for (int i = 0; i < N-1; i++)
            {
                String x = lcp(suffixes[i], suffixes[i+1]);
                if (x.length() > lrs.length()) lrs = x;
            }
        return lrs;
    }
    
   
    
    

    //---------------------------------
    // Test client
    //--------------------------------
    public static void main(String[] args)
    {
        String s= StdIn.readAll();
        
        StdOut.println(lrs(s));
    }
}
