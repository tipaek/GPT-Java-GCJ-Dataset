import java.util.Scanner;

public class Solution {
    static int[][] grid;
    static boolean[][] rowUsed;
    static boolean[][] colUsed;
    static int n;
    static int k;
    static int caseNumber;
    static boolean solutionFound;
    static boolean[][] rowSumUsed;

    public static void solveSudoku(int row, int col, int currentSum) {
        if (row == n && col == n + 1 && currentSum == k && !solutionFound) {
            solutionFound = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solveSudoku(row + 1, 1, currentSum);
        }

        for (int i = 1; i <= n && !solutionFound; i++) {
            if (!rowSumUsed[row][i] && !colUsed[col][i]) {
                rowSumUsed[row][i] = colUsed[col][i] = true;
                if (row == col) {
                    currentSum += i;
                }
                grid[row][col] = i;
                solveSudoku(row, col + 1, currentSum);
                rowSumUsed[row][i] = colUsed[col][i] = false;
                if (row == col) {
                    currentSum -= i;
                }
                grid[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            caseNumber++;
            n = sc.nextInt();
            k = sc.nextInt();
            grid = new int[n + 2][n + 2];
            rowSumUsed = new boolean[n + 2][n + 2];
            colUsed = new boolean[n + 2][n + 2];
            solutionFound = false;
            solveSudoku(1, 1, 0);
            if (!solutionFound) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}