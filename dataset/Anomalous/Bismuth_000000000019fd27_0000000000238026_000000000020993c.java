import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int sumRow = 0;
            int sumCol = 0;

            // Read matrix and calculate trace
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for duplicate values in rows and columns
            for (int j = 0; j < N; j++) {
                boolean[] rowCheck = new boolean[N + 1];
                boolean[] colCheck = new boolean[N + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < N; k++) {
                    if (!rowHasDuplicate && rowCheck[matrix[j][k]]) {
                        sumRow++;
                        rowHasDuplicate = true;
                    }
                    if (!colHasDuplicate && colCheck[matrix[k][j]]) {
                        sumCol++;
                        colHasDuplicate = true;
                    }
                    rowCheck[matrix[j][k]] = true;
                    colCheck[matrix[k][j]] = true;
                }
            }

            ans.append("Case #").append(i + 1).append(": ").append(trace).append(" ").append(sumRow).append(" ").append(sumCol).append("\n");
        }

        System.out.print(ans.toString());
    }
}