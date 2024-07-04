import java.util.Scanner;

class Activity {
    int start;
    int end;
}

class Person {
    char name;
    Activity activity;

    Person(char name) {
        this.name = name;
        this.activity = new Activity();
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
            }

            char[] schedule = new char[n];
            Person cameron = new Person('C');
            Person jamie = new Person('J');

            schedule[0] = 'C';
            cameron.activity = activities[0];
            schedule[1] = 'J';
            jamie.activity = activities[1];

            int assignedCount = 2;
            for (int j = 2; j < n; j++) {
                if (activities[j].start >= cameron.activity.end || activities[j].end <= cameron.activity.start) {
                    cameron.activity = activities[j];
                    schedule[j] = 'C';
                    assignedCount++;
                } else if (activities[j].start >= jamie.activity.end || activities[j].end <= jamie.activity.start) {
                    jamie.activity = activities[j];
                    schedule[j] = 'J';
                    assignedCount++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : schedule) {
                result.append(c);
            }

            if (assignedCount == n) {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}