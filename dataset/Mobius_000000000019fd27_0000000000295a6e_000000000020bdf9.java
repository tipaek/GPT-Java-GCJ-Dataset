import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    static String solve(Scanner in) {
        int numActivities = in.nextInt();

        List<Activity> activityList = new ArrayList<>(numActivities);

        for (int j = 0; j < numActivities; j++) {
            Activity a = new Activity(in.nextInt(), in.nextInt());

            for (Activity b : activityList) {
                a.overlap(b);
            }

            activityList.add(a);
        }

        for (Activity a : activityList) {
            if (!dfs(a, "C")) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Activity a : activityList) {
            sb.append(a.assigned);
        }

        return sb.toString();
    }

    static boolean dfs(Activity a, String c) {
        if (a.assigned == null) {
            a.assigned = c;

            for (Activity b : a.overlaps) {
                if (c.equals("C") && b.assigned == null) {
                    if (!dfs(b, "J")){
                        return false;
                    }
                } else if (b.assigned == null) {
                    if (!dfs(b, "C")){
                        return false;
                    }

                } else if (b.assigned.equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Activity {
        int s;
        int e;
        List<Activity> overlaps = new ArrayList<>();
        String assigned;

        Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public void overlap(Activity b) {
            if ((s <= b.s && b.s < e) || (s < b.e && b.e <= e) || (b.s <= s && s < b.e) || (b.s < e && e <= b.e)) {
                overlaps.add(b);
                b.overlaps.add(this);
            }
        }
    }
}
