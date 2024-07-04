import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tt = 1; tt <= t; tt++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            int[] timeline = new int[1441];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                timeline[intervals[i][0]]++;
                timeline[intervals[i][1]]--;
            }

            for (int i = 1; i < 1441; i++) {
                timeline[i] += timeline[i - 1];
            }

            boolean impossible = false;
            for (int i = 0; i < 1441; i++) {
                if (timeline[i] > 2) {
                    sb.append("Case #").append(tt).append(": IMPOSSIBLE\n");
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            List<Integer>[] schedules = new ArrayList[2];
            for (int i = 0; i < 2; i++) {
                schedules[i] = new ArrayList<>();
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean assigned = false;

                for (int j = 0; j < schedules[0].size(); j++) {
                    if (end > schedules[0].get(j) && start < schedules[1].get(j)) {
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    schedules[0].add(start);
                    schedules[1].add(end);
                    result.append("C");
                } else {
                    result.append("J");
                }
            }

            sb.append("Case #").append(tt).append(": ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}