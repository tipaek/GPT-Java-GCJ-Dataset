import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            TreeMap<Integer, List<int[]>> scheduleMap = new TreeMap<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scheduleMap.putIfAbsent(start, new ArrayList<>());
                scheduleMap.get(start).add(new int[]{end, i});
            }
            
            int cameronEnd = -1;
            int jamieEnd = -1;
            char[] result = new char[n];
            boolean possible = true;
            
            for (Map.Entry<Integer, List<int[]>> entry : scheduleMap.entrySet()) {
                int start = entry.getKey();
                for (int[] interval : entry.getValue()) {
                    int end = interval[0];
                    int index = interval[1];
                    
                    if (start >= cameronEnd) {
                        cameronEnd = end;
                        result[index] = 'C';
                    } else if (start >= jamieEnd) {
                        jamieEnd = end;
                        result[index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }
                if (!possible) break;
            }
            
            System.out.println("Case #" + (t + 1) + ": " + (possible ? new String(result) : "IMPOSSIBLE"));
        }
        
        scanner.close();
    }
}