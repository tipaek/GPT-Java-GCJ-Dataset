import java.util.ArrayList;
import java.util.Scanner;

class Activity {
    private int startMin;
    private int endMin;

    public Activity(int startMin, int endMin) {
        this.startMin = startMin;
        this.endMin = endMin;
    }

    public boolean isValid(Activity activity) {
        return endMin <= activity.getStartMin() || startMin >= activity.getEndMin();
    }

    public int getStartMin() {
        return startMin;
    }

    public int getEndMin() {
        return endMin;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder schedule = new StringBuilder();
            int numActivities = Integer.parseInt(scanner.nextLine());
            ArrayList<Activity> cActivities = new ArrayList<>();
            ArrayList<Activity> jActivities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                String[] activityInput = scanner.nextLine().split("\\s");
                Activity activity = new Activity(Integer.parseInt(activityInput[0]), Integer.parseInt(activityInput[1]));

                boolean canAssignToC = cActivities.stream().allMatch(a -> a.isValid(activity));
                boolean canAssignToJ = jActivities.stream().allMatch(a -> a.isValid(activity));

                if (canAssignToC) {
                    schedule.append("C");
                    cActivities.add(activity);
                } else if (canAssignToJ) {
                    schedule.append("J");
                    jActivities.add(activity);
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    for (int k = j + 1; k < numActivities; k++) {
                        scanner.nextLine();
                    }
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }
}