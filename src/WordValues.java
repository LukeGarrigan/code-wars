import java.util.Arrays;

public class WordValues {

    public static void main(String[] args) {


        String[] array = {"codewars","abc","xyz"};
        System.out.println(solve(array));

    }

    public static final String ALPHABET = " abcdefghijklmnopqrstuvwxyz";

    public static String solve(String[] args) {
        int[] sums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            String currentWord = args[i];
            for (int j = 0; j < currentWord.length(); j++) {
                sums[i] += ALPHABET.indexOf(currentWord.charAt(j));
            }
            sums[i] += sums[i]*i;
        }
        return Arrays.toString(sums);
    }
}
