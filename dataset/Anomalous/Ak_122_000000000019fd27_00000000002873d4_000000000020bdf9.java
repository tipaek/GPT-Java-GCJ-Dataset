import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            char[] result = new char[n];
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }

            Collections.sort(activities, new ActivityEndComparator());

            int endC = 0, endJ = 0;
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (endC <= activity.start) {
                    result[activity.pos] = 'C';
                    endC = activity.end;
                } else if (endJ <= activity.start) {
                    result[activity.pos] = 'J';
                    endJ = activity.end;
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + i + ": ");
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
    int pos;

    public Activity(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class ActivityEndComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a, Activity b) {
        return Integer.compare(a.end, b.end);
    }
}