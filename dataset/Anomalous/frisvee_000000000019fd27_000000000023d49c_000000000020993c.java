import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        int[][] matrix = new int[100][];
        for (int i = 0; i < 100; i++) {
            matrix[i] = new int[100];
        }
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];

                rowSet.clear();
                colSet.clear();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }

                if (colSet.size() != matrixSize) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}