import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            scanner.nextLine();

            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < numberOfActivities; i++) {
                String[] activityDetails = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(activityDetails[0]);
                int endTime = Integer.parseInt(activityDetails[1]);
                activities.add(new Activity(startTime, endTime, i));
            }

            activities.sort(Comparator.comparingInt((Activity a) -> a.startTime)
                                      .thenComparingInt(a -> a.endTime)
                                      .thenComparingInt(a -> a.index));

            int endTimeCameron = 0;
            int endTimeJamie = 0;
            boolean isImpossible = false;
            String[] schedule = new String[numberOfActivities];

            for (Activity activity : activities) {
                if (activity.startTime >= endTimeCameron) {
                    schedule[activity.index] = "C";
                    endTimeCameron = activity.endTime;
                } else if (activity.startTime >= endTimeJamie) {
                    schedule[activity.index] = "J";
                    endTimeJamie = activity.endTime;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }
}

class Activity {
    int startTime, endTime, index;

    Activity(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}