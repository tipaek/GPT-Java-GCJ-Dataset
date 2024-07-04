import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < N; i++) {
                HashSet<Integer> columnSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Print the results for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }

        sc.close();
    }
}