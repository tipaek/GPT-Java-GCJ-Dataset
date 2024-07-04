import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[] schedule = new int[24 * 60 + 1];
            int[][] activities = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                schedule[start]++;
                schedule[end]--;
                activities[i][0] = i;
                activities[i][1] = start;
            }
            
            boolean impossible = false;
            for (int i = 1; i <= 24 * 60; i++) {
                schedule[i] += schedule[i - 1];
                if (schedule[i] > 2) {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                Arrays.sort(activities, (a, b) -> Integer.compare(b[1], a[1]));
                char[] result = new char[N];
                boolean assignC = true;
                
                for (int i = 0; i < N; i++) {
                    result[activities[i][0]] = assignC ? 'C' : 'J';
                    assignC = !assignC;
                }
                
                System.out.printf("Case #%d: %s\n", t, new String(result));
            }
        }
    }
}