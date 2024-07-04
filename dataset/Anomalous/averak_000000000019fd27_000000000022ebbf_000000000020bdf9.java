import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            if (scanner.hasNext()) {
                int intervalCount = scanner.nextInt();
                int[][] intervals = new int[intervalCount][2];
                Map<String, Integer> intervalMap = new HashMap<>();
                boolean isImpossible = false;
                
                for (int i = 0; i < intervalCount; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (scanner.hasNext()) {
                            intervals[i][j] = scanner.nextInt();
                        }
                    }
                    
                    String key = intervals[i][0] + "-" + intervals[i][1];
                    if (!intervalMap.containsKey(key)) {
                        intervalMap.put(key, i);
                    } else {
                        String alternateKey = key + "*";
                        if (!intervalMap.containsKey(alternateKey)) {
                            intervalMap.put(alternateKey, i);
                        } else {
                            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                }
                
                if (!isImpossible) {
                    assignTasks(intervals, testCase, intervalMap);
                }
            }
        }
    }

    private static void assignTasks(int[][] intervals, int testCase, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] assignments = new char[intervals.length];
        assignments[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        intervalMap.remove(intervals[0][0] + "-" + intervals[0][1]);
        
        int cEnd = intervals[0][1];
        int jEnd = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (!intervalMap.containsKey(key)) {
                key = key + "*";
            }
            
            Integer index = intervalMap.get(key);
            if (index == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
            
            if (intervals[i][0] >= cEnd) {
                assignments[index] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                assignments[index] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
            
            intervalMap.remove(key);
        }
        
        System.out.println("Case #" + testCase + ": " + new String(assignments));
    }
}