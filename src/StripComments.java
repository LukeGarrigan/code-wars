import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StripComments {


    public static void main(String[] args) {

        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples\ns", new String[]{"#", "!"}));
    }

    public static String stripComments(String text, String[] commentSymbols) {

        boolean ignoreNext = false;
        StringBuilder noCommentString = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (String.valueOf(c).equals("\n")) {
                ignoreNext = false;
                noCommentString.append(currentLine.toString().replaceAll("\\s+$", ""));
                noCommentString.append("\n");
                currentLine = new StringBuilder();
                continue;
            }
            if (!ignoreNext) {

                for (int j = 0; j < commentSymbols.length; j++) {
                    if (commentSymbols[j].equals(String.valueOf(c))) {
                        ignoreNext = true;
                        noCommentString.append(currentLine.toString().trim());
                        currentLine = new StringBuilder();
                    }
                }
                if (!ignoreNext) {
                    currentLine.append(c);
                }
            }
        }
        noCommentString.append(currentLine);
        return noCommentString.toString().replaceAll("\\s+$", "");
    }

    @Test
    public void stripComments() throws Exception {

        String expected = "apples, pears\ngrapes\nbananas";
        String actual =  StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples ", new String[]{"#", "!"});
        assertEquals(expected, actual);
    }
}


