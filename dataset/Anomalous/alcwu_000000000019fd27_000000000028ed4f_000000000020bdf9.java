import java.util.*;
import java.io.*;

public class Solution {
    static Map<int[], Boolean> parentResponsible;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] pair = {scanner.nextInt(), scanner.nextInt()};
                activities.add(pair);
            }
            String result = determineParentSchedule(activities);
            System.out.println(formatOutput(i, result));
        }
    }

    public static String formatOutput(int caseNumber, String result) {
        return "Case #" + caseNumber + ": " + result;
    }

    public static String determineParentSchedule(List<int[]> activities) {
        parentResponsible = new HashMap<>();
        List<int[]> sortedActivities = sortActivitiesByStartTime(activities);
        assignParents(sortedActivities);
        return generateFinalSchedule(activities);
    }

    public static void assignParents(List<int[]> sortedActivities) {
        int[] current = sortedActivities.get(0);
        int[] waiting = null;
        parentResponsible.put(current, true);
        for (int i = 1; i < sortedActivities.size(); i++) {
            int[] next = sortedActivities.get(i);
            if (current[1] > next[0]) {
                if (waiting == null) {
                    waiting = next;
                    parentResponsible.put(waiting, false);
                } else if (waiting[1] > next[0]) {
                    parentResponsible.put(next, null);
                } else {
                    waiting = next;
                    parentResponsible.put(waiting, false);
                }
            } else {
                current = next;
                parentResponsible.put(current, true);
                waiting = null;
            }
        }
    }

    public static List<int[]> sortActivitiesByStartTime(List<int[]> activities) {
        List<int[]> sortedActivities = new ArrayList<>(activities);
        sortedActivities.sort(Comparator.comparingInt(a -> a[0]));
        return sortedActivities;
    }

    public static String generateFinalSchedule(List<int[]> activities) {
        StringBuilder schedule = new StringBuilder();
        for (int[] activity : activities) {
            Boolean parent = parentResponsible.get(activity);
            if (parent == null) {
                return "IMPOSSIBLE";
            }
            schedule.append(parent ? 'C' : 'J');
        }
        return schedule.toString();
    }
}