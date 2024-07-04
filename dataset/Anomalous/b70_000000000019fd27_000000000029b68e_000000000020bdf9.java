import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            
            String schedule = scheduleTasks(tasks);
            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }
    }
    
    public static String scheduleTasks(int[][] tasks) {
        Map<Character, Integer> startTimes = new HashMap<>();
        Map<Character, Integer> endTimes = new HashMap<>();
        char workerC = 'C', workerJ = 'J', currentWorker = ' ';
        StringBuilder schedule = new StringBuilder();
        
        for (int[] task : tasks) {
            if (schedule.length() == 0) {
                currentWorker = workerJ;
                startTimes.put(currentWorker, task[0]);
                endTimes.put(currentWorker, task[1]);
                schedule.append(currentWorker);
            } else {
                char nextWorker = (currentWorker == workerC) ? workerJ : workerC;
                
                if (canContinueTask(currentWorker, startTimes, endTimes, task)) {
                    schedule.append(currentWorker);
                } else if (canTakeNewTask(nextWorker, startTimes, endTimes, task)) {
                    currentWorker = nextWorker;
                    schedule.append(currentWorker);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        return schedule.toString();
    }
    
    public static boolean canContinueTask(char worker, Map<Character, Integer> startTimes, Map<Character, Integer> endTimes, int[] task) {
        int start = startTimes.get(worker);
        int end = endTimes.get(worker);
        
        if (task[0] < end) {
            if (start < task[0] || task[1] > start) {
                return false;
            }
        }
        
        if (task[0] < start) {
            startTimes.replace(worker, task[0]);
        }
        endTimes.replace(worker, task[1]);
        
        return true;
    }
    
    public static boolean canTakeNewTask(char worker, Map<Character, Integer> startTimes, Map<Character, Integer> endTimes, int[] task) {
        if (!startTimes.containsKey(worker)) {
            startTimes.put(worker, task[0]);
            endTimes.put(worker, task[1]);
        } else {
            int start = startTimes.get(worker);
            int end = endTimes.get(worker);
            
            if (task[0] < end) {
                if (start < task[0] || task[1] > start) {
                    return false;
                }
            }
            
            if (task[0] < start) {
                startTimes.replace(worker, task[0]);
            }
            endTimes.replace(worker, task[1]);
        }
        
        return true;
    }
}