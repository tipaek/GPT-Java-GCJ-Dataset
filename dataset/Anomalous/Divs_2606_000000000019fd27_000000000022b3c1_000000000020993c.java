import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Counting the number of rows with duplicates
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (set.contains(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                    set.add(matrix[i][j]);
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Counting the number of columns with duplicates
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (set.contains(matrix[j][i])) {
                        hasDuplicate = true;
                    }
                    set.add(matrix[j][i]);
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Printing the result for the current case
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }

        sc.close();
    }
}