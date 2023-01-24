public class Minesweeper
{
    public static void main(String[] args)
    {
        // Exercise 1.4.32 Minesweeper


        int n = Integer.parseInt(args[0]), m = Integer.parseInt(args[1]);

        // mineField[i][j]==true if there is a mine at slot (i,j)
        boolean[][] mineField = new boolean[n][m];
        
        // value is used to compute 
        int[][] value = new int[n][m];
        
        // The following code is given to read a mine-field
        // specification. See problem description for further
        // informaiton
        
        //---------------------------------------
        //  "mineField"
        //---------------------------------------
        // We use a 2D array to represent the mine field:
        //    1. mineField[i][i] == true if there is a mine in slot (i,j)
        //    2. mineField[i][i] == false if there is a no mine in slot (i,j)
        
        //-------------------------------------------------------------
        // The following code is given (don't modify) to read in the
        // specification of a mine field
        // -------------------------------------------------------------
        // See problem description for the form of the mine-field
        // specification

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
            {
                char ch = ' ';
                while (ch == ' ' || ch == '\n') ch = StdIn.readChar();
                if (ch == '*') mineField[i][j] = true;
                else mineField[i][j] = false;
            }

        // Fill in the code to compute the 2D-array 'value' 
        // Complete the code here, see README on course website for problem description and instructions.
            int temp0 = mineField.length;
            String[][] mine= new String[mineField.length][mineField[0].length];
            boolean[][] tempar = new boolean[mineField.length+2][mineField[0].length+2];  

            for (int i=0;i<mineField.length;i++){
                for (int j=0;j<mineField[0].length;j++){
                tempar[i+1][j+1]=mineField[i][j];
            }
            }
            for (int i=1;i<mineField.length+1;i++){
                for (int j=1;j<mineField[0].length+1;j++){
                    int temp1=0;
                    for (int i0=-1;i0<=1;i0++){
                        for (int j0=-1; j0<=1; j0++){
                            if (i0==0 && j0==0){
                                continue;
                            }else{
                                if(tempar[i+i0][j+j0]==true) {
                                    temp1=temp1+1;
                    }
                }
            }
        }
                    if(tempar[i][j] == true){
                        mine[i-1][j-1]="*";
                    }else{
                        if (temp1==0){
                            mine[i-1][j-1] = " ";
                        }else{
                        mine[i-1][j-1]=Integer.toString(temp1);}
                    }

                }
            }
        System.out.println("The mine-field:\n");

        //-----------------------------------------------
        // The following code print the content of 'value' 
        //-----------------------------------------------

        // Complete the code here, see README on course website for problem description and instructions.
        for (int ipp=0; ipp<mine.length; ipp++){
            for (int jpp=0; jpp<mine[ipp].length; jpp++) { 
                System.out.print(mine[ipp][jpp]);
                System.out.print(" ");
        }
        System.out.print("\n");
    }


        System.out.println();

        return;
    }
}