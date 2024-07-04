import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int N = 0;
    private static int K = 0;
    private static int caseNumber = 0;
    private static int[][] grid = new int[1000][1000];
    private static boolean[][] visitedRow = new boolean[1000][1000];
    private static boolean[][] visitedCol = new boolean[1000][1000];
    private static boolean isValid = false;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                caseNumber++;
                String[] input = br.readLine().trim().split("\\s+");
                N = Integer.parseInt(input[0]);
                K = Integer.parseInt(input[1]);
                solve(1, 1, 0);

                if (!isValid) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
                isValid = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(int row, int col, int sum) {
        if (row == N && col == N + 1 && sum == K && !isValid) {
            isValid = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printGrid();
            return;
        }
        if (row > N) {
            return;
        }
        if (col > N) {
            solve(row + 1, 1, sum);
            return;
        }

        for (int i = 1; i <= N && !isValid; i++) {
            if (!visitedRow[row][i] && !visitedCol[col][i]) {
                visitedRow[row][i] = visitedCol[col][i] = true;
                if (row == col) {
                    sum += i;
                }
                grid[row][col] = i;
                solve(row, col + 1, sum);
                visitedRow[row][i] = visitedCol[col][i] = false;
                if (row == col) {
                    sum -= i;
                }
                grid[row][col] = 0;
            }
        }
    }

    private static void printGrid() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}