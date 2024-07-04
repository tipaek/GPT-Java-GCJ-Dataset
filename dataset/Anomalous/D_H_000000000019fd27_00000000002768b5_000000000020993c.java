import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Reading the matrix
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check for repeated rows
            int repeatedRows = 0;
            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < N) {
                    repeatedRows++;
                }
            }

            // Check for repeated columns
            int repeatedColumns = 0;
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < N) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}