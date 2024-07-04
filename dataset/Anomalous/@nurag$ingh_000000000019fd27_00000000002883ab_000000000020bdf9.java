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
            
            sortIntervals(sortedStartTimes, sortedEndTimes, n);
            
            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;
            Map<String, Character> scheduleMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                if (sortedStartTimes[i] >= cEnd) {
                    scheduleMap.put(getKey(sortedStartTimes[i], sortedEndTimes[i]), 'C');
                    cEnd = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jEnd) {
                    scheduleMap.put(getKey(sortedStartTimes[i], sortedEndTimes[i]), 'J');
                    jEnd = sortedEndTimes[i];
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
                    result.append(scheduleMap.get(getKey(startTimes[i], endTimes[i])));
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
    }
    
    private static void sortIntervals(int[] startTimes, int[] endTimes, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (startTimes[j] > startTimes[j + 1]) {
                    swap(startTimes, j, j + 1);
                    swap(endTimes, j, j + 1);
                }
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static String getKey(int start, int end) {
        return start + "" + end;
    }
}