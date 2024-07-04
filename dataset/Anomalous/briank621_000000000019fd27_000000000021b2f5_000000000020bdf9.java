import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[] timeSlots = new int[1441];
            int[] endCounts = new int[1441];

            boolean isValid = true;
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                }

                endCounts[end]++;
                intervals.add(new int[]{start, end});
            }

            for (int i = 0; i < 1441; i++) {
                if (timeSlots[i] > 2 || endCounts[i] > 2) {
                    isValid = false;
                    break;
                }
            }

            int[] assignments = new int[n];
            if (isValid) {
                for (int i = 0; i < n; i++) {
                    int start1 = intervals.get(i)[0];
                    int end1 = intervals.get(i)[1];
                    int assignment = 0;

                    for (int j = 0; j < i; j++) {
                        int start2 = intervals.get(j)[0];
                        int end2 = intervals.get(j)[1];
                        if (!(start1 >= end2 || start2 >= end1) || (start1 == start2 && end1 == end2)) {
                            if (assignments[j] == 0) {
                                assignment = 1;
                            } else {
                                assignment = 0;
                            }
                        }
                    }
                    assignments[i] = assignment;
                }
            }

            if (!isValid) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", caseNum, result.toString());
            }
        }

        reader.close();
    }
}