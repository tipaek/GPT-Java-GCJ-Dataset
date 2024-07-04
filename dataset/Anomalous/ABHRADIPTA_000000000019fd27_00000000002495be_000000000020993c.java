import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(in.readLine());
        int[] sums = new int[testCaseCount];
        int[] duplicateRows = new int[testCaseCount];
        int[] duplicateCols = new int[testCaseCount];

        for (int a = 0; a < testCaseCount; a++) {
            int n = Integer.parseInt(in.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] elements = in.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }

                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            sums[a] = sum;
            duplicateRows[a] = rowDuplicates;
            duplicateCols[a] = colDuplicates;
        }

        for (int a = 0; a < testCaseCount; a++) {
            System.out.println("Case #" + (a + 1) + ": " + sums[a] + " " + duplicateRows[a] + " " + duplicateCols[a]);
        }
    }
}