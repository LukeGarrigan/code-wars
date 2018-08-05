import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class CatchingCarMileage {


    /**
     * "Interesting" Numbers
     * Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
     * <p>
     * Any digit followed by all zeros: 100, 90000                                                  done
     * Every digit is the same number: 1111                                                         done
     * The digits are sequential, incementing†: 1234                                                done
     * The digits are sequential, decrementing‡: 4321                                               done
     * The digits are a palindrome: 1221 or 73837                                                   done
     * The digits match one of the values in the awesomePhrases array
     * † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
     * ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210
     * 2 - is interesting
     * 1 - is <= 2 before being interesting
     * 0 - not interesting
     */


    private static String incrementingSequence = "1234567890";
    private static String decrementingSequence = "9876543210";

    public static int isInteresting(int number, int[] awesomePhrases) {
        return isInteresting(number, awesomePhrases, true);
    }

    private static int isInteresting(int number, int[] awesomePhrases, boolean isFirstIteration) {

        if (number < 98) {
            return 0;
        }

        if ( number >= 100) {
            if (numberIsFollowedByZeros(number)) return 2;
            if (isAllNumbersTheSame(number)) return 2;
            if (incrementingSequence.contains(String.valueOf(number))) return 2;
            if (decrementingSequence.contains(String.valueOf(number))) return 2;
            if (isAPalindrome(number)) return 2;
            if (isAnAwesomePhrase(number, awesomePhrases)) return 2;
        }
        if (isFirstIteration) {
            if (isInteresting(number + 1, awesomePhrases, false) == 2) return 1;
            if (isInteresting(number + 2, awesomePhrases, false) == 2) return 1;
        }
        return 0;

    }

    private static boolean isAnAwesomePhrase(int number, int[] awesomePhrases) {
        for (int i = 0; i < awesomePhrases.length; i++) {
            if (number == awesomePhrases[i]) {
                return true;
            }
        }
        return false;
    }


    private static boolean isAllNumbersTheSame(int number) {
        String numberAsString = String.valueOf(number);
        int firstNumber = Character.getNumericValue(numberAsString.charAt(0));
        for (int i = 1; i < numberAsString.length(); i++) {
            if (Character.getNumericValue(numberAsString.charAt(i)) != firstNumber) {
                return false;
            }
        }
        return true;
    }

    private static boolean numberIsFollowedByZeros(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 1; i < numberAsString.length(); i++) {
            if (Character.getNumericValue(numberAsString.charAt(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAPalindrome(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 0; i < numberAsString.length() / 2; i++) {
            if (numberAsString.charAt(i) != numberAsString.charAt(numberAsString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    @RunWith(Enclosed.class)
    public static class CatchingCarMileageTests {

        public static class IsFollowedByZerosAndInteresting {

            @Test
            public void isNumberFollowedByZerosWeirdOne() {
                assertEquals(1, CatchingCarMileage.isInteresting(98, new int[]{}));
            }

            @Test
            public void isNumberFollowedByZeros() {
                assertEquals(1, CatchingCarMileage.isInteresting(9998, new int[]{}));

            }

            @Test
            public void isNumberFollowedByZerosLessThanTwoAway() {
                assertEquals(1, CatchingCarMileage.isInteresting(198, new int[]{}));
            }


            @Test
            public void isBigNumberFollowedByZerosAndInteresting() {
                assertEquals(1, CatchingCarMileage.isInteresting(998, new int[]{}));
            }


        }

        public static class AreAllTheSameDigits {


            @Test
            public void isAllOnes() {
                assertEquals(2, CatchingCarMileage.isInteresting(11111, new int[]{}));
            }


            @Test
            public void isNotImportantEnough() {
                assertEquals(0, CatchingCarMileage.isInteresting(88, new int[]{}));
            }


            @Test
            public void isThreeThrees() {
                assertEquals(2, CatchingCarMileage.isInteresting(1111111111, new int[]{}));
            }


            @Test
            public void isCloseToBeingAllOnes() {
                assertEquals(1, CatchingCarMileage.isInteresting(11110, new int[]{}));
            }
        }


        public static class IsSequentialTesting {

            @Test
            public void isEasySequential() {

                assertEquals(2, CatchingCarMileage.isInteresting(123456, new int[]{}));
            }

            @Test
            public void isAwkwardSequential() {
                assertEquals(2, CatchingCarMileage.isInteresting(7890, new int[]{}));
            }

            @Test
            public void isNotSequential() {
                assertEquals(0, CatchingCarMileage.isInteresting(789054, new int[]{}));
            }

            @Test
            public void isNearlySeqeuential() {
                assertEquals(1, CatchingCarMileage.isInteresting(123455, new int[]{}));
            }

            @Test
            public void failBecauseZeroIsBeforeOne() {
                assertEquals(0, CatchingCarMileage.isInteresting(901234, new int[]{}));
            }

        }


        public static class DecrementingSequentialTests {

            @Test
            public void isEasySequential() {
                assertEquals(2, CatchingCarMileage.isInteresting(54321, new int[]{}));
            }

            @Test
            public void isNearlySequential() {
                assertEquals(1, CatchingCarMileage.isInteresting(54320, new int[]{}));
            }


            @Test
            public void isDifficultDecrementing() {
                assertEquals(0, CatchingCarMileage.isInteresting(32109, new int[]{}));
            }

        }


        public static class IsAPalindromeTests {

            @Test
            public void isANiceEasyPalindrome() {
                assertEquals(true, CatchingCarMileage.isAPalindrome(73837));
            }


            @Test
            public void isAPalindromeOverallWith() {
                assertEquals(2, CatchingCarMileage.isInteresting(211112, new int[]{}));
            }

            @Test
            public void isNearlyAPalindrome() {
                assertEquals(1, CatchingCarMileage.isInteresting(211110, new int[]{}));
            }

        }


        public static class IsAnAwesomePhraseTests {

            @Test
            public void isAnAwesomePhrase() {
                assertEquals(2, CatchingCarMileage.isInteresting(1337, new int[]{122, 1337}));
            }

            @Test
            public void isNearlyAnAwesomePhrase() {
                assertEquals(1, CatchingCarMileage.isInteresting(1336, new int[]{1337}));
            }


            @Test
            public void isNotAnAwesomePhrase() {
                assertEquals(1, CatchingCarMileage.isInteresting(130, new int[]{1337}));
            }
        }

    }


}
