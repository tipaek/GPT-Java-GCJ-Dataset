import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = in.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = in.nextInt();
            List<Integer[]> activitiesTime = retrieveActivitiesTime(activitiesCount, in); 
            String output = taskAssignment(activitiesTime);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String taskAssignment(List<Integer[]> activitiesTime) {
        StringBuilder sb = new StringBuilder("C");
        int maxStartTime = activitiesTime.get(0)[1];
        int overlapCount = 0;
        int cCount = 1;
        int jCount = 0;
        for (int i = 1; i < activitiesTime.size(); i++) {
            Integer[] currentTime = activitiesTime.get(i);
            Integer[] previousTime = activitiesTime.get(i - 1);
            int currentStartTime = currentTime[0];
            int previousEndTime = previousTime[1]; 
            String toBeAdded = cCount <= jCount ? "C" : "J";
            if (currentStartTime == previousEndTime) {
                toBeAdded = sb.substring(sb.length() - 1);
            } else if (isOverlapping(currentTime, maxStartTime)) {
                overlapCount++;
            } 

            if (toBeAdded.equals("C")) cCount++;
            else if (toBeAdded.equals("J")) jCount++;
            sb.append(toBeAdded);
            maxStartTime = Math.max(maxStartTime, currentTime[1]);
        }
        return overlapCount == activitiesTime.size() - 1 ? "IMPOSSIBLE" : sb.toString();
    }

    private static boolean isOverlapping(Integer[] currentTime, int maxStartTime) {
        int currentStartTime = currentTime[0];
        if (currentStartTime < maxStartTime) return true;
        return false;
    }

    private static List<Integer[]> retrieveActivitiesTime(int activitiesCount, Scanner in) {
        List<Integer[]> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            activitiesTime.add(new Integer[] {startTime, endTime});
        }
        return activitiesTime;
    }
}   