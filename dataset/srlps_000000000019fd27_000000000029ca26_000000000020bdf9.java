import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        List<int[]> activities;
        List<Integer> cActivities, jActivities;
        String assignments;
        int[] currentActivity;
        boolean impossible;
        for (int t = 1; t <= tests; ++t) {
            int n = in.nextInt();

            activities = new ArrayList<>();
            cActivities = new LinkedList<>();
            jActivities = new LinkedList<>();
            assignments = "";
            impossible = false;
            for (int i = 0; i < n; i++) {
                currentActivity = new int[2];
                currentActivity[0] = in.nextInt();
                currentActivity[1] = in.nextInt();
                if (!impossible) {
                    if (insert(i, currentActivity, cActivities, activities)) {
                        assignments += "C";
                    } else if (insert(i, currentActivity, jActivities, activities)) {
                        assignments += "J";
                    } else {
                        assignments = "IMPOSSIBLE";
                        impossible = true;
                        continue;
                    }
                    activities.add(currentActivity);
                }
            }

            System.out.printf("Case #%d: %s\n", t, assignments);
        }
    }

    private static boolean insert(int currentIndex, int[] currentActivity, List<Integer> personActivities,
            List<int[]> activities) {
        int[] personActivity;
        int comp;
        for (int i = 0; i < personActivities.size(); i++) {
            personActivity = activities.get(personActivities.get(i));
            comp = compare(currentActivity, personActivity);
            switch (comp) {
                case -1: // current activity before person activity
                    personActivities.add(i, currentIndex);
                    return true;
                case 1: // current activity after person activity
                    // do nothing
                    break;
                case 0: // current activity and person activity overlap
                    return false;
            }
        }
        personActivities.add(currentIndex);
        return true;
    }

    private static int compare(int[] first, int[] last) {
        return first[1] <= last[0] ? -1 : (first[0] >= last[1] ? 1 : 0);
    }
}