import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            int numTests = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[numTests][2];
            int[][] originalIntervals = new int[numTests][2];

            for (int i = 0; i < numTests; i++) {
                String[] times = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(times[0]);
                intervals[i][1] = Integer.parseInt(times[1]);
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            Set<Integer> jSet = new HashSet<>();
            Set<Integer> cSet = new HashSet<>();
            String[] result = new String[numTests];
            boolean isPossible = true;

            for (int[] interval : intervals) {
                boolean jAvailable = true;
                boolean cAvailable = true;

                for (int time = interval[0]; time < interval[1]; time++) {
                    if (jSet.contains(time)) {
                        jAvailable = false;
                        break;
                    }
                }

                if (jAvailable) {
                    for (int time = interval[0]; time < interval[1]; time++) {
                        jSet.add(time);
                    }
                } else {
                    for (int time = interval[0]; time < interval[1]; time++) {
                        if (cSet.contains(time)) {
                            cAvailable = false;
                            break;
                        }
                    }

                    if (cAvailable) {
                        for (int time = interval[0]; time < interval[1]; time++) {
                            cSet.add(time);
                        }
                    }
                }

                int index = 0;
                for (int i = 0; i < originalIntervals.length; i++) {
                    if (Arrays.equals(interval, originalIntervals[i])) {
                        index = i;
                        originalIntervals[i][0] = originalIntervals[i][1] = -1;
                        break;
                    }
                }

                if (jAvailable) {
                    result[index] = "J";
                } else if (cAvailable) {
                    result[index] = "C";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", caseNum + 1, String.join("", result));
            } else {
                System.out.printf("Case #%d: %s\n", caseNum + 1, "IMPOSSIBLE");
            }
        }

        reader.close();
    }
}