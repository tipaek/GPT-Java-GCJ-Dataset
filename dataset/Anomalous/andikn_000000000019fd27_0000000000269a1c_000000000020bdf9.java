import java.util.*;

public class Solution {
    public static boolean overlaps(int[] a, int[] b) {
        return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();
            int[] schedule = new int[n];
            boolean impossible = false;
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int[] interval = new int[2];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                intervals.add(interval);
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            TreeSet<Integer> labels = new TreeSet<>(Arrays.asList(0, 1));
            for (int i = 0; i < n; i++) {
                int[] interval = intervals.get(i);
                labels.clear();
                labels.add(0);
                labels.add(1);

                for (int j = 0; j < i; j++) {
                    if (overlaps(interval, intervals.get(j))) {
                        labels.remove(schedule[j]);
                    }
                }

                if (labels.isEmpty()) {
                    impossible = true;
                    break;
                }
                schedule[i] = labels.first();
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(schedule[i] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}