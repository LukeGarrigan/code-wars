import java.util.HashMap;
import java.util.Stack;

public class ValidBraces {


    public static void main(String[] args) {

        System.out.println(isValid("([{}])"));

    }


    static HashMap<Character, Character> allBraces = new HashMap<>();

    public static boolean isValid(String braces) {
        // Add code here
        populateBracesMap();
        Stack<Character> seenBraces = new Stack<>();

        char firstBrace = braces.charAt(0);

        if(!isOpeningBrace(firstBrace)) {
            return false;
        }
        seenBraces.push(firstBrace);

        for (int i = 1; i < braces.length(); i++) {
            char currentBrace = braces.charAt(i);
            if(isOpeningBrace(currentBrace)) {
                seenBraces.push(currentBrace);
            }else {

                if(!seenBraces.empty() && allBraces.get(currentBrace) != seenBraces.pop()) {
                    return false;
                }
            }

        }

        if(seenBraces.empty()) {
            return true;
        }
        return false;
    }


    private static void populateBracesMap(){
        allBraces.put(')','(');
        allBraces.put(']','[');
        allBraces.put('}','{');
    }

    private static boolean isOpeningBrace(char firstBrace) {
        return firstBrace == '(' || firstBrace == '{' || firstBrace == '[';
    }
}
