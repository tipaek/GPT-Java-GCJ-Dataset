import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void solve(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Reading matrix values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating trace
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Calculating row repetitions
        int rowRepetitions = calculateRepetitions(matrix, n, true);

        // Calculating column repetitions
        int columnRepetitions = calculateRepetitions(matrix, n, false);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepetitions + " " + columnRepetitions);
    }

    private static int calculateRepetitions(int[][] matrix, int n, boolean isRow) {
        int repetitions = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen[value]) {
                    repetitions++;
                    break;
                }
                seen[value] = true;
            }
        }
        return repetitions;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            solve(scanner, i);
        }
    }
}