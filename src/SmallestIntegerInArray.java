public class SmallestIntegerInArray {

    public static void main(String[] args) {


        int[] nums = {1, 2, 4, -4, 1, 6, 55};
        System.out.println(findSmallestInt(nums));

    }

    public static int findSmallestInt(int[] args) {

        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<args.length; i++){
            if(args[i] < smallest) smallest = args[i];
        }
        return smallest;
    }

}
