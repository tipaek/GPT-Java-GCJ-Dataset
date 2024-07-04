import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            System.out.print("Case #" + ks + ":");
            processCase(input);
        }
    }

    private static void processCase(Scanner input) {
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowCount = calculateDuplicateRows(matrix, n);
        int colCount = calculateDuplicateColumns(matrix, n);

        System.out.println(" " + trace + " " + rowCount + " " + colCount);
    }

    private static int calculateDuplicateRows(int[][] matrix, int n) {
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int calculateDuplicateColumns(int[][] matrix, int n) {
        int colCount = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }
}