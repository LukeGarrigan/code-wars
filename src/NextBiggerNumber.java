public class NextBiggerNumber {

    public static void main(String[] args) {


        permutation("", "hell");
    }


    public static long nextBiggerNumber(long n) {


        String valueAsString = String.valueOf(n);

        long[] allPossibleValues = new long[valueAsString.length()];


        return 0;

    }


    public static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
