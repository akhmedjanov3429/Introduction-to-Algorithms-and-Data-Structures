public class BST_v2<Key extends Comparable<Key>, Value> {

    //------------------------------------------------------------
    // Instance variable: root
    //------------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.
    private Node root;



    public class Node {
        //------------------------------------------------------------
        // Instance variable: key, val, left, right
        //------------------------------------------------------------
        // Complete the code here, see README on course website for problem description and instructions.
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        //------------------------------------------------------------
        // Constructor
        //------------------------------------------------------------
        // Complete the code here, see README on course website for problem description and instructions.

        Node(Key key, Value val){
            this.key = key; 
            this.val = val;
            }

        
        public String toString() {
            return key + ":" + val;
        }
    }

    //------------------------------------------------------------
    // Instance methods ( verbatim copy from textbook )
    //------------------------------------------------------------

    public Value get(Key key) {
        

        // adapt verbatim from the textbook
        // Complete the code here, see README on course website for problem description and instructions.
        return get(root,key);



    }

    private Value get(Node x, Key key) {


        // adapt verbatim from the textbook
        // Complete the code here, see README on course website for problem description and instructions.
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return get(x.left, key);
        else if(cmp>0) return get(x.right,key);
        else return x.val;

    }

    public void put(Key key, Value val) {  


        // adapt verbatim from the textbook
        // Complete the code here, see README on course website for problem description and instructions.
        if(key==null){
            throw new IllegalArgumentException("first argument to put() is null");}
        root= put(root,key,val);

    }

    private Node put(Node x, Key key, Value val) {


        // adapt verbatim from the textbook
        // Complete the code here, see README on course website for problem description and instructions.
        if(x==null) return new Node(key,val);
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = put(x.left, key, val);
        else if(cmp>0) x.right = put(x.right, key, val);
        else x.val=val;
        return x;



    }
    
    public Iterable<Node> inOrder() {
        // adapt from textbook, and call inorder 
        // Complete the code here, see README on course website for problem description and instructions.
        Queue<Node> queue=new Queue<Node>();
        inorder(root, queue);
        return queue;


    } 
    
    public void inorder(Node node, Queue<Node> q){
        
        // Complete the code here, see README on course website for problem description and instructions.
        if(node==null)return;
        inorder(node.left,q);
        q.enqueue(node);
        inorder(node.right,q);



    }
    
    //------------------------------------------------------------
    // Does this symbol table contain the given key?
    //------------------------------------------------------------
    public boolean contains(Key key) {
        
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
        
    }

    
    //------------------------------------------------------------
    // 4.4.34 Implement a **linear-time** method height() that returns the
    // maximum number of links on any path from the root to a leaf
    // node (the height of a one-node tree is 0).”
    //
    // Excerpt From: Sedgewick, Robert,Wayne, Kevin. “Computer Science.” Apple Books. 
    //------------------------------------------------------------
    
    public int height() {
        // Complete the code here, see README on course website for problem description and instructions.
        return height_r(root);




    }
    private int height_r(Node node){
        // Complete the code here, see README on course website for problem description and instructions.
        if (node == null) return 0;
		return 1 + Math.max(height_r(node.left), height_r(node.right));

    }
    
    //------------------------------------------------------------
    // 4.4.27 Modify BST to add methods min() and max() that return
    // the smallest (or largest) key in the table (or null if no such
    // Key exists).
    //
    // Excerpt From: Sedgewick, Robert,Wayne, Kevin. “Computer Science.” Apple Books. 
    // ------------------------------------------------------------

    // ------------------------------------------------------------
    // min
    // ------------------------------------------------------------
    public Key min() {
        Key a =  min_iter(root);
        Key b = min_r(root);
        assert(a==b); // should be the same node/reference
        return a;
    }
    
    // ------------------------------------------------------------
    // min : recursive implementation
    // ------------------------------------------------------------
    private Key min_r(Node node) {
        // Complete the code here, see README on course website for problem description and instructions.
        if(node.left==null)return node.key;
        return min_r(node.left);



    }
    
    // ------------------------------------------------------------
    // min : iterative implmentation
    // ------------------------------------------------------------
    private Key min_iter(Node node){
        // Complete the code here, see README on course website for problem description and instructions
        Key dash = null;
        while (node.left != null) {
        dash= node.left.key;
        node = node.left;
    }
    return dash;

    }
   
    
    
    public static void PrintStack(Stack<Integer> stack) {

        String ws="";
        StdOut.print("stack: " );
        for(Integer i: stack){
            StdOut.print(ws+i);
            ws = " " ;
        }
        StdOut.println();
    }
    
    //-------------------------------------------------------
    // Generic method to print Iterable<Key> separted by white space
    //-------------------------------------------------------
    public static <Key> void PrintIterable(Iterable<Key> iter){

        String ws = "";
        for(Key key: iter){
            StdOut.print(ws + key);
            ws = " " ;
        }
        StdOut.println();

    }

    //-------------------------------------------------------
    // Generic method to print key/value pair of node, seperate by colon
    //-------------------------------------------------------
    public void PrintKeyValue(Iterable<Node> iter){
        
        String ws = "";
        for(Node node: iter){
            StdOut.print(ws + node);
            ws = ", " ;
        }
        StdOut.println();
        
    }
    //------------------------------------------------------------
    // Test client
    //------------------------------------------------------------
    public static void main( String [] args ) {

        // declare stack and bst here
        // Complete the code here, see README on course website for problem description and instructions.
        BST_v2<Integer, Integer> bst = new BST_v2<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();

    bst.PrintKeyValue(bst.inOrder());

        // don't touch below

        while (!StdIn.isEmpty()){
            String in = StdIn.readString();
            try { 
                if (in.equals("put") ) {
                    int key = stack.pop();
                    int val = stack.pop();
                    bst.put(key,val);
                    StdOut.printf(in +  ": (%d, %d)\n", key,val);
                } else if (in.equals("get") ) {
                    int a = stack.pop();
                    StdOut.printf(in +  " %d : %d\n", a,  bst.get(a));
                } else if (in.equals("contains") ) {
                    StdOut.println(in + ": " + bst.contains(stack.pop()));
                } 
                else if (in.equals("min")) StdOut.println(in + ": " + bst.min());
                else if (in.equals("height")) StdOut.println(in + ": " + bst.height());
                else if (in.equals("stack")) PrintStack(stack);
                else if (in.equals("inOrder")) {
                    StdOut.print(in+": ");
                    bst.PrintKeyValue(bst.inOrder());
                }
                else {
                    try { 
                        int a = Integer.parseInt(in);
                        stack.push(a);
                    } catch ( RuntimeException e) {
                        StdOut.println(in + ": unrecogized op");
                    }
                }
                //StdOut.print(in+": ");
                bst.PrintKeyValue(bst.inOrder());
            } catch (RuntimeException e) {
                
                StdOut.println("Exception: " + e + " -- " + in);
            }
        };
        
    } 
}
