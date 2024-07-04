package vestigium;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            solve(matrix, t);
        }

        scanner.close();
    }

    private static void solve(int[][] matrix, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
                
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            
            if (rowSet.size() < size) {
                rowRepeats++;
            }
            if (colSet.size() < size) {
                colRepeats++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, trace, rowRepeats, colRepeats);
    }
}