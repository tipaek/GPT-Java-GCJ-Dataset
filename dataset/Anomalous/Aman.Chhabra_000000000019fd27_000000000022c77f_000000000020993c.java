import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<SolutionResult> results = new ArrayList<>();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            results.add(analyzeMatrix(matrix));
        }
        
        int caseNumber = 1;
        for (SolutionResult result : results) {
            System.out.println("Case #" + caseNumber++ + ": " + result.k + " " + result.r + " " + result.c);
        }
        
        scanner.close();
    }

    private static SolutionResult analyzeMatrix(int[][] matrix) {
        SolutionResult result = new SolutionResult();
        int size = matrix.length;
        
        // Calculate the trace (sum of diagonal elements)
        for (int i = 0; i < size; i++) {
            result.k += matrix[i][i];
        }
        
        // Check for duplicate elements in each row
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    result.r++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        // Check for duplicate elements in each column
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    result.c++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        return result;
    }

    static class SolutionResult {
        int k = 0;
        int r = 0;
        int c = 0;
    }
}