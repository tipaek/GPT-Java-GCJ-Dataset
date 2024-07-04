import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            analyzeMatrix(matrix, size, caseIndex);
        }
        
        scanner.close();
    }

    public static void analyzeMatrix(int[][] matrix, int size, int caseIndex) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        int caseNumber = caseIndex + 1;

        // Calculate diagonal sum
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for repeated rows
        for (int row = 0; row < size; row++) {
            Map<Integer, Integer> rowElements = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (rowElements.containsKey(matrix[row][col])) {
                    repeatedRows++;
                    break;
                } else {
                    rowElements.put(matrix[row][col], 1);
                }
            }
        }

        // Check for repeated columns
        for (int col = 0; col < size; col++) {
            Map<Integer, Integer> colElements = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (colElements.containsKey(matrix[row][col])) {
                    repeatedCols++;
                    break;
                } else {
                    colElements.put(matrix[row][col], 1);
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
    }
}