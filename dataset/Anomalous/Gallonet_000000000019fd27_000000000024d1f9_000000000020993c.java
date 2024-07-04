import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0, repeatedRows = 0, repeatedColumns = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for repeated rows
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Check for repeated columns
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }

        sc.close();
    }
}