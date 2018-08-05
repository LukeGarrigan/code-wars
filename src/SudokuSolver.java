import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        System.out.println(isBottomBlockRowValid(sudoku));

        System.out.println(check(sudoku));
    }

    public static boolean check(int[][] sudoku) {
        if(areRowsValid(sudoku) && areColumnsValid(sudoku) && areBlocksValid(sudoku)) {
            return true;
        }

        return false;

    }

    private static boolean areBlocksValid(int[][] sudoku) {
       if(isTopBlockRowValid(sudoku) && isMiddleBlockRowValid(sudoku) && isBottomBlockRowValid(sudoku)) {
           return true;
       }
       return false;
    }

    private static boolean isTopBlockRowValid(int[][] sudoku) {
        int min =0;
        int max = 3;
        for (int k = 0; k < 3; k++) {
            List<Integer> numberRange = getNumberRange();
            for (int i = 0; i < 3; i++) {
                for (int j = min; j < max; j++) {
                    if(!numberInRange(numberRange, sudoku[i][j])){
                        return false;
                    }
                }
            }
            min = min + 3;
            max = max + 3;
        }
        return true;
    }

    private static boolean isMiddleBlockRowValid(int[][] sudoku) {
        int min =0;
        int max = 3;
        for (int k = 0; k < 3; k++) {
            List<Integer> numberRange = getNumberRange();
            for (int i = 3; i < 6; i++) {
                for (int j = min; j < max; j++) {
                    if(!numberInRange(numberRange, sudoku[i][j])){
                        return false;
                    }
                }

            }
            min = min + 3;
            max = max + 3;
        }
        return true;
    }

    private static boolean isBottomBlockRowValid(int[][] sudoku) {
        int min =0;
        int max = 3;
        for (int k = 0; k < 3; k++) {
            List<Integer> numberRange = getNumberRange();
            for (int i = 6; i < 9; i++) {
                for (int j = min; j < max; j++) {
                    if(!numberInRange(numberRange, sudoku[i][j])){
                        return false;
                    }
                }
            }
            min = min + 3;
            max = max + 3;
        }
        return true;
    }


    private static boolean areColumnsValid(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            List<Integer> numberRange = getNumberRange();
            for (int j = 0; j < sudoku.length; j++) {
                if(!numberInRange(numberRange, sudoku[j][i])){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean areRowsValid(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            List<Integer> numberRange = getNumberRange();
            for (int j = 0; j < sudoku.length; j++) {
                if(!numberInRange(numberRange, sudoku[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> getNumberRange() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static boolean numberInRange(List<Integer> numbers, int number) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) == number) {
                numbers.remove(i);
                return true;
            }
        }
        return false;

    }

    @Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertEquals(true, check(sudoku));

        sudoku[4][4] = 0;

        assertEquals(false, check(sudoku));
    }
}
