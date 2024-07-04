import java.util.*;
import java.io.*;

public class Solution {

    private static int[] compute(int n, int[][] arr) {
        int[] res = new int[3];

        List<Set<Integer>> cols = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cols.add(i, new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    res[0] += arr[i][j];
                }
                row.add(arr[i][j]);
                cols.get(j).add(arr[i][j]);
            }
            if (row.size() != n) {
                res[1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (cols.get(i).size() != n) {
                res[2]++;
            }
        }

        return res;

        // 0 - sum
        // 1 - rows
        // 2 - cols
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] arr = new int[n][n];
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    arr[k][j] = in.nextInt();
                }
            }

            int[] r = compute(n, arr);

            System.out.println("Case #" + i + ": " + r[0] + " " + r[1] + " " + r[2]);
        }
    }

}
