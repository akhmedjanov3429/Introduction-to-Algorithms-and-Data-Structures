
public class LinkedList<Item extends Comparable> {
    //-------------------------------------------------------
    // Instance varaibles
    //-------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.
   int N; // number of elements in the linked list
     // reference to the first node




    
    //-------------------------------------------------------
    // Private class Node
    //-------------------------------------------------------

    // Complete the code here, see README on course website for problem description and instructions.

    private class Node {
        Node next;
        Item val;
        public Node(Item val)
        {this.val=val;}
    }
    private Node first;
    //-------------------------------------------------------
    // Constructor (can be optional)
    //-------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.


    //-------------------------------------------------------
    // Add element to the head of the list
    //-------------------------------------------------------
    public void add( Item item ) {
        // Complete the code here, see README on course website for problem description and instructions.

       Node u = new Node(item);
       u.next=first;
       first=u;
       ++N;


    }

    //-------------------------------------------------------
    // Remove the first element
    //-------------------------------------------------------
    public void remove() {
        // Complete the code here, see README on course website for problem description and instructions.

        
            first = first.next;
            --N;


    }    

    //-------------------------------------------------------
    // Count: count number of elements in the list
    //-------------------------------------------------------
    public int size(){
        // Complete the code here, see README on course website for problem description and instructions.
        return N;



    }
    //-------------------------------------------------------
    // is empty
    //-------------------------------------------------------
    public boolean isEmpty(){
        // Complete the code here, see README on course website for problem description and instructions.


        return N==0;

    }

    //-------------------------------------------------------
    // Count: count
    //-------------------------------------------------------
    public int count() {
        assert ( count1() == N);
        assert ( count2() == N);
        return N;
    }

    //-------------------------------------------------------
    // Count: iterative implementation
    //-------------------------------------------------------
    public int count1 (){
        // Complete the code here, see README on course website for problem description and instructions.

       Node u = first; int res =0;
       while(u!=null){
        ++res;
        u=u.next;
       }
       return res;
    }
    //-------------------------------------------------------
    // Count: method2 
    //-------------------------------------------------------
    public int count2 (){
        return count_r(first);
    }

    //-------------------------------------------------------
    // Recursive implementation of count
    //-------------------------------------------------------
    public  int count_r(Node  node){
        // Complete the code here, see README on course website for problem description and instructions.


        if (node == null)  return 0;
            return 1 + count_r(node.next);
        
    }
    
    //-------------------------------------------------------
    // Return the max element value
    //-------------------------------------------------------
    public Item maxItem () {
        Node r = maxNode1(first);
        Node s = maxNode2(first);
        if (r!=null) assert (r.val .equals(s.val));
        
        
        // requires both maxNode method return the same Node reference
        assert (r == s);
        
        if (r==null) return null;
        return r.val;
    }
    
    //-------------------------------------------------------
    // Return the node with the max element value: iterative implementation
    //-------------------------------------------------------
    // need to return the same Node as maxNode2
    public Node maxNode1(Node node){
        // Complete the code here, see README on course website for problem description and instructions.

        if(node==null)return null;
        Node res = node, u =node.next;
        while(u!=null){
            if(u.val.compareTo(res.val)>0)
            res=u;
            u=u.next;
        }
    return res;


    }
    //-------------------------------------------------------
    // Return the node with the max element value: method2
    //-------------------------------------------------------
    public Node maxNode2(Node  node){
        return maxNode_r(node);
    }

    //-------------------------------------------------------
    // Return the node with the max element value: recursive implementation
    //-------------------------------------------------------
    public Node maxNode_r(Node  node){
        // Complete the code here, see README on course website for problem description and instructions.

        if (node == null)return null;
        Node u =maxNode_r(node.next);
        if(u==null||node.val.compareTo(u.val)>0) return node;
        else return u;


    }

    //-------------------------------------------------------
    // Find if an elements exists
    //-------------------------------------------------------
    public boolean find (Item item) {
        // Complete the code here, see README on course website for problem description and instructions.
        Node u = first;
        while (u != null) {
          if (u.val==item) return true;
          u=u.next;
          }
        return false;
      



    }

    //-------------------------------------------------------
    // Delete the ith element using recursion
    //
    // Note: the first element is 0_th element 
    //-------------------------------------------------------
    public void deleteKth ( int k) {
        if (k>=N) return ;
        if (k == 0) first = first.next;
        else deleteKth_r(first, k);
        N--;
    }

    //-------------------------------------------------------
    // Delete the ith element using iterative method
    //-------------------------------------------------------
    public void deleteKth_iter ( int k) {

        // Note: just return if k >= N

        // case spit:
        // 1. k==0
        // 2. k!=0

        // Complete the code here, see README on course website for problem description and instructions.
    
        if (k >= N) return;
        --N;
        if (k == 0) {
            first = first.next;
        return;
        }
        Node u = first.next, v = first;
        while (u != null) {
        --k;
        if (k == 0) {
        v.next = u. next;
        return;
        }
        u = u.next; v = v.next;
        }
        return;
    }

    //-------------------------------------------------------
    // Delete the ith element using recursion
    //-------------------------------------------------------
    public Node deleteKth_r(Node node, int k) {
        // Complete the code here, see README on course website for problem description and instructions.
        if (k == 1) {
            Node u = node. next;
            node. next = u. next;
            return u;}
            return deleteKth_r(node.next,k-1);
    }
    
    //-------------------------------------------------------
    // Return the head of the list
    //-------------------------------------------------------
    public Item head() {
        // Complete the code here, see README on course website for problem description and instructions.
return first.val;
    }
    
    //-------------------------------------------------------
    // Print the list items from first to last, separated by one space
    //-------------------------------------------------------
    public void show() {
        // Complete the code here, see README on course website for problem description and instructions.

show(first);


    }
    
    public void show(Node node){
        if(node ==null) {
            System.out.println(" nil");
            return ;
        }
        
        System.out.print(" " + node.val + " ->");
        show(node.next);
    }
    //-------------------------------------------------------
    // Print the content of the stack, separated by one space (hint: use Stack's iterator())
    //-------------------------------------------------------
    public static void PrintStack(Stack<Integer> stack) {
        StdOut.println(stack.toString());
        return ;
    }

    //-------------------------------------------------------
    // Test client
    //-------------------------------------------------------
    public static void main( String [] args ) {
        Stack<Integer> stack = new Stack<Integer>();
        LinkedList<Integer> lst = new LinkedList<Integer> ();
        while (!StdIn.isEmpty()){
            String a = StdIn.readString();
            //StdOut.println("a="+ a);
            try { 
                if (a.equals("add"))  {
                    if (!stack.isEmpty()){
                        StdOut.print("add: ...  ");
                        Integer b = stack.pop();
                        StdOut.print(b);
                        lst.add(b);
                        //StdOut.print("add ");
                        //lst.show();
                        StdOut.println(" ... done");
                    }else {
                        StdOut.println(" ... ignored(stack empty)");
                    }
                } /*else if (a.equals("remove"))  {
                    StdOut.print("remove: ...  ");
                    if (!stack.isEmpty()){
                        Integer b = stack.pop();
                        StdOut.print(b);
                        lst.remove(b);
                        StdOut.println(" ... done");
                    } else {
                        StdOut.println(" ... ignored(stack empty)");
                    }
                } */
                else if ( a.equals("remove") ) {
                    StdOut.print("remove: ... ");
                    lst.remove();
                    StdOut.println("done");
                } else if ( a.equals("size") ) StdOut.println("size: " + lst.size());
                else if ( a.equals("count") ) StdOut.println("count: " + lst.count());
                else if ( a.equals("deleteKth") ) {
                    int kth = stack.pop();
                    lst.deleteKth(kth);
                    StdOut.println("deleteKth k=" + kth );
                }
                else if ( a.equals("deleteKth_iter") ) {
                    int kth = stack.pop();
                    lst.deleteKth_iter(kth);
                    StdOut.println("deleteKth_iter k=" + kth );
                }
                else if ( a.equals("head") ) StdOut.println("head: " + lst.head());                
                else if ( a.equals("find") ) StdOut.println("find: " + lst.find(stack.pop()));
                else if (a.equals("show") )  {
                    StdOut.print("show: ");
                    lst.show();
                } else if ( a.equals("max") )  StdOut.println("max: " + lst.maxItem());               
                else if(a.equals("stack"))   {
                    StdOut.print("stack: " );
                    PrintStack(stack);
                } else {
                    stack.push(Integer.parseInt(a));
                } 
            } catch (RuntimeException e) {
                StdOut.println("Exception: " + e);
            } 
        }
    }
}
