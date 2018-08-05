import java.util.Arrays;

public class Beggars {


    public static void main(String[] args) {

        int[] money = {1,2,3,4,5};

        System.out.println(Arrays.toString(beggars(money, 0)));
    }

    public static int[] beggars(int[] earnings, int numberOfBeggars) {
        // show me the code!
        if(numberOfBeggars==0) return new int[0];
        int[] splitEarnings = new int[numberOfBeggars];
        int beggar = 0;
        for (int i = 0; i < earnings.length; i++) {
            splitEarnings[beggar] += earnings[i];
            beggar++;
            if(beggar == numberOfBeggars) {
                beggar = 0;
            }
        }
        return splitEarnings;
    }

}
