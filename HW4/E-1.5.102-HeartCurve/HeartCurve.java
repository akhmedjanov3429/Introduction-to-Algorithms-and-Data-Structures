public class HeartCurve {
    public static void main(String[] args) {
     
        String fname= args.length>0 ? args[0] : null;

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.PINK);
        int a = 1;
        
        StdDraw.setXscale(-4, +4);
        StdDraw.setYscale(-4, +4);
        double N = 360;

        double x0 = 0, y0 = 0;

        for (double t = 0.0; t <= N; t += 0.1) {
            
            // compute (x1,y1) and draw the line (x0,y0) to (x1, y1)

            // Complete the code here, see README on course website for problem description and instructions.

            double x1 = 2*a*(1-Math.cos(Math.toRadians(t)))*Math.sin(Math.toRadians(t));
            double y1 = 2*a*(1-Math.cos(Math.toRadians(t)))*Math.cos(Math.toRadians(t));
            StdDraw.line(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
            System.out.println(x0 + ", " + y0);
        


        }
        
        
        // You need to have vnc setup if run from Ubuntu or WSL
        // Remember to have `export DISPLAY=:1` in the ~/.bashrc or ~/.zshrc,
        // or, manually run `export DISPLAY=:1 
        
        StdDraw.show();
        if (fname != null) {
            StdDraw.save(fname); // fname must end with .png
            System.exit(0);
        }
        return;
    }
    


}
