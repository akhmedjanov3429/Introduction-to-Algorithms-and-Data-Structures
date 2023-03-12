public class LazyString {
    private final String parent;
    private final int start;
    private final int length;

    public LazyString(String parent, int start, int length) {
        this.parent = parent;
        this.start = start;
        this.length = length;
    }

    public LazyString(String parent) {
        this(parent, 0, parent.length());
    }

    public int length() {
        return length;
    }

    public char charAt(int index) {
        return parent.charAt(start + index);
    }

    public String toString() {
        return parent.substring(start, start + length);
    }

    public LazyString substring(int startIndex, int endIndex) {
        return new LazyString(parent, this.start + startIndex, endIndex - startIndex);
    }

    public LazyString substring(int startIndex) {
        return new LazyString(parent, this.start + startIndex, length - startIndex);
    }

    public int compareTo(LazyString other) {
        int length = Math.min(this.length, other.length);
        for (int i = 0; i < length; i++) {
            if (this.charAt(i) != other.charAt(i)) {
                return this.charAt(i) - other.charAt(i);
            }
        }
        return this.length - other.length;
    
}

    //---------------------------------------------
    // Test client 
    //---------------------------------------------
    public static void main(String [] args){
        String x = args.length>0? args[0] : "abcdef";
        String y = args.length>1? args[1] : "bcdefg";
        LazyString a = new LazyString(x);
        LazyString b = new LazyString(y);
        StdOut.println("LazyString a: " + a);
        StdOut.println("a.charAt(3): " + a.charAt(3));
        StdOut.println("LazyString a.substring(1): " + a.substring(1));
        StdOut.println("LazyString a.substring(1, 5): " + a.substring(1,5));
        StdOut.println("LazyString x.substring(1, 5): " + x.substring(1,5));
        StdOut.println("LazyString a.substring(1, 5).substring(2): " + a.substring(1,5).substring(2));
        StdOut.println("LazyString a.substring(1, 5).substring(2, 4): " + a.substring(1,5).substring(2,4));
        StdOut.println("LazyString x.substring(1, 5).substring(2, 4): " + x.substring(1,5).substring(2,4));
        StdOut.println("LazyString a.substring(1, 5).substring(2): " + x.substring(1,5).substring(2));
        StdOut.println("LazyString a.substring(1, 5).charat(2): " + x.substring(1,5).charAt(2));
        StdOut.println("LazyString a.substring(1, 5).substring(2).toString().equals(x.substring(1,5).substring(2)): " + a.substring(1, 5).substring(1).toString().equals(x.substring(1,5).substring(1) ));

        StdOut.println("LazyString a.substring(0, 3): " + a.substring(0,3));
        StdOut.println("LazyString a.substring(0): " + a.substring(0));
        StdOut.println("LazyString b: " + b);
        StdOut.println("LazyString b.legnth: " + b.length);
        StdOut.println("a.compareTo(b): " + a.compareTo(b));
        StdOut.println("b.compareTo(a): " + b.compareTo(a));
        StdOut.println("LazyString a.substring(1): " + a.substring(1));
        StdOut.println("LazyString b.substring(0,b.length-1): " + b.substring(0,b.length-1)) ;
        StdOut.println("a.substring(1).compareTo(b.substring(0,b.length-1)): " + a.substring(1).compareTo(b.substring(0,b.length-1)));

    }
} ;