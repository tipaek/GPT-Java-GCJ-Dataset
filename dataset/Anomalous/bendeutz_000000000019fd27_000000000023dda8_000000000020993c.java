package firstRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = in.nextInt();
        for (int i = 1; i <= numberOfTests; i++) {
            int actualSizeOfSquare = in.nextInt();
            int[][] matrix = new int[actualSizeOfSquare][actualSizeOfSquare];
            for (int j = 0; j < actualSizeOfSquare; j++) {
                for (int k = 0; k < actualSizeOfSquare; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int trace = calculateTrace(matrix);
            int row = calculateRepeatedElementsInRow(matrix);
            int col = calculateRepeatedElementsInCol(matrix);
            printMatrix(i, trace, row, col);
        }
    }

    private static int calculateRepeatedElementsInRow(int[][] matrix) {
        int result = 0;
        for (int[] row : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int value : row) {
                if (!set.add(value)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private static int calculateRepeatedElementsInCol(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int[] row : matrix) {
                if (!set.add(row[i])) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private static int calculateTrace(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][i];
        }
        return result;
    }

    public static void printMatrix(int number, int trace, int row, int col) {
        System.out.println("Case #" + number + ": " + trace + " " + row + " " + col);
    }
}