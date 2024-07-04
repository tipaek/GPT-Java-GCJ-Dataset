import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        String[] output = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][2];
            char[] assigned = new char[n];
            Arrays.fill(assigned, ' ');

            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().split("\\s+");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            boolean possible = true;
            for (int i = 0; i < n && possible; i++) {
                assigned[i] = 'C';
                for (int j = 0; j < i; j++) {
                    if (assigned[j] == 'C' && overlap(intervals[j], intervals[i])) {
                        assigned[i] = 'J';
                        break;
                    }
                }

                if (assigned[i] == 'J') {
                    for (int j = 0; j < i; j++) {
                        if (assigned[j] == 'J' && overlap(intervals[j], intervals[i])) {
                            possible = false;
                            break;
                        }
                    }
                }
            }

            if (!possible) {
                output[t] = "IMPOSSIBLE";
            } else {
                StringBuilder result = new StringBuilder();
                for (char c : assigned) {
                    result.append(c);
                }
                output[t] = result.toString();
            }
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + output[i]);
        }
    }

    private static boolean overlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}