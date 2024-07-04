

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author satish.thulva. Generated on 11/04/20
 **/
public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTests; i += 1) {
                parseAndSolveTestCase(i + 1, reader);
            }
        }
    }

    private static void parseAndSolveTestCase(int testNumber, BufferedReader reader) throws IOException {
        String[] split = reader.readLine().split(" ", -1);
        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);
        Cell[][] matrix = new Cell[rows][columns];
        for (int i = 0; i < rows; i += 1) {
            split = reader.readLine().split(" ", -1);
            for (int j = 0; j < columns; j += 1) {
                Cell cell = new Cell();
                cell.value = Integer.parseInt(split[j]);
                if (j > 0) {
                    cell.left = matrix[i][j - 1];
                    cell.left.right = cell;
                }
                if (i > 0) {
                    cell.top = matrix[i - 1][j];
                    cell.top.bottom = cell;
                }
                matrix[i][j] = cell;
            }
        }
        System.out.println("Case #" + testNumber + ": " + playGame(matrix));
    }

    private static class Cell {
        int value;
        boolean eliminate;
        Cell left;
        Cell right;
        Cell top;
        Cell bottom;

        public boolean shouldEliminate() {
            int numNeighbours = 0;
            double neighboursValue = 0;
            if (left != null) {
                neighboursValue += left.value;
                numNeighbours += 1;
            }
            if (right != null) {
                neighboursValue += right.value;
                numNeighbours += 1;
            }
            if (top != null) {
                neighboursValue += top.value;
                numNeighbours += 1;
            }
            if (bottom != null) {
                neighboursValue += bottom.value;
                numNeighbours += 1;
            }
            return numNeighbours > 0 && neighboursValue / numNeighbours > value;
        }
    }

    private static int getRoundValue(Cell[][] square) {
        int numRows = square.length;
        int numColumns = square[0].length;

        int value = 0;
        for (int i = 0; i < numRows; i += 1) {
            for (int j = 0; j < numColumns; j += 1) {
                value += square[i][j].value;
                if (square[i][j].shouldEliminate()) {
                    square[i][j].eliminate = true;
                }
            }
        }

        return value;
    }

    private static int playRound(Cell[][] square) {
        int value = getRoundValue(square);
        int numRows = square.length;
        int numColumns = square[0].length;
        for (int i = 0; i < numRows; i += 1) {
            for (int j = 0; j < numColumns; j += 1) {
                Cell cell = square[i][j];
                if (cell != null && cell.eliminate) {
                    square[i][j].value = 0;
                    if (cell.left != null) {
                        cell.left.right = cell.right;
                    }
                    if (cell.right != null) {
                        cell.right.left = cell.left;
                    }
                    if (cell.top != null) {
                        cell.top.bottom = cell.bottom;
                    }
                    if (cell.bottom != null) {
                        cell.bottom.top = cell.top;
                    }
                }
            }
        }
        return value;
    }

    private static int playGame(Cell[][] square) {
        int prevValue = -1;
        int curValue = 0;
        int aggValue = 0;
        while (true) {
            curValue = playRound(square);
            if (curValue == 0 || curValue == prevValue) {
                break;
            }

            aggValue += curValue;
            prevValue = curValue;
        }
        return aggValue;
    }

}
