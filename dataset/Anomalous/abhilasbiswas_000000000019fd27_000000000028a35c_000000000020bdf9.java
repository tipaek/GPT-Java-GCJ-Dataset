import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result;
        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        result = new char[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);

        if (intervals == null) {
            return "IMPOSSIBLE";
        }

        int ct = 0, jt = 0;
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean canC = !c[start];
            boolean canJ = !j[start];
            int nc = start - ct;
            int nj = start - jt;

            if ((canC && !canJ) || (canC && canJ && nc > nj)) {
                ct = end;
                markBusy(c, start, end);
                result[i] = 'C';
            } else if ((canJ && !canC) || (canC && canJ && nj > nc)) {
                jt = end;
                markBusy(j, start, end);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static int[][] sortIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] sorted = new int[n][2];
        int[][] mapping = new int[n][2];
        boolean[] flag = new boolean[1441];
        boolean[] shadow = new boolean[1441];
        boolean[] ss = new boolean[1441];
        int[] first = new int[1441];
        int[] second = new int[1441];
        int[] third = new int[1441];

        for (int i = 0; i < n; i++) {
            int index = intervals[i][0];
            if (!flag[index]) {
                first[index] = i;
                flag[index] = true;
            } else if (!shadow[index]) {
                second[index] = i;
                shadow[index] = true;
            } else if (!ss[index]) {
                third[index] = i;
                ss[index] = true;
            } else {
                return null;
            }
        }

        int p = 0;
        for (int i = 0; i < 1441; i++) {
            if (flag[i]) {
                int index = first[i];
                sorted[p] = intervals[index];
                mapping[p][0] = p;
                mapping[p][1] = index;
                p++;
                if (shadow[i]) {
                    index = second[i];
                    sorted[p] = intervals[index];
                    mapping[p][0] = p;
                    mapping[p][1] = index;
                    p++;
                    if (ss[i]) {
                        index = third[i];
                        sorted[p] = intervals[index];
                        mapping[p][0] = p;
                        mapping[p][1] = index;
                        p++;
                    }
                }
            }
        }
        return sorted;
    }

    public static void markBusy(boolean[] arr, int start, int end) {
        Arrays.fill(arr, start, end, true);
    }
}