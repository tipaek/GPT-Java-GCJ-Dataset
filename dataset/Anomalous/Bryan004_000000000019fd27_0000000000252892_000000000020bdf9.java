import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] original = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                original[j][0] = intervals[j][0];
                original[j][1] = intervals[j][1];
            }
            
            System.out.println("Case #" + (i + 1) + ": " + assignTasks(intervals, original));
        }
    }
    
    public static String assignTasks(int[][] intervals, int[][] original) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        StringBuilder result = new StringBuilder();
        int[] cameronTask = null;
        int[] jamieTask = null;
        HashMap<String, String> taskMap = new HashMap<>();
        
        for (int[] interval : intervals) {
            if (cameronTask == null) {
                cameronTask = interval;
                taskMap.put(interval[0] + "-" + interval[1], "C");
            } else if (interval[0] >= cameronTask[1]) {
                cameronTask = interval;
                taskMap.put(interval[0] + "-" + interval[1], "C");
            } else if (jamieTask == null) {
                jamieTask = interval;
                taskMap.put(interval[0] + "-" + interval[1], "J");
            } else if (interval[0] >= jamieTask[1]) {
                jamieTask = interval;
                taskMap.put(interval[0] + "-" + interval[1], "J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        for (int[] orig : original) {
            result.append(taskMap.get(orig[0] + "-" + orig[1]));
        }
        
        return result.toString();
    }
}