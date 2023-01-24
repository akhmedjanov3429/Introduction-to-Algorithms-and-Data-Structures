public class Triangle {
    public static void main(String[] args) {
     
        // Complete the code here, see README on course website for problem description and instructions.
        double t = Math.sqrt(3.0)/2.0;
        StdDraw.setXscale(-1, 2);
        StdDraw.setYscale(-1, 2);
        StdDraw.line(0,0,1,0);
        StdDraw.line(1,0,0.5,t);
        StdDraw.line(0.5, t, 0.0 ,0.0);
        StdDraw.point(0.5, t/3.0);



        return;
    }
}