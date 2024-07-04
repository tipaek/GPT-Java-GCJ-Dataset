import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            int[] result = trace(N, arr);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    public static int[] trace(int N, int[][] arr) {
        int[] info = new int[3];
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        boolean[] countedRow = new boolean[N];
        boolean[] countedCol = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = arr[i][j];
                if (i == j)
                    info[0] += value;
                if (!countedRow[i]) {
                    if (rows[i][value - 1] != 0) {
                        info[1]++;
                        countedRow[i] = true;
                    }
                    rows[i][value - 1] = 1;
                }
                if (!countedCol[j]) {
                    if (cols[value - 1][j] != 0) {
                        info[2]++;
                        countedCol[j] = true;
                    }
                    cols[value - 1][j] = 1;
                }
            }
        }
        return info;
    }
}