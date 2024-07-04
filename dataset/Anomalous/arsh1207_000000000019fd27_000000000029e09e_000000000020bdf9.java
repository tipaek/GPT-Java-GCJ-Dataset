import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(br.readLine());
                int[][] intervals = new int[n][3];
                
                for (int i = 0; i < n; i++) {
                    String[] parts = br.readLine().split(" ");
                    intervals[i][0] = Integer.parseInt(parts[0]);
                    intervals[i][1] = Integer.parseInt(parts[1]);
                    intervals[i][2] = i;
                }
                
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                
                Map<Integer, String> schedule = new HashMap<>();
                String result = "";
                int cEnd = 0, jEnd = 0;
                
                for (int[] interval : intervals) {
                    int start = interval[0];
                    int end = interval[1];
                    int index = interval[2];
                    
                    if (start >= cEnd) {
                        schedule.put(index, "C");
                        cEnd = end;
                    } else if (start >= jEnd) {
                        schedule.put(index, "J");
                        jEnd = end;
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
                
                if (result.equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + t + ": " + result);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        sb.append(schedule.get(i));
                    }
                    System.out.println("Case #" + t + ": " + sb.toString());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}