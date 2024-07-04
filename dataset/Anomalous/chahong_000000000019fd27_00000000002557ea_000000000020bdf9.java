import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            Map<Integer, Integer> dict = new HashMap<>();
            int maxSchedule = 0;

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                dict.put(schedule[j][0], j);
                maxSchedule = Math.max(maxSchedule, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] work = new char[t];
            work[dict.get(schedule[0][0])] = 'C';
            int cEnd = schedule[0][1];
            int jEnd = 0;
            boolean cAvailable = false;
            boolean jAvailable = true;
            boolean possible = true;
            int pos = 1;

            for (int k = schedule[0][0]; k < maxSchedule; k++) {
                if (cEnd == k) cAvailable = true;
                if (jEnd == k) jAvailable = true;

                if (pos < t && schedule[pos][0] == k) {
                    if (!cAvailable) {
                        if (!jAvailable) {
                            possible = false;
                            break;
                        } else {
                            jAvailable = false;
                            jEnd = schedule[pos][1];
                            work[dict.get(schedule[pos][0])] = 'J';
                        }
                    } else {
                        cAvailable = false;
                        cEnd = schedule[pos][1];
                        work[dict.get(schedule[pos][0])] = 'C';
                    }
                    pos++;
                }
            }

            String result = possible ? new String(work) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}