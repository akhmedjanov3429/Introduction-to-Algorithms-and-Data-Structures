public class Reversename
{
    public static void main(String[] args)    {
        // Exercise 3.1.17 Reversename
        
        String a = args[0];
        

        System.out.println(reverseName(a));

        return;
    }
    public static String reverseName(String sequence) {
        // Complete the code here, see README on course website for problem description and instructions.

        String[] parts = sequence.split("\\.");
        StringBuilder reversed = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            reversed.append(parts[i]);
            if (i > 0) {
                reversed.append(".");
            }
        }
        return reversed.toString();
    }


    }
