import java.util.Arrays;
public class WCPalindrome
{
    public static void main(String[] args) {
        // Exercise 3.1.11 WCPalindrome
        // Do not change this part
        System.out.println(isWatsonCrickPalindrome(args[0]));
        
        return;
    }

    public static boolean isWatsonCrickPalindrome(String sequence) {
    // Complete the code here, see README on course website for problem description and instructions.

    String complement = Complement(sequence);
    String reverse = Reverse(complement);
    return sequence.equals(reverse);
}

public static String Complement(String sequence) {
    char[] charArray = sequence.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
        switch (charArray[i]) {
            case 'A':
                charArray[i] = 'T';
                break;
            case 'T':
                charArray[i] = 'A';
                break;
            case 'C':
                charArray[i] = 'G';
                break;
            case 'G':
                charArray[i] = 'C';
                break;
        }
    }
    return new String(charArray);
}

public static String Reverse(String sequence) {
    return new StringBuilder(sequence).reverse().toString();
}


}