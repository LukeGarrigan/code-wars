import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFinder {

    //static List<char[]> SEEN_STATES = new ArrayList<>();
    static Set<char[]> SEEN_STATES = new HashSet<>();


    public static void main(String[] args) {


        System.out.println(pathFinder("..W...W.W \n" +
                "..WW..WWW \n" +
                ".....W... \n" +
                ".W..W.... \n" +
                "W....WWWW \n" +
                ".......W. \n" +
                "..W...... \n" +
                "WW.WW..WW\n" +
                ".....W..."));

    }

    public static boolean pathFinder(String environment) {

        environment = environment.replaceAll("\n", "");

        char[] maze = environment.toCharArray();
        if(maze[0] == 'W' || maze[maze.length-1] == 'W') {
            return false;
        }
        maze[0] = 'x';


        LinkedList<char[]> queue = new LinkedList<>();
        queue.add(maze);
        SEEN_STATES.add(maze);
        while (!queue.isEmpty()) {
            char[] currentState = queue.removeFirst();
            if (findCurrentPosition(currentState) == currentState.length - 1) {
                return true;
            }
            for (char[] move : findPossibleMoves(currentState)) {
                if (!hasAlreadyBeenSeen(move)) {
                    queue.add(move);
                    SEEN_STATES.add(move);
                }

            }


        }
        return false;
    }

    private static boolean hasAlreadyBeenSeen(char[] move) {
        for (char[] seenState : SEEN_STATES) {
            if(seenState.length != move.length) continue;
            boolean hasBeenSeen = true;
            for (int i = 0; i < seenState.length; i++) {
                if (seenState[i] != move[i]) {
                    hasBeenSeen = false;
                }
            }

            if (hasBeenSeen) {
                return true;
            }

        }

        return false;
    }

    private static List<char[]> findPossibleMoves(char[] currentState) {
        int currentPosition = findCurrentPosition(currentState);

        int width = (int) Math.sqrt(currentState.length);


        List<char[]> possibleMoves = new ArrayList<>();


        if (currentPosition % width != 0 && currentState[currentPosition - 1] != 'W') {
            char[] left = new char[currentState.length];
            System.arraycopy(currentState, 0, left, 0, left.length);

            char temp = left[currentPosition];
            left[currentPosition] = left[currentPosition - 1];
            left[currentPosition - 1] = temp;
            if (!SEEN_STATES.contains(left)) {
                possibleMoves.add(left);
            }

        }

        if (currentPosition % width != (width - 1) && currentState[currentPosition + 1] != 'W') {
            char[] right = new char[currentState.length];
            System.arraycopy(currentState, 0, right, 0, right.length);

            char temp = right[currentPosition];
            right[currentPosition] = right[currentPosition + 1];
            right[currentPosition + 1] = temp;

            if (!SEEN_STATES.contains(right)) {
                possibleMoves.add(right);
            }
        }

        if (currentPosition >= width && currentState[currentPosition - width] != 'W') {
            char[] up = new char[currentState.length];
            System.arraycopy(currentState, 0, up, 0, up.length);

            char temp = up[currentPosition];
            up[currentPosition] = up[currentPosition - width];
            up[currentPosition - width] = temp;
            if (!SEEN_STATES.contains(up)) {
                possibleMoves.add(up);
            }

        }


        if (currentPosition < ((width * width) - width) && currentState[currentPosition + width] != 'W') {
            char[] down = new char[currentState.length];
            System.arraycopy(currentState, 0, down, 0, down.length);

            char temp = down[currentPosition];
            down[currentPosition] = down[currentPosition + width];
            down[currentPosition + width] = temp;
            if (!SEEN_STATES.contains(down)) {
                possibleMoves.add(down);
            }


        }

        return possibleMoves;

    }

    private static int findCurrentPosition(char[] currentState) {
        for (int i = 0; i < currentState.length; i++) {
            if (currentState[i] == 'x') {
                return i;
            }
        }
        return 0;
    }


    public static void visualiseCurrentState(char[] currentState) {
        System.out.println("\n");
        int width = (int) Math.sqrt(currentState.length);
        for (int i = 0; i < currentState.length; i++) {

            if (i != 0 && i % width == 0) {
                System.out.print("\n" + currentState[i]);
            } else {
                System.out.print(currentState[i]);
            }
        }


    }


    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                ".W.\n" +
                "...",

                b = ".W.\n" +
                        ".W.\n" +
                        "W..",

                c = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......",

                d = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        ".....W\n" +
                        "....W.";

        assertEquals(true, PathFinder.pathFinder(a));
        assertEquals(false, PathFinder.pathFinder(b));
        assertEquals(true, PathFinder.pathFinder(c));
        assertEquals(false, PathFinder.pathFinder(d));
    }
}
