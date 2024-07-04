import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] scheduleC = new int[60 * 24 + 1];
            int[] scheduleJ = new int[60 * 24 + 1];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            
            for (int activity = 1; activity <= activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (result.length() > 0) continue;
                
                if (isAvailable(scheduleC, start, end)) {
                    assignTask(scheduleC, start, end, activity);
                } else if (isAvailable(scheduleJ, start, end)) {
                    assignTask(scheduleJ, start, end, activity);
                } else {
                    result.append("IMPOSSIBLE");
                }
            }
            
            if (result.length() == 0) {
                Set<Integer> cTasks = new HashSet<>();
                for (int task : scheduleC) cTasks.add(task);
                
                for (int activity = 1; activity <= activities; activity++) {
                    if (cTasks.contains(activity)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) return false;
        }
        return true;
    }

    private static void assignTask(int[] schedule, int start, int end, int taskNumber) {
        for (int i = start; i < end; i++) {
            schedule[i] = taskNumber;
        }
    }
}