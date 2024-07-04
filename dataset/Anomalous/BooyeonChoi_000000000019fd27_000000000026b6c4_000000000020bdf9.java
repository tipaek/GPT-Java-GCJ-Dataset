import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = Integer.parseInt(reader.readLine());
            int[][] activities = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                String[] times = reader.readLine().split(" ");
                activities[i][0] = Integer.parseInt(times[0]);
                activities[i][1] = Integer.parseInt(times[1]);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            Set<Integer> cameron = new HashSet<>();
            Set<Integer> jamie = new HashSet<>();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                if (canSchedule(jamie, start, end)) {
                    schedule(jamie, start, end);
                    result.append("J");
                } else if (canSchedule(cameron, start, end)) {
                    schedule(cameron, start, end);
                    result.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s\n", caseNum, result.toString());
        }

        reader.close();
    }

    private static boolean canSchedule(Set<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void schedule(Set<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.add(i);
        }
    }
}