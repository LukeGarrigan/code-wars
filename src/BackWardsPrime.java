public class BackWardsPrime {


    public static String backwardsPrime(long start, long end) {
        // your code
        StringBuilder backwardPrimes = new StringBuilder();
        long startValue = start < 12 ? 12 : start;
        for (long i = startValue; i <= end; i++) {
            if (isNumberPrime(i)) {
                if (reverseNumber(i) != i && isNumberPrime(reverseNumber(i))) {
                    backwardPrimes.append(i).append(" ");
                }

            }

        }
        return backwardPrimes.toString().trim();
    }

    public static long reverseNumber(long numberToBeReversed) {
        String numberAsString = String.valueOf(numberToBeReversed);
        StringBuilder output = new StringBuilder(numberAsString);
        for (int i = 0; i < numberAsString.length() / 2; i++) {
            char temp = numberAsString.charAt(i);
            output.setCharAt(i, numberAsString.charAt(numberAsString.length() - i - 1));
            output.setCharAt(numberAsString.length() - i - 1, temp);
        }

        long returnValue = 0;
        for (int i = 0; i < output.length(); i++) {
            returnValue = returnValue * 10 + Character.getNumericValue(output.charAt(i));
        }


        return returnValue;
    }

    public static boolean isNumberPrime(long number) {
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
