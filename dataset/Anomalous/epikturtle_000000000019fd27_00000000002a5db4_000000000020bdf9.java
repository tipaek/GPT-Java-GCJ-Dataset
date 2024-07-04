import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cases; i++) {
            int activities = Integer.parseInt(scanner.nextLine());
            Activity[] schedule = new Activity[activities];

            for (int j = 0; j < activities; j++) {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                schedule[j] = new Activity(start, end);
            }

            List<Activity> cameron = new ArrayList<>();
            List<Activity> jamie = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (Activity activity : schedule) {
                if (canAssign(activity, cameron)) {
                    output.append("C");
                    cameron.add(activity);
                } else if (canAssign(activity, jamie)) {
                    output.append("J");
                    jamie.add(activity);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }

    public static boolean canAssign(Activity activity, List<Activity> person) {
        for (Activity a : person) {
            if (!(activity.start >= a.end || activity.end <= a.start)) {
                return false;
            }
        }
        return true;
    }
}

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}