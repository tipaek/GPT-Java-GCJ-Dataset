import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeDuration> cSchedule = new ArrayList<>(numberOfActivities);
            List<TimeDuration> jSchedule = new ArrayList<>(numberOfActivities);
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canSchedule(start, end, cSchedule)) {
                    cSchedule.add(new TimeDuration(start, end));
                    result.append('C');
                } else if (canSchedule(start, end, jSchedule)) {
                    jSchedule.add(new TimeDuration(start, end));
                    result.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private static boolean canSchedule(int start, int end, List<TimeDuration> schedule) {
        for (TimeDuration duration : schedule) {
            if (duration.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeDuration {
        int start;
        int end;

        TimeDuration(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(int newStart, int newEnd) {
            return (newStart < end && newEnd > start);
        }
    }
}