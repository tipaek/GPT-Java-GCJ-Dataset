import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
                Set<Activity> cActivities = new TreeSet<>();
                Set<Activity> jActivities = new TreeSet<>();

                int activityCount = scanner.nextInt();
                boolean impossible = false;
                StringBuilder result = new StringBuilder();

                for (int activityIndex = 0; activityIndex < activityCount; ++activityIndex) {
                    Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());

                    if (cActivities.add(activity)) {
                        result.append("C");
                    } else if (jActivities.add(activity)) {
                        result.append("J");
                    } else {
                        impossible = true;
                    }
                }

                if (impossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + result.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if ((start >= other.start && start < other.end) || (end > other.start && end <= other.end)) {
                return 0;
            }
            return Integer.compare(this.start, other.start);
        }
    }
}