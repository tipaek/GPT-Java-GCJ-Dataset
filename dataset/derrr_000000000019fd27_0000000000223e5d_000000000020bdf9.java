import java.util.*;
import java.io.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        PriorityQueue<int[]> pq = new PriorityQueue<>(t, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 1; i <= t; ++i) {
            pq.clear();
            for (int n = in.nextInt(), index = 0; n > 0; n--, index++) {
                pq.add(new int[] {in.nextInt(), in.nextInt(), index}); // [start, end, index]
            }
            System.out.printf("Case #%d: %s%n", i, compute(pq));
        }
    }

    public static String compute(PriorityQueue<int[]> activities) {
        int cameron = 0, jamie = 0;
        char[] result = new char[activities.size()];
        while (!activities.isEmpty()) {
            int[] cur = activities.poll();
            if (cur[0] >= cameron) {
                cameron = cur[1];
                result[cur[2]] = 'C';
            } else if (cur[0] >= jamie) {
                jamie = cur[1];
                result[cur[2]] = 'J';
            } else {
                return IMPOSSIBLE;
            }
        }
        return new String(result);
    }

}
