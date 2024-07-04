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
            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                activities[j] = new Activity(start, finish);
            }

            Arrays.sort(activities);

            Stack<Activity> cStack = new Stack<>();
            Stack<Activity> jStack = new Stack<>();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cStack.isEmpty()) {
                    cStack.push(activity);
                } else if (jStack.isEmpty()) {
                    jStack.push(activity);
                } else if (activity.start >= cStack.peek().finish) {
                    cStack.push(activity);
                } else if (activity.start >= jStack.peek().finish) {
                    jStack.push(activity);
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            cStack.clear();
            jStack.clear();

            for (Activity activity : activities) {
                if (cStack.isEmpty()) {
                    System.out.print("C");
                    cStack.push(activity);
                } else if (jStack.isEmpty()) {
                    System.out.print("J");
                    jStack.push(activity);
                } else if (activity.start >= cStack.peek().finish) {
                    System.out.print("C");
                    cStack.push(activity);
                } else if (activity.start >= jStack.peek().finish) {
                    System.out.print("J");
                    jStack.push(activity);
                }
            }
            System.out.println();
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.finish, other.finish);
    }
}