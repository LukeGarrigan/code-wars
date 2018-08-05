import java.util.Arrays;

public class Mumbling {

    public static void main(String[] args) {

        System.out.println(accum("abcd"));
    }




    public static String accum(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += String.valueOf(chars[i]).toUpperCase();
            for (int j = 0; j < i; j++) {
                result += String.valueOf(chars[i]).toLowerCase();
            }
            result += i != chars.length-1 ? "-" : "";
        }
        return result;
    }
}
