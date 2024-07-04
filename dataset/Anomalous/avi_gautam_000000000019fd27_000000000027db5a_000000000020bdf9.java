import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] timings = new int[N][3];

            in.nextLine();
            for (int r = 0; r < N; r++) {
                String[] rowRead = in.nextLine().split(" ");
                timings[r][0] = Integer.parseInt(rowRead[0]);
                timings[r][1] = Integer.parseInt(rowRead[1]);
                timings[r][2] = r;
            }

            Arrays.sort(timings, Comparator.comparingInt(e -> e[0]));
            System.out.println("Case #" + i + ": " + scheduleActivities(timings, N));
        }
    }

    private static String scheduleActivities(int[][] timings, int N) {
        int cFinishTime = 0, jFinishTime = 0;
        char[] result = new char[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (timings[i][0] >= cFinishTime) {
                result[timings[i][2]] = 'C';
                cFinishTime = timings[i][1];
            } else if (timings[i][0] >= jFinishTime) {
                result[timings[i][2]] = 'J';
                jFinishTime = timings[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }
}