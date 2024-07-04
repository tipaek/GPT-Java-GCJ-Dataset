import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int t = start + 1; t < end; t++) {
                    if (jSchedule[t] == 1) {
                        canAssignToJ = false;
                    }
                    if (cSchedule[t] == 1) {
                        canAssignToC = false;
                    }
                }

                if (!canAssignToJ && !canAssignToC) {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }

                if (canAssignToJ) {
                    for (int t = start; t <= end; t++) {
                        jSchedule[t] = 1;
                    }
                    result.append("J");
                } else {
                    for (int t = start; t <= end; t++) {
                        cSchedule[t] = 1;
                    }
                    result.append("C");
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + result.toString());
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}