import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectionsReduction {


    public static void main(String[] args) {


        String[] directions = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};

        System.out.println(Arrays.toString(directionReduction(directions)));

    }

    public static String[] directionReduction(String[] arr) {
        List<String> shortenedDirections = new ArrayList();
        for (int i = 0; i < arr.length; i++) {

            String direction = arr[i];
            if(direction.equals("NORTH")) {
                if(shortenedDirections.contains("SOUTH")) {
                    shortenedDirections.remove("SOUTH");
                } else {
                    shortenedDirections.add("NORTH");
                }
            }else if(direction.equals("SOUTH")) {
                if(shortenedDirections.contains("NORTH")) {
                    shortenedDirections.remove("NORTH");
                } else {
                    shortenedDirections.add("SOUTH");
                }

            }else if(direction.equals("WEST")) {
                if(shortenedDirections.contains("EAST")) {
                    shortenedDirections.remove("EAST");
                } else {
                    shortenedDirections.add("WEST");
                }

            }else if(direction.equals("EAST")) {
                if(shortenedDirections.contains("WEST")) {
                    shortenedDirections.remove("WEST");
                } else {
                    shortenedDirections.add("EAST");
                }

            }
        }
        return shortenedDirections.toArray(new String[shortenedDirections.size()]);

    }

}
