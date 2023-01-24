class CheckDuplicate{

    // Textbook Exercise 1.4.33
    // 
    
    public static void main(String args[]){
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        boolean hasDuplicate = false;

        // Complete the code here, see README on course website for problem description and instructions.
        for (int i=0;i<args.length;i++){
            if (a[Math.abs(a[i])-1]<0){
                hasDuplicate=true;
                break;
            }else{
                a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
            }
        }
        if (hasDuplicate){
            System.out.println("There are duplicate values");
        }
        else {
            System.out.println("There is no duplicate value");
        }
        
    }
    
}