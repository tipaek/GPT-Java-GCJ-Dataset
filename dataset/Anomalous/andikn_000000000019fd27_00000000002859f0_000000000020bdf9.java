import java.util.*;

public class Solution {
    public static boolean overlaps(int[] a, int[] b) {
        return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int[] schedule = new int[n];
            boolean impossible = false;
            List<int[]> intervals = new ArrayList<>();

            // Read intervals
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new int[]{start, end, i});
            }

            // Sort intervals by start time
            intervals.sort(Comparator.comparingInt(a -> a[0]));

            // Assign labels
            TreeSet<Integer> labels = new TreeSet<>(Arrays.asList(0, 1));
            for (int i = 0; i < n; i++) {
                int[] current = intervals.get(i);
                TreeSet<Integer> availableLabels = new TreeSet<>(labels);

                for (int j = 0; j < i; j++) {
                    int[] previous = intervals.get(j);
                    if (overlaps(current, previous)) {
                        availableLabels.remove(schedule[previous[2]]);
                    }
                }

                if (availableLabels.isEmpty()) {
                    impossible = true;
                    break;
                } else {
                    schedule[current[2]] = availableLabels.first();
                }
            }

            // Output result
            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder("Case #" + t + ": ");
                for (int i = 0; i < n; i++) {
                    result.append(schedule[i] == 0 ? "C" : "J");
                }
                System.out.println(result);
            }
        }

        in.close();
    }
}