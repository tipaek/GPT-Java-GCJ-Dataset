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
                String key = schedule[j][0] + " " + schedule[j][1];
                dict.put(key, j);
                maxSchedule = Math.max(maxSchedule, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));
            char[] work = new char[t];
            boolean cAvailable = true;
            boolean jAvailable = true;
            boolean possible = true;
            int cEnd = 0, jEnd = 0, position = 0;

            for (int k = 0; k < maxSchedule && possible; k++) {
                if (position < t && schedule[position][0] == k) {
                    if (cAvailable) {
                        cAvailable = false;
                        cEnd = schedule[position][1];
                        String key = schedule[position][0] + " " + schedule[position][1];
                        work[dict.get(key)] = 'C';
                    } else if (jAvailable) {
                        jAvailable = false;
                        jEnd = schedule[position][1];
                        String key = schedule[position][0] + " " + schedule[position][1];
                        work[dict.get(key)] = 'J';
                    } else {
                        possible = false;
                    }
                    position++;
                }
                if (k == cEnd) cAvailable = true;
                if (k == jEnd) jAvailable = true;
            }

            String result = possible ? new String(work) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        sc.close();
    }
}