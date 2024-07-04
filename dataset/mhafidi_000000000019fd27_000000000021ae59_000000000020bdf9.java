
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public class Solution {

    public static String solve(List<Activity> activities) {
        StringBuilder res = new StringBuilder();
        String lastAssigned = null;
        int endJ = 0, endC =0;

        activities.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < activities.size() ; i++) {
            Activity curActivity = activities.get(i);
            if(endJ <= curActivity.start) {
                endJ = curActivity.end;
                res.append("J");
                lastAssigned="J";
                continue;
            }

            if(endC <= curActivity.start) {
                endC = curActivity.end;
                res.append("C");
                lastAssigned="C";
                continue;
            }

            res = new StringBuilder("IMPOSSIBLE");
            break;

        }
        return res.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            List<Activity> activities = new ArrayList<>();
            int nActivities = in.nextInt();
            for (int j =0;j<nActivities; j++) {
                Activity a = new Activity();
                a.start = in.nextInt();
                a.end = in.nextInt();
                activities.add(a);
            }
            String result = solve(activities);
            System.out.println("Case #" + i + ": " + result);
        }

    }
}
 class Activity {
    int start;
    int end;
    String assigned;
}
