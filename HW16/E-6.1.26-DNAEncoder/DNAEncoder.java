public class DNAEncoder
{
    //------------------------------------------
    // Instance Variables
    //------------------------------------------
    private int[] dnaIntArray;
    private int length;

    //------------------------------------------
    // Constructor
    //------------------------------------------
    public DNAEncoder(String dnaString) {
        length = dnaString.length();
        int intArrayLength = (length + 15) / 16;
        dnaIntArray = new int[intArrayLength];

        for (int i = 0; i < length; i++) {
            int index = i / 16;
            int offset = (i % 16) * 2;
            char c = dnaString.charAt(i);
            int value = 0;
            if (c == 'A') {
                value = 0;
            } else if (c == 'C') {
                value = 1;
            } else if (c == 'G') {
                value = 2;
            } else if (c == 'T') {
                value = 3;
            }
            dnaIntArray[index] |= (value << offset);
        }
    }

    //------------------------------------------
    // Method
    //------------------------------------------
    public char charAt(int i) {
        int index = i / 16;
        int offset = (i % 16) * 2;
        int value = (dnaIntArray[index] >> offset) & 3;
        if (value == 0) {
            return 'A';
        } else if (value == 1) {
            return 'C';
        } else if (value == 2) {
            return 'G';
        } else {
            return 'T';
        }
    }

    public int indexOf(String pattern) {
        DNAEncoder d = new DNAEncoder(pattern);
        for (int i = 0; i <= length - d.length; i++) {
            boolean eq = true;
            for (int j = 0; j < d.length; j++) {
                if (this.charAt(i + j) != d.charAt(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                return i;
            }
        }
        return -1;
    }

    // Don't touch beyond this line
    public String toString() {
        char[] ret = new char[length];
        for (int i = 0; i < length; i++) {
            ret[i] = charAt(i);
        }
        return String.copyValueOf(ret);
    }

    //------------------------------------------
    // Test client
    //------------------------------------------
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        DNAEncoder encoder = new DNAEncoder("");
        while (!StdIn.isEmpty()) {
            String next = StdIn.readString();
            if (next.equals("new")) {
                String t = stack.pop();
                encoder = new DNAEncoder(t);
            } else if (next.equals("toString")) {
                System.out.println(encoder);
            } else if (next.equals("charAt")) {
                int n = Integer.parseInt(stack.pop());
                System.out.println(encoder.charAt(n));
            } else if (next.equals("indexOf")) {
                System.out.println(encoder.indexOf(stack.pop()));
            } else {
                stack.push(next);
            }
        }
    }
}
