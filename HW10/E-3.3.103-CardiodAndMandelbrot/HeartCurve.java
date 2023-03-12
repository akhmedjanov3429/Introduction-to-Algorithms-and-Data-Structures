
public class HeartCurve {
	String fname;
	public HeartCurve() {}
	public void init (String [] args) {}
	public void run() {

		// Note: you need to enable double buffer for SAG to pass
		// StdDraw.enableDoubleBuffering();

		// code-begin
		StdDraw.enableDoubleBuffering();
		// code-end


		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setPenRadius(0.005);
		int a = 1;
		
		StdDraw.setXscale(-4, +4);
		StdDraw.setYscale(-4, +4);
		double N = 360;

		double x0 = 0, y0 = 0;

        for (double t = 0.0; t <= N; t += 0.1) {
            
            // compute (x1,y1) and draw the line (x0,y0) to (x1, y1)
            
            // code-begin
            double theta = Math.toRadians(t);
                
            //x = 2a(1-cos(theta)cos(theta)
            //y = 2a(1-cos(theta)sin(theta)
            double c = Math.cos(theta);
            double u = 2*a*(1-c);
            double y1 = u* c;
            double x1 = u* Math.sin(theta);
            StdDraw.line(y0+3, x0, y1+3, x1); // draw the line
            //System.out.println(x0 + ", " + y0);
            
            x0 = x1;
            y0 = y1;
            // code-end        
        }
        
        
		// You need to have vnc setup if run from Ubuntu or WSL
		// Remember to have `export DISPLAY=:1` in the ~/.bashrc or ~/.zshrc,
		// or, manually run `export DISPLAY=:1 
        
		StdDraw.show();
		if (fname != null) {
			//StdDraw.save(fname); // fname must end with .png
			//            System.exit(0);
		}
		return;
	}
	public static void main(String[] args) {
		
		String fname= args.length>0 ? args[0] : null;
		
		StdDraw.enableDoubleBuffering();
		HeartCurve h = new HeartCurve();
		h.run();
	}
}



