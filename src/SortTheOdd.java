import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheOdd {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4})));

    }


    public static int[] sortArray(int[] array) {
        List<Integer> oddNumberPositions = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] % 2 == 1) {
                oddNumbers.add(array[i]);
                oddNumberPositions.add(i);
            }
        }

        Collections.sort(oddNumbers);

        for (int i = 0; i < oddNumbers.size(); i++) {
            int position = oddNumberPositions.get(i);
            array[position] = oddNumbers.get(i);
        }

        return array;
    }
}
