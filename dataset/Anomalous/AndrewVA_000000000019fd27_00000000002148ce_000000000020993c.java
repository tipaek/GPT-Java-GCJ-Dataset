import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int rowRepeats = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int columnRepeats = 0;
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnRepeats++;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
        }
    }
}