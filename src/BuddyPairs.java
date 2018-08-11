import java.util.ArrayList;
import java.util.List;

public class BuddyPairs {






    public static Buddy myBuddy;

    public static String buddy(long start, long limit) {
        for (long i = start; i < limit ; i++) {
            long sumOfDivisors = getSumOfDivisors(i);
            Buddy buddy = new Buddy(i, sumOfDivisors-1);

            if(isABuddyPair(buddy)) {
                if (myBuddy.getSum() < buddy.getSum()) {
                    return "("+ myBuddy.getSum() + " " + buddy.getSum()+")";
                }
            }
        }

        return "Nothing";
    }

    public static boolean isABuddyPair(Buddy buddy) {
        long sumOfOtherBuddyDivisors = getSumOfDivisors(buddy.getSum())-1;
        if (sumOfOtherBuddyDivisors == buddy.getNumber()) {
            myBuddy = new Buddy(buddy.getSum(), sumOfOtherBuddyDivisors);
            return true;
        }
        return false;
    }


    public static long getSumOfDivisors(long number) {
        long total = 1;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                total += i;

                long flipped = number/i;
                if(flipped != i) {
                    total += flipped;
                }
            }
        }
        return total;
    }


}

class Buddy {

    private long number;
    private long sum;

    public Buddy(long number, long sum) {
        this.number = number;
        this.sum = sum;
    }

    public long getNumber() {
        return number;
    }

    public long getSum() {
        return sum;
    }
}



