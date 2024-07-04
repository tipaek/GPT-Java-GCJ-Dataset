import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            int[][] matrix = new int[n][n];

            int[][] minMaxCols = new int[2][n];
            int[][] minMaxRows = new int[2][n];

            // Initialize min and max values
            for (int i = 0; i < n; i++) {
                minMaxCols[0][i] = minMaxRows[0][i] = n;
                minMaxCols[1][i] = minMaxRows[1][i] = 1;
            }

            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(tokens[j]);
                    matrix[i][j] = value;

                    // Update min and max for columns
                    if (value < minMaxCols[0][j]) minMaxCols[0][j] = value;
                    if (value > minMaxCols[1][j]) minMaxCols[1][j] = value;

                    // Update min and max for rows
                    if (value < minMaxRows[0][i]) minMaxRows[0][i] = value;
                    if (value > minMaxRows[1][i]) minMaxRows[1][i] = value;
                }

                // Calculate trace
                trace += matrix[i][i];
            }

            int colDiff = 0, rowDiff = 0;
            for (int i = 0; i < n; i++) {
                if (minMaxCols[0][i] > 1 || minMaxCols[1][i] < n) colDiff++;
                if (minMaxRows[0][i] > 1 || minMaxRows[1][i] < n) rowDiff++;
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDiff + " " + colDiff);
        }

        scanner.close();
    }
}