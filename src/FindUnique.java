import java.util.HashMap;
import java.util.Map;

public class FindUnique {

    public static void main(String[] args) {

        System.out.println(findUniq(new double[]{1,2,2,2,5,5}));
    }

    public static double findUniq(double arr[]) {

        Map<Double,Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            numbersMap.put(arr[i], numbersMap.get(arr[i]) == null ? 1 : numbersMap.get(arr[i])+1);
        }

        for (Map.Entry<Double, Integer> doubleIntegerEntry : numbersMap.entrySet()) {
            if(doubleIntegerEntry.getValue() == 1) {
                return doubleIntegerEntry.getKey();
            }
        }
        return 0;
    }
}
