import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static int n1 = 0;
    public static int m1 = 0;
    public static boolean isPossible = false;
    public static int caseNumber = 0;

    static void solve(int[][] matrix, int targetSum, HashMap<Integer, HashMap<Integer, Boolean>> rows, HashMap<Integer, HashMap<Integer, Boolean>> cols, int row, int col) {
        if (row == n1) {
            return;
        }
        if (row == n1 - 1 && col == n1 && m1 == targetSum && !isPossible) {
            isPossible = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int x = 0; x < n1; x++) {
                for (int y = 0; y < n1; y++) {
                    System.out.print(matrix[x][y] + " ");
                }
                if (x != n1 - 1) {
                    System.out.println();
                }
            }
            return;
        }
        if (row == n1 - 1 && col == n1) {
            return;
        }
        if (col == n1) {
            solve(matrix, targetSum, rows, cols, row + 1, 0);
            return;
        }
        if (isPossible) {
            return;
        }
        for (int value = 1; value <= n1; value++) {
            if (!rows.get(row).containsKey(value) && !cols.get(col).containsKey(value)) {
                if (isPossible) {
                    return;
                }
                matrix[row][col] = value;
                if (row == col) {
                    m1 += value;
                }
                rows.get(row).put(value, true);
                cols.get(col).put(value, true);
                solve(matrix, targetSum, rows, cols, row, col + 1);
                rows.get(row).remove(value);
                cols.get(col).remove(value);
                if (row == col) {
                    m1 -= value;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        caseNumber = 1;
        while (caseNumber <= testCases) {
            isPossible = false;
            m1 = 0;
            n1 = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[][] matrix = new int[n1][n1];
            HashMap<Integer, HashMap<Integer, Boolean>> rows = new HashMap<>();
            HashMap<Integer, HashMap<Integer, Boolean>> cols = new HashMap<>();
            for (int i = 0; i < n1; i++) {
                rows.put(i, new HashMap<>());
                cols.put(i, new HashMap<>());
            }
            solve(matrix, targetSum, rows, cols, 0, 0);
            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
        scanner.close();
    }
}