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
            Map<int[], Integer> intervalIndexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int[] interval = new int[2];
                interval[0] = scanner.nextInt();
                interval[1] = scanner.nextInt();
                intervals.add(interval);
                intervalIndexMap.put(interval, i);
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            Set<Integer> labels = new HashSet<>(Arrays.asList(0, 1));
            for (int i = 0; i < n; i++) {
                labels.clear();
                labels.add(0);
                labels.add(1);
                int[] currentInterval = intervals.get(i);

                for (int j = 0; j < i; j++) {
                    int[] previousInterval = intervals.get(j);
                    if (overlaps(currentInterval, previousInterval)) {
                        labels.remove(schedule[intervalIndexMap.get(previousInterval)]);
                    }
                }

                if (labels.isEmpty()) {
                    impossible = true;
                    break;
                }

                schedule[intervalIndexMap.get(currentInterval)] = labels.iterator().next();
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