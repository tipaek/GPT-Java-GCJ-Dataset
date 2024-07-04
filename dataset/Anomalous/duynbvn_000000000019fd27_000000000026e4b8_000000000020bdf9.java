import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeInterval> cameronActivities = new ArrayList<>();
            List<TimeInterval> jamieActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = canAssign(start, end, cameronActivities);

                if (canAssignToCameron) {
                    cameronActivities.add(new TimeInterval(start, end));
                    schedule.append("C");
                } else {
                    boolean canAssignToJamie = canAssign(start, end, jamieActivities);
                    if (canAssignToJamie) {
                        jamieActivities.add(new TimeInterval(start, end));
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }
        }
    }

    private static boolean canAssign(int start, int end, List<TimeInterval> activities) {
        for (TimeInterval interval : activities) {
            if (interval.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeInterval {
        int start;
        int end;

        TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(int start, int end) {
            return (this.start < end) && (start < this.end);
        }
    }
}