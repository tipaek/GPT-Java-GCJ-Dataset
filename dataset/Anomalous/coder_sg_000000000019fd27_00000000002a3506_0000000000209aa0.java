import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    private static int[][] square;
    private static StringBuilder sb;

    private static boolean startFilling(int currCell, int n, int k, boolean[][] rows, boolean[][] cols) {
        if (currCell == n * n) {
            return true;
        }

        int currRow = currCell / n;
        int currCol = currCell % n;

        if (currRow == currCol) {
            return startFilling(currCell + 1, n, k, rows, cols);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!rows[currRow][i] && !cols[currCol][i]) {
                    int temp = square[currRow][currCol];
                    square[currRow][currCol] = i;
                    rows[currRow][i] = true;
                    cols[currCol][i] = true;
                    boolean done = startFilling(currCell + 1, n, k, rows, cols);
                    if (done) {
                        return true;
                    }
                    square[currRow][currCol] = temp;
                    rows[currRow][i] = false;
                    cols[currCol][i] = false;
                }
            }
        }

        return false;
    }

    private static boolean possibleLatinSquares(ArrayList<Integer> diagonal, int n, int k, int tC) {
        square = new int[n][n];
        boolean[][] rows = new boolean[n][n + 1];
        boolean[][] cols = new boolean[n][n + 1];

        for (int j = 0; j < n; j++) {
            int digit = diagonal.get(j);
            square[j][j] = digit;
            rows[j][digit] = true;
            cols[j][digit] = true;
        }

        boolean isPossible = startFilling(0, n, k, rows, cols);

        if (isPossible) {
            sb.append("Case #").append(tC).append(": POSSIBLE\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(square[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return true;
        }
        return false;
    }

    private static boolean generateAllPerm(int currIndex, ArrayList<Integer> currPerm, int currSum, int n, int k, int tC) {
        if (currIndex == n) {
            if (currSum == k) {
                return possibleLatinSquares(currPerm, n, k, tC);
            }
            return false;
        }

        if (currSum > k) {
            return false;
        }

        for (int i = 1; i <= n; i++) {
            currPerm.add(i);
            if (generateAllPerm(currIndex + 1, currPerm, currSum + i, n, k, tC)) {
                return true;
            }
            currPerm.remove(currPerm.size() - 1);
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tC = 1; tC <= t; tC++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            boolean isPossible = generateAllPerm(0, new ArrayList<>(), 0, n, k, tC);
            if (!isPossible) {
                sb.append("Case #").append(tC).append(": IMPOSSIBLE\n");
            }
        }
        System.out.println(sb);
    }
}