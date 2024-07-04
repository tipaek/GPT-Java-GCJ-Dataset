import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        String[] strings;
        int[][] mat;
        // For each test case.
        for (int p=0; p<t; p++) {
            char[] chs = br.readLine().toCharArray();
            int n = chs.length;
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = chs[i] - '0';
            }
            int[] leftCount = new int[n]; // Left count of parenthesis.
            int[] rightCount = new int[n]; // Right count of parenthesis.

            boolean changed = true;
            while (changed) {
                int min = Integer.MAX_VALUE;
                int start = 0;
                for (int i = 0; i < n - 1; i++) {
                    if (values[i] == 0) {
                        start = i+1;
                        continue;
                    }

                    // Begin Start.
                    if (i > 0 && values[i-1] == 0) {
                        start = i;
                        min = Integer.MAX_VALUE;
                    }

                    min = Math.min(values[i], min);
                    // End detected.
                    if (values[i+1] == 0) {
                        rightCount[i] += min;
                        leftCount[start] += min;
                        // Decrease the count of each by min.
                        for (int j = start; j <= i; j++) {
                            values[j] -= min;
                        }
                    }
                }

                // For n-1.
                // Begin Start.
                if (n > 1 && values[n-1] == 0) {
                    start = n-1;
                    min = Integer.MAX_VALUE;
                }
                min = Math.min(values[n-1], min);
                // End detected.
                if (values[n-1] != 0) {
                    rightCount[n-1] += min;
                    leftCount[start] += min;
                    // Decrease the count of each by min.
                    for (int j = start; j <= n-1; j++) {
                        values[j] -= min;
                    }
                }

                changed = false;
                for (int i = 0; i < n; i++) {
                    if (values[i] != 0) changed = true;
                }
            }

            StringBuffer ans = new StringBuffer();

            for (int i = 0; i < n; i++) {
                // Left braces.
                for (int j = 0; j < leftCount[i]; j++) {
                    ans.append("(");
                }
                ans.append(chs[i]);
                // Right braces.
                for (int j = 0; j < rightCount[i]; j++) {
                    ans.append(")");
                }
            }
            output(sb, p, ans.toString());
        }
        System.out.println(sb);
    }

    private static void output(StringBuffer sb, int testCase, String s) {
        sb.append("Case #" + (testCase + 1) + ": " + s + "\n");
    }
}
