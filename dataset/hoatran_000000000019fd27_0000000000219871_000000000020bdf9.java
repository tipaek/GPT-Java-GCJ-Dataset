import java.util.*;
import java.io.*;
public class Solution {

    static class Activity {
        Activity() {

        }
        int start;
        int end;
        int index;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                Activity activity = new Activity();
                activity.start = in.nextInt();
                activity.end = in.nextInt();
                activity.index = j;
                activities[j] = activity;
            }
            String s = in.nextLine();
            Arrays.sort(activities, Comparator.comparingInt(x -> x.start));
            findSolution(i, activities);
        }
    }

    public static void findSolution(int index, Activity[] activities) {
        char[] a = new char[activities.length];
        String result = "IMPOSSIBLE";
        int aj = 0;
        int ac = 0;
        int n = 0;
        for (Activity activity : activities) {
            if (ac <= activity.start) {
                ac = activity.end;
                a[activity.index] = 'C';
                n++;
                continue;
            }
            if (aj <= activity.start) {
                aj = activity.end;
                a[activity.index] = 'J';
                n++;
                continue;
            }
            break;
        }
        if (n == activities.length) {
            result = new String(a);
        }
        System.out.println("Case #" + index + ": " + result.toString());
    }
}
