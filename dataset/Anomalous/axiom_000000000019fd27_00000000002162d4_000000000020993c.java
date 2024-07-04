import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }
                int[] result = calculate(matrix, size);
                System.out.printf("Case #%d: %d %d %d%n", caseNum, result[0], result[1], result[2]);
            }
        }
    }

    private static int[] calculate(int[][] matrix, int size) {
        int[] result = new int[3];
        
        // Calculate the trace of the matrix
        for (int i = 0; i < size; i++) {
            result[0] += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                result[1]++;
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != size) {
                result[2]++;
            }
        }

        return result;
    }
}