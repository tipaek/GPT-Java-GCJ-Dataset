import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] times = new int[N][3];
            boolean isPossible = true;
            int minTime = Integer.MAX_VALUE;
            int maxTime = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                times[j][0] = start;
                times[j][1] = end;
                times[j][2] = j; // index of the activity

                if (start < minTime) {
                    minTime = start;
                }
                if (end > maxTime) {
                    maxTime = end;
                }
            }

            Arrays.sort(times, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            StringBuilder solution = new StringBuilder("C".repeat(N));

            for (int a = 0; a < N; a++) {
                for (int b = a + 1; b < N; b++) {
                    if (times[a][1] > times[b][0] && solution.charAt(a) == solution.charAt(b)) {
                        solution.setCharAt(b, 'J');
                    }
                }
            }

            for (double time = minTime - 0.5; time < maxTime + 0.5; time++) {
                int overlapCount = 0;
                for (int[] timeRange : times) {
                    if (timeRange[0] < time && time < timeRange[1]) {
                        overlapCount++;
                    }
                }
                if (overlapCount > 2) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                char[] orderedSolution = new char[N];
                for (int q = 0; q < N; q++) {
                    orderedSolution[times[q][2]] = solution.charAt(q);
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(orderedSolution));
            }
        }

        br.close();
    }
}