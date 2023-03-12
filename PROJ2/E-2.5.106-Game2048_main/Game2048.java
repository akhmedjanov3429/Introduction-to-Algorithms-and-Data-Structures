import java.util.Random;

public class Game2048 extends Const{
    
    public static int [][] grid;
    public static int [][] old;
    public static int [] new2;

    public static Random rGen ;
    public static int seed;
    
    public static boolean conf_GUI = false;
    public static boolean conf_useStdIn = false;
    public static boolean conf_Debug = false;

    public static int validRoundCount  = 0 ;
    public static int tileSum = 0 ;

} ;
