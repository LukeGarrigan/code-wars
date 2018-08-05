public class TwoSum {


    public static void main(String[] args) {

        System.out.println(persistence(39L));

    }



    public static int persistence(long n) {
        return persistence(n, 0);
    }

    public static int persistence(long n, int numberOfTimes) {
        if (n < 10) {
            return numberOfTimes;
        }
        String number = String.valueOf(n);
        long total = 1;
        for (int i = 0; i < number.length(); i++) {
            total = total * Character.getNumericValue(number.charAt(i));
        }
        numberOfTimes = numberOfTimes + 1;
        return persistence(total, numberOfTimes++);
    }


}
