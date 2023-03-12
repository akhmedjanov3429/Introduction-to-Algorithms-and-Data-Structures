public class DFA {

    private int start;
    private String[] action;
    private ST<Character, Integer>[] next;

    public DFA(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        this.start=in.readInt();
        action = new String[n];
        next = (ST<Character,Integer>[])new ST[n];
        for (int state = 0; state < n; state++) {
            action[state] = in.readString();
            next[state]=new ST<Character,Integer>();
            for(int i = 0; i<alphabet.length(); i++ ){
                next[state].put(alphabet.charAt(i),in.readInt());
            }}
        }
    public String recognizes(String input) {
        int state = start;
        for(int i =0; i<input.length();i++){
            System.out.print(state);
            state = next[state].get(input.charAt(i));
            System.out.print(" #"+input.charAt(i)+"-> ");
        }
        System.out.print(state+" ");
        if(action[state].equals("True")){
            return "Yes";
        }else{
            return "No";
        }}
    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);
        while (!StdIn.isEmpty()) {
    System.out.println(dfa.recognizes(StdIn.readLine()));
        
        }}
}
