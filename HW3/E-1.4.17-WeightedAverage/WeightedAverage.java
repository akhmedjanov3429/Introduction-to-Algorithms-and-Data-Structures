public class WeightedAverage
{
    public static void main(String[] args)
    {
        // Exercise 1.4.17 WeightedAverage

        // the following code read the weight array -- don't modify
        double[] weights = StdArrayIO.readDouble1D();
        
        // assert weights.length == raw_exam_score[0].length
        double [][] raw_exam_score = StdArrayIO.readDouble2D();
        
        // Complete the code here, see README on course website for problem description and instructions.
        double[] weightedAverages = new double[raw_exam_score.length];
for (int i = 0; i < raw_exam_score.length; i++) {
    double sum = 0;
    for (int j = 0; j < raw_exam_score[i].length; j++) {
        sum += raw_exam_score[i][j] * weights[j];
    }
    weightedAverages[i] = sum;
}

for (int i = 0; i < weightedAverages.length; i++) {
    System.out.println(weightedAverages[i]);
}




        return;
    }
}