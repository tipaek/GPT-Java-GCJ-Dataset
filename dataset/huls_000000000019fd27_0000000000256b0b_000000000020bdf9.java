
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Google Code Jam 2020 - Round 0 - Solution C
 *
 * @author : huls
 */
public class Solution {

    static class Activity implements Comparable<Activity> {
        int from = 0;
        int to = 0;
        char owner = '_';

        public Activity(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return from == activity.from &&
                    to == activity.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        @Override
        public int compareTo(Activity activity) {
            return Integer.compare(this.from, activity.from);
        }
    }

    public static final char CAMERON = 'C';
    public static final char JAMIE = 'J';


    public static String checkOverlap(TreeSet<Activity> activities) {
        TreeSet<Integer> allTimeStamps = new TreeSet<>();
        activities.stream().forEach(activity -> {
            allTimeStamps.add(activity.from);
            allTimeStamps.add(activity.to);
        });
        StringBuilder sb = new StringBuilder();

        int max = allTimeStamps.stream().mapToInt(v -> v).max().getAsInt();
        boolean[][] timeStampBusy = new boolean[2][max];
        for (int aa = 0; aa < max; ++aa) {
            timeStampBusy[0][aa] = false;
            timeStampBusy[1][aa] = false;
        }
        for (Activity activity : activities) {
            int currentParent = (timeStampBusy[0][activity.from] == false) ? 0 : 1;
            activity.owner = (currentParent == 0) ? CAMERON : JAMIE;
            sb.append(activity.owner);
            for (int perd = activity.from; perd < activity.to; ++perd) {
                if (timeStampBusy[0][perd] && timeStampBusy[1][perd]) return "IMPOSSIBLE";
                timeStampBusy[currentParent][perd] = true;
            }
        }
        return sb.toString();
    }

    private static boolean hasOverlap(Activity t1, Activity t2) {
        return !(t1.to < (t2.from)) && !(t1.from > (t2.to));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            TreeSet<Activity> activityList = new TreeSet<>();
            for (int act = 0; act < n; ++act) {
                int tmpFrom = in.nextInt();
                int tmpTo = in.nextInt();
                activityList.add(new Activity(tmpFrom, tmpTo));
            }

            System.out.println("Case #" + i + ": " + checkOverlap(activityList));
        }
    }
}
