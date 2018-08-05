import java.util.HashMap;
import java.util.Map;

public class StringsAndAsterisks {


    public static void main(String[] args) {

        System.out.println(getStrings("Chicago"));
    }


    public static String getStrings(String country) {
        country = country.toLowerCase();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < country.length(); i++) {
            if (counts.get(country.charAt(i)) == null) {
                counts.put(country.charAt(i), 1);
            } else {
                counts.put(country.charAt(i), counts.get(country.charAt(i)) + 1);
            }
        }
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Character, Integer> characterIntegerEntry : counts.entrySet()) {
            s.append(characterIntegerEntry.getKey());
            for (int i = 0; i < characterIntegerEntry.getValue(); i++) {
                s.append("*");
            }

        }
        return s.toString();
    }
}
