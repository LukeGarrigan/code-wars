import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowManyIII {




    private int totalNumbers;


    public ArrayList findAll(final int sumDigits, final int numDigits) {


        long startValue = (long) Math.pow(10, (numDigits-1));
        long endValue = startValue * 10 - 1;


        List<Long> allNumbers = new ArrayList<>();

        for (long i = startValue; i <= endValue; i++) {
            int total = 0;
            int previous = 0;
            String currentNumberAsString = String.valueOf(i);
            boolean isMatching = true;
            for (int j = 0; j < currentNumberAsString.length(); j++) {
                int currentDigit = Integer.parseInt(String.valueOf(currentNumberAsString.charAt(j)));
                if (currentDigit < previous) {
                    isMatching = false;
                    break;
                }

                total = total + currentDigit;
                previous = currentDigit;
            }

            if (isMatching && total == sumDigits) {
                allNumbers.add(i);
            }
        }


        if (allNumbers.isEmpty()) {
            return new ArrayList<Long>();
        } else {
            return new ArrayList<Long>() {
                {
                    add((long) allNumbers.size());
                    add(allNumbers.get(0));
                    add(allNumbers.get(allNumbers.size()-1));

                }
            } ;
        }

    }


    public int getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    public static class TestHowMany {

        @Test
        public void findBetween10And99() {
            HowManyIII howManyIII = new HowManyIII();
            System.out.println(howManyIII.findAll(84, 8));
        }


    }
}


