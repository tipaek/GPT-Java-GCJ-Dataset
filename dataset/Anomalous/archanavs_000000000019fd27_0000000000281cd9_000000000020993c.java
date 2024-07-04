import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            analyzeMatrix(t, n, matrix);
        }
    }

    private static void analyzeMatrix(int caseNumber, int n, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowValues = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowValues.add(matrix[i][j]);
            }
            if (rowValues.size() != n) {
                duplicateRows++;
            }
        }
        
        for (int j = 0; j < n; j++) {
            HashSet<Integer> columnValues = new HashSet<>();
            for (int i = 0; i < n; i++) {
                columnValues.add(matrix[i][j]);
            }
            if (columnValues.size() != n) {
                duplicateColumns++;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}