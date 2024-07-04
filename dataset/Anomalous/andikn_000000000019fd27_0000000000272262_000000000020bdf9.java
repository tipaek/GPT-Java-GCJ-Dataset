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
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });

            Set<Integer> labels = new HashSet<>();
            int[] previous = null;

            for (int i = 0; i < intervals.size(); i++) {
                labels.clear();
                labels.add(0);
                labels.add(1);

                int[] current = intervals.get(i);

                if (i == 0) {
                    schedule[current[2]] = 0;
                } else {
                    for (int j = 0; j < i; j++) {
                        previous = intervals.get(j);
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
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(schedule[i] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}