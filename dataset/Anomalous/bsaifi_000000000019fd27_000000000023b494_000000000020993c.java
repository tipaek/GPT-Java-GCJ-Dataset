import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int k = 1; k <= testCases; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);
            
            System.out.println("Case #" + k + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}