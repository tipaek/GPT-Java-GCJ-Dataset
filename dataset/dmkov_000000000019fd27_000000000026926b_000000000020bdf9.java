import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int k = in.nextInt();

            int[][] intervals = new int[k][3];
            char[] ans = new char[k];
            for (int l = 0; l < k; l++) {
                int s = in.nextInt();
                int e = in.nextInt();
                intervals[l] = new int[]{l, s, e};
            }

            // 0 - i
            // 1 - start
            // 2 - end

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            });

            int C = Integer.MIN_VALUE;
            int J = Integer.MIN_VALUE;
            boolean result = true;
            for (int[] interval : intervals) {

                if (C <= interval[1]) {
                    ans[interval[0]] = 'C';
                    C = interval[2];
                } else if (J <= interval[1]) {
                    ans[interval[0]] = 'J';
                    J = interval[2];
                } else {
                    result = false;
                    break;
                }

            }

            if (!result) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for (char ch : ans) {
                    sb.append(ch);
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            }

        }
    }

}
