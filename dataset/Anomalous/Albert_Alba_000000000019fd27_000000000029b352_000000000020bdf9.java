import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];
            Activity[] originalOrder = new Activity[activityCount];

            System.out.print("Case #" + testCase + ": ");
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
                originalOrder[i] = activities[i];
            }

            Arrays.sort(activities);

            Stack<Activity> cStack = new Stack<>();
            Stack<Activity> jStack = new Stack<>();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cStack.isEmpty() || activity.start >= cStack.peek().end) {
                    cStack.push(activity);
                    activity.assignedTo = "C";
                } else if (jStack.isEmpty() || activity.start >= jStack.peek().end) {
                    jStack.push(activity);
                    activity.assignedTo = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Activity activity : originalOrder) {
                    System.out.print(activity.assignedTo);
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    String assignedTo;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }
}