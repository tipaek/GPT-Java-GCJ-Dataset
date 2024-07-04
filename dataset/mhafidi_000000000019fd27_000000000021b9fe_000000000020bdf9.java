
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public class Solution {

    public static String solve(List<Activity> activities) {
        List<Activity> sol = new ArrayList<>();
        String lastAssigned = null;
        int endJ = 0, endC =0;

        activities.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 0; i < activities.size() ; i++) {
            Activity curActivity = activities.get(i);
            if(endJ <= curActivity.start) {
                endJ = curActivity.end;
                curActivity.assigned = "J";
                sol.add(curActivity);
                lastAssigned="J";
                continue;
            }

            if(endC <= curActivity.start) {
                endC = curActivity.end;
                curActivity.assigned = "C";
                sol.add(curActivity);

                lastAssigned="C";
                continue;
            }

            return "IMPOSSIBLE";

        }
        return sol.stream().sorted(Comparator.comparingInt(a->a.i)).map(a->a.assigned).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            List<Activity> activities = new ArrayList<>();
            int nActivities = in.nextInt();
            for (int j =0;j<nActivities; j++) {
                Activity a = new Activity();
                a.i = j;
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
    int i;
    int start;
    int end;
    String assigned;
}
