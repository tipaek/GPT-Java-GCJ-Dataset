import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int numActivities = scanner.nextInt();
            List<Integer> cameronStartTimes = new ArrayList<>();
            List<Integer> cameronEndTimes = new ArrayList<>();
            List<Integer> jamieStartTimes = new ArrayList<>();
            List<Integer> jamieEndTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!impossible) {
                    if (assignActivity(start, end, cameronStartTimes, cameronEndTimes)) {
                        schedule.append("C");
                    } else if (assignActivity(start, end, jamieStartTimes, jamieEndTimes)) {
                        schedule.append("J");
                    } else {
                        impossible = true;
                        schedule.setLength(0); // Clear the schedule
                        schedule.append("IMPOSSIBLE");
                    }
                }
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }
    }

    private static boolean assignActivity(int start, int end, List<Integer> startTimes, List<Integer> endTimes) {
        for (int i = 0; i < startTimes.size(); i++) {
            if (overlaps(start, end, startTimes.get(i), endTimes.get(i))) {
                return false;
            }
        }
        startTimes.add(start);
        endTimes.add(end);
        return true;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}