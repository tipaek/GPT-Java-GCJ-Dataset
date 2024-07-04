import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end, i});
            }
            
            activities.sort(Comparator.comparingInt(a -> a[0]));

            boolean[] assignedToJamie = new boolean[activityCount];
            int[] cameronSchedule = new int[]{-1, -1};
            int[] jamieSchedule = new int[]{-1, -1};
            boolean isImpossible = false;
            
            for (int[] activity : activities) {
                if (!isOverlapping(activity, cameronSchedule)) {
                    cameronSchedule = activity;
                } else if (!isOverlapping(activity, jamieSchedule)) {
                    jamieSchedule = activity;
                    assignedToJamie[activity[2]] = true;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (boolean assigned : assignedToJamie) {
                    result.append(assigned ? "J" : "C");
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean isOverlapping(int[] activity1, int[] activity2) {
        return activity1[1] > activity2[0] && activity1[0] < activity2[1];
    }
}