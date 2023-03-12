public class LCS_R
{
    public static void main(String[] args)  {
        String a = args[0];
        String b = args[1];

        String ret = LCS_r(a,b);
        System.out.println(ret);
    }
    
    public static String LCS_r(String x, 
                               String y) {

        // Complete the code here, see README on course website for problem description and instructions.


        int m = x.length();
        int n = y.length();
        if (m == 0 || n == 0) {
            return "";
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return LCS_r(x.substring(0, m - 1), y.substring(0, n - 1))
                    + x.charAt(m - 1);
        }
        String lcs1 = LCS_r(x, y.substring(0, n - 1));
        String lcs2 = LCS_r(x.substring(0, m - 1), y);
        return (lcs1.length() > lcs2.length()) ? lcs1 : lcs2;
    

    }
}