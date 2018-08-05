import java.util.HashMap;
import java.util.Map;

public class UpsideDownNumbers {


    public static void main(String[] args) {

        initialiseUpsideDownNumbers();
        System.out.println(countNumbersWhichAreTheSameUpsideDown(0, 10));
    }

    private static Map<Integer, Integer> UPSIDE_DOWN_NUMBERS = new HashMap<>();

    private static void initialiseUpsideDownNumbers() {
        UPSIDE_DOWN_NUMBERS.put(0, 0);
        UPSIDE_DOWN_NUMBERS.put(1, 1);
        UPSIDE_DOWN_NUMBERS.put(6, 9);
        UPSIDE_DOWN_NUMBERS.put(8, 8);
        UPSIDE_DOWN_NUMBERS.put(9, 6);

    }


    public static int countNumbersWhichAreTheSameUpsideDown(int x, int y) {


        int count = 0;
        for (int i = x; i < y; i++) {
            if (i == 0) {
                count++;
            } else {
                int number = i;
                StringBuilder upsideDownString = new StringBuilder();
                boolean isFlippable = true;
                while (number > 0 && isFlippable) {
                    int currentNumber = number % 10;
                    if (UPSIDE_DOWN_NUMBERS.get(currentNumber) != null) {
                        upsideDownString.append(UPSIDE_DOWN_NUMBERS.get(currentNumber));
                    } else {
                        isFlippable = false;
                    }
                    number = number / 10;
                }
                if (!upsideDownString.toString().isEmpty() && Integer.parseInt(upsideDownString.toString()) == i) {
                    count++;
                }
            }

        }
        return count;
    }
}
