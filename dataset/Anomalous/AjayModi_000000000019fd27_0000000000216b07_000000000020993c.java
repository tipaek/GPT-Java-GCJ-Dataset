import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for repeated elements in rows and columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowRepeatFound = false;
                boolean colRepeatFound = false;

                for (int j = 0; j < n; j++) {
                    // Check row
                    if (!rowRepeatFound && !rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        rowRepeatFound = true;
                    }

                    // Check column
                    if (!colRepeatFound && !colSet.add(matrix[j][i])) {
                        colRepeats++;
                        colRepeatFound = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}