import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            String result = assignTasks(n, intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int n, int[][] intervals) {
        List<Integer> cameronStart = new ArrayList<>();
        List<Integer> cameronEnd = new ArrayList<>();
        List<Integer> jamesStart = new ArrayList<>();
        List<Integer> jamesEnd = new ArrayList<>();
        
        cameronStart.add(intervals[0][0]);
        cameronEnd.add(intervals[0][1]);
        StringBuilder schedule = new StringBuilder("C");
        
        for (int j = 1; j < n; j++) {
            boolean conflictWithCameron = hasConflict(cameronStart, cameronEnd, intervals[j]);
            boolean conflictWithJames = hasConflict(jamesStart, jamesEnd, intervals[j]);
            
            if (!conflictWithCameron) {
                cameronStart.add(intervals[j][0]);
                cameronEnd.add(intervals[j][1]);
                schedule.append("C");
            } else if (!conflictWithJames) {
                jamesStart.add(intervals[j][0]);
                jamesEnd.add(intervals[j][1]);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }

    private static boolean hasConflict(List<Integer> startTimes, List<Integer> endTimes, int[] interval) {
        for (int k = 0; k < startTimes.size(); k++) {
            if ((interval[0] >= startTimes.get(k) && interval[0] < endTimes.get(k)) ||
                (interval[1] > startTimes.get(k) && interval[1] <= endTimes.get(k))) {
                return true;
            }
        }
        return false;
    }
}