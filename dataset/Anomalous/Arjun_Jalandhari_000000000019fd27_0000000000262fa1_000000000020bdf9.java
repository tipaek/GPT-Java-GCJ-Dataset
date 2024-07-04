import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int z = 0; z < T; z++) {
            result.append("Case #").append(z + 1).append(": ");

            int N = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[N][3];

            // Read intervals
            for (int i = 0; i < N; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
                intervals[i][2] = i;
            }

            // Sort intervals by start time
            java.util.Arrays.sort(intervals, java.util.Comparator.comparingInt(a -> a[0]));

            int[] assigned = new int[N];
            int[][] schedule = { {-1, -1}, {-1, -1} };
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                boolean assignedTask = false;

                for (int j = 0; j < 2; j++) {
                    if (schedule[j][1] <= intervals[i][0]) {
                        schedule[j] = intervals[i];
                        assigned[intervals[i][2]] = j;
                        assignedTask = true;
                        break;
                    }
                }

                if (!assignedTask) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (int i = 0; i < N; i++) {
                    result.append(assigned[i] == 0 ? 'C' : 'J');
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            result.append("\n");
        }

        System.out.print(result.toString().trim());
    }
}