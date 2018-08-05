import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Pangram {


    public static void main(String[] args) {


    }


    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static boolean check(String sentence) {
        sentence = sentence.replaceAll(" ", "");
        sentence = sentence.trim();

        if (sentence.length() < alphabet.length) {
            return false;
        }

        sentence = sentence.toLowerCase();
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            letterCounts.put(alphabet[i], 0);
        }

        for (int i = 0; i < sentence.length(); i++) {
            char currentLetter = sentence.charAt(i);

            Integer letterCount = letterCounts.get(currentLetter);

            if(letterCount != null) {
                letterCounts.put(currentLetter, letterCount + 1);
            }

        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : letterCounts.entrySet()) {
            if (characterIntegerEntry.getValue() < 1) {
                return false;
            }
        }
        return true;
    }


    @RunWith(Enclosed.class)
    public static class PanagramTest {


        public static class SomePangramTests {
            @Test
            public void testQuickBrownFox() {
                assertEquals(true, Pangram.check("The quick brown fox jumps over the lazy dog"));
            }

            @Test
            public void testShouldHitBaseCase() {
                assertEquals(false, Pangram.check("No enough letters"));
            }

            @Test
            public void notAllCountsHit() {
                assertEquals(false, Pangram.check("There is enough letters here I believe but unfortunately there isnt all the letters in the alphabet"));
            }


            @Test
            public void failWithDodgyLetters() {
                assertEquals(false, Pangram.check("There is enough letters here I believe but unfortunately there isn't all the letters in the alphabet"));
            }

        }


    }



}


