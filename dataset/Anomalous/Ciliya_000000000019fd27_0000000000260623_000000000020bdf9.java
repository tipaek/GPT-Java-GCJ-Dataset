import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            String result = scheduleActivities(intervals, N);
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }

    private static String scheduleActivities(int[][] intervals, int N) {
        List<Integer> cSchedule = new ArrayList<>();
        List<Integer> jSchedule = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (canSchedule(cSchedule, start, end)) {
                cSchedule.add(start);
                cSchedule.add(end);
                Collections.sort(cSchedule);
                output.append("C");
            } else if (canSchedule(jSchedule, start, end)) {
                jSchedule.add(start);
                jSchedule.add(end);
                Collections.sort(jSchedule);
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return output.toString();
    }
    
    private static boolean canSchedule(List<Integer> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return true;
        }
        
        for (int i = 0; i < schedule.size(); i += 2) {
            int scheduledStart = schedule.get(i);
            int scheduledEnd = schedule.get(i + 1);
            
            if (end <= scheduledStart || start >= scheduledEnd) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}