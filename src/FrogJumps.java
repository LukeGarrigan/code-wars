public class FrogJumps {


    public static void main(String[] args) {

        int[] dsf = {1, 2, 1, 2, -3, -4};
        System.out.println(solution(dsf));


    }

    public static int solution(int[] a) {
        int numberOfJumps = 0;
        int index = 0;
        boolean stillInLoop = true;
        while(stillInLoop && numberOfJumps < a.length ) {
            if(index > a.length-1 || index < 0) {
                return numberOfJumps;
            }
            int jumps = a[index];
            if(jumps == 0) {
                return -1;
            }
            index = index + jumps;
            numberOfJumps++;
        }
        return -1;
    }


    public static int solutionTwo(int[] a) {
        int numberOfJumps = 0;
        int index = 0;
        boolean[] frogLocations = new boolean[a.length];
        while(true) {
            if(index > a.length -1 || index < 0) break;
            if(frogLocations[index]) return -1;
            frogLocations[index] = true;
            index += a[index];
            numberOfJumps++;
        }
        return numberOfJumps;
    }
}
