import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[] jSchedule = new int[1441];
            int[] cSchedule = new int[1441];
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                    if (jSchedule[time] == 1) {
                        canAssignToJ = false;
                    }
                    if (cSchedule[time] == 1) {
                        canAssignToC = false;
                    }
                }

                if (!canAssignToJ && !canAssignToC) {
                    isPossible = false;
                    break;
                }

                if (canAssignToJ) {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        jSchedule[time] = 1;
                    }
                    result.append("J");
                } else {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        cSchedule[time] = 1;
                    }
                    result.append("C");
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }
}