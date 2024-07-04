import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution { // Square Dance
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int r = in.nextInt();
            int c = in.nextInt();

            int nbCells = r * c;

            // Cell[] allCells = new Cell[nbCells];

            int[][] grid = new int[r][c];

            BigInteger competitionLevel = BigInteger.ZERO;

            for (int n = 0; n < r; n++) {
                for (int m = 0; m < c; m++) {
                    grid[n][m] = in.nextInt();

                    competitionLevel = competitionLevel.add(toBigInt(grid[n][m]));
                }
            }

            boolean eliminationDone = updateGrid(grid, r, c);;

            while (eliminationDone) {

                competitionLevel = competitionLevel.add(calcRoundLevel(grid, r, c));

                eliminationDone = updateGrid(grid, r, c);
            }

            System.out.println("Case #" + i + ": " + competitionLevel.toString());
        }
    }

    private static BigInteger calcRoundLevel(int[][] grid, int r, int c) {
        BigInteger sum = BigInteger.ZERO;

        for (int n = 0; n < r; n++) {
            for (int m = 0; m < c; m++) {
                sum = sum.add(toBigInt(grid[n][m]));
            }
        }

        return sum;
    }

    static boolean updateGrid(int[][] grid, int r, int c) {

        List<int[]> toEliminate = new ArrayList<>();

        boolean eliminationDone = false;

        for (int n = 0; n < r; n++) {
            for (int m = 0; m < c; m++) {
                if (grid[n][m] > 0 && canBeEliminated(grid, n, m, r, c)) {
                    eliminationDone = true;
                    toEliminate.add(new int[] { n, m });
                }
            }
        }

        for (int[] cell : toEliminate) {
            grid[cell[0]][cell[1]] = 0;
        }

        return eliminationDone;
    }

    private static boolean canBeEliminated(int[][] grid, int n, int m, int r, int c) {
        int neighborSum = 0;
        int neighborCount = 0;

        for (int i = m - 1; i >= 0; i--) {
            if (grid[n][i] > 0) {
                neighborSum += grid[n][i];
                neighborCount++;
                break;
            }
        }

        for (int i = m + 1; i < c; i++) {
            if (grid[n][i] > 0) {
                neighborSum += grid[n][i];
                neighborCount++;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (grid[i][m] > 0) {
                neighborSum += grid[i][m];
                neighborCount++;
                break;
            }
        }

        for (int i = n + 1; i < r; i++) {
            if (grid[i][m] > 0) {
                neighborSum += grid[i][m];
                neighborCount++;
                break;
            }
        }

        return (double) neighborSum / (double) neighborCount > grid[n][m];
    }

    static BigInteger toBigInt(int val) {
        return BigInteger.valueOf(val);
    }
}