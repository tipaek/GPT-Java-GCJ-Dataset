import java.io.*;

public class Solution {

    private int N;
    private int[][] matrix;
    private int targetSum;
    private boolean[][] colUsed;
    private boolean[][] rowUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; ++t) {
            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            solution.targetSum = Integer.parseInt(input[1]);
            solution.N = N;
            solution.matrix = new int[N][N];

            solution.rowUsed = new boolean[N][N + 1];
            solution.colUsed = new boolean[N][N + 1];

            if (solution.fillMatrix(0, 0, 0)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int i = 0; i < N; ++i) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < N; ++j) {
                        row.append(solution.matrix[i][j]).append(' ');
                    }
                    System.out.println(row.toString().trim());
                }
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private boolean fillMatrix(int currentSum, int row, int col) {
        if (row == col && row == N && currentSum == targetSum) {
            return true;
        } else if (row == col && row == N) {
            return false;
        } else if (currentSum >= targetSum && (row < N || col < N)) {
            return false;
        }

        for (int num = 1; num <= N; ++num) {
            if (!rowUsed[row][num] && !colUsed[col][num]) {
                matrix[row][col] = num;
                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                if (row == col) {
                    currentSum += num;
                    if (currentSum == targetSum && row == N - 1) {
                        return true;
                    }
                }
                if (col < N - 1) {
                    if (fillMatrix(currentSum, row, col + 1)) {
                        return true;
                    }
                } else if (col == N - 1 && row < N - 1) {
                    if (fillMatrix(currentSum, row + 1, 0)) {
                        return true;
                    }
                }
                rowUsed[row][num] = false;
                colUsed[col][num] = false;
                if (row == col) {
                    currentSum -= num;
                }
            }
        }

        return false;
    }
}