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
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            Person cameron = new Person('C');
            Person jamie = new Person('J');

            for (int j = 0; j < n; j++) {
                activities[j] = new Activity();
                activities[j].start = sc.nextInt();
                activities[j].end = sc.nextInt();
                activities[j].index = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            char[] schedule = new char[n];
            Arrays.fill(schedule, ' ');

            schedule[0] = 'C';
            cameron.currentActivity = activities[0];
            boolean possible = true;

            for (int j = 1; j < n; j++) {
                if (activities[j].start >= cameron.currentActivity.end) {
                    cameron.currentActivity = activities[j];
                    schedule[activities[j].index] = 'C';
                } else if (activities[j].start >= jamie.currentActivity.end) {
                    jamie.currentActivity = activities[j];
                    schedule[activities[j].index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}