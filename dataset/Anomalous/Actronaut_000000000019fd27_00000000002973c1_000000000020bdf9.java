import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = in.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int numActivities = in.nextInt();
            int[] parents = new int[]{-1, -1};

            PriorityQueue<int[]> activities = new PriorityQueue<>(numActivities, Comparator.comparingInt(a -> a[0]));
            for (int j = 0; j < numActivities; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new int[]{start, end, j, -1});
            }

            PriorityQueue<int[]> outputOrder = new PriorityQueue<>(numActivities, Comparator.comparingInt(a -> a[2]));
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();

            while (!activities.isEmpty()) {
                int[] activity = activities.poll();

                if (parents[0] <= activity[0]) {
                    parents[0] = activity[1];
                    activity[3] = 0;
                } else if (parents[1] <= activity[0]) {
                    parents[1] = activity[1];
                    activity[3] = 1;
                } else {
                    impossible = true;
                    break;
                }

                outputOrder.add(activity);
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                while (!outputOrder.isEmpty()) {
                    schedule.append(outputOrder.poll()[3] == 0 ? "C" : "J");
                }
                System.out.println("Case #" + i + ": " + schedule);
            }
        }
    }
}