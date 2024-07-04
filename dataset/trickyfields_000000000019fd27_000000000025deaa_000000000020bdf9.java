import java.util.*;

public class Solution {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int testCaseCount = sc.nextInt();

        for (int t = 0; t < testCaseCount; t++) {
            System.out.println("Case #" + (t + 1) + ": " + process(sc));
        }
    }

    private static String process(Scanner sc) {
        final int activityCount = sc.nextInt();
        List<List<Integer>> activities = new ArrayList<>();

        for (int y = 0; y < activityCount; y++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            ArrayList<Integer> activity = new ArrayList<>();
            activity.add(start);
            activity.add(end);
            activities.add(activity);
        }
        activities.sort(Comparator.comparing(a -> a.get(0)));
        return assignActivities(activities);
    }

    private static String assignActivities(List<List<Integer>> activities) {
        int cameronEnd = 0;
        int jamesEnd = 0;
        StringBuilder assignment = new StringBuilder();

        for (List<Integer> activity : activities) {
            if (cameronEnd <= activity.get(0)) {
                assignment.append("C");
                cameronEnd = activity.get(1);
            } else if (jamesEnd <= activity.get(0)) {
                assignment.append("J");
                jamesEnd = activity.get(1);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return assignment.toString();
    }
}
