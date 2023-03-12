import java.util.Random;
public class Grid extends Const{
    public static Random rGen= new Random(1023);
    //----------------------------------------------------------------
    // Check if the grid is full of none-zeros
    //----------------------------------------------------------------
    public static int fill_count(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        int c = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++)
                if(grid[i][j]!=0) c++;
        }
        return c;
    } 

    //----------------------------------------------------------------
    // Total score is the sum of all cells
    //----------------------------------------------------------------
    public static int score(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        return Array.sum(grid);
    } 

    //----------------------------------------------------------------
    // Maximum label on the grid
    //----------------------------------------------------------------
    public static int max_label(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.

return Array.max(grid);
    } 

    //----------------------------------------------------------------
    // Return nums of empty tiles (grid[i][j] == 0)
    //----------------------------------------------------------------
    public static int empty_count(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        int n=grid.length*grid[0].length;
        return n-fill_count(grid);
    } 

    //----------------------------------------------------------------
    // Return true if cells are filled, otherwise false
    //----------------------------------------------------------------
    public static boolean full(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        if (empty_count(grid)==0) return true;
        else return false;
    } 

    //----------------------------------------------------------------
    // Check if the player has reach the winning_label
    //----------------------------------------------------------------
    public static boolean win(int [][] grid, int winning_label) {
        // Complete the code here, see README on course website for problem description and instructions.

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                if(grid[i][j]==winning_label) return true;}}

        return false;
    } 

    //----------------------------------------------------------------
    // Game over if the grid can no-longer be changed 
    //
    // The condition would be either full() and no 2 adjacent cell has
    // the same non-zero value
    // ----------------------------------------------------------------
    public static boolean game_over(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        boolean go= true;
        if(full(grid)){
        outterloop:
        for (int i =0;i<grid.length-1;i++){ 
            for (int j=0;j<grid[0].length; j++){
        if(grid[i][j]==grid[i+1][j]){
        go=false;
        break outterloop;}}}
        if (go=true){ outterloop:
        for (int i =0;i<grid. length; i++){
        for (int j =0; j<grid[0]. length-1;j++){
        if(grid[i][j]==grid[i][j+1]){
        go=false;
        break outterloop;}}}}
    } 
    else{go=false;}
return go;}
    public static boolean game_over_R(int [][] grid, int x, int y) {

        if(x == grid.length-1 || x == grid.length-1) return true;
        if(grid[x][y] == grid[x+1][y] || grid[x][y] == grid[x][y+1]) return false;

        return game_over_R(grid, x+1, y) && game_over_R(grid, x, y+1);
    }
    //----------------------------------------------------------------
    // Print the grid with a msg tag
    //----------------------------------------------------------------
    public static void print_grid(int [][] grid, String msg){
        
        print_grid(grid, -1,-1, msg);
        
    }

    //----------------------------------------------------------------
    // Print the grid and indicate (x,y) is newly created
    //----------------------------------------------------------------
    public static void print_grid(int [][] grid, int x, int y, String msg) {

        /*
          This is to use Tabulate.Tabulate2 to print the grid in
          formatted table.

          To indicate the newly created-tile, this has the following feature
         
          if (x,y) is a legal cell coordinate, it would print '()`
          surronding the value at grid[x][y])
        */
        // Complete the code here, see README on course website for problem description and instructions.

        StdOut.println(msg+":");
        String [][]g =new String [grid. length][grid[0]. length];
        for (int m=0;m<grid.length;m++){
        for (int n=0;n<grid. length; n++){
        if (m==x&n==y)g[m][n]="("+String.valueOf(grid[m][n])+")" ;
        else g[m] [n]=String. valueOf(grid[m][n]);}}
        Tabulate.Tabulate(g);}

    //----------------------------------------------------------------
    // Check if the two grids are the same: 
    //    a[i][j] == b[i][j] for all (i,j) in a
    //----------------------------------------------------------------
    public static boolean eq_grid(int [][] a, int[][]b){
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i = 0; i<a.length; i++)
            for(int j = 0; j<a.length; j++)
                if(a[i][j]!=b[i][j]) return false;


        return true;
    }


    //----------------------------------------------------------------
    // Update the grid from a move
    //----------------------------------------------------------------
    public static void update_grid(int [][] grid, int move){

        // Note : move is one of the values from UP, DONW, LEFT, RIGHT
        // from Const.java

        // Complete the code here, see README on course website for problem description and instructions.
        switch(move){
            case UP:
                Player.move_up(grid);return;
            case DOWN:
                Player.move_down(grid);return;
            case LEFT:
                Player.move_left(grid);return;
            case RIGHT:
                Player.move_right(grid);return;
        }



    }

    //----------------------------------------------------------------
    // Update the grid from a move
    //----------------------------------------------------------------
    public static void main(String [] args) {
        // read the two array and does the following
        int N = 6;
        // read the two array and does the following
        if (args.length>0) {
            N = Integer.parseInt(args[0]);
            rGen = new Random(N);
            Player.rGen = new Random(N);
            Array.rGen = new Random(N);
        }

        
        int [][] m = new int [4][4];
        Player.rand_fill(m, 5);
        Array.print_2d(m, "grid");
        
        print_grid(m, 1,2, "marked_grid");
        print_grid(m, "unmarked_grid");
        
        StdOut.println("fill_count: " +  fill_count(m));
        StdOut.println("max_label: " +  max_label(m));
        StdOut.println("win: " +  win(m,32));
        StdOut.println("game_over: " +  game_over(m));
        StdOut.println("full: " +  full(m));
        StdOut.println("empty_count: " +  empty_count(m));
        StdOut.println("game_over: " +  game_over(m));

        update_grid(m, RIGHT);
        print_grid(m, "RIGHT move");
        update_grid(m, LEFT);
        print_grid(m, "LEFT move");
        update_grid(m, UP);
        print_grid(m, "UP move");
        update_grid(m, DOWN);
        print_grid(m, "DOWN move");
    } 
} ;