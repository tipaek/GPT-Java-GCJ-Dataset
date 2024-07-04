import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[j][i] = scanner.nextInt();
                }
            }
            
            processMatrix(matrix, t);
        }
        
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int diagonalSum = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        int size = matrix.length;
        
        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                rowSet.add(value);
                if (i == j) {
                    diagonalSum += value;
                }
            }
            if (rowSet.size() < size) {
                rowRepeats++;
            }
        }
        
        for (int j = 0; j < size; j++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() < size) {
                colRepeats++;
            }
        }
        
        System.out.println(String.format("Case #%d: %d %d %d", caseNumber + 1, diagonalSum, colRepeats, rowRepeats));
    }
}