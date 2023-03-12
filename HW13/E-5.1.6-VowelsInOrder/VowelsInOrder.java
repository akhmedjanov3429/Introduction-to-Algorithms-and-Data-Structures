public class VowelsInOrder {
    public static void main(String[] args) {
        String arg = args[0];
        String regexp = "^[^aeiou]*a[^aeiou]*e[^aeiou]*i[^aeiou]*o[^aeiou]*u[^aeiou]*$";
        if (arg.matches(regexp)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
