import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int activitiesCount = scanner.nextInt();
            List<Integer> cameronStartTimes = new ArrayList<>();
            List<Integer> cameronEndTimes = new ArrayList<>();
            List<Integer> jamieStartTimes = new ArrayList<>();
            List<Integer> jamieEndTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < activitiesCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (!isImpossible) {
                    if (!assignActivity(startTime, endTime, cameronStartTimes, cameronEndTimes)) {
                        if (!assignActivity(startTime, endTime, jamieStartTimes, jamieEndTimes)) {
                            isImpossible = true;
                            schedule = new StringBuilder("IMPOSSIBLE");
                        } else {
                            schedule.append("J");
                        }
                    } else {
                        schedule.append("C");
                    }
                }
            }

            System.out.println("Case #" + i + ": " + schedule.toString());
        }
    }

    private static boolean assignActivity(int startTime, int endTime, List<Integer> startTimes, List<Integer> endTimes) {
        for (int i = 0; i < startTimes.size(); i++) {
            int existingStartTime = startTimes.get(i);
            int existingEndTime = endTimes.get(i);

            if ((startTime < existingEndTime && endTime > existingStartTime) || 
                (startTime == existingStartTime || endTime == existingEndTime)) {
                return false;
            }
        }
        startTimes.add(startTime);
        endTimes.add(endTime);
        return true;
    }
}