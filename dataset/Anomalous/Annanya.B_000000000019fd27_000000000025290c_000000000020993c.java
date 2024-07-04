import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0, duplicateColumns = 0;
            Set<Integer> uniqueElements = new HashSet<>();

            // Read matrix and check for duplicate rows
            for (int row = 0; row < n; row++) {
                uniqueElements.clear();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != n) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                uniqueElements.clear();
                for (int row = 0; row < n; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != n) {
                    duplicateColumns++;
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Print result
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}