import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IsAnagram {


    public static void main(String[] args) {
        System.out.println(isAnagram("Buckethead", "DeathCubeK"));

    }

    public static boolean isAnagram(String firstWord, String secondWord) {

        char[] firstWordAsArray = firstWord.toLowerCase().toCharArray();
        Arrays.sort(firstWordAsArray);

        char[] secondWordAsArray = secondWord.toLowerCase().toCharArray();
        Arrays.sort(secondWordAsArray);

        String sortedFirstWord = new String(firstWordAsArray);
        String sortedSecondWord = new String(secondWordAsArray);

        if(sortedFirstWord.equals(sortedSecondWord)){
            return true;
        } else {
            return false;
        }

    }

}
