import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            
            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            
            String schedule = generateSchedule(tasks);
            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    public static String generateSchedule(int[][] tasks) {
        Map<Character, Integer> startTimes = new HashMap<>();
        Map<Character, Integer> endTimes = new HashMap<>();
        char cameron = 'C', jamie = 'J';
        char currentWorker = ' ';
        StringBuilder schedulePattern = new StringBuilder();
        
        for (int[] task : tasks) {
            if (schedulePattern.length() == 0) {
                currentWorker = jamie;
                startTimes.put(currentWorker, task[0]);
                endTimes.put(currentWorker, task[1]);
                schedulePattern.append(currentWorker);
            } else {
                char alternateWorker = (currentWorker == cameron) ? jamie : cameron;
                
                if (canContinueTask(currentWorker, startTimes, endTimes, task)) {
                    schedulePattern.append(currentWorker);
                } else if (canTakeNewTask(alternateWorker, startTimes, endTimes, task)) {
                    currentWorker = alternateWorker;
                    schedulePattern.append(currentWorker);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return schedulePattern.toString();
    }

    public static boolean canContinueTask(char worker, Map<Character, Integer> startTimes, Map<Character, Integer> endTimes, int[] task) {
        int startTime = startTimes.get(worker);
        int endTime = endTimes.get(worker);
        
        if (task[0] < endTime) {
            if (startTime < task[0] || task[1] > startTime) {
                return false;
            }
        }
        
        if (task[0] < startTime) {
            startTimes.put(worker, task[0]);
        }
        endTimes.put(worker, task[1]);
        return true;
    }

    public static boolean canTakeNewTask(char worker, Map<Character, Integer> startTimes, Map<Character, Integer> endTimes, int[] task) {
        if (!startTimes.containsKey(worker)) {
            startTimes.put(worker, task[0]);
            endTimes.put(worker, task[1]);
        } else {
            int startTime = startTimes.get(worker);
            int endTime = endTimes.get(worker);
            
            if (task[0] < endTime) {
                if (startTime < task[0] || task[1] > startTime) {
                    return false;
                }
            }
            
            if (task[0] < startTime) {
                startTimes.put(worker, task[0]);
            }
            endTimes.put(worker, task[1]);
        }
        return true;
    }
}