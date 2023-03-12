import java.util.*;

public class HamDistance {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String s = args[1];
        int n = s.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < n; j++) {
                b.append((i & (1 << j)) != 0 ? '1' : '0');
            }
            int distance = hammingDistance(s, b.toString());
            if (distance <= k) {
                result.add(b.toString());
            }
        }
        System.out.println(String.join("\n", result));
    }

    static int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
