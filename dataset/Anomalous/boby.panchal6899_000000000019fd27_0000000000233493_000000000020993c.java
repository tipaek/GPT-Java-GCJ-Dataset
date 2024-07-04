import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
                for (int j = 0; j < matrixSize; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + caseIndex + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}