import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= tc; caseNum++) {
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

                intervals.add(new int[]{start, end, i});
            }

            for (int count : timeSlots) {
                if (count > 2) {
                    isValid = false;
                    break;
                }
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                int start1 = intervals.get(i)[0];
                int end1 = intervals.get(i)[1];
                int person = 0;

                for (int j = i - 1; j >= 0; j--) {
                    int start2 = intervals.get(j)[0];
                    int end2 = intervals.get(j)[1];
                    if (!(start1 >= end2 || start2 >= end1)) {
                        if (assignments[intervals.get(j)[2]] == 0) {
                            person = 1;
                        } else {
                            person = 0;
                        }
                    }
                }
                assignments[intervals.get(i)[2]] = person;
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