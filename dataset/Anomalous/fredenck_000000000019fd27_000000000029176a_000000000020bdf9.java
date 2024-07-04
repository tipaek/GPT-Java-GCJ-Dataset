import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] times = new int[N][3];
            boolean possible = true;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[j][0] = Integer.parseInt(st.nextToken());
                times[j][1] = Integer.parseInt(st.nextToken());
                times[j][2] = j; // index of the activity
            }

            // Sort activities by the sum of start and end times
            Arrays.sort(times, Comparator.comparingInt(o -> o[0] + o[1]));

            // Assume all assignments to J
            char[] assignments = new char[N];
            Arrays.fill(assignments, 'J');

            // Check for overlaps and assign 'C' where necessary
            for (int a = 0; a < N; a++) {
                int overlapCount = 0;
                for (int b = a + 1; b < N; b++) {
                    if (times[a][1] > times[b][0]) {
                        overlapCount++;
                        assignments[times[b][2]] = 'C';
                    }
                }
                if (overlapCount >= 2) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(assignments));
            }
        }

        br.close();
    }
}