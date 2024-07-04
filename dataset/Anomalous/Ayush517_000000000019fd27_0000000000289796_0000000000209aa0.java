import java.util.Scanner;

class Solution {
    private static final int MAX_SIZE = 51;
    private static int[][] square = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] rowUsed = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colUsed = new boolean[MAX_SIZE][MAX_SIZE];
    private static int n, targetSum, caseNumber;
    private static boolean solved;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            n = scanner.nextInt();
            targetSum = scanner.nextInt();
            solved = false;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static void solve(int row, int col, int currentSum) {
        if (row == n && col == n + 1 && currentSum == targetSum && !solved) {
            solved = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printSquare();
            return;
        }
        
        if (row > n) {
            return;
        }
        
        if (col > n) {
            solve(row + 1, 1, currentSum);
            return;
        }
        
        for (int i = 1; i <= n && !solved; i++) {
            if (!rowUsed[row][i] && !colUsed[col][i]) {
                rowUsed[row][i] = colUsed[col][i] = true;
                if (row == col) {
                    currentSum += i;
                }
                square[row][col] = i;
                solve(row, col + 1, currentSum);
                rowUsed[row][i] = colUsed[col][i] = false;
                if (row == col) {
                    currentSum -= i;
                }
                square[row][col] = 0;
            }
        }
    }

    private static void printSquare() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}