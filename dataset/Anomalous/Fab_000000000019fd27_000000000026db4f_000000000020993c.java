import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposedMatrix[col][row] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
                if (hasRepeatedElements(matrix[row])) {
                    repeatedRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                if (hasRepeatedElements(transposedMatrix[col])) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}