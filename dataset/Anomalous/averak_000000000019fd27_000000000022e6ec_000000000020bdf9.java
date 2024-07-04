import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int i = 1; i <= testCaseCount; i++) {
            if (scanner.hasNext()) {
                int intervalCount = scanner.nextInt();
                int[][] intervals = new int[intervalCount][2];
                Map<String, Integer> intervalMap = new HashMap<>();
                boolean isImpossible = false;
                
                for (int j = 0; j < intervalCount; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (scanner.hasNext()) {
                            intervals[j][k] = scanner.nextInt();
                        }
                    }
                    
                    String key = intervals[j][0] + "-" + intervals[j][1];
                    if (!intervalMap.containsKey(key)) {
                        intervalMap.put(key, j);
                    } else {
                        key += "*";
                        if (!intervalMap.containsKey(key)) {
                            intervalMap.put(key, j);
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                }
                
                if (!isImpossible) {
                    assignIntervals(intervals, i, intervalMap);
                }
            }
        }
    }

    private static void assignIntervals(int[][] intervals, int caseNumber, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        intervalMap.remove(intervals[0][0] + "-" + intervals[0][1]);
        
        int cameronEnd = intervals[0][1];
        int jamieEnd = 0;

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (!intervalMap.containsKey(key)) {
                key += "*";
            }
            
            Integer index = intervalMap.get(key);
            if (index == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            
            if (intervals[i][0] >= cameronEnd) {
                result[index] = 'C';
                cameronEnd = intervals[i][1];
            } else if (intervals[i][0] >= jamieEnd) {
                result[index] = 'J';
                jamieEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            
            intervalMap.remove(key);
        }
        
        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }
}