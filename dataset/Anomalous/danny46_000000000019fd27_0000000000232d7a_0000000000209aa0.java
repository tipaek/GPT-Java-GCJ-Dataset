import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; ++testCase) {
            int matrixSize = scanner.nextInt();
            int targetSum = scanner.nextInt();
            
            String result = solve(matrixSize, targetSum);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String solve(int size, int target) {
        int[][] matrix = new int[size][size];
        
        if (fillMatrix(matrix, target)) {
            StringBuilder resultBuilder = new StringBuilder("POSSIBLE");
            
            for (int[] row : matrix) {
                resultBuilder.append('\n');
                for (int value : row) {
                    resultBuilder.append(value).append(' ');
                }
            }
            
            return resultBuilder.toString().trim();
        }
        
        return "IMPOSSIBLE";
    }

    private static boolean fillMatrix(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 0) {
                    List<Integer> candidates = generateCandidates(matrix, row, col);
                    
                    if (!candidates.isEmpty()) {
                        for (int candidate : candidates) {
                            matrix[row][col] = candidate;
                            
                            if (fillMatrix(matrix, target)) {
                                return true;
                            }
                            
                            matrix[row][col] = 0;
                        }
                        
                        return false;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return calculateTrace(matrix) == target;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        
        return trace;
    }

    private static List<Integer> generateCandidates(int[][] matrix, int row, int col) {
        List<Integer> rowValues = new ArrayList<>();
        List<Integer> colValues = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            rowValues.add(matrix[row][i]);
            colValues.add(matrix[i][col]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        
        for (int value = 1; value <= matrix.length; value++) {
            if (!rowValues.contains(value) && !colValues.contains(value)) {
                candidates.add(value);
            }
        }
        
        return candidates;
    }
}