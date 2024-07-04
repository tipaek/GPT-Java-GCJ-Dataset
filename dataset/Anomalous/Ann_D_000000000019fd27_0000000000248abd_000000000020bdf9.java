import java.util.*;

class Activity {
    int start;
    int end;
    int index;
}

class Person {
    char name;
    Activity currentActivity;

    Person(char name) {
        this.name = name;
        this.currentActivity = new Activity();
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            Person cameron = new Person('C');
            Person jamie = new Person('J');

            for (int j = 0; j < n; j++) {
                activities[j] = new Activity();
                activities[j].start = scanner.nextInt();
                activities[j].end = scanner.nextInt();
                activities[j].index = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            char[] assignments = new char[n];
            Arrays.fill(assignments, ' ');

            assignments[0] = 'C';
            cameron.currentActivity = activities[0];
            if (n > 1) {
                assignments[1] = 'J';
                jamie.currentActivity = activities[1];
            }

            int assignedCount = 2;
            for (int j = 2; j < n; j++) {
                if (activities[j].start >= cameron.currentActivity.end) {
                    cameron.currentActivity = activities[j];
                    assignments[j] = 'C';
                    assignedCount++;
                } else if (activities[j].start >= jamie.currentActivity.end) {
                    jamie.currentActivity = activities[j];
                    assignments[j] = 'J';
                    assignedCount++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (assignments[activities[j].index] != ' ') {
                    result.append(assignments[activities[j].index]);
                }
            }

            if (assignedCount == n) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}