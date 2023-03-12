public class Gen_Heap_BST {
    // Complete the code here, see README on course website for problem description and instructions.

    public class Node{
        public int key = -1;

        public Node left;
        public Node right;

        public Node(int key){
            this.key = key;
        }

        public void Push(int i){
            if(i < key){
                if(left==null){
                    left = new Node(i);
                }else{
                    left.Push(i); 
                }
            } 
            if(i > key){
                if(right==null){
                    right = new Node(i);
                }else{
                    right.Push(i); 
                }
            }
        }

        public String Traverse(){
            System.out.print(key+" ");
            if(this.left!=null)       this.left.Traverse();
            if(this.right!=null)      this.right.Traverse();

            return "";
        }

        public void Update(){
            
        }
    }

    public void Push(int i){
        if(root == null) root = new Node(i);
        else             root.Push(i);
    }

    public Node root;


    public static String Heap_BST(int s, int num){

        if(num-s<=0) return "";

        int root = 0;
        int number = num-s;                                                         // what is the total number of nodes
        // ignore this part if you cannot understand, try to write your own method instead.
        int full_layer = (int)Math.ceil(Math.log(number+1)/Math.log(2));         //calculate the length of full layers
        int min_layer = (int)Math.floor(Math.log(number+1)/Math.log(2));
        int reminder = number - ((int)Math.pow(2, min_layer)-1);                    // calculate the reminder nodes
        /* 
        int left_full_number = (int)Math.pow(2, full_layer-2)-1+reminder;          // calculate the left full number of the nodes
        if (reminder > __4__){
            root = (number - reminder -1)/2 + left_full_number + lo;
        }
        else{
            root = __5__;
        }
        */
        if (reminder > 0){
            if(reminder < Math.pow(2, min_layer-1)){
                root = s + (int)Math.pow(2, min_layer-1) -1 + reminder;
            }else{
                int r = reminder-(int)Math.pow(2, min_layer);
                root = s + (int)Math.pow(2, min_layer-1) -1 + (int)Math.pow(2, min_layer-1);
            }

        }else{
            root = s + number/2;
        }
/*
        StdOut.println(number);
        StdOut.println(full_layer);
        StdOut.println(min_layer);
        StdOut.println(reminder);
        StdOut.println(root); */
        //StdOut.println(left_full_number);

        //if(s+number/2 == s) return "";
        return root+" "+Heap_BST(s, root)+Heap_BST(root+1, num);
        //return "";
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int N2;
        N2 = args.length > 1 ?Integer.parseInt(args[1]):0;
        
        // Hint: Heap_BST should be recursive func with lo, hi as
        // input parameters

        String r = Heap_BST(N2, N);

        
        StdOut.println(r);
        return;
    }
}