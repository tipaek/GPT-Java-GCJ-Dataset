import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            int[] sortedStartTimes = startTimes.clone();
            int[] sortedEndTimes = endTimes.clone();
            
            // Sort the intervals by start time using bubble sort
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (sortedStartTimes[j] > sortedStartTimes[j + 1]) {
                        swap(sortedStartTimes, j, j + 1);
                        swap(sortedEndTimes, j, j + 1);
                    }
                }
            }
            
            int cEndTime = 0;
            int jEndTime = 0;
            boolean isImpossible = false;
            Map<String, LinkedList<String>> assignmentMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                if (sortedStartTimes[i] >= cEndTime) {
                    assignTask(assignmentMap, sortedStartTimes[i], sortedEndTimes[i], "C");
                    cEndTime = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jEndTime) {
                    assignTask(assignmentMap, sortedStartTimes[i], sortedEndTimes[i], "J");
                    jEndTime = sortedEndTimes[i];
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    LinkedList<String> taskList = assignmentMap.get(startTimes[i] + "" + endTimes[i]);
                    result.append(taskList.removeFirst());
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void assignTask(Map<String, LinkedList<String>> map, int startTime, int endTime, String task) {
        String key = startTime + "" + endTime;
        map.putIfAbsent(key, new LinkedList<>());
        map.get(key).add(task);
    }
}