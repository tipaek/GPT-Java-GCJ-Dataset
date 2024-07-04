import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int[][] matrix = new int[n][n];
            int[][] columnStats = new int[3][n];
            int[][] rowStats = new int[3][n];

            initializeStats(columnStats, rowStats, n);

            int trace = 0;
            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int cellValue = Integer.parseInt(tokens[j]);
                    matrix[i][j] = cellValue;
                    updateStats(columnStats, rowStats, cellValue, i, j);
                }
                trace += matrix[i][i];
            }

            int columnDiff = calculateDifferences(columnStats, n);
            int rowDiff = calculateDifferences(rowStats, n);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDiff + " " + columnDiff);
        }
    }

    private static void initializeStats(int[][] columnStats, int[][] rowStats, int n) {
        for (int i = 0; i < n; i++) {
            columnStats[0][i] = rowStats[0][i] = n;
            columnStats[1][i] = rowStats[1][i] = 1;
        }
    }

    private static void updateStats(int[][] columnStats, int[][] rowStats, int cellValue, int row, int col) {
        if (cellValue < columnStats[0][col]) columnStats[0][col] = cellValue;
        if (cellValue > columnStats[1][col]) columnStats[1][col] = cellValue;
        columnStats[2][col] += cellValue;

        if (cellValue < rowStats[0][row]) rowStats[0][row] = cellValue;
        if (cellValue > rowStats[1][row]) rowStats[1][row] = cellValue;
        rowStats[2][row] += cellValue;
    }

    private static int calculateDifferences(int[][] stats, int n) {
        int differences = 0;
        int expectedSum = (n * n + n) / 2;

        for (int i = 0; i < n; i++) {
            if (stats[0][i] > 1 || stats[1][i] < n || stats[2][i] != expectedSum) {
                differences++;
            }
        }
        return differences;
    }
}