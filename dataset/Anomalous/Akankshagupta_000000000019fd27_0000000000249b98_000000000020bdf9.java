import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        if (cases <= 0) return;

        for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
            int noOfActivities = Integer.parseInt(scanner.nextLine());
            if (noOfActivities <= 0) continue;

            Activity[] activities = new Activity[noOfActivities];
            for (int i = 0; i < noOfActivities; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

            int cameronEnd = -1, jamieEnd = -1;
            char[] schedule = new char[noOfActivities];
            boolean possible = true;

            for (Activity activity : activities) {
                if (cameronEnd <= activity.start) {
                    schedule[activity.index] = 'J';
                    cameronEnd = activity.end;
                } else if (jamieEnd <= activity.start) {
                    schedule[activity.index] = 'C';
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}