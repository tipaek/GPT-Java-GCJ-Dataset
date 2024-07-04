import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            }

            StringBuilder result = new StringBuilder(activitiesCount);
            result.setLength(activitiesCount);

            Arrays.sort(activities, (a, b) -> {
                if (a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            });

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cameronEnd <= activity.start) {
                    result.setCharAt(activity.index, 'C');
                    cameronEnd = activity.end;
                } else if (jamieEnd <= activity.start) {
                    result.setCharAt(activity.index, 'J');
                    jamieEnd = activity.end;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("CASE #" + (t + 1) + ": " + result);
        }

        scanner.close();
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