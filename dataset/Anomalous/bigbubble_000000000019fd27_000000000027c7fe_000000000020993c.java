import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);
            
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int repeatedCols = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedCols++;
                    break;
                }
            }
        }
        return repeatedCols;
    }
}