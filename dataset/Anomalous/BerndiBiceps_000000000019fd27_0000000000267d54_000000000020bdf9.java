import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            char[] result = new char[numActivities];
            int cameronEnd = 0, jamieEnd = 0;
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

            System.out.print("Case #" + testCase + ": ");
            if (possible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
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