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
            int[][] intrvls = new int[n][2];
            for (int j = 0; j < n; ++j) {
                int s = in.nextInt();
                int e = in.nextInt();
                intrvls[j][0] = s;
                intrvls[j][1] = e;
            }
            String result = solve(intrvls);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int[][] intrvls) {
        String res = "";
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(intrvls, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        String prev = "C";
        for (int i = 0; i < intrvls.length; ++i) {
            int[] curInt = intrvls[i];
            while (!q.isEmpty() && !isOverlap(q.peek(), curInt)) {
                q.poll();
            }
            q.offer(curInt);
            if (q.size() == 3) {
                return "IMPOSSIBLE";
            }
            String resEl = prev.equals("C") ? "J" : "C";
            res += resEl;
            prev = resEl;
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
