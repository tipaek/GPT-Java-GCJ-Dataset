import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static ArrayList<ArrayList<Integer>> allPossiblePerm;
    private static int[][] square;

    private static boolean fillSquare(int cell, int n, int k, boolean[][] rows, boolean[][] cols) {
        if (cell == n * n) return true;

        int row = cell / n;
        int col = cell % n;

        if (row == col) {
            return fillSquare(cell + 1, n, k, rows, cols);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!rows[row][i] && !cols[col][i]) {
                    square[row][col] = i;
                    rows[row][i] = true;
                    cols[col][i] = true;
                    if (fillSquare(cell + 1, n, k, rows, cols)) return true;
                    rows[row][i] = false;
                    cols[col][i] = false;
                }
            }
        }
        return false;
    }

    private static void generateLatinSquares(int n, int k, int testCase) {
        if (allPossiblePerm.isEmpty()) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            return;
        }

        for (ArrayList<Integer> diagonal : allPossiblePerm) {
            square = new int[n][n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];

            for (int i = 0; i < n; i++) {
                int val = diagonal.get(i);
                square[i][i] = val;
                rows[i][val] = true;
                cols[i][val] = true;
            }

            if (fillSquare(0, n, k, rows, cols)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int[] row : square) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
    }

    private static void generatePermutations(int index, ArrayList<Integer> currentPerm, int currentSum, int n, int k) {
        if (index == n) {
            if (currentSum == k) {
                allPossiblePerm.add(new ArrayList<>(currentPerm));
            }
            return;
        }

        if (currentSum > k) return;

        for (int i = 1; i <= n; i++) {
            currentPerm.add(i);
            generatePermutations(index + 1, currentPerm, currentSum + i, n, k);
            currentPerm.remove(currentPerm.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            allPossiblePerm = new ArrayList<>();
            generatePermutations(0, new ArrayList<>(), 0, n, k);
            generateLatinSquares(n, k, testCase);
        }
    }
}