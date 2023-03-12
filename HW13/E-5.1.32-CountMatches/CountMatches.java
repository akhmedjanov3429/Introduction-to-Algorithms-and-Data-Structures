import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CountMatches {
    public static void main(String[] args) { 
        int count = 0;
        String input = null;
        String regexp = StdIn.readLine();
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = null;
        
        while (StdIn.hasNextLine()) {
            input = StdIn.readLine();
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                count++;
            }
        }
        
        StdOut.println(count);
    }
}
