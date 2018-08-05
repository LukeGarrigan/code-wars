import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryMultipleOfThree {


    public static void main(String[] args) {


    }

    public static class Boggle {

        private char[][] board;
        private String word;
        private int previousX;
        private int previousY;

        private int currentX;
        private int currentY;
        private boolean isFirstLetter = true;


        public Boggle(final char[][] board, final String word) {
            this.board = board;
            this.word = word;
        }

        public boolean check() {
            for (int i = 0; i < word.length(); i++) {
                char currentLetter = word.charAt(i);
                if (numberOfTimesLetterIsOnBoard(currentLetter) > 0) {
                    while(true) {
                        findPositionOfLetter(currentLetter, 0, 0);

                        
                    }

                } else {
                    return false;
                }
            }

            return false;
        }

        private int numberOfTimesLetterIsOnBoard(char currentLetter) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == currentLetter) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void findPositionOfLetter(char currentLetter, int x, int y) {
            for (int j = x; j < board.length; j++) {
                for (int k = y; k < board[0].length; k++) {
                    if(board[j][k] == currentLetter) {
                        currentX = j;
                        currentY = k;
                        return;
                    }
                }
            }

        }

    }

    public static class SolutionTest {

        final private static char[][] board = {
                {'E', 'A', 'R', 'A'},
                {'N', 'L', 'E', 'C'},
                {'I', 'A', 'I', 'S'},
                {'B', 'Y', 'O', 'R'}
        };

        private static String[] toCheck = {"C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES"};
        private static boolean[] expecteds = {true, true, false, true, true, false, false};

        @Test
        public void sampleTests() {
            for (int i = 0; i < toCheck.length; i++) {
                assertEquals(expecteds[i], new Boggle(deepCopy(board), toCheck[i]).check());
            }
        }

        private char[][] deepCopy(char[][] arr) {
            return Arrays.stream(arr)
                    .map(a -> Arrays.copyOf(a, a.length))
                    .toArray(char[][]::new);
        }
    }


}
