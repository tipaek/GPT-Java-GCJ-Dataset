import java.util.*;
import java.io.*;

class Activity {
    int start;
    int end;
    char person;

    Activity() {
    }

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            String output = "";
            List<Activity> activities = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                Activity newActivity = new Activity(start, end);

                boolean collisionWithC = false;
                boolean collisionWithJ = false;

                for (Activity activity : activities) {
                    if ((newActivity.start >= activity.start && newActivity.start < activity.end) ||
                        (newActivity.end > activity.start && newActivity.end <= activity.end)) {
                        if (activity.person == 'C') {
                            collisionWithC = true;
                        } else if (activity.person == 'J') {
                            collisionWithJ = true;
                        }
                    }
                }

                if (collisionWithC) {
                    if (collisionWithJ) {
                        isImpossible = true;
                    } else {
                        newActivity.person = 'J';
                        activities.add(newActivity);
                        output += 'J';
                    }
                } else {
                    newActivity.person = 'C';
                    activities.add(newActivity);
                    output += 'C';
                }
            }

            if (isImpossible) {
                output = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (testCase + 1) + ": " + output);
        }
    }
}