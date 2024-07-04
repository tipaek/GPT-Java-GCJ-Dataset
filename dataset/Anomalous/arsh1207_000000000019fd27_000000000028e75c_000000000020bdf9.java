import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(br.readLine());
                int[][] intervals = new int[n][2];
                int[][] originalIntervals = new int[n][2];

                for (int i = 0; i < n; i++) {
                    String[] parts = br.readLine().split(" ");
                    intervals[i][0] = Integer.parseInt(parts[0]);
                    intervals[i][1] = Integer.parseInt(parts[1]);
                    originalIntervals[i][0] = intervals[i][0];
                    originalIntervals[i][1] = intervals[i][1];
                }

                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

                Map<Integer, String> schedule = new HashMap<>();
                StringBuilder result = new StringBuilder();
                int cEnd = 0, jEnd = 0;

                for (int[] interval : intervals) {
                    if (interval[0] >= cEnd) {
                        schedule.put(interval[0], "C");
                        cEnd = interval[1];
                    } else if (interval[0] >= jEnd) {
                        schedule.put(interval[0], "J");
                        jEnd = interval[1];
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                if (result.toString().equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + t + ": " + result);
                } else {
                    for (int[] originalInterval : originalIntervals) {
                        result.append(schedule.get(originalInterval[0]));
                    }
                    System.out.println("Case #" + t + ": " + result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}