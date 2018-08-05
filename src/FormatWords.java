import java.util.ArrayList;
import java.util.List;

public class FormatWords {

    public static void main(String[] args) {

        System.out.println(formatWords(new String[]{}));

    }

    public static String formatWords(String[] words) {

        if(words == null) {
            return "";
        }

        List<String> listOfWords = new ArrayList<>();
        for(String word : words) {
            if(!word.isEmpty()) {
                listOfWords.add(word);
            }
        }

        if(listOfWords.size() == 1) {
            return listOfWords.get(0);
        }else if(listOfWords.size() == 0) {
            return "";
        }

        StringBuilder sentence = new StringBuilder();

        String lastWord = listOfWords.get(listOfWords.size()-1);
        sentence.append(listOfWords.get(listOfWords.size()-2) + " and " + lastWord);

        if(listOfWords.size() > 2) {
            for (int i = listOfWords.size()-3; i >= 0 ; i--) {
                sentence.insert(0, listOfWords.get(i)+", ");
            }
        }
        return sentence.toString();
    }
}
