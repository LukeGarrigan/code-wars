import java.util.Arrays;
import java.util.List;

public class RecursiveLengthArray {




    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abcd", "a", "abcddef");
        double avg = avgStringLength(strings, strings.size());
        System.out.println(avg);
    }



    public static double avgStringLength(List<String> l, int arrayLength) {
        if (l.isEmpty()) {
            return 0;
        }
        double first = l.get(0).length();

        return (first/arrayLength) + avgStringLength(l.subList(1, l.size()), arrayLength);
    }


}
