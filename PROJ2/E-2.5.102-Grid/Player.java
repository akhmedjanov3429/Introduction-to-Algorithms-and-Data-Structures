import java.util.Random;

public class Player {

    public static Random rGen = new Random(1023);

    public static void move_left(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            move_left(grid[i]);
        }
    }

    //----------------------------------------------------------------
    // User press 'a' to move all cells to the left
    //
    // Implement this with a combination of merge and Array.collapse.
    //
    // Need to collapse before and after the merge
    //
    //----------------------------------------------------------------
    public static void move_left(int[] row) {
        // Collapse the row to the left
        Array.collapse(row);

        // Merge the cells that can be merged
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] *= 2;
                row[i + 1] = 0;
            }
        }

        // Collapse the row to the left again
        Array.collapse(row);
    }

    //----------------------------------------------------------------
    // User press 'd' to move all cells to the right
    //
    // Implementation: reverse each row (Array.mirror2D_LR), move_left, reverse back
    //----------------------------------------------------------------
    public static void move_right(int[][] grid) {
        // Mirror the grid from left to right
        Array.mirror2D_LR(grid);

        // Move the cells to the left
        move_left(grid);

        // Mirror the grid back from right to left
        Array.mirror2D_LR(grid);
    }

    //----------------------------------------------------------------
    // User press 'w' to move all cells up
    //
    // Implementation: Array.transpose, move_left, Array.transpose
    //----------------------------------------------------------------
    public static void move_up(int[][] grid) {
        // Transpose the grid
        Array.transpose(grid);

        // Move the cells to the left
        move_left(grid);

        // Transpose the grid back
        Array.transpose(grid);
    }

    //----------------------------------------------------------------
    // User press 's' to move all cells down
    //
    // Implementation: Array.transpose, move_right, Array.transpose
    //----------------------------------------------------------------
    public static void move_down(int[][] grid) {
        // Transpose the grid
        Array.transpose(grid);

        // Move the cells to the right
        move_right(grid);

        // Transpose the grid back
        Array.transpose(grid);
    }

    //----------------------------------------------------------------
    // Random fill (for testing use)
    //----------------------------------------------------------------    
    public static void rand_fill(int[][] grid, int max) {
        Array.rand_fill(grid, 0, max, rGen);
        Array.print_2d(grid, "rand_fill raw");

        // If grid[i][j] is not 0, change it to 2^grid[i][j] ( use Math.pow)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    grid[i][j] = (int) Math.pow(2, grid[i][j]);
                }
            }
        }
    }
    //----------------------------------------------------------------
    // Test client
    //----------------------------------------------------------------    
    public static void main(String [] args) {
        
        int N = 6;
        // read the two array and does the following
        if (args.length>0) {
            N = Integer.parseInt(args[0]);
            rGen = new Random(N);
        }
        int [][] m = new int [4][4];
        rand_fill(m, 5);
        Array.print_2d(m, "grid");
        

        move_left(m);
        Array.print_2d(m, "move LEFT");
        move_left(m);
        Array.print_2d(m, "move LEFT");
        
        move_right(m);
        Array.print_2d(m, "move RIGHT");
        move_right(m);
        Array.print_2d(m, "move RIGHT");
        
        move_up(m);
        Array.print_2d(m, "move UP");
        move_up(m);
        Array.print_2d(m, "move UP");
        
        move_down(m);
        Array.print_2d(m, "move DOWN");
        move_down(m);
        Array.print_2d(m, "move DOWN");


    }
} ;