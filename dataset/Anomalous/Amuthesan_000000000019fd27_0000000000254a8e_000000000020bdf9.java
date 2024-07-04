import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<int[]> camSchedule = new ArrayList<>();
            List<int[]> jamSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (int activity = 0; activity < numActivities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isAvailable(camSchedule, start, end)) {
                    result.append('C');
                    camSchedule.add(new int[]{start, end});
                } else if (isAvailable(jamSchedule, start, end)) {
                    result.append('J');
                    jamSchedule.add(new int[]{start, end});
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean isAvailable(List<int[]> scheduleList, int start, int end) {
        for (int[] schedule : scheduleList) {
            int scheduledStart = schedule[0];
            int scheduledEnd = schedule[1];
            
            if (start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        return true;
    }
}