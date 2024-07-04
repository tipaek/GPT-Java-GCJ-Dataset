import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int[] cameronSchedule = new int[1440];
                int[] jamieSchedule = new int[1440];
                int taskCount = scanner.nextInt();
                StringBuilder result = new StringBuilder();
                
                for (int task = 1; task <= taskCount; task++) {
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();
                    
                    if (result.length() > 0) continue;
                    
                    if (isAvailable(cameronSchedule, startTime, endTime)) {
                        assignTask(cameronSchedule, startTime, endTime, task);
                    } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                        assignTask(jamieSchedule, startTime, endTime, task);
                    } else {
                        result.append("IMPOSSIBLE");
                    }
                }
                
                if (result.length() == 0) {
                    Set<Integer> cameronTasks = new HashSet<>();
                    for (int task : cameronSchedule) {
                        cameronTasks.add(task);
                    }
                    
                    for (int task = 1; task <= taskCount; task++) {
                        if (cameronTasks.contains(task)) {
                            result.append("C");
                        } else {
                            result.append("J");
                        }
                    }
                }
                
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void assignTask(int[] schedule, int start, int end, int taskNumber) {
        for (int i = start; i < end; i++) {
            schedule[i] = taskNumber;
        }
    }
}