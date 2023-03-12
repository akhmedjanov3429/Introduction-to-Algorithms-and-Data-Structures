// Exercise 3.2.1 Rectangle
// Please fill in the perimeter(), intersects() and contains() methods.

public class Rectangle
{

    
    private final double x, y;    // center of rectangle
    private final double width;   // width of rectangle
    private final double height;  // height of rectangle
    
    // Complete the code here, see README on course website for problem description and instructions.
    public Rectangle(double x0, double y0, double w, double h)
    {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }
    
    public double area()
    {
        return width * height;
    }
    
    public double perimeter()
    {
        return 2 * (width + height);
    }
    
    public boolean intersects(Rectangle b)
    {
        // Check if the two rectangles intersect by checking if the x and y values
        // of the centers of the two rectangles are within the width and height of the other rectangle
        return Math.abs(x - b.x) <= (width + b.width) / 2 && Math.abs(y - b.y) <= (height + b.height) / 2;
    }
    
    public boolean contains(Rectangle b)
    {
        // Check if the rectangle is completely contained within the other rectangle
        // by checking if the width and height of the contained rectangle is less than or equal to
        // the width and height of the containing rectangle and the center points are equal
        return width >= b.width && height >= b.height && x == b.x && y == b.y;
    }

    public String toString() {
        return "Rectangle "+ width + "x"+ height + " centered at (" + x + ", " + y + ").";
    }
        
    public String infoString() {
        return "   perimeter = " + perimeter() + ", area = " + area();
    }

    public static Rectangle CreateRectangleFromStdin(){
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        double w = StdIn.readDouble();
        double h = StdIn.readDouble();
        return new Rectangle(x,y,w,h);
    }
    
    public static void main(String[] args)
    {
        Rectangle A =  CreateRectangleFromStdin();
        Rectangle B =  CreateRectangleFromStdin();
        System.out.println("A : " + A + A.infoString());
        System.out.println("B : " + B + B.infoString());
        
        System.out.println("A contains B: " + A.contains(B));
        System.out.println("B contains A: " + B.contains(A));
        
        System.out.println("A intersects B: " + A.intersects(B));
        System.out.println("B intersects A: " + B.intersects(A));
    }
}
