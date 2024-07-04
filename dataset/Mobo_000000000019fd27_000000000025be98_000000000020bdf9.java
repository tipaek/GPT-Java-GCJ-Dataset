import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        int start;
        int end;
        int position;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            int size = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int row = 0; row < size; row++) {
                Activity a = new Activity();
                a.start = in.nextInt();
                a.end = in.nextInt();
                a.position = row;
                activities.add(a);
            }

            String result = solveCase(activities);
            System.out
                .println("Case #" + (problemNumber + 1) + ": " + result);
        }
    }

    private static String solveCase(List<Activity> activities) {
        StringBuilder result = new StringBuilder(".".repeat(activities.size()));
        int[] busyUntil = { 0, 0 };

        activities.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);

            if (activity.start >= busyUntil[0]) {
                //assign to C
                busyUntil[0] = activity.end;
                result.replace(activity.position, activity.position + 1, "C");
            } else if (activity.start >= busyUntil[1]) {
                //assign to J
                busyUntil[1] = activity.end;
                result.replace(activity.position, activity.position + 1, "J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }
}
