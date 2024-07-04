import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= testCaseCount; caseNum++) {
            int n = Integer.parseInt(br.readLine());
            int[] timeSlots = new int[1441];
            boolean isValid = true;
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                
                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                }
                
                intervals.add(new int[] {start, end});
            }

            for (int i = 0; i < timeSlots.length; i++) {
                if (timeSlots[i] > 2) {
                    isValid = false;
                    break;
                }
            }

            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                int currentAssignment = 0;
                int currentStart = intervals.get(i)[0];
                int currentEnd = intervals.get(i)[1];

                for (int j = i - 1; j >= 0; j--) {
                    int previousStart = intervals.get(j)[0];
                    int previousEnd = intervals.get(j)[1];

                    if (!(currentStart >= previousEnd || previousStart >= currentEnd)) {
                        if (assignments[j] == 0) {
                            currentAssignment = 1;
                        } else {
                            currentAssignment = 0;
                        }
                    }
                }
                assignments[i] = currentAssignment;
            }

            if (!isValid) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            } else {
                StringBuilder result = new StringBuilder();
                for (int assignment : assignments) {
                    result.append(assignment == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", caseNum, result.toString());
            }
        }

        br.close();
    }
}