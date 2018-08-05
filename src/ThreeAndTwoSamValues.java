import java.util.HashMap;
import java.util.Map;

public class ThreeAndTwoSamValues {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'a', 'b', 'b'};
        System.out.println(checkThreeAndTwo(chars));

    }

    public static boolean checkThreeAndTwo(char[] chars) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            counts.put(chars[i], counts.get(chars[i]) == null ? 1 : counts.get(chars[i]) + 1);
        }
        boolean threeCount = false;
        boolean twoCount = false;
        for (Integer num : counts.values()) {
            if (num == 2) {
                twoCount = true;
            } else if (num == 3) {
                threeCount = true;
            }
        }
        return threeCount && twoCount;
    }

}
