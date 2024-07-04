import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int loop=1; loop<=T; loop++) {
            int n = in.nextInt();

            int[][] squareMatrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    squareMatrix[i][j] = in.nextInt();
                }
            }

            int[] result = solve(n, squareMatrix);

            sb.append("Case #");
            sb.append(loop);
            sb.append(": ");
            sb.append(result[0]);
            sb.append(" ");
            sb.append(result[1]);
            sb.append(" ");
            sb.append(result[2]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int[] solve(int n, int[][] grid) {
        int k = 0; // trace of the matrix

        for (int i = 0; i < n; i++) {
            k += grid[i][i];
        }

        int numRepeatRows = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> hs = new HashSet<>();

            for (int j = 0; j < n; j++) {
                int num = grid[i][j];

                if (hs.contains(num)) {
                    numRepeatRows++;
                    break;
                }

                hs.add(num);
            }
        }

        int numRepeatCols = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> hs = new HashSet<>();

            for (int j = 0; j < n; j++) {
                int num = grid[j][i];

                if (hs.contains(num)) {
                    numRepeatCols++;
                    break;
                }

                hs.add(num);
            }
        }

        return new int[] {k, numRepeatRows, numRepeatCols};
    }
}


