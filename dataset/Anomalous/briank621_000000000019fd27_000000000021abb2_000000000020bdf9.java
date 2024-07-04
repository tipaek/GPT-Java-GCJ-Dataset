import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(br.readLine());
            int[] timeSlots = new int[1441];
            int[] endCount = new int[1441];

            boolean isPossible = true;
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                }
                endCount[end]++;
                intervals.add(new int[]{start, end});
            }

            for (int i = 0; i < timeSlots.length; i++) {
                if (endCount[i] > 2 || timeSlots[i] > 2) {
                    isPossible = false;
                    break;
                }
            }

            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                int assignedPerson = 0;
                int start1 = intervals.get(i)[0];
                int end1 = intervals.get(i)[1];

                for (int j = i - 1; j >= 0; j--) {
                    int start2 = intervals.get(j)[0];
                    int end2 = intervals.get(j)[1];

                    if (!(start1 >= end2 || start2 >= end1)) {
                        if (assignments[j] == 0) {
                            assignedPerson = 1;
                        } else {
                            assignedPerson = 0;
                        }
                    }
                }
                assignments[i] = assignedPerson;
            }

            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", caseNum, result.toString());
            }
        }

        br.close();
    }
}