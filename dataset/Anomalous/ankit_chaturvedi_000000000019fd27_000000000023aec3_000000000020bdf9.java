import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            ArrayList<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] values = br.readLine().split(" ");
                int start = Integer.parseInt(values[0]);
                int end = Integer.parseInt(values[1]);
                intervals.add(new int[]{start, end, i});
            }

            result.append("Case #").append(caseNumber).append(": ");
            assignTasks(intervals, result);
            result.append("\n");
            caseNumber++;
        }

        System.out.println(result);
    }

    private static void assignTasks(ArrayList<int[]> intervals, StringBuilder result) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int cEnd = 0;
        int jEnd = 0;
        boolean possible = true;
        char[] assignments = new char[intervals.size()];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int index = interval[2];

            if (start >= cEnd) {
                assignments[index] = 'C';
                cEnd = end;
            } else if (start >= jEnd) {
                assignments[index] = 'J';
                jEnd = end;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (char assignment : assignments) {
                result.append(assignment);
            }
        } else {
            result.append("IMPOSSIBLE");
        }
    }
}