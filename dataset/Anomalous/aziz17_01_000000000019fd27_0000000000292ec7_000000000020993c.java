import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numOfCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate values
            int duplicateRows = 0;
            for (int row = 0; row < size; row++) {
                boolean[] seen = new boolean[size + 1];
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    if (seen[matrix[row][col]]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Calculate the number of columns with duplicate values
            int duplicateCols = 0;
            for (int col = 0; col < size; col++) {
                boolean[] seen = new boolean[size + 1];
                boolean hasDuplicate = false;
                for (int row = 0; row < size; row++) {
                    if (seen[matrix[row][col]]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}