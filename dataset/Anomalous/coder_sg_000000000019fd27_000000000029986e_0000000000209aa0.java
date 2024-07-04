import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static ArrayList<ArrayList<Integer>> allPossiblePerm;
    private static int[][] square;
    private static StringBuilder sb;

    private static boolean startFilling(int currCell, int n, int k, boolean[][] rows, boolean[][] cols) {
        if (currCell == n * n) return true;

        int currRow = currCell / n;
        int currCol = currCell % n;

        if (currRow == currCol) {
            return startFilling(currCell + 1, n, k, rows, cols);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!rows[currRow][i] && !cols[currCol][i]) {
                    square[currRow][currCol] = i;
                    rows[currRow][i] = true;
                    cols[currCol][i] = true;
                    if (startFilling(currCell + 1, n, k, rows, cols)) return true;
                    rows[currRow][i] = false;
                    cols[currCol][i] = false;
                }
            }
        }
        return false;
    }

    private static boolean fillSquare(int n, int k, boolean[][] rows, boolean[][] cols) {
        return startFilling(0, n, k, rows, cols);
    }

    private static void possibleLatinSquares(int n, int k, int tC) {
        if (allPossiblePerm.isEmpty()) {
            sb.append("Case #").append(tC).append(": IMPOSSIBLE\n");
            return;
        }

        for (ArrayList<Integer> diagonal : allPossiblePerm) {
            square = new int[n][n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];

            for (int j = 0; j < n; j++) {
                int d = diagonal.get(j);
                square[j][j] = d;
                rows[j][d] = true;
                cols[j][d] = true;
            }

            if (fillSquare(n, k, rows, cols)) {
                sb.append("Case #").append(tC).append(": POSSIBLE\n");
                for (int[] row : square) {
                    for (int cell : row) {
                        sb.append(cell).append(" ");
                    }
                    sb.append("\n");
                }
                return;
            }
        }
        sb.append("Case #").append(tC).append(": IMPOSSIBLE\n");
    }

    private static void generateAllPerm(int currIndex, ArrayList<Integer> currPerm, int currSum, int n, int k) {
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
        sb = new StringBuilder();

        for (int tC = 1; tC <= t; tC++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            allPossiblePerm = new ArrayList<>();
            generateAllPerm(0, new ArrayList<>(), 0, n, k);
            possibleLatinSquares(n, k, tC);
        }
        System.out.println(sb);
    }
}