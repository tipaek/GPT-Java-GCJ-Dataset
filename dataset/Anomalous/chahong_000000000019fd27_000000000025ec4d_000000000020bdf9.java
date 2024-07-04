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
            int maxEnd = 0;

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                String key = schedule[j][0] + "-" + schedule[j][1];
                dict.put(key, j);
                maxEnd = Math.max(maxEnd, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] work = new char[t];
            boolean cAvailable = true, jAvailable = true, possible = true;
            int cEnd = 0, jEnd = 0;

            for (int[] task : schedule) {
                int start = task[0], end = task[1];
                String key = start + "-" + end;

                if (cAvailable && (start >= cEnd)) {
                    work[dict.get(key)] = 'C';
                    cEnd = end;
                    cAvailable = false;
                } else if (jAvailable && (start >= jEnd)) {
                    work[dict.get(key)] = 'J';
                    jEnd = end;
                    jAvailable = false;
                } else {
                    possible = false;
                    break;
                }

                cAvailable = start >= cEnd;
                jAvailable = start >= jEnd;
            }

            String result = possible ? new String(work) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}