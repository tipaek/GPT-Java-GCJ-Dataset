import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Map<Integer, HashSet<Character>> scheduleMap = new TreeMap<>();
            List<Integer> times = new ArrayList<>();
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int j = 0; j < activityCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                times.add(startTime);
                times.add(endTime);
                
                scheduleMap.putIfAbsent(startTime, new HashSet<>());
                scheduleMap.putIfAbsent(endTime, new HashSet<>());
            }
            
            String result = "";
            for (int k = 0; k < times.size() - 1; k += 2) {
                int start = times.get(k);
                int end = times.get(k + 1);
                boolean hasJ = false, hasC = false, hasBoth = false;
                
                for (Integer key : scheduleMap.keySet()) {
                    if (key >= start && key < end) {
                        if (scheduleMap.get(key).contains('J') && scheduleMap.get(key).contains('C')) {
                            hasBoth = true;
                        } else if (scheduleMap.get(key).contains('C')) {
                            hasC = true;
                        } else if (scheduleMap.get(key).contains('J')) {
                            hasJ = true;
                        }
                    }
                }
                
                for (Integer key : scheduleMap.keySet()) {
                    if (key >= start && key < end) {
                        if (hasBoth) {
                            resultBuilder.setLength(0);
                            result = "IMPOSSIBLE";
                        } else if (hasJ) {
                            result = "C";
                            scheduleMap.get(key).add('C');
                        } else if (hasC) {
                            result = "J";
                            scheduleMap.get(key).add('J');
                        } else {
                            result = "C";
                            scheduleMap.get(key).add('C');
                        }
                    }
                }
                resultBuilder.append(result);
            }
            System.out.println("Case #" + i + ": " + resultBuilder.toString());
        }
        scanner.close();
    }
}