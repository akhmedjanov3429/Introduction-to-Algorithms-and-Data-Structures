
import java.util.*;

public class Tabulate {

    //--------------------------------------------------
    // static variables
    //--------------------------------------------------
    // fix-me
    public static final String COLUMNDELIMITER = ";";
    public static final int SEP_WIDTH=2;
    //--------------------------------------------------
    // Read a CSV file as a String[][]
    //--------------------------------------------------
    public static String[][] ReadCSV(String fname){
        // first read the file to get how many rows/lines in the file
        int nRows = CountCsvRows(fname);

        // Read nRows from the CSV (including the header line)
        return ReadCSV(fname, nRows);
    }
    //--------------------------------------------------
    // Read a CSV file as a String[][]
    //--------------------------------------------------
    public static String[][] ReadCSV(String fname , int nRows){
        // To convert a line into String[], use     
        // String [] row = line.split(COLUMNDELIMITER, -1);    
        // Complete the code here, see README on course website for problem description and instructions.
        In fp = new In(fname);
        String[][] data = new String[nRows][];

        for(int i = 0; i < nRows; i++) {
            String line = fp.readLine();
            String[] row = line.split(COLUMNDELIMITER, -1);
            data[i] = row;
        }
        return data;
    }   
    //--------------------------------------------------
    // Count the number of rows in the file, use In.java
    //
    // Call In.readLne() , In.isEmpty()
    //--------------------------------------------------
    public static int CountCsvRows(String fname ) { 
        // open the file as an input stream, see In.java
       In fp = new In(fname);  
        // In.java is provided with StdLib by textbook site
        // This function returns how many times you can call
        // fp.readLine() befoe fp.isEmpty()
        // Complete the code here, see README on course website for problem description and instructions.
        int nRows = 0;
        while(!fp.isEmpty()) {
            fp.readLine();
            nRows++;
        }
        return nRows;
    }
    //--------------------------------------------------
    // Tabulate the CSV as a 2D array: rows[0] is the header row
    //
    // call Tabulate(body,header)
    //--------------------------------------------------
    public static void Tabulate(String[][] rows) {

        // This should separate rows into header, and body and call
        // Tabulate(body, header)
        // Complete the code here, see README on course website for problem description and instructions.
        String[] header = rows[0];
        String[][] body = new String[rows.length - 1][];
        for(int i = 1; i < rows.length; i++) {
            body[i-1] = rows[i];
        }
        Tabulate(body, header);
    }
    //--------------------------------------------------
    // Tabulate the CSV as a 2D array: rows[0] is the header row
    //
    // call PrintRow, PrintDashSeparator
    //--------------------------------------------------
    public static void Tabulate(String [][] body , String[] header) {
        int[] wx = MaxWidth (body, header); // maxwidth   
        PrintRow(header, wx, "|");
        PrintDashSeparator(wx);
        for (String[] i: body) {     
            PrintRow(i, wx, "|"); 
        } 
    } 
    //--------------------------------------------------
    // Print a row given the separator and columnWidth
    //--------------------------------------------------
    public static void PrintRow(  String[] row, int[] columnWidth, String separator){

        // Note: The actual separator needs be padded as follows:
        //  " ".repeat(SEP_WIDTH) + separator+ " ".repeat(SEP_WIDTH);
        
        // Complete the code here, see README on course website for problem description and instructions.

        for(int i = 0; i<row.length; i++){
            System.out.print(PadOnLeft(row[i], columnWidth[i]));
            if(i!=row.length-1) System.out.print(" ".repeat(SEP_WIDTH)+separator+" ".repeat(SEP_WIDTH));
        }
        System.out.print('\n');

    }
    //--------------------------------------------------
    // Pad a string with spaces on the left
    // Example : PadOnLeft("abc", 4) returns " " + "abc", a string of length 4
    //--------------------------------------------------
    public static String  PadOnLeft(String a, int width){
        // pad the string on the left side up to width:     
        //i.e. " ".repeat(width-a.length()) + a
        assert width >= a.length();
        int len = (""+a).length();
        return " ".repeat(width - a.length()) + a;
    }
    //--------------------------------------------------
    // Compute the maximum string width per column, includes the header
    // 
    // will call UpdateMaxWidth
    //--------------------------------------------------
    public static int[] MaxWidth( String[][] body, String[] header){
        // You should use UpdateMaxWidth to calculate this, first run
        // on the header and then iterate on the rows
        
        // MaxWdith of 2D array 
        // String[][] a =  { { "1","12", "123"},
        //                   {"3455", "4", "34"}
        //                 } 
        // is and an int[3] with `[4,2,3]`.
        // Complete the code here, see README on course website for problem description and instructions.
        int[] width = new int[header.length];
        UpdateMaxWidth(width, header);
        for(String[] row : body){
        UpdateMaxWidth(width, row);
        }
        return width;
    }
    //--------------------------------------------------
    // Given existing columnWidth, update it with a new row
    //--------------------------------------------------
    public static void UpdateMaxWidth( int [] columnWidth,  String [] row ){
        // Example: columnWidth is {2, 5, 4}
        //          row is { "Alice", "Bob", "Carrie"} 
        // columnWidth is updated to {5, 5, 6}
        for (int i=0;i<columnWidth.length;i++) {
            columnWidth[i] = Math.max(columnWidth[i], row[i].length());
        }
        return ;
    }
    //--------------------------------------------------
    // Print '------+------+----...' the separator line after header row
    //--------------------------------------------------
    public static void PrintDashSeparator(int[] columnWidth){
        
        // The  separator between dashes needs be padded as follows:
        //  "-".repeat(SEP_WIDTH) + "+"+ "-".repeat(SEP_WIDTH);
        
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i = 0; i<columnWidth.length; i++){
            if(i==0||i==columnWidth.length-1){
                System.out.print("-".repeat(columnWidth[i]+SEP_WIDTH*1));
            }else{
                System.out.print("-".repeat(columnWidth[i]+SEP_WIDTH*2));
            }

            if(i!=columnWidth.length-1) System.out.print("+");
        }
        System.out.print("\n");


    }
    //--------------------------------------------------
    // main 
    //--------------------------------------------------
    public static void main(String[] args) {    
        String  fname = args[0];
        String[][] k= ReadCSV(fname);   
        StdOut.println("Debug prints(content of csv file)");
        StdOut.println("-".repeat(60));
        // debug prints
        for (String[] i :k)
            StdOut.println(Arrays.toString(i));
        StdOut.println();
        StdOut.println();
        Tabulate(k);

        return;
    }
}