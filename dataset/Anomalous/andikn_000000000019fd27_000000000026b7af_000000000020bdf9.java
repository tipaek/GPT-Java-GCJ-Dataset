import java.util.*;

public class Solution {

    public static boolean overlaps(int[] a, int[] b) {
        return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] schedule = new int[n];
            boolean impossible = false;

            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end, i});
            }

            intervals.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

            int[] assignedLabels = new int[n];
            Arrays.fill(assignedLabels, -1);

            for (int i = 0; i < n; i++) {
                int[] currentInterval = intervals.get(i);
                Set<Integer> availableLabels = new HashSet<>(Arrays.asList(0, 1));

                for (int j = 0; j < i; j++) {
                    int[] prevInterval = intervals.get(j);
                    if (overlaps(currentInterval, prevInterval)) {
                        availableLabels.remove(assignedLabels[prevInterval[2]]);
                    }
                }

                if (availableLabels.isEmpty()) {
                    impossible = true;
                    break;
                }

                assignedLabels[currentInterval[2]] = availableLabels.contains(0) ? 0 : 1;
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(assignedLabels[i] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}