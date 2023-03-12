import java.util.Scanner;
import java.util.regex.*;

public class RE_match {
    public static void main(String[] args) {
        // check if regular expression is provided
        if (args.length == 0) {
            System.out.println("Error: Please provide a regular expression as argument.");
            return;
        }

        // compile regular expression
        Pattern pattern = Pattern.compile(args[0]);

        // read input strings from standard input
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                count++;
            }
        }

        // print number of matches
        System.out.println("#matching string: " + count);
    }
}
