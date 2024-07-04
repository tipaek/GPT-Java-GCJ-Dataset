import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
                int n = Integer.parseInt(br.readLine());
                int[][] intervals = new int[n][2];
                int[][] originalIntervals = new int[n][2];
                
                for (int i = 0; i < n; i++) {
                    String[] line = br.readLine().split(" ");
                    intervals[i][0] = Integer.parseInt(line[0]);
                    intervals[i][1] = Integer.parseInt(line[1]);
                    originalIntervals[i][0] = intervals[i][0];
                    originalIntervals[i][1] = intervals[i][1];
                }
                
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                
                Map<Integer, String> scheduleMap = new HashMap<>();
                StringBuilder result = new StringBuilder();
                int cEnd = 0;
                int jEnd = 0;
                
                for (int[] interval : intervals) {
                    if (interval[0] >= cEnd) {
                        scheduleMap.put(interval[0], "C");
                        cEnd = interval[1];
                    } else if (interval[0] >= jEnd) {
                        scheduleMap.put(interval[0], "J");
                        jEnd = interval[1];
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                
                if (result.toString().equals("IMPOSSIBLE")) {
                    System.out.println(result);
                } else {
                    for (int[] originalInterval : originalIntervals) {
                        result.append(scheduleMap.get(originalInterval[0]));
                    }
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}