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
            for (int i = 0; i < n; i++) {
                int[] interval = new int[3];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                interval[2] = i;
                intervals.add(interval);
            }

            intervals.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

            Set<Integer> labels = new HashSet<>(Arrays.asList(0, 1));
            for (int i = 0; i < n; i++) {
                int[] interval = intervals.get(i);
                Set<Integer> availableLabels = new HashSet<>(labels);

                for (int j = 0; j < i; j++) {
                    int[] prev = intervals.get(j);
                    if (overlaps(interval, prev)) {
                        availableLabels.remove(schedule[prev[2]]);
                    }
                }

                if (availableLabels.isEmpty()) {
                    impossible = true;
                    break;
                }

                schedule[interval[2]] = availableLabels.contains(0) ? 0 : 1;
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int label : schedule) {
                    System.out.print(label == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}