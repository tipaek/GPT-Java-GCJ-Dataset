
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<TestCase> testCases = readInput();
        int i = 1;
        for (TestCase testCase : testCases) {
            System.out.println("Case #" + i++ + ": " + solve(testCase.activities));
        }
    }

    static List<TestCase> readInput() {
        List<TestCase> results = new ArrayList<>(100);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            List<Activity> activities = new ArrayList<>(1000);
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scanner.nextLine();
                activities.add(new Activity(start, end));
            }

            activities.sort(new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    if (o1.start == o2.start) {
                        return o1.end < o2.end ? -1 : 1;
                    }
                    return o1.start < o2.start ? -1 : 1;
                }
            });

            results.add(new TestCase(activities));
        }
        return results;
    }

    static String solve(List<Activity> activities) {
        Person j = new Person();
        Person c = new Person();

        int size = activities.size();
        char[] solution = new char[size];

        for (int i = 0; i < size; i++) {
            Activity activity = activities.get(i);
            if (j.canAssign(activity)) {
                j.assign(activity);
                solution[i] = 'J';
            } else if (c.canAssign(activity)) {
                c.assign(activity);
                solution[i] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(solution);
    }

    static class Person {
        List<Activity> assignedActivities = new ArrayList<>(1000);

        void assign(Activity activity) {
            this.assignedActivities.add(activity);
        }

        boolean canAssign(Activity activity) {
            for (Activity a : assignedActivities) {
                if (a.overlaps(activity)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Activity {
        int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Activity other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }

    static class TestCase {
        List<Activity> activities;

        public TestCase(List<Activity> activities) {
            this.activities = activities;
        }
    }
}
