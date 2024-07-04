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
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            StringBuilder output = new StringBuilder();
            List<Activity> activities = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity newActivity = new Activity(start, end);

                boolean collisionWithC = false;
                boolean collisionWithJ = false;

                for (Activity activity : activities) {
                    if ((newActivity.start >= activity.start && newActivity.start < activity.end) ||
                        (newActivity.end > activity.start && newActivity.end < activity.end)) {
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
                        output.append('J');
                    }
                } else {
                    newActivity.person = 'C';
                    activities.add(newActivity);
                    output.append('C');
                }
            }

            if (isImpossible) {
                output = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (t + 1) + ": " + output);
        }
    }
}