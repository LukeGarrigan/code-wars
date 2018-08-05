

public class ReversedStrings {


    public static void main(String[] args) {


        System.out.println(solution(""));
    }


    public static String solution(String str) {
        // Your code here...
        if(str.isEmpty() || str == null) {
            return "";
        }
        StringBuilder reversedString = new StringBuilder();
        int endPosition = str.length() - 1;
        for (int i = 0; i <= str.length() / 2; i++) {
            char temp = str.charAt(i);
            reversedString.setCharAt(i, str.charAt(endPosition - i));
            reversedString.setCharAt(endPosition -i, temp);
        }
        return reversedString.toString();
    }
}
