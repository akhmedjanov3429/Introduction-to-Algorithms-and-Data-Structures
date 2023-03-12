public class LongestPlateau
{
    public static void main(String[] args)
    {
        // Exercise 1.4.23 LongestPlateau

        int maxPlateauLen = 0;         // max record
        int maxPlateauStartPos = -1;

        // Read the terrain info from command line 
        int[] A = new int[args.length];
        for (int i = 0 ; i < args.length ; i++){
            A[i] = Integer.parseInt(args[i]);        
        }
        
        // Complete the code here, see README on course website for problem description and instructions.

        int len = 1;
        int start = 0;
        boolean one = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                if(one==true){
                len++;}
        } else {
            if(A[i] > A[i - 1]){
                one=true;
                len=1;
                start=i;}
            
            if(A[i] < A[i - 1]){
                if(len>maxPlateauLen){
                    maxPlateauLen=len;
                    maxPlateauStartPos = start;
                }
                one=false;
            }
            
        }
       
    }
     
    if(len>maxPlateauLen){
        maxPlateauLen=len;
        maxPlateauStartPos = start;}

        System.out.println("maxPlateauLen = "  + maxPlateauLen);
        System.out.println("startPos = " + maxPlateauStartPos);
        return;
    }
}