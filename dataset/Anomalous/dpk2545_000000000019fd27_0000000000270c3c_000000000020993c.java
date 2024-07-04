import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int caseNumber = 1;
            while (testCases-- > 0) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                evaluateMatrix(matrix, caseNumber++);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void evaluateMatrix(int[][] matrix, int caseNumber) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("0 0 0");
            return;
        }

        int n = matrix.length;
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        // Check rows and calculate trace
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                    rowDuplicates++;
                    rowHasDuplicate = true;
                }
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j]) && !colHasDuplicate) {
                    colDuplicates++;
                    colHasDuplicate = true;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}