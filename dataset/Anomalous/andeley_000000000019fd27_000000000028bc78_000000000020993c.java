import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int diagonalSum = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }
}