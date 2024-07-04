import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
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
            System.out.println("Case #" + index + ": " + getRes(array, len, wid, sum));
        }
    }

    private static long getRes(int[][] act, int len, int wid, long all) {
        long res = all;
        float[][] sum = new float[len][wid];
        int[][] count = new int[len][wid];
        while (true) {
            for (int i = 0; i < len; i++) {
                int preSameRow = 0;

                for (int j = 0; j < wid; j++) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameRow;
                        if (preSameRow > 0) {
                            count[i][j]++;
                        }
                        preSameRow = act[i][j];
                    }

                }
            }
            for (int j = 0; j < wid; j++) {
                int preSameCol = 0;
                for (int i = 0; i < len; i++) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameCol;
                        if (preSameCol > 0) {
                            count[i][j]++;
                        }
                        preSameCol = act[i][j];
                    }
                }
            }

            for (int i = len - 1; i >= 0; i--) {
                int preSameRow = 0;
                for (int j = wid - 1; j >= 0; j--) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameRow;
                        if (preSameRow > 0) {
                            count[i][j]++;
                        }
                        preSameRow = act[i][j];
                    }

                }
            }

            for (int j = wid - 1; j >= 0; j--) {
                int preSameCol = 0;
                for (int i = len - 1; i >= 0; i--) {
                    if (act[i][j] > 0) {
                        sum[i][j] += preSameCol;
                        if (preSameCol > 0) {
                            count[i][j]++;
                        }
                        preSameCol = act[i][j];
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
            for (int i = 0; i < len; i++) {
                Arrays.fill(sum[i], 0);
                Arrays.fill(count[i], 0);

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