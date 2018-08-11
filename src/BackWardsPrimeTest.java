import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BackWardsPrimeTest {


    @Test
    public void backWardsPrime13() {
        assertEquals("13 17 31 37 71 73 79 97", BackWardsPrime.backwardsPrime(1, 100));
    }

    @Test
    public void backWardsPrime21() {
        assertEquals("9923 9931 9941 9967", BackWardsPrime.backwardsPrime(9900, 10000));
    }


    @Test
    public void backwardsPrimeTests() {
        assertEquals("70001 70009 70061 70079 70121 70141 70163 70241", BackWardsPrime.backwardsPrime(70000, 70241));
    }

    @Test
    public void isNumberPrimeTests() {
        assertEquals(true, BackWardsPrime.isNumberPrime(13));
        assertEquals(false, BackWardsPrime.isNumberPrime(12));
        assertEquals(true, BackWardsPrime.isNumberPrime(9967));
    }

    @Test
    public void hasNumberReversed() {
        assertEquals(7016, BackWardsPrime.reverseNumber(6107));
        assertEquals(70164, BackWardsPrime.reverseNumber(46107));
    }



}
