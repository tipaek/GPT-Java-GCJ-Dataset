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
            ActivityIndex[] activityIndices = new ActivityIndex[activityCount];
            System.out.print("Case #" + (i + 1) + ": ");
            
            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                activities[j] = new Activity(start, finish);
                activityIndices[j] = new ActivityIndex(activities[j], j);
            }
            
            Arrays.sort(activities);
            Stack<Activity> cStack = new Stack<>();
            Stack<Activity> jStack = new Stack<>();
            boolean isImpossible = false;
            
            for (Activity activity : activities) {
                if (cStack.isEmpty() || activity.start >= cStack.peek().finish) {
                    cStack.push(activity);
                    activity.assignedPerson = "C";
                } else if (jStack.isEmpty() || activity.start >= jStack.peek().finish) {
                    jStack.push(activity);
                    activity.assignedPerson = "J";
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                Arrays.sort(activityIndices);
                for (ActivityIndex activityIndex : activityIndices) {
                    System.out.print(activityIndex.activity.assignedPerson);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int finish;
    String assignedPerson;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.finish, other.finish);
    }
}

class ActivityIndex implements Comparable<ActivityIndex> {
    Activity activity;
    int index;

    ActivityIndex(Activity activity, int index) {
        this.activity = activity;
        this.index = index;
    }

    @Override
    public int compareTo(ActivityIndex other) {
        return Integer.compare(this.index, other.index);
    }
}