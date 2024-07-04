import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        if (t < 1 || t >= 101) return;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                intervals.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1]), j});
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] endTimes = new int[2]; // endTimes[0] for C, endTimes[1] for J
            char[] result = new char[n];

            boolean possible = true;
            for (int[] interval : intervals) {
                if (interval[0] >= endTimes[0]) {
                    endTimes[0] = interval[1];
                    result[interval[2]] = 'C';
                } else if (interval[0] >= endTimes[1]) {
                    endTimes[1] = interval[1];
                    result[interval[2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i + 1).append(": ");
            if (possible) {
                sb.append(new String(result));
            } else {
                sb.append("IMPOSSIBLE");
            }

            System.out.println(sb.toString());
        }
    }
}