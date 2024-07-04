import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(reader.readLine().trim());
            sb.append("Case #").append(test + 1).append(": ");

            int[][] intervals = new int[n][4];
            boolean[] timeSlots = new boolean[1440];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                String[] toks = reader.readLine().split(" ");
                int start = Integer.parseInt(toks[0]);
                int end = Integer.parseInt(toks[1]);
                intervals[i][0] = start;
                intervals[i][1] = end;
                intervals[i][2] = -1;  // Unassigned
                intervals[i][3] = i;

                for (int j = start; j < end; j++) {
                    if (timeSlots[j]) {
                        impossible = true;
                        break;
                    }
                    timeSlots[j] = true;
                }
                if (impossible) {
                    sb.append("IMPOSSIBLE\n");
                    break;
                }
            }

            if (!impossible) {
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
                int[] lastEnd = {-1, -1};  // Last end times for C and J

                for (int[] interval : intervals) {
                    int start = interval[0];
                    int end = interval[1];
                    if (start >= lastEnd[0]) {
                        interval[2] = 0;  // Assign to C
                        lastEnd[0] = end;
                    } else if (start >= lastEnd[1]) {
                        interval[2] = 1;  // Assign to J
                        lastEnd[1] = end;
                    } else {
                        sb.append("IMPOSSIBLE\n");
                        impossible = true;
                        break;
                    }
                }

                if (!impossible) {
                    Arrays.sort(intervals, Comparator.comparingInt(a -> a[3]));
                    for (int[] interval : intervals) {
                        sb.append(interval[2] == 0 ? 'C' : 'J');
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}