import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            Map<String, Integer> dict = new HashMap<>();
            int maxSchedule = 0;

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                String key = schedule[j][0] + "," + schedule[j][1];
                dict.put(key, j);
                maxSchedule = Math.max(maxSchedule, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] work = new char[t];
            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int[] task : schedule) {
                int start = task[0], end = task[1];
                String key = start + "," + end;

                if (start >= cEnd) {
                    work[dict.get(key)] = 'C';
                    cEnd = end;
                } else if (start >= jEnd) {
                    work[dict.get(key)] = 'J';
                    jEnd = end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(work) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}