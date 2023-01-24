public class GreatCircle {
    public static void main(String[] args) {

        // Compute distance

        // Complete the code here, see README on course website for problem description and instructions.
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double distance1= Math.acos(Math.sin(x1) * Math.sin(x2)+ Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        double distance2 = Math.toDegrees(distance1);
        double distance3 = 60*distance2;
        
        System.out.println(distance3 + " nautical miles");
    }
}
