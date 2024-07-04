import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposedMatrix[col][row] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
                repeatedRows += hasDuplicates(matrix[row]);
            }

            for (int col = 0; col < matrixSize; col++) {
                repeatedColumns += hasDuplicates(transposedMatrix[col]);
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return 1;
            }
        }
        return 0;
    }
}