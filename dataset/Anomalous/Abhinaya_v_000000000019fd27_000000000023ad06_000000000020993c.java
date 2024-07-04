import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            boolean validInput = true;

            // Read matrix and validate input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (value <= 0 || value > n) {
                        validInput = false;
                        break;
                    }
                    matrix[i][j] = value;
                }
                if (!validInput) break;
            }

            if (!validInput) break;

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            results[caseIndex][0] = trace;

            // Count duplicate rows
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            results[caseIndex][1] = duplicateRows;

            // Count duplicate columns
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            results[caseIndex][2] = duplicateColumns;
        }

        // Print results
        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }
}