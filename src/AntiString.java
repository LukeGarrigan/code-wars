import java.util.HashMap;
import java.util.Map;

public class AntiString {

    public static void main(String[] args) {


        System.out.println(antiString("abcWXY123"));
    }

    static Map<Integer, Integer> compliment = new HashMap<>();

    public static String antiString(String str) {
        populateComplimentMap();
        StringBuilder antiString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentLetter = str.charAt(i);
            if (Character.isAlphabetic(currentLetter)) {
                if (Character.isUpperCase(currentLetter)) {
                    antiString.append(Character.toLowerCase(currentLetter));
                } else {
                    antiString.append(Character.toUpperCase(currentLetter));
                }

            } else {
                antiString.append(getComplimentOfNumericValue(Character.getNumericValue(currentLetter)));
            }
        }

        return reverseString(antiString.toString());


    }

    private static String reverseString(String s) {

        StringBuilder reversedString = new StringBuilder();
        reversedString.setLength(s.length());
        for (int i = 0; i < s.length() / 2; i++) {
            char letter = s.charAt(i);
            char temp = s.charAt(s.length()-i-1);
            reversedString.insert(i, temp);
            reversedString.insert(s.length()-i-1, letter);
        }

        return reversedString.toString();
    }

    private static void populateComplimentMap() {

        compliment.put(0, 9);
        compliment.put(1, 8);
        compliment.put(2, 7);
        compliment.put(3, 6);
        compliment.put(4, 5);
    }

    private static int getComplimentOfNumericValue(int numericValue) {
        if (compliment.get(numericValue) != null) {
            return compliment.get(numericValue);
        } else {
            for (Map.Entry<Integer, Integer> entry : compliment.entrySet()) {
                if (entry.getValue().equals(numericValue)) {
                    return entry.getKey();
                }
            }

        }
        return 0;
    }
}
