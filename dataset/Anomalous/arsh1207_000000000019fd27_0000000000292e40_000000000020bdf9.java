import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(br.readLine());
                int[][] intervals = new int[n][2];
                for (int i = 0; i < n; i++) {
                    String[] parts = br.readLine().split(" ");
                    intervals[i][0] = Integer.parseInt(parts[0]);
                    intervals[i][1] = Integer.parseInt(parts[1]);
                }

                StringBuilder result = new StringBuilder();
                int jEnd = 0, cEnd = 0;
                boolean possible = true;

                for (int[] interval : intervals) {
                    if (interval[0] >= cEnd) {
                        result.append("C");
                        cEnd = interval[1];
                    } else if (interval[0] >= jEnd) {
                        result.append("J");
                        jEnd = interval[1];
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    result = new StringBuilder("IMPOSSIBLE");
                }

                System.out.println("Case #" + t + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}