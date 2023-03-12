public class DesignSquares {
    public static void main(String[] args) {
        String fname = null;
        if (args.length > 0) {
            fname = args[0];
            if (!fname.endsWith(".png")) {
                System.out.println("Error: file name must end with .png");
                System.exit(1);
            }
        }

        // Set canvas size and background color
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setXscale(-0.05, 1.05);
        StdDraw.setYscale(-0.05, 1.05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(.5, .5, .5);

        // Draw gray square
        StdDraw.setPenColor(StdDraw.GRAY);
        double[] ax = {0.25, 0.75, 0.75, 0.25};
        double[] ay = {0.25, 0.25, 0.75, 0.75};
        StdDraw.filledPolygon(ax, ay);

        // Draw white squares
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] bx = {0.0, 0.25, 0.25, 0.0};
        double[] by = {0.0, 0.0, 0.25, 0.25};
        double[] cx = {1.0, 0.75, 0.75, 1.0};
        double[] cy = {1.0, 1.0, 0.75, 0.75};
        StdDraw.filledPolygon(bx, by);
        StdDraw.filledPolygon(cx, cy);

        // Display drawing and save to file if specified
        StdDraw.show();
        if (fname != null) {
            StdDraw.save(fname);
            System.exit(0);
        }
   
    }}