import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processTestCase(Scanner input) {
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

            boolean canAssignC = !c[start];
            boolean canAssignJ = !j[start];
            int timeUntilC = start - ct;
            int timeUntilJ = start - jt;

            if ((canAssignC && !canAssignJ) || (canAssignC && canAssignJ && timeUntilC > timeUntilJ)) {
                ct = end;
                markInterval(c, start, end);
                result[i] = 'C';
            } else if ((canAssignJ && !canAssignC) || (canAssignC && canAssignJ && timeUntilJ >= timeUntilC)) {
                jt = end;
                markInterval(j, start, end);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    static int[][] mapping;

    public static String rearrangeResult(char[] result) {
        char[] rearranged = new char[result.length];
        for (int[] map : mapping) {
            rearranged[map[0]] = result[map[1]];
        }
        return new String(rearranged);
    }

    public static int[][] sortIntervals(int[][] intervals) {
        boolean[] flag = new boolean[1441];
        boolean[] shadow = new boolean[1441];
        boolean[] ss = new boolean[1441];
        int[] n = new int[1441];
        int[] ns = new int[1441];
        int[] nss = new int[1441];

        int length = intervals.length;
        int[][] sortedIntervals = new int[length][2];
        mapping = new int[length][2];

        for (int i = 0; i < length; i++) {
            int start = intervals[i][0];
            if (!flag[start]) {
                n[start] = i;
                flag[start] = true;
            } else if (!shadow[start]) {
                ns[start] = i;
                shadow[start] = true;
            } else if (!ss[start]) {
                nss[start] = i;
                ss[start] = true;
            } else {
                return null;
            }
        }

        int index = 0;
        for (int i = 0; i < 1441; i++) {
            if (flag[i]) {
                sortedIntervals[index] = intervals[n[i]];
                mapping[index][0] = index;
                mapping[index][1] = n[i];
                index++;
                if (shadow[i]) {
                    sortedIntervals[index] = intervals[ns[i]];
                    mapping[index][0] = index;
                    mapping[index][1] = ns[i];
                    index++;
                    if (ss[i]) {
                        sortedIntervals[index] = intervals[nss[i]];
                        mapping[index][0] = index;
                        mapping[index][1] = nss[i];
                        index++;
                    }
                }
            }
        }

        return sortedIntervals;
    }

    public static void markInterval(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}