import java.util.*;

public class Solution {
    public static boolean overlaps(int[] a, int[] b) {
        return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] schedule = new int[n];
            boolean impossible = false;

            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] interval = new int[3];
                interval[0] = scanner.nextInt();
                interval[1] = scanner.nextInt();
                interval[2] = i;
                intervals.add(interval);
            }

            intervals.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return b[1] - a[1];
            });

            for (int i = 0; i < n; i++) {
                Set<Integer> labels = new HashSet<>(Arrays.asList(0, 1));
                int[] current = intervals.get(i);

                for (int j = 0; j < i; j++) {
                    int[] previous = intervals.get(j);
                    if (overlaps(current, previous)) {
                        labels.remove(schedule[previous[2]]);
                    }
                }

                if (labels.isEmpty()) {
                    impossible = true;
                    break;
                }

                schedule[current[2]] = labels.contains(0) ? 0 : 1;
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i : schedule) {
                    System.out.print(i == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}