import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[][] m = new int[n][3];
            for (int i = 0; i < n; i++) {
                m[i][0] = in.nextInt();
                m[i][1] = in.nextInt();
                m[i][2] = i;
            }
            solve(l, n, m);
        }
    }

    public static void solve(int t, int n, int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
        int last = 0;
        char[] name = new char[n];
        name[0] = 'C';
        for (int i = 1; i < n; i++) {
            if (intervals[last][1] <= intervals[i][0]) {
                name[i] = 'C';
                last = i;
            } else {
                name[i] = 'J';
            }
        }
        char[] name2 = new char[n];
        for (int i = 0; i < n; i++) {
            name2[intervals[i][2]] = name[i];
        }

        String ans = new String(name2);
        last = -1;
        for (int i = 0; i < n; i++) {
            if (name[i] == 'J') {
                if (last >= 0 && intervals[last][1] > intervals[i][0]) {
                    ans = "IMPOSSIBLE";
                }
                last = i;
            }
        }
        System.out.println(String.format("Case #%d: %s", t, ans));
    }
}