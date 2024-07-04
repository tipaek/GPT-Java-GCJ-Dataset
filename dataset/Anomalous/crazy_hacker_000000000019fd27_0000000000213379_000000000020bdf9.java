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
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= cEnd) {
                    cEnd = intervals[i][1];
                    result[intervals[i][2]] = 'C';
                } else if (intervals[i][0] >= jEnd) {
                    jEnd = intervals[i][1];
                    result[intervals[i][2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                output.append("IMPOSSIBLE");
            } else {
                output.append(new String(result));
            }
            output.append("\n");
        }

        writer.print(output);
        writer.flush();
        reader.close();
    }
}