import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        // Constant
        String IMPOSSIBLE = "IMPOSSIBLE";

        String[] strings;
        // For each test case.
        nextTest: for (int p=0; p<t; p++) {
            int n = Integer.parseInt(br.readLine());

            int[][] events = new int[n][2];
//            int[] map = new int[24 * 60 + 1];
            boolean isImpossible = false;
            for (int i = 0; i < n; i++) {
                strings = br.readLine().split(" ");
                events[i][0] = Integer.parseInt(strings[0]);
                events[i][1] = Integer.parseInt(strings[1]);
            }

//            // For each event
//            for (int i = 0; i < n; i++) {
//                int start = events[i][0];
//                int end = events[i][1];
//                for (int j = start; j < end; j++) {
//                    map[j]++;
//                    // More than 2 tasks in a minute.
//                    if (map[j] > 2) {
//                        output(sb, p, IMPOSSIBLE);
//                        continue nextTest;
//                    }
//                }
//            }

            char[] ans = new char[n];
            boolean[] jMap = new boolean[24 * 60 + 1];
            boolean[] cMap = new boolean[24 * 60 + 1];

            // For each event.
            for (int i = 0; i < n; i++) {
                int start = events[i][0];
                int end = events[i][1];
                // Check if it can be assigned to J.
                boolean isJFree = true;
                for (int j = start; j < end; j++) {
                    if (jMap[j]) isJFree = false;
                }

                boolean isCFree = true;
                for (int j = start; j < end; j++) {
                    if (cMap[j]) isCFree = false;
                }

                if (isJFree) {
                    ans[i] = 'J';
                    for (int j = start; j < end; j++) {
                        jMap[j] = true;
                    }
                } else if (isCFree) {
                    ans[i] = 'C';
                    for (int j = start; j < end; j++) {
                        cMap[j] = true;
                    }
                } else {
                    isImpossible = true;
                }
            }
            if (!isImpossible) {
                output(sb, p, new String(ans));
            } else {
                output(sb, p, IMPOSSIBLE);
            }
        }
        System.out.println(sb);
    }

    private static void output(StringBuffer sb, int testCase, String answer) {
        sb.append("Case #" + (testCase + 1) + ": " + answer +  "\n");
    }
}
