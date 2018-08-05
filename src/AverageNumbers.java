import java.util.Arrays;

public class AverageNumbers {




    public static void main(String[] args) {

        System.out.println(Arrays.toString(averages(new int[]{1, 3, 5, 1, -10})));

    }
    public static double[] averages(int[] numbers) {

        double[] averageNumbers = new double[numbers.length-1];
        for (int i = 0; i < numbers.length-1; i++) {
            averageNumbers[i] = ((numbers[i] + numbers[i+1])/2D);
        }
        return averageNumbers;

    }
}
