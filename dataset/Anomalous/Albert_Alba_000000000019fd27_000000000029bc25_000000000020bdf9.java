import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];
            Assignment[] assignments = new Assignment[activityCount];

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                activities[j] = new Activity(start, finish);
                assignments[j] = new Assignment(activities[j]);
            }
            Arrays.sort(activities);

            Stack<Activity> cActivities = new Stack<>();
            Stack<Activity> jActivities = new Stack<>();
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (cActivities.isEmpty() || activity.start >= cActivities.peek().finish) {
                    cActivities.push(activity);
                    activity.assignedTo = 'C';
                } else if (jActivities.isEmpty() || activity.start >= jActivities.peek().finish) {
                    jActivities.push(activity);
                    activity.assignedTo = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Assignment assignment : assignments) {
                    System.out.print(assignment.activity.assignedTo);
                }
                System.out.println();
            }
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int finish;
    char assignedTo;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.finish, other.finish);
    }
}

class Assignment {
    Activity activity;

    Assignment(Activity activity) {
        this.activity = activity;
    }
}