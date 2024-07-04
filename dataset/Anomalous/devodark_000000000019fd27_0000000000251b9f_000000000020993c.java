import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int diagonalSum = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowSeen = new boolean[matrixSize + 1];
            boolean[] colSeen = new boolean[matrixSize + 1];
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }

                if (!rowHasRepeat && rowSeen[matrix[i][j]]) {
                    rowHasRepeat = true;
                    rowRepeats++;
                } else {
                    rowSeen[matrix[i][j]] = true;
                }

                if (!colHasRepeat && colSeen[matrix[j][i]]) {
                    colHasRepeat = true;
                    columnRepeats++;
                } else {
                    colSeen[matrix[j][i]] = true;
                }
            }
        }

        System.out.println(diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }
}