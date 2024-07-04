import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int activitiesCount = scanner.nextInt();
                boolean isImpossible = false;
                StringBuilder schedule = new StringBuilder();

                Set<Activity> cActivities = new TreeSet<>();
                Set<Activity> jActivities = new TreeSet<>();

                for (int i = 0; i < activitiesCount; i++) {
                    Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());

                    if (isImpossible) {
                        continue;
                    }

                    if (cActivities.add(activity)) {
                        schedule.append('C');
                    } else if (jActivities.add(activity)) {
                        schedule.append('J');
                    } else {
                        System.out.println("IMPOSSIBLE: " + activity.getStart() + " " + activity.getEnd());
                        isImpossible = true;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + schedule.toString());
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

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Activity other) {
            if ((start >= other.getStart() && start < other.getEnd())
                    || (end > other.getStart() && end <= other.getEnd())
                    || (start >= other.getStart() && end <= other.getEnd())
                    || (start <= other.getStart() && end >= other.getEnd())) {
                return 0;
            }
            return Integer.compare(start, other.start);
        }
    }
}