import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    public static ArrayList<ArrayList<Integer>> allPossiblePerm;
    public static int[][] square;

    public static boolean startFilling(int currCell, int n, boolean[][] rows, boolean[][] cols) {
        if (currCell == n * n) return true;

        int currRow = currCell / n;
        int currCol = currCell % n;

        if (currRow == currCol) return startFilling(currCell + 1, n, rows, cols);

        for (int i = 1; i <= n; i++) {
            if (!rows[currRow][i] && !cols[currCol][i]) {
                square[currRow][currCol] = i;
                rows[currRow][i] = true;
                cols[currCol][i] = true;
                if (startFilling(currCell + 1, n, rows, cols)) return true;
                rows[currRow][i] = false;
                cols[currCol][i] = false;
            }
        }
        return false;
    }

    public static boolean fillSquare(int n, boolean[][] rows, boolean[][] cols) {
        return startFilling(0, n, rows, cols);
    }

    public static void possibleLatinSquares(int n, int k, int tC) {
        if (allPossiblePerm.isEmpty()) {
            System.out.println("Case #" + tC + ": IMPOSSIBLE\n");
            return;
        }

        for (ArrayList<Integer> diagonal : allPossiblePerm) {
            square = new int[n][n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];

            for (int i = 0; i < n; i++) {
                int d = diagonal.get(i);
                square[i][i] = d;
                rows[i][d] = true;
                cols[i][d] = true;
            }

            if (fillSquare(n, rows, cols)) {
                System.out.println("Case #" + tC + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(square[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Case #" + tC + ": IMPOSSIBLE");
    }

    public static void generateAllPerm(int currIndex, ArrayList<Integer> currPerm, int currSum, int n, int k) {
        if (currIndex == n) {
            if (currSum == k) allPossiblePerm.add(new ArrayList<>(currPerm));
            return;
        }

        if (currSum > k) return;

        for (int i = 1; i <= n; i++) {
            currPerm.add(i);
            generateAllPerm(currIndex + 1, currPerm, currSum + i, n, k);
            currPerm.remove(currPerm.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tC = 1; tC <= t; tC++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            allPossiblePerm = new ArrayList<>();
            generateAllPerm(0, new ArrayList<>(), 0, n, k);
            possibleLatinSquares(n, k, tC);
        }
    }
}