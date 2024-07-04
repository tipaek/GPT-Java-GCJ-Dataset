import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();
        if (numOfCases <= 0) {
            return;
        }

        StringBuilder output = new StringBuilder();
        for (int c = 0; c < numOfCases; c++) {
            int numOfActivities = scanner.nextInt();

            Activity[] activities = new Activity[numOfActivities];
            for (int i = 0; i < numOfActivities; i++) {
                activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int jaimeOccupied = 0;
            int cameronOccupied = 0;

            output.append("Case #").append(c + 1).append(": ");
            boolean fail = false;
            for (Activity activity : activities) {
                if (jaimeOccupied <= activity.start) {
                    activity.assignedTo = 'J';
                    jaimeOccupied = activity.end;
                } else if (cameronOccupied <= activity.start) {
                    activity.assignedTo = 'C';
                    cameronOccupied = activity.end;
                } else {
                    fail = true;
                    break;
                }
            }

            if (fail) {
                output.append("IMPOSSIBLE\n");
            } else {
                Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
                for (Activity activity : activities) {
                    output.append(activity.assignedTo);
                }
                output.append("\n");
            }
        }
        System.out.println(output.toString());
    }

    static class Activity {
        int index;
        int start;
        int end;
        char assignedTo;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}