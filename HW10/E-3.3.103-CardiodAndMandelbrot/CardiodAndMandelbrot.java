public class CardiodAndMandelbrot {
	public static void main(String[] args) {
     
			
		// This code should not be changed, 
		// Modify HeartCurve.java to draw/overlay the cardioid 

		Mandelbrot m = new Mandelbrot();
		m.run();

		HeartCurve h = new HeartCurve();
		h.run();
		
		// Save the image to file and close the window
		if (args.length >0) {
			StdDraw.save(args[0]);
			System.exit(0);
		} else{
			
		}
		return;
	}
}