import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            pw.println("Case #" + k + ": " + solve());
        }
        pw.flush();
    }

    private static String solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Activity> activityList = new ArrayList<>();
        List<Activity> activityListSorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Activity activity = new Activity(i, start, end);
            activityList.add(activity);
            activityListSorted.add(activity);
        }
        Collections.sort(activityListSorted);
        int cameronEnd = -1;
        int jamieEnd = -1;
        for (int i = 0; i < n; i++) {
            Activity activity = activityListSorted.get(i);
            if (cameronEnd <= activity.start) {
                activity.parent = "C";
                cameronEnd = activity.end;
            } else {
                if (jamieEnd <= activity.start) {
                    activity.parent = "J";
                    jamieEnd = activity.end;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            Activity activity = activityList.get(i);
            result = result + activity.parent;
        }
        return result;
    }

    private static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;
        String parent;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity activity) {
            if (this.start != activity.start) {
                return Integer.signum(this.start - activity.start);
            }
            return Integer.signum(this.index - activity.index);
        }
    }
}