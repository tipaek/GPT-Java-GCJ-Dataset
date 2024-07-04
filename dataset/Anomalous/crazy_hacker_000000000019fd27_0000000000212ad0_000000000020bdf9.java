import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            result.append("Case #").append(testCase).append(": ");
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int cEnd = 0;
            int jEnd = 0;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int[] interval : intervals) {
                if (interval[0] >= cEnd) {
                    cEnd = interval[1];
                    schedule.append("C");
                } else if (interval[0] >= jEnd) {
                    jEnd = interval[1];
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                result.append(schedule);
            }
            result.append("\n");
        }

        writer.print(result);
        writer.flush();
        reader.close();
    }
}