import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate row duplicates
            int rowDuplicates = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Calculate column duplicates
            int colDuplicates = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}