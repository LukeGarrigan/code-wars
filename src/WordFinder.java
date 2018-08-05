import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFinder {

    public static void main(String[] args) throws IOException {




        int length = 8;
        List<String> words = getListOfWordsOverSpecifiedLength(length);

        List<Character> lineOfKeyboard = getListOfCharacters();

        List<String> wordsOnOneLine = new ArrayList<>();
        for (String word : words) {
            boolean isOnSameLine = true;
            for (int i = 0; i < word.length(); i++) {
                if(!lineOfKeyboard.contains(word.charAt(i))) {
                    isOnSameLine = false;
                    break;
                }
            }
            if(isOnSameLine) {
                wordsOnOneLine.add(word);
            }
        }


        System.out.println(wordsOnOneLine);


    }

    private static List<Character> getListOfCharacters() {
        List<Character> characters = new ArrayList<>();
        characters.add('q');
        characters.add('w');
        characters.add('e');
        characters.add('r');
        characters.add('t');
        characters.add('y');
        characters.add('u');
        characters.add('i');
        characters.add('o');
        characters.add('p');
        return characters;
    }


    private static List<Character> getListOfCharactersTwo() {
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('s');
        characters.add('d');
        characters.add('f');
        characters.add('g');
        characters.add('h');
        characters.add('j');
        characters.add('k');
        characters.add('l');
        return characters;
    }

    private static List<Character> getListOfCharactersThree() {
        List<Character> characters = new ArrayList<>();
        characters.add('z');
        characters.add('x');
        characters.add('c');
        characters.add('v');
        characters.add('b');
        characters.add('n');
        characters.add('m');
        return characters;
    }
    private static List<String> getListOfWordsOverSpecifiedLength(int length) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("words_alpha.txt"));
        String word = bufferedReader.readLine();

        List<String> words = new ArrayList<>();
        while(word != null) {
            word = bufferedReader.readLine();

            if(word != null && word.length() >= length) {
                words.add(word);
            }

        }

        return words;
    }


}
