import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[] results = new int[3];
            calculateVestigium(matrix, n, results);
            System.out.println("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
            caseNumber++;
        }
    }

    public static void calculateVestigium(int[][] matrix, int n, int[] results) {
        int[][] rowTracker = new int[n][n + 1];
        int[][] colTracker = new int[n][n + 1];
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];

                if (rowTracker[i][value] == 1) {
                    duplicateRows++;
                }
                if (colTracker[j][value] == 1) {
                    duplicateCols++;
                }

                rowTracker[i][value]++;
                colTracker[j][value]++;

                if (i == j) {
                    trace += value;
                }
            }
        }

        results[0] = trace;
        results[1] = duplicateRows;
        results[2] = duplicateCols;
    }
}