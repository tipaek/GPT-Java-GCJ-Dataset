import java.util.*;

class Activity {
    int start;
    int end;
    int index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Person {
    char name;
    Activity currentActivity;

    Person(char name) {
        this.name = name;
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
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[j] = new Activity(start, end, j);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

            char[] allocation = new char[n];
            Arrays.fill(allocation, ' ');

            allocation[0] = 'C';
            cameron.currentActivity = activities[0];

            boolean possible = true;

            for (int j = 1; j < n; j++) {
                if (activities[j].start >= cameron.currentActivity.end) {
                    cameron.currentActivity = activities[j];
                    allocation[activities[j].index] = 'C';
                } else if (jamie.currentActivity == null || activities[j].start >= jamie.currentActivity.end) {
                    jamie.currentActivity = activities[j];
                    allocation[activities[j].index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (possible) {
                for (char c : allocation) {
                    result.append(c);
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}