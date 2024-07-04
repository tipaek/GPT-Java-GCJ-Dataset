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
            for (int j = 0; j < n; j++) {
                activities[j] = new Activity();
                activities[j].start = sc.nextInt();
                activities[j].end = sc.nextInt();
                activities[j].index = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            char[] allotments = new char[n];
            Arrays.fill(allotments, ' ');

            Person c = new Person('C');
            Person j = new Person('J');

            boolean possible = true;

            for (Activity activity : activities) {
                if (c.currentActivity.end <= activity.start) {
                    c.currentActivity = activity;
                    allotments[activity.index] = c.name;
                } else if (j.currentActivity.end <= activity.start) {
                    j.currentActivity = activity;
                    allotments[activity.index] = j.name;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(allotments));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}