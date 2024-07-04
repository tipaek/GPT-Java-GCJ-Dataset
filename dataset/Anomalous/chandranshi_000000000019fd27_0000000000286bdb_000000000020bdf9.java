import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        if (t < 1 || t > 100) {
            return;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                int s = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                intervals.add(new int[]{s, e, j});
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] endTimes = new int[2]; // endTimes[0] for C, endTimes[1] for J
            char[] result = new char[n];

            boolean possible = true;
            for (int[] interval : intervals) {
                int s = interval[0];
                int e = interval[1];
                int index = interval[2];

                if (s >= endTimes[0]) {
                    endTimes[0] = e;
                    result[index] = 'C';
                } else if (s >= endTimes[1]) {
                    endTimes[1] = e;
                    result[index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(result));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}