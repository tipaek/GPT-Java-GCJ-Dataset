import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                String[] parts = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            char[] schedule = new char[n];
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (cEnd <= intervals[i][0]) {
                    cEnd = intervals[i][1];
                    schedule[intervals[i][2]] = 'C';
                } else if (jEnd <= intervals[i][0]) {
                    jEnd = intervals[i][1];
                    schedule[intervals[i][2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}