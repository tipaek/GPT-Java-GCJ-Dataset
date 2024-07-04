import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            rowDuplicates++;
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
            }

            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            colDuplicates++;
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}