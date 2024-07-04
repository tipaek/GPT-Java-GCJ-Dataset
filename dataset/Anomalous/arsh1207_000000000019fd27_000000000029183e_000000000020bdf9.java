import java.io.*;
import java.util.*;

public class CodeJam3 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
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

                Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
                Map<int[], String> schedule = new HashMap<>();
                StringBuilder result = new StringBuilder();
                int cEnd = 0;
                int jEnd = 0;

                for (int[] interval : intervals) {
                    if (interval[0] >= cEnd) {
                        schedule.put(interval, "C");
                        cEnd = interval[1];
                    } else if (interval[0] >= jEnd) {
                        schedule.put(interval, "J");
                        jEnd = interval[1];
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                if (result.toString().equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + (t + 1) + ": " + result);
                } else {
                    for (int[] originalInterval : originalIntervals) {
                        for (int[] interval : intervals) {
                            if (Arrays.equals(originalInterval, interval)) {
                                result.append(schedule.get(interval));
                                break;
                            }
                        }
                    }
                    System.out.println("Case #" + (t + 1) + ": " + result);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}