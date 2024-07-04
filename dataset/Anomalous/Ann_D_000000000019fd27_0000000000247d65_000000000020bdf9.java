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

            for (int j = 0; j < n; j++) {
                activities[j] = new Activity();
                activities[j].start = scanner.nextInt();
                activities[j].end = scanner.nextInt();
                activities[j].index = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            char[] allocation = new char[n];
            Arrays.fill(allocation, ' ');

            Person cameron = new Person('C');
            Person jamie = new Person('J');

            boolean possible = true;
            for (Activity activity : activities) {
                if (cameron.currentActivity.end <= activity.start) {
                    cameron.currentActivity = activity;
                    allocation[activity.index] = cameron.name;
                } else if (jamie.currentActivity.end <= activity.start) {
                    jamie.currentActivity = activity;
                    allocation[activity.index] = jamie.name;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(allocation) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}