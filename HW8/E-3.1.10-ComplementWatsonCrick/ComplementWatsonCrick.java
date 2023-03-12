public class ComplementWatsonCrick
{
    public static void main(String[] args) {
        // Exercise 3.1.10 ComplementWatsonCrick
        // TODO: your own description
        
        String s = StdIn.readString();
            
        System.out.println( Complement(s));
    } 
    
    public static String Complement(String s){
        // Complete the code here, see README on course website for problem description and instructions.

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A') sb.append('T');
            else if(c == 'T') sb.append('A');
            else if(c == 'C') sb.append('G');
            else if(c == 'G') sb.append('C');
        }
        return sb.toString();
    


    }
}