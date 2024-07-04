import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            List<Integer>[] cIntervals = new ArrayList[2];
            List<Integer>[] jIntervals = new ArrayList[2];

            for (int i = 0; i < 2; i++) {
                cIntervals[i] = new ArrayList<>();
                jIntervals[i] = new ArrayList<>();
            }

            boolean possible = true;

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canSchedule(cIntervals, start, end)) {
                    cIntervals[0].add(start);
                    cIntervals[1].add(end);
                    schedule.append("C");
                } else if (canSchedule(jIntervals, start, end)) {
                    jIntervals[0].add(start);
                    jIntervals[1].add(end);
                    schedule.append("J");
                } else {
                    possible = false;
                }
            }

            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            resultBuilder.append("Case #").append(caseNum).append(": ").append(schedule).append("\n");
        }

        System.out.print(resultBuilder);
    }

    private static boolean canSchedule(List<Integer>[] intervals, int start, int end) {
        for (int i = 0; i < intervals[0].size(); i++) {
            int existingStart = intervals[0].get(i);
            int existingEnd = intervals[1].get(i);
            if ((end > existingStart && start < existingEnd) || (start < existingEnd && end > existingStart)) {
                return false;
            }
        }
        return true;
    }
}