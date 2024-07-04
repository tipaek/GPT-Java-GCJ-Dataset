import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                scanner.nextLine();
            }
            
            processCase(caseNumber, matrixSize, matrix);
        }
        
        scanner.close();
    }

    private static void processCase(int caseNumber, int matrixSize, int[][] matrix) {
        int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
        
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
                columnSet.add(matrix[j][i]);
            }
            
            if (rowSet.size() != matrixSize) {
                rowDuplicates++;
            }
            if (columnSet.size() != matrixSize) {
                columnDuplicates++;
            }
        }
        
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, columnDuplicates);
    }
}