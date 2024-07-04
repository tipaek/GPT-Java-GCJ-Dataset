import java.util.*;
import java.io.*;

class Vestigium {

    static StreamTokenizer in;

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int T = nextInt();

        for (int loop=1; loop<=T; loop++) {
            int n = nextInt();

            int[][] squareMatrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    squareMatrix[i][j] = nextInt();
                }
            }

            int[] result = solve(n, squareMatrix);

            System.out.println("Case #" + loop + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
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


