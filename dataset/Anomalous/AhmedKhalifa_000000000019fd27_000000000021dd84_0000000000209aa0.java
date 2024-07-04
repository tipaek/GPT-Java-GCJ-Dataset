import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Inducium {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static int[][] grid;
    private static int k;

    public static void main(String[] args) throws IOException {
        solve();
        pw.flush();
        pw.close();
        bf.close();
    }

    private static boolean isValidPlacement(int row, int col, int num) {
        for (int x = 0; x < grid.length; ++x) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDiagonalSumCorrect() {
        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            sum += grid[i][i];
        }
        return sum == k;
    }

    private static void displayGrid() {
        for (int[] row : grid) {
            for (int cell : row) {
                pw.print(cell + " ");
            }
            pw.println();
        }
    }

    private static boolean generateGrid(int row, int col) {
        if (row == grid.length) {
            return isDiagonalSumCorrect();
        }
        for (int num = 1; num <= grid.length; ++num) {
            if (isValidPlacement(row, col, num)) {
                grid[row][col] = num;
                if (generateGrid(col == grid.length - 1 ? row + 1 : row, (col + 1) % grid.length)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static void solve() throws IOException {
        int testCases = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= testCases; ++t) {
            String[] input = bf.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);
            grid = new int[N][N];
            boolean isPossible = generateGrid(0, 0);
            if (isPossible) {
                pw.println("Case #" + t + ": POSSIBLE");
                displayGrid();
            } else {
                pw.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}