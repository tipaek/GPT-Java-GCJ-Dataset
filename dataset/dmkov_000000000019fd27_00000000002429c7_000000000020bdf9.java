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

            int[][] intervals = new int[2*k][3];
            char[] ans = new char[k];
            for (int l = 0; l < 2*k; l = l + 2) {
                int s = in.nextInt();
                intervals[l] = new int[]{l, s, 0};
                int e = in.nextInt();
                intervals[l + 1] = new int[]{l, e, 1};
            }

            // 0 - i
            // 1 - point
            // 2 - type (0 - start, 1 - end)

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]){
                    return b[2] - a[2];
                }
                else return a[1] - b[1];
            });

            int count = 0;
            boolean result = true;
            for (int[] interval : intervals) {
                if (interval[2] == 0) {
                    count++;

                    if (count == 1) {
                        ans[interval[0] / 2] = 'C';
                    } else if (count == 2) {
                        ans[interval[0] / 2] = 'J';
                    } else {
                        result = false;
                        break;
                    }

                } else {
                    count--;
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
