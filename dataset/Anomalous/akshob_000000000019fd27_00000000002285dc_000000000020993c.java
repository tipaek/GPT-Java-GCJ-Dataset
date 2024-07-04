import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCases = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int arraySize = sc.nextInt();
            int[][] matrix = new int[arraySize][arraySize];

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            processMatrix(matrix, arraySize, caseNumber);
        }
    }

    public static void processMatrix(int[][] matrix, int arraySize, int caseNumber) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        // Calculate diagonal sum
        for (int i = 0; i < arraySize; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for repeated rows
        for (int i = 0; i < arraySize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < arraySize; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    repeatedRows++;
                    break;
                }
            }
        }

        // Check for repeated columns
        for (int j = 0; j < arraySize; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < arraySize; i++) {
                if (!colSet.add(matrix[i][j])) {
                    repeatedCols++;
                    break;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
    }
}