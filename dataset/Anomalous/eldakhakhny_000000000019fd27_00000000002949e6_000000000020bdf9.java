import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            activities.sort(Comparator.comparingInt(a -> a.startingTime));
            
            int cameronEndTime = 0;
            int jamieEndTime = 0;
            boolean isImpossible = false;
            StringBuilder resultBuilder = new StringBuilder();
            
            for (Activity activity : activities) {
                if (cameronEndTime <= activity.startingTime) {
                    activity.setOwner('C');
                    cameronEndTime = activity.endTime;
                } else if (jamieEndTime <= activity.startingTime) {
                    activity.setOwner('J');
                    jamieEndTime = activity.endTime;
                } else {
                    resultBuilder = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            int caseNumber = caseIndex + 1;
            
            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + resultBuilder);
            } else {
                Activity[] sortedActivities = new Activity[numberOfActivities];
                
                for (Activity activity : activities) {
                    sortedActivities[activity.index] = activity;
                }
                
                for (Activity activity : sortedActivities) {
                    resultBuilder.append(activity.owner);
                }
                
                System.out.println("Case #" + caseNumber + ": " + resultBuilder);
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int startingTime;
        int endTime;
        int index;
        char owner;

        public Activity(int startingTime, int endTime, int index) {
            this.startingTime = startingTime;
            this.endTime = endTime;
            this.index = index;
        }

        public void setOwner(char owner) {
            this.owner = owner;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startingTime, other.startingTime);
        }
    }
}