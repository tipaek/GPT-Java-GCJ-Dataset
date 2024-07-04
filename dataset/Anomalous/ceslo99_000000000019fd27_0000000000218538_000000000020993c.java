import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            analyzeLatinSquare(matrix, matrixSize, testCase);
        }
    }

    public static void analyzeLatinSquare(int[][] matrix, int matrixSize, int caseNumber) {
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                    rowDuplicates++;
                    rowHasDuplicate = true;
                }

                if (!colSet.add(matrix[j][i]) && !colHasDuplicate) {
                    colDuplicates++;
                    colHasDuplicate = true;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, diagonalSum, rowDuplicates, colDuplicates);
    }
}