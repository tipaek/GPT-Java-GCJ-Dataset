import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[][] activities = new int[N][4];

            for (int i = 0; i < N; i++) {
                String[] parts = reader.readLine().trim().split(" ");
                activities[i][0] = i;
                activities[i][1] = Integer.parseInt(parts[0]);
                activities[i][2] = Integer.parseInt(parts[1]);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (int i = 0; i < N; i++) {
                if (cameronEnd <= activities[i][1]) {
                    cameronEnd = activities[i][2];
                    activities[i][3] = 1; // Cameron
                } else if (jamieEnd <= activities[i][1]) {
                    jamieEnd = activities[i][2];
                    activities[i][3] = 2; // Jamie
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
                StringBuilder result = new StringBuilder(N);
                for (int[] activity : activities) {
                    result.append(activity[3] == 1 ? 'C' : 'J');
                }
                System.out.printf("Case #%d: %s\n", t, result);
            }
        }
    }
}