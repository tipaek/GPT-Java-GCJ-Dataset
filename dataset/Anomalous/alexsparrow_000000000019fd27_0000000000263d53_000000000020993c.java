import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[101];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        columnRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
        }
        
        scanner.close();
    }
}