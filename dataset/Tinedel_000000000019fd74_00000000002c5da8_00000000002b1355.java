import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] danceFloor = readDanceFloor(R, C, in);
            System.out.println("Case #" + i + ": " + interestLevel(danceFloor));
        }
    }

    private static int interestLevel(int[][] danceFloor) {
        int level = interestLevelNow(danceFloor);
        while (someOneEliminated(danceFloor)) {
            level += interestLevelNow(danceFloor);
        }
        return level;
    }

    private static boolean someOneEliminated(int[][] danceFloor) {
        boolean res = false;
        int[][] nextRound = createNextRound(danceFloor);
        for (int i = 0; i < danceFloor.length; i++) {
            for (int j = 0; j < danceFloor[i].length; j++) {
                if(danceFloor[i][j] == 0) continue;
                double v = cardinalAvg(danceFloor, i, j);
                if (danceFloor[i][j] < v) {
                    res = true;
                    nextRound[i][j] = 0;
                } else {
                    nextRound[i][j] = danceFloor[i][j];
                }
            }
        }

        for (int i = 0; i < danceFloor.length; i++) {
            System.arraycopy(nextRound[i], 0, danceFloor[i], 0, danceFloor[i].length);
        }

        return res;
    }

    private static double cardinalAvg(int[][] danceFloor, int i, int j) {
        int R = danceFloor.length;
        int C = danceFloor[0].length;

        int r;
        int c;

        int sum = 0;
        int neighbors = 0;

        // look up
        r = i - 1;
        c = j;
        while (r >= 0 && danceFloor[r][c] == 0) {
            r--;
        }
        if (r >= 0 && danceFloor[r][c] > 0) {
            neighbors++;
            sum += danceFloor[r][c];
        }

        // look down
        r = i + 1;
        c = j;
        while (r < R && danceFloor[r][c] == 0) {
            r++;
        }
        if (r < R && danceFloor[r][c] > 0) {
            neighbors++;
            sum += danceFloor[r][c];
        }

        // look left
        r = i;
        c = j - 1;
        while (c >= 0 && danceFloor[r][c] == 0) {
            c--;
        }
        if (c >= 0 && danceFloor[r][c] > 0) {
            neighbors++;
            sum += danceFloor[r][c];
        }

        // look right
        r = i;
        c = j + 1;
        while (c < R && danceFloor[r][c] == 0) {
            c++;
        }
        if (c < R && danceFloor[r][c] > 0) {
            neighbors++;
            sum += danceFloor[r][c];
        }
        if (neighbors == 0) return 0.0;
        return 1.0 * sum / neighbors;
    }

    private static int[][] createNextRound(int[][] danceFloor) {
        int[][] res = new int[danceFloor.length][];
        for (int i = 0; i < danceFloor.length; i++) {
            res[i] = new int[danceFloor[i].length];
        }
        return res;
    }

    private static int interestLevelNow(int[][] danceFloor) {
        int sum = 0;
        for (int[] ints : danceFloor) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private static int[][] readDanceFloor(int r, int c, Scanner in) {
        int[][] danceFloor = new int[r][];
        for (int i = 0; i < r; i++) {
            danceFloor[i] = new int[c];
            for (int j = 0; j < c; j++) {
                danceFloor[i][j] = in.nextInt();
            }
        }
        return danceFloor;
    }
}