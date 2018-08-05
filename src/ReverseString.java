import java.util.Arrays;

public class ReverseString {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(reverse(5)));
    }


    /**
     *
     * @param n
     * @return
     */
    public static int[] reverse(int n){

        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = n-i;
        }
        return reversed;
    }


}
