public class Ruler {

    public static String ruler(int n) {

        if (n == 0) {
            return " ";
        } else {
            String prefix = "";
            for (int i = 0; i < n - 1; i++) {
                prefix += " ";
            }
            return ruler(n-1) + prefix + n + "\n" + ruler(n-1);
        }
    }     
    public static void main(String[] args) {
 
        int n = Integer.parseInt(args[0]);
        System.out.println("Ruler of " + n + ":");
        System.out.println("==========");
        System.out.println(ruler(n));
    }
}
