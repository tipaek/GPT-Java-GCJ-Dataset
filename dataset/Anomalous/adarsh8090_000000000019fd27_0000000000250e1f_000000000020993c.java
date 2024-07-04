import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] tempMatrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    tempMatrix[i][j] = matrix[i][j];
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(tempMatrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}