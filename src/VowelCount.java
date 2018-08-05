
import java.util.Arrays;
import java.util.List;

public class VowelCount {



    public static void main(String[] args) {

        System.out.println(getCount("sausage"));

    }

    private static List<Character> vowelsList = Arrays.asList(new Character[]{'a','e','i','o','u'});
    public static int getCount(String str) {
        int vowelsCount = 0;
        for(int i=0; i<str.length(); i++) {
            if(vowelsList.contains(str.charAt(i))) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }
}
