public class MaximumSubarray {


    public static void main(String[] args) {

        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));




    }

    public static int sequence(int[] arr) {

        int maximumSubArray = 0;
        for (int i = 0; i < arr.length; i++) {
            int thisSubArray = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                thisSubArray += arr[j];
                if(thisSubArray > maximumSubArray) {
                    maximumSubArray = thisSubArray;
                }
            }

        }
        return maximumSubArray;

    }
}
