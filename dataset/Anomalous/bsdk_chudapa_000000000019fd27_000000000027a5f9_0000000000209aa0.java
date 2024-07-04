import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 60;
    private static Scanner scanner;
    private static int testCaseNumber = 1;
    private static int[][] square = new int[MAX_SIZE][MAX_SIZE];
    private static int n, k;
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean solved;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        solved = false;
        findSolution(1, 1, 0);

        if (!solved) {
            System.out.println("Case #" + (testCaseNumber++) + ": IMPOSSIBLE");
        }
    }

    private static void findSolution(int row, int col, int sum) {
        if (row == n && col == n + 1 && sum == k && !solved) {
            solved = true;
            printSolution();
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            findSolution(row + 1, 1, sum);
            return;
        }

        for (int q = 0; q < n && !solved; q++) {
            if (!rowSafe[row][q] && !colSafe[col][q]) {
                rowSafe[row][q] = colSafe[col][q] = true;
                if (row == col) {
                    sum += q;
                }
                square[row][col] = q;

                findSolution(row, col + 1, sum);

                rowSafe[row][q] = colSafe[col][q] = false;
                if (row == col) {
                    sum -= q;
                }
                square[row][col] = 0;
            }
        }
    }

    private static void printSolution() {
        System.out.println("Case #" + (testCaseNumber++) + ": POSSIBLE");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}