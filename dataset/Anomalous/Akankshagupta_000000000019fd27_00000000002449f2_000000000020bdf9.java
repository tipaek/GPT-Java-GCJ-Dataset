import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 0; caseNumber < cases; caseNumber++) {
            int noOfActivities = Integer.parseInt(scanner.nextLine());
            Activity[] activities = new Activity[noOfActivities];

            for (int i = 0; i < noOfActivities; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a.end, b.end));

            int cameronEnd = 0, jamieEnd = 0;
            char[] result = new char[noOfActivities];
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result[activity.index] = 'C';
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result[activity.index] = 'J';
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + (caseNumber + 1) + ": ");
            if (possible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}