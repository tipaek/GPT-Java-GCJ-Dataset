import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        String IMPOSSIBLE = "IMPOSSIBLE";

        String[] strings;
        // For each test case.
        nextTest: for (int p=0; p<t; p++) {
            int n = Integer.parseInt(br.readLine());

            int[][] events = new int[n][2];
            int[] map = new int[24 * 60 + 1];
            for (int i = 0; i < n; i++) {
                strings = br.readLine().split(" ");
                events[i][0] = Integer.parseInt(strings[0]);
                events[i][1] = Integer.parseInt(strings[1]);

                for (int j = events[i][0]; j < events[i][1]; j++) {
                    map[j]++;
                    if (map[j] > 2) {
                        output(sb, p, IMPOSSIBLE);
                        continue nextTest;
                    }
                }
            }

            // It is possible to schedule.
            // Sort based on end date.
//            Arrays.sort(events, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] event1, int[] event2) {
//                    if (event1[1] == event2[1]) { return event1[0] - event2[0]; }
//                    return event1[1] - event2[1];
//                }
//            });

            char[] ans = new char[n];
            boolean[] jMap = new boolean[24 * 60 + 1];
            boolean[] cMap = new boolean[24 * 60 + 1];

            for (int i = 0; i < n; i++) {
                int start = events[i][0];
                int end = events[i][1];
                // Check if it can be assigned to J.
                boolean isJFree = true;
                for (int j = start; j < end; j++) {
                    if (jMap[j]) isJFree = false;
                }

                if (isJFree) {
                    ans[i] = 'J';
                    for (int j = start; j < end; j++) {
                        jMap[j] = true;
                    }
                } else {
                    ans[i] = 'C';
                    for (int j = start; j < end; j++) {
                        cMap[j] = true;
                    }
                }
            }
            output(sb, p, new String(ans));
        }
        System.out.println(sb);
    }

    private static void output(StringBuffer sb, int testCase, String answer) {
        sb.append("Case #" + (testCase + 1) + ": " + answer +  "\n");
    }
}
