import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = input.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
            }

            int kRow = 0, kCol = 0;

            // Check for duplicate values in each row
            for (int r = 0; r < N; r++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        kRow++;
                        break;
                    }
                }
            }

            // Check for duplicate values in each column
            for (int c = 0; c < N; c++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        kCol++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + kRow + " " + kCol);
        }

        input.close();
    }
}