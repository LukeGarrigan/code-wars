import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringNIterations {


    public static void main(String[] args) {


        System.out.println(jumbledString("Such Wow!", 1));
    }


    public static String jumbledString(String s, long n) {

        char[] chars = s.toCharArray();
        int lastEvenIndex = -1;
        for (int i = 0; i < s.length(); i++) {

            if (i % 2 == 0) {
                if (lastEvenIndex != -1) {
                    char toBeMoved = chars[i];
                    for (int j = lastEvenIndex + 1; j < i; j++) {
                        char temp = chars[j];
                        chars[j] = toBeMoved;
                        toBeMoved = temp;
                    }
                }
                lastEvenIndex = lastEvenIndex +1;
            } else {
                char temp = chars[i];
                for (int j = i; j < s.length() - 1; j++) {
                    chars[j] = chars[j + 1];
                }
                chars[s.length() - 1] = temp;
            }


        }
        return Arrays.toString(chars);

    }

    @Test
    public void fixed2() {
        String s = "better example", a = "bexltept merae";
        assertEquals(a, jumbledString(s, 2));
    }


}
