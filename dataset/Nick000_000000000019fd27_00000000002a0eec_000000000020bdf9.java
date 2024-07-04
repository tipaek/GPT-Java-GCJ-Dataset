import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intrvls = new int[n][4];
            for (int j = 0; j < n; ++j) {
                int s = in.nextInt();
                int e = in.nextInt();
                intrvls[j][0] = s;
                intrvls[j][1] = e;
                intrvls[j][2] = j;
            }
            String result = solve(intrvls);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int[][] intrvls) {
        if (intrvls.length == 1)
            return "C";
        String res = "";
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(intrvls, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] first = {-1, -1};
        int[] second = {-1, -1};
        for (int i = 0; i < intrvls.length; ++i) {
            int[] curInt = intrvls[i];
            if (!isOverlap(curInt, first)) {
                first[0] = curInt[0];
                first[1] = curInt[1];
                curInt[3] = 1;
            } else if (!isOverlap(curInt, second)) {
                second[0] = curInt[0];
                second[1] = curInt[1];
                curInt[3] = 0;
            } else {
                return "IMPOSSIBLE";
            }
        }
        Arrays.sort(intrvls, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < intrvls.length; ++i) {
            int[] curInt = intrvls[i];
            if (curInt[3] == 1) {
                res += "C";
            } else {
                res += "J";
            }
        }
        return res;
    }

    private static boolean isOverlap(int[] int1, int[] int2) {
        int s1 = int1[0];
        int e1 = int1[1];
        int s2 = int2[0];
        int e2 = int2[1];
        return Math.max(s1, s2) < Math.min(e1, e2);
    }
}
