import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(activities, new ActivityEndComparator());

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cEnd <= activity.start) {
                    result[activity.position] = 'C';
                    cEnd = activity.end;
                } else if (jEnd <= activity.start) {
                    result[activity.position] = 'J';
                    jEnd = activity.end;
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + testCase + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}

class Activity {
    int start;
    int end;
    int position;

    public Activity(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class ActivityEndComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a, Activity b) {
        return Integer.compare(a.end, b.end);
    }
}