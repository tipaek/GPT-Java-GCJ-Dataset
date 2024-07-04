import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] intervals = new int[n][4];
            boolean[] timeSlots = new boolean[1440];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                String[] parts = reader.readLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                intervals[i][0] = start;
                intervals[i][1] = end;
                intervals[i][2] = i;

                for (int j = start; j < end; j++) {
                    if (timeSlots[j]) {
                        impossible = true;
                    }
                    timeSlots[j] = true;
                }
            }

            if (impossible) {
                result.append("Case #").append(testCase).append(": IMPOSSIBLE\n");
                continue;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            char[] assigned = new char[n];
            int lastC = 0, lastJ = 0;

            for (int[] interval : intervals) {
                if (interval[0] >= lastC) {
                    assigned[interval[2]] = 'C';
                    lastC = interval[1];
                } else if (interval[0] >= lastJ) {
                    assigned[interval[2]] = 'J';
                    lastJ = interval[1];
                } else {
                    result.append("Case #").append(testCase).append(": IMPOSSIBLE\n");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                result.append("Case #").append(testCase).append(": ");
                for (char c : assigned) {
                    result.append(c);
                }
                result.append("\n");
            }
        }

        System.out.print(result);
    }
}