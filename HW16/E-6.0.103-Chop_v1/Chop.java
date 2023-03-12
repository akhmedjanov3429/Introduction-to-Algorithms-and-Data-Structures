public class Chop {
    public static void chop(short n) { 
        int bit_pos = 0;

        while(n!=0) {
            int x = n & 0x1;
            if(3-(bit_pos/4) < 0) 
            break;
            if (x != 0) {
                System.out.printf("%04x\n", (1 << bit_pos));
            }

            bit_pos += 1;
            n = (short) (n >> 1);
        }        
    }

    public static void main(String[] args) {
        short n = Short.parseShort(args[0], 16);
        chop(n);
    }
}

