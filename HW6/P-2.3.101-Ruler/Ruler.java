public class Ruler {

    public static int depth=0;
    public static String ruler(int n) {
        if (n == 0) {
            return "\n";
        } else {
            return ruler(n-1) + " ".repeat(2*depth - 2*n) + n + ruler(n-1);
        }
    }

    

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        depth = n;
        System.out.println(ruler(n));
    }
}
