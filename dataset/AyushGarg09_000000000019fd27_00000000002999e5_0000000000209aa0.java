import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int[][] createMatrix(int n, int t) {

        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (t == i * n)
                start = i;
        }

        if (start == 0)
            return null;

        int[] arr = new int[n];

        int val = start;
        for (int i = 0; i < n; i++) {
            arr[i] = val;
            val = val + 1;
            if (val == n + 1)
                val = 1;
        }

        int k = n;

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int c = 0;

            int temp = k;

            while (temp < n) {

                result[i][c++] = arr[temp];
                temp++;
            }

            for (int j = 0; j < k; j++) {

                result[i][c++] = arr[j];
            }

            k--;

        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {

            int n = in.nextInt();
            int k = in.nextInt();
            // System.out.println("Size: "+n+" Trace: "+k);
            int[][] result = Solution.createMatrix(n, k);
            if (result != null) {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n - 1; y++) {
                        System.out.print(result[x][y] + " ");
                    }
                    System.out.print(result[x][n - 1]);
                    System.out.println();
                }
            } else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            //
        }
        in.close();
    }
}