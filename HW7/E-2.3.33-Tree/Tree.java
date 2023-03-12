public class Tree {

    public static void tree(int n, double x, double y, double a, double branchRadius) {

        double bendAngle   = Math.toRadians(15);
        double branchAngle = Math.toRadians(37);
        double branchRatio = 0.65; 

        // coordinates of the tip of the trunk base on the angle and radius
        double cx = x + Math.cos(a) * branchRadius; 
        double cy = y + Math.sin(a) * branchRadius;
        
        StdDraw.setPenRadius(0.001 * Math.pow(n+1, 1.2)); // thickness of the trunk
        
        StdDraw.line(x, y, cx, cy); // draw the trunk
                
        if (n == 0) return;

        // Next, we are recursively draw 3 branches 
        
        // 0. The starting point is (cx, cy)

        // -- The order of recursive call need to follow this order to pass SAG
        // 1. middle branch's angle is a + bendAngle
        // 2. right branch 's angle is a + bendAngle - branchAngle
        // 3. left branch's angle is a + bendAngle +  branchAngle

        // 4. middle branch 's radius is branchRadius * (1 - branchRatio));
        // 5. both left and right  branch's radius is branchRadius * branchRatio

        /*
          Note: The order of above 2,3,4  is important to pass SAG. 
         */
        // Complete the code here, see README on course website for problem description and instructions.

        // Complete the code here, see README on course website for problem description and instructions.
// draw the middle branch
tree(n-1, cx, cy, a + bendAngle, branchRadius * (1 - branchRatio));

// draw the right branch
tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);

// draw the left branch
tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);




    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        String fname= args.length>1 ? args[1] : null;

        if (fname != null) 
            StdDraw.enableDoubleBuffering();

        // The tree stands in the middle at the bottom the canvas, growing vertically upward.
        tree(n, 0.5, 0, Math.PI/2, 0.3); 

        StdDraw.show();
        if (fname != null) {
            StdDraw.save(fname); // fname must end with .png
            System.exit(0);
        }
    }
}