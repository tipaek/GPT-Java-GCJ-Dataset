import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int t = 0; t < testCases; t++) {
                int n = Integer.parseInt(br.readLine());
                int[][] intervals = new int[n][2];
                int[][] originalIntervals = new int[n][2];
                
                for (int i = 0; i < n; i++) {
                    String[] parts = br.readLine().split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    intervals[i][0] = start;
                    intervals[i][1] = end;
                    originalIntervals[i][0] = start;
                    originalIntervals[i][1] = end;
                }
                
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                
                Map<Integer, String> schedule = new HashMap<>();
                String result = "";
                int jEnd = 0, cEnd = 0;
                
                for (int[] interval : intervals) {
                    if (interval[0] >= cEnd) {
                        schedule.put(interval[0], "C");
                        cEnd = interval[1];
                    } else if (interval[0] >= jEnd) {
                        schedule.put(interval[0], "J");
                        jEnd = interval[1];
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
                
                if (result.equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + (t + 1) + ": " + result);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int[] interval : originalIntervals) {
                        sb.append(schedule.get(interval[0]));
                    }
                    System.out.println("Case #" + (t + 1) + ": " + sb.toString());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}