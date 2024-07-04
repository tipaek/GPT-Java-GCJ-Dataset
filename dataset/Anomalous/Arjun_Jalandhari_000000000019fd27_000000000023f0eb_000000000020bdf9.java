import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            result.append("Case #").append(t + 1).append(": ");
            int N = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[N][3];

            // Reading intervals
            for (int i = 0; i < N; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
                intervals[i][2] = i;
            }

            // Sorting intervals by start time
            java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int[] assignments = new int[N];
            int[][] schedules = { { -1, -1 }, { -1, -1 } }; // Schedules for C and J
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                boolean assigned = false;
                for (int j = 0; j < 2; j++) {
                    if (schedules[j][1] <= intervals[i][0]) {
                        schedules[j] = intervals[i];
                        assignments[intervals[i][2]] = j;
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result.append("IMPOSSIBLE\n");
            } else {
                for (int i = 0; i < N; i++) {
                    result.append(assignments[i] == 0 ? 'C' : 'J');
                }
                result.append("\n");
            }
        }

        System.out.print(result.toString().trim());
    }
}