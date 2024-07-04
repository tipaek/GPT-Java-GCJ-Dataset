import java.io.IOException;
import java.util.*;

public class Jam {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int testCaseNumber = 0;

        while (testCases-- > 0) {
            testCaseNumber++;
            try {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int diagonalSum = 0;

                // Reading the matrix and calculating the diagonal sum
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            diagonalSum += matrix[i][j];
                        }
                    }
                }

                int duplicateRows = 0, duplicateCols = 0;

                // Checking for duplicate values in rows
                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!rowSet.add(matrix[i][j])) {
                            duplicateRows++;
                            break;
                        }
                    }
                }

                // Checking for duplicate values in columns
                for (int j = 0; j < n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        if (!colSet.add(matrix[i][j])) {
                            duplicateCols++;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        scanner.close();
    }
}