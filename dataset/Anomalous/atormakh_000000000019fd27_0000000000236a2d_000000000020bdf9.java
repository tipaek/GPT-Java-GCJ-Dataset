import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Integer> cameronStartTimes = new ArrayList<>();
            List<Integer> cameronEndTimes = new ArrayList<>();
            List<Integer> jamieStartTimes = new ArrayList<>();
            List<Integer> jamieEndTimes = new ArrayList<>();
            
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;
            
            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!impossible) {
                    if (assignActivity(start, end, cameronStartTimes, cameronEndTimes)) {
                        schedule.append("C");
                    } else if (assignActivity(start, end, jamieStartTimes, jamieEndTimes)) {
                        schedule.append("J");
                    } else {
                        impossible = true;
                        schedule = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    private static boolean assignActivity(int start, int end, List<Integer> startTimes, List<Integer> endTimes) {
        for (int i = 0; i < startTimes.size(); i++) {
            int existingStart = startTimes.get(i);
            int existingEnd = endTimes.get(i);
            
            if ((start < existingEnd && end > existingStart)) {
                return false;
            }
        }
        
        startTimes.add(start);
        endTimes.add(end);
        return true;
    }
}