package datareverse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Luke.Garrigan
 * @since 06/11/2018
 */
public class DataReverse {

    public static void main(String[] args) {

        DataReverse(new int[] {1,2,3,4,5});

    }

    public static int[] DataReverse(int[] data) {


        List<int[]> splitBits = new ArrayList<>();

        int[] bits = new int[8];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            bits[count] = data[i];
            if (i % 7 == 0) {
                bits = new int[8];
                count = 0;
            }
        }

        int[] output = new int[data.length];



        int outputCount =0;
        for (int i = splitBits.size()-1; i > 0; i--) {

            for (int bit : splitBits.get(i)) {
                output[outputCount] = bit;
                outputCount++;
            }
        }
        return output;
    }

}

class Tests {

    public static void test1() {
        int[] data1 =  {
            1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0
        } ;
        int[] data2 = {
            1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1
        } ;
        assertEquals(data2, DataReverse.DataReverse(data1));
    }

}
