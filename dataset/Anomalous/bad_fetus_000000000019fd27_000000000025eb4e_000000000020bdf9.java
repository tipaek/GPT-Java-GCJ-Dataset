import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                String[] times = scanner.nextLine().split("\\s+");
                activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
            }
            
            List<Activity> originalOrder = new ArrayList<>(activities);
            Collections.sort(activities);
            
            int cameronEnd = -1;
            int jamieEnd = -1;
            boolean impossible = false;
            boolean[] assignedToCameron = new boolean[numActivities];
            
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                if (activity.startTime >= cameronEnd) {
                    cameronEnd = activity.endTime;
                    assignedToCameron[i] = true;
                } else if (activity.startTime >= jamieEnd) {
                    jamieEnd = activity.endTime;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                boolean[] sortedAssignments = sortAssignments(assignedToCameron, activities, originalOrder);
                StringBuilder result = new StringBuilder("Case #");
                result.append(caseNum).append(": ");
                for (boolean assigned : sortedAssignments) {
                    result.append(assigned ? "C" : "J");
                }
                System.out.println(result);
            }
        }
        
        scanner.close();
    }

    private static boolean[] sortAssignments(boolean[] assignments, List<Activity> sortedActivities, List<Activity> originalActivities) {
        boolean[] sorted = new boolean[assignments.length];
        for (int i = 0; i < assignments.length; i++) {
            int originalIndex = originalActivities.indexOf(sortedActivities.get(i));
            sorted[originalIndex] = assignments[i];
        }
        return sorted;
    }
}

class Activity implements Comparable<Activity> {
    int startTime;
    int endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.startTime, other.startTime);
    }

    @Override
    public String toString() {
        return startTime + " " + endTime;
    }
}