import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][2];
            int[] jSchedule = new int[1441];
            int[] cSchedule = new int[1441];
            Arrays.fill(jSchedule, 0);
            Arrays.fill(cSchedule, 0);

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean jConflict = false;
                boolean cConflict = false;

                for (int time = start + 1; time < end; time++) {
                    if (jSchedule[time] == 1) jConflict = true;
                    if (cSchedule[time] == 1) cConflict = true;
                }

                if (jConflict && cConflict) {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }

                if (!jConflict) {
                    Arrays.fill(jSchedule, start, end + 1, 1);
                    result.append("J");
                } else {
                    Arrays.fill(cSchedule, start, end + 1, 1);
                    result.append("C");
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}