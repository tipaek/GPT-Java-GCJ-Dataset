import java.util.*;
import java.io.*;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int INT_MAX = 1000000000;
    private static final int INT_MIN = -1000000000;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; ++t) {
            System.out.print("Case #" + t + ": ");
            int N = Integer.parseInt(br.readLine().trim());
            Event[] events = new Event[N];

            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                events[i] = new Event(start, end, i);
            }

            Arrays.sort(events, Comparator.comparingInt(e -> e.start));

            char[] ans = new char[N];
            int cEnd = -1, jEnd = -1;
            boolean isImpossible = false;

            for (Event event : events) {
                if (event.start >= cEnd) {
                    cEnd = event.end;
                    ans[event.index] = 'C';
                } else if (event.start >= jEnd) {
                    jEnd = event.end;
                    ans[event.index] = 'J';
                } else {
                    System.out.print("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.print(new String(ans));
            }
            if (t != T) {
                System.out.println();
            }
        }
        br.close();
    }

    static class Event {
        int start, end, index;

        Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}