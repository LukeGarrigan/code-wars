public class FindEvenIndex {


    public static void main(String[] args) {


        int[] n = {1,100,50,-51,1,1};

        System.out.println(findEvenIndex(n));
    }


    public static int findEvenIndex(int[] arr) {
        int leftTotal =0;
        int rightTotal = 0;

        for (int i = 0; i < arr.length; i++) {

            leftTotal += arr[i];

            for (int j = i; j < arr.length ; j++) {
                rightTotal += arr[j];
            }
            if(leftTotal == rightTotal) {
                return i;
            }
            rightTotal = 0;
        }

        return -1;

    }
}
