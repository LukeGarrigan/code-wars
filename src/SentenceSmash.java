public class SentenceSmash {



    public static void main(String[] args) {

        String[] words = {"This", "is", "my", "sentence"};
        System.out.println(smash(words));

    }

    public static String smash(String... words) {
        // TODO Write your code below this comment please

        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            sentence.append(word);
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }
}
