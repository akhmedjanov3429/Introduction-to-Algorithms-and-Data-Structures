public class GeoHarmMean {
    public static void main(String[] args) {

        // Complete the code here, see README on course website for problem description and instructions.
        int count = 0;
        double product = 0.0;
        double harmonicSum = 0.0;

        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            if (x > 0) {
                product += Math.log(x);
                harmonicSum += 1.0 / x;
                count++;
            }
        }

        if (count > 0) {
            double geometricMean = Math.exp((product) / count);
            double harmonicMean = count / harmonicSum;
            System.out.println(geometricMean);
            System.out.println(harmonicMean);
        
        }
    }

    }
