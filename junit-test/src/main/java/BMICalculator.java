import java.util.Comparator;
import java.util.List;

public class BMICalculator {

    private static final double BMI_THRESHOLD = 25.0;


    //we dont need BMICalculator instance to use it so static
    public static boolean isDietRecommended(double weight, double height) {
        if(height == 0.0) throw new  ArithmeticException();
        double bmi = weight / (height * height);
        return !(bmi < BMI_THRESHOLD);
    }

    public static Coder findCoderWithWorstBMI(List<Coder> coderList) {
        return coderList.stream()
                .sorted(Comparator.comparing(BMICalculator::calculateBMI))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    private static double calculateBMI(Coder coder) {
        double height = coder.getHeight();
        double weight = coder.getWeight();
        if(height == 0.0) throw new ArithmeticException();
        double bmi = weight / (height * height);
        return Math.round(bmi);
    }

    public static double[] getBMIScore(List<Coder> coders) {
        double[] bmiScores = new double[coders.size()];
        for(int i = 0; i < bmiScores.length; i++) {
            bmiScores[i] = BMICalculator.calculateBMI(coders.get(i));
        }
        return bmiScores;
    }
}
