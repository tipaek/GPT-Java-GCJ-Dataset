import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCases = in.nextInt();
        String[] results = new String[numOfCases];

        for (int i = 0; i < numOfCases; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Check for duplicate rows
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}