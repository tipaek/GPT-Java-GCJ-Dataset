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

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            String result = "";
            List<Activity> activities = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                Activity newActivity = new Activity(start, end);
                boolean conflictWithC = false;
                boolean conflictWithJ = false;

                for (Activity activity : activities) {
                    if ((newActivity.start >= activity.start && newActivity.start < activity.end) ||
                        (newActivity.end > activity.start && newActivity.end <= activity.end)) {
                        if (activity.person == 'C') {
                            conflictWithC = true;
                        } else if (activity.person == 'J') {
                            conflictWithJ = true;
                        }
                    }
                }

                if (conflictWithC) {
                    if (conflictWithJ) {
                        isImpossible = true;
                    } else {
                        newActivity.person = 'J';
                        activities.add(newActivity);
                        result += 'J';
                    }
                } else {
                    newActivity.person = 'C';
                    activities.add(newActivity);
                    result += 'C';
                }
            }

            if (isImpossible) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}