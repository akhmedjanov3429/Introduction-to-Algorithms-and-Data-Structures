public class TuringMachine {
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachine(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        out = (ST<Character, Character>[]) new ST[n];
        for (int st = 0; st < n; st++) {
            action[st] = in.readString();
            if (action[st].equals("Halt"))
                continue;
            if (action[st].equals("Yes"))
                continue;
            if (action[st].equals("No"))
                continue;
            next[st] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }
            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
        }
    }

    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = 0;
        while (action[state].equals("L") || action[state].equals("R")) {
            if (action[state].equals("R"))
                tape.moveRight();
            if (action[state].equals("L"))
                tape.moveLeft();
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
        }
        return action[state] + " " + tape;
    }

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);
        while (StdIn.hasNextLine())
        {
            String temp= StdIn.readLine();
            if(temp.equals("-1")){
                StdOut.println("Terminated");
                break;
            }
            StdOut.println(tm.simulate(temp));
        }
    }
}