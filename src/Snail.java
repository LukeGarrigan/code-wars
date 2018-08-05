import java.util.Arrays;

public class Snail {


    public static void main(String[] args) {

        int[][] array =  {{1,2,3},{1,2}};


        System.out.println(Arrays.toString(snail(array)));


    }

    private static final String RIGHT = "right";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String UP = "up";


    public static int[] snail(int[][] array) {
        if(array[0].length != array.length || array.length == 0) return new int[0];
        int snailLength = array.length;
        int[] newArray = new int[snailLength * snailLength];
        int xPos = 0;
        int yPos = 0;

        int limit = snailLength;
        int count =0;
        String direction = RIGHT;
        for (int i = 0; i < newArray.length; i++) {

            newArray[i] = array[yPos][xPos];

            if (direction.equals(RIGHT)) {
                if (count == limit - 1) {
                    direction = DOWN;
                    limit = limit -1;
                    count=0;
                    yPos++;
                    continue;
                } else {
                    xPos++;
                }
            } else if (direction.equals(DOWN)) {
                if (count == limit - 1) {
                    direction = LEFT;
                    count=0;
                    xPos--;
                    continue;
                } else {
                    yPos++;
                }

            } else if (direction.equals(LEFT)) {
                if (count == limit - 1) {
                    direction = UP;
                    limit = limit -1;
                    count=0;
                    yPos--;
                    continue;
                } else {
                    xPos--;
                }
            }
            else if (direction.equals(UP)) {
                if (count == limit - 1) {
                    direction = RIGHT;
                    count=0;
                    xPos++;
                    continue;
                } else {
                    yPos--;
                }
            }

            count++;

        }
        return newArray;
    }

}

