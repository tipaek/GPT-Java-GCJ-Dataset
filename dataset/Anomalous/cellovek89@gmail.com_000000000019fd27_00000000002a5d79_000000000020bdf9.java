import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] intervals = new int[n][4];
            int[] timeSlots = new int[1440];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                intervals[i][0] = start;
                intervals[i][1] = end;
                intervals[i][2] = -1; // Unassigned
                intervals[i][3] = i;

                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                    if (timeSlots[j] > 2) {
                        isImpossible = true;
                    }
                }
            }

            result.append("Case #").append(test).append(": ");
            if (isImpossible) {
                result.append("IMPOSSIBLE\n");
                continue;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            intervals[0][2] = 0; // Assign first task to Cameron (0)

            for (int i = 1; i < n; i++) {
                int currentPerson = 0;
                for (int j = 0; j < i; j++) {
                    if (intervals[j][1] > intervals[i][0] && intervals[j][2] == currentPerson) {
                        currentPerson = 1;
                        break;
                    }
                }
                intervals[i][2] = currentPerson;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[3]));
            for (int i = 0; i < n; i++) {
                result.append(intervals[i][2] == 0 ? 'C' : 'J');
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}