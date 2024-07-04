import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int rowRepeats = countRowRepeats(matrix);
            int columnRepeats = countColumnRepeats(matrix);
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix) {
        int repeats = 0;
        for (int[] row : matrix) {
            if (hasRepeats(row)) {
                repeats++;
            }
        }
        return repeats;
    }

    private static int countColumnRepeats(int[][] matrix) {
        int repeats = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepeats(column)) {
                repeats++;
            }
        }
        return repeats;
    }

    private static boolean hasRepeats(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : array) {
            if (!uniqueElements.add(num)) {
                return true;
            }
        }
        return false;
    }
}