import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleCola {


    public static void main(String[] args) {

        String[] names = {"Sheldon", "Leonard", "Penny", "Raj", "Howard"};

        System.out.println(whoIsNext(names, 6));
    }

    public static String whoIsNext(String[] names, int n) {
        List<String> doubledUp = new ArrayList<String>(Arrays.asList(names));
        for (int count = 0; count < n; count++) {
            String currentBanger = doubledUp.get(0);
            if (count == n-1) return currentBanger;
            doubledUp.remove(0);
            doubledUp.add(currentBanger);
            doubledUp.add(currentBanger);
        }
        return doubledUp.get(0);
    }
}
