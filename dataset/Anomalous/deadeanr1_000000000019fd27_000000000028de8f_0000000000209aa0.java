import java.util.*;

public class Solution {
    private static final int MAX_SIZE = 55;
    private static int[] N;
    private static Scanner sc;
    private static int tn = 1;
    private static int[][] M = new int[MAX_SIZE][MAX_SIZE];
    private static int n, k;
    private static List<Set<Integer>> rows = new ArrayList<>(MAX_SIZE);
    private static List<Set<Integer>> columns = new ArrayList<>(MAX_SIZE);
    private static boolean solved;

    static {
        for (int i = 0; i < MAX_SIZE; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            initialize();
            n = sc.nextInt();
            k = sc.nextInt();
            N = new int[n];

            if (k % n == 0) {
                handleDivisibleCase();
            } else {
                solvePuzzle(1, 1, 0);
                if (!solved) {
                    System.out.println("Case #" + (tn++) + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void initialize() {
        solved = false;
        for (int i = 0; i < MAX_SIZE; i++) {
            rows.get(i).clear();
            columns.get(i).clear();
        }
    }

    private static void handleDivisibleCase() {
        for (int j = 0; j < n; j++) {
            N[j] = j + 1;
        }
        int d = k / n - 1;
        System.out.println("Case #" + (tn++) + ": POSSIBLE");
        for (int x = 0; x < n; x++) {
            int temp = d + n - x;
            for (int j = 0; j < n; j++) {
                System.out.print(N[(temp + j) % n]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void solvePuzzle(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            printSolution();
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solvePuzzle(row + 1, 1, m);
            return;
        }

        for (int q = 1; q <= n && !solved; q++) {
            if (isValidPlacement(row, col, q)) {
                placeNumber(row, col, q);
                solvePuzzle(row, col + 1, m + (row == col ? q : 0));
                removeNumber(row, col, q);
            }
        }
    }

    private static boolean isValidPlacement(int row, int col, int q) {
        return !rows.get(row).contains(q) && !columns.get(col).contains(q) && (row != col || m + q + Math.min(n - row, n - col) <= k);
    }

    private static void placeNumber(int row, int col, int q) {
        rows.get(row).add(q);
        columns.get(col).add(q);
        M[row][col] = q;
    }

    private static void removeNumber(int row, int col, int q) {
        rows.get(row).remove(q);
        columns.get(col).remove(q);
        M[row][col] = 0;
    }

    private static void printSolution() {
        System.out.println("Case #" + (tn++) + ": POSSIBLE");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(M[i][j]);
                if (j != n) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}