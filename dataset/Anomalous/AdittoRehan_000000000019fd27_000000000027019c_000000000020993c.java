import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[] rowDup = new int[n];
            int[] colDup = new int[n];

            // Reading matrix input and calculating trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = input.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Finding duplicate values in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowDup[row]++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Finding duplicate values in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colDup[col]++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Summing up rows and columns with duplicates
            for (int x : rowDup) {
                rowDuplicates += x;
            }
            for (int x : colDup) {
                colDuplicates += x;
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}