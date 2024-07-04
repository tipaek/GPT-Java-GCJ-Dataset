import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static String assignActivities(ArrayList<ArrayList<Integer>> activities) {
        StringBuilder result = new StringBuilder();
        int cEnd = 0;
        int jEnd = 0;

        for (ArrayList<Integer> activity : activities) {
            if (cEnd <= activity.get(0)) {
                result.append("C");
                cEnd = activity.get(1);
            } else if (jEnd <= activity.get(0)) {
                result.append("J");
                jEnd = activity.get(1);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> comparator = Comparator.comparingInt(o -> o.get(0));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            ArrayList<ArrayList<Integer>> activities = new ArrayList<>();
            ArrayList<ArrayList<Integer>> originalActivities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                ArrayList<Integer> activity = new ArrayList<>();
                activity.add(scanner.nextInt());
                activity.add(scanner.nextInt());
                activities.add(activity);
                originalActivities.add(new ArrayList<>(activity));
            }

            activities.sort(comparator);
            String assignment = assignActivities(activities);

            char[] resultArray = new char[assignment.length()];
            for (int j = 0; j < activities.size() && !assignment.equals("IMPOSSIBLE"); j++) {
                int position = originalActivities.indexOf(activities.get(j));
                resultArray[position] = assignment.charAt(j);
            }

            String result = assignment.equals("IMPOSSIBLE") ? assignment : new String(resultArray);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}