import java.util.Arrays;

public class ProductOfConsecutiveFibonacci {



    public static void main(String[] args) {


        System.out.println(Arrays.toString(fibIterative(183631203)));

    }




    public static long[] fibIterative(long targetNumber) {
        long fib = 1;
        long prevFib = 1;
        long[] productArray = new long[3];
        for(int i = 2; i < Integer.MAX_VALUE; i++) {
            long product  = fib * prevFib;
            if(product >= targetNumber) {
                productArray[0] = prevFib;
                productArray[1] = fib;
                productArray[2] = product == targetNumber ? 1 : 0;
                return productArray;
            }
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return null;
    }

}
