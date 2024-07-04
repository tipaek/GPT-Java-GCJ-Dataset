import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Reading matrix and calculating diagonal sum
            for (int i = 0; i < size; i++) {
                HashMap<Integer, Boolean> rowElements = new HashMap<>();
                boolean hasDuplicateRow = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (rowElements.put(matrix[i][j], true) != null) {
                        hasDuplicateRow = true;
                    }
                }
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate columns
            for (int j = 0; j < size; j++) {
                HashMap<Integer, Boolean> colElements = new HashMap<>();
                boolean hasDuplicateCol = false;
                for (int i = 0; i < size; i++) {
                    if (colElements.put(matrix[i][j], true) != null) {
                        hasDuplicateCol = true;
                    }
                }
                if (hasDuplicateCol) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        scanner.close();
    }
}