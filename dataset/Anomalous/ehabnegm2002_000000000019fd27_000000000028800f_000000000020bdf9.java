import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            int size = scanner.nextInt();
            Activity[] activities = new Activity[size];

            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            System.out.println("Case #" + testCase + ": " + assignActivities(activities));
        }

        scanner.close();
    }

    public static String assignActivities(Activity[] activities) {
        char[] result = new char[activities.length];
        Arrays.sort(activities);

        activities[0].symbol = 'C';
        Activity lastC = activities[0];
        Activity lastJ = null;

        for (int i = 1; i < activities.length; i++) {
            Activity current = activities[i];

            if (!current.overlaps(lastJ)) {
                lastJ = current;
                lastJ.symbol = 'J';
            } else if (!current.overlaps(lastC)) {
                lastC = current;
                lastC.symbol = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Activity activity : activities) {
            result[activity.index] = activity.symbol;
        }

        return new String(result);
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int index;
    char symbol;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }

    public boolean overlaps(Activity other) {
        if (other == null) {
            return false;
        }
        return (this.start < other.end && this.end > other.start);
    }
}