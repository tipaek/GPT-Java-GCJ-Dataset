import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int num = in.nextInt();
            int len = in.nextInt();
            int wid = in.nextInt();
            int sum = 0;
            int[][] array = new int[len][wid];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < wid; j++) {
                    array[i][j] = in.nextInt();
                    sum += array[i][j];
                }
            }
//            int res = getRes(array, len, wid);
            System.out.println("Case #" + index + ": " + getRes(array, index, num, sum));
        }
    }

    private static long getRes(int[][] act, int len, int wid, long all) {
        long res = all;
        float[][] sum = new float[len][wid];
        int[][] count = new int[len][wid];
        while (true) {
            for (int i = 0; i < len; i++) {
                int preSameRow = 0;
                int preSameCol = 0;
                for (int j = 0; j < wid; j++) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameRow;
                        if (preSameRow > 0) {
                            count[i][j]++;
                        }
                        preSameRow = act[i][j];
                    }
                    if (act[j][i] > 0) {
                        sum[j][i] += preSameCol;
                        if (preSameCol > 0) {
                            count[j][i]++;
                        }
                        preSameCol = act[j][i];
                    }
                }
            }

            for (int i = len - 1; i >= 0; i--) {
                int preSameRow = 0;
                int preSameCol = 0;
                for (int j = 0; j < wid; j++) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameRow;
                        if (preSameRow > 0) {
                            count[i][j]++;
                        }
                        preSameRow = act[i][j];
                    }
                    if (act[j][i] > 0) {
                        sum[j][i] += preSameCol;
                        if (preSameCol > 0) {
                            count[j][i]++;
                        }
                        preSameCol = act[j][i];
                    }
                }
            }
            boolean del = false;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < wid; j++) {
                    if (count[i][j] > 0 && act[i][j] < sum[i][j] / count[i][j]) {
                        del = true;
                        all -= act[i][j];
                        act[i][j] = -1;
                    }
                }
            }
            if (del) {
                res += all;
            } else {
                break;
            }
        }
        return res;
    }
}