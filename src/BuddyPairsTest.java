import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BuddyPairsTest {

    private static void testing(long start, long limit, String expected) {
        System.out.println("start: " + start);
        System.out.println("limit: " + limit);
        String actual = BuddyPairs.buddy(start, limit);
        System.out.println("Expect: " + expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(1071625, 1103735, "(1081184 1331967)");
        testing(2382, 3679, "Nothing");
        testing(10, 50, "(48 75)");
        testing(381, 4318, "(1050 1925)");
    }




    @Test
    public void isABuddyPairTest() {
        Buddy buddy = new Buddy(48, 75);
        assertEquals(true, BuddyPairs.isABuddyPair(buddy));

    }

    @Test
    public void getSumOfDivisors(){
        assertEquals(11, BuddyPairs.getSumOfDivisors(21));
        assertEquals(15,BuddyPairs.getSumOfDivisors(16));


    }

}
