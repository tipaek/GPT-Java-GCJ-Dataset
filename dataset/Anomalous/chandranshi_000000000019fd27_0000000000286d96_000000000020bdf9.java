import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        if (t < 1 || t > 100) {
            return;
        }

        for (int i = 0; i < t; i++) {
            List<Integer> arrC = new ArrayList<>();
            List<Integer> arrJ = new ArrayList<>();
            StringBuilder ans = new StringBuilder("Case #").append(i + 1).append(": ");
            int n = Integer.parseInt(br.readLine());

            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (start < 0 || start > 1440 || end < 0 || end > 1440) {
                    ans.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }

                if (canSchedule(arrJ, start, end)) {
                    arrJ.add(start);
                    arrJ.add(end);
                    ans.append("J");
                } else if (canSchedule(arrC, start, end)) {
                    arrC.add(start);
                    arrC.add(end);
                    ans.append("C");
                } else {
                    ans.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(ans.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean canSchedule(List<Integer> schedule, int start, int end) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int scheduledStart = schedule.get(k);
            int scheduledEnd = schedule.get(k + 1);
            if (!(end <= scheduledStart || start >= scheduledEnd)) {
                return false;
            }
        }
        return true;
    }
}