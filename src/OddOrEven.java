public class OddOrEven {



    public static void main(String[] args) {

        System.out.println(oddOrEven(new int[] {1,2,3,4}));

    }

    public static String oddOrEven (int[] array) {
        // your code
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        if (sum % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

}
