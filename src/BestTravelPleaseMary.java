import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTravelPleaseMary {


    public static void main(String[] args) {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = chooseBestSum(163, 3, ts);
        System.out.println(n);

    }


    public static Integer chooseBestSum(int maxDistanceInMiles, int maxNumberOfTowns, List<Integer> distancesBetweenTowns) {

        for (int i = 0; i < distancesBetweenTowns.size(); i++) {
            int[] currentSums = new int[maxNumberOfTowns];
            int count =0;
            for (int j = i; j < distancesBetweenTowns.size() ; j++) {
                if(j == distancesBetweenTowns.size()-1) {
                    j=0;
                }
                currentSums[count] = distancesBetweenTowns.get(j);
                count++;
            }
            System.out.println(Arrays.toString(currentSums));
        }

        return 0;
    }

}

