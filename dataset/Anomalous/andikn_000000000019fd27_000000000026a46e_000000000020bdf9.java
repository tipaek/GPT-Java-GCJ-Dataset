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

            SortedSet<int[]> intervals = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                }
            });

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end, i});
            }

            int[] assigned = new int[n];
            Arrays.fill(assigned, -1);
            int[] lastEnd = {-1, -1};

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                int index = interval[2];

                boolean assignedToC = false;
                if (lastEnd[0] <= start) {
                    assigned[index] = 0;
                    lastEnd[0] = end;
                    assignedToC = true;
                } else if (lastEnd[1] <= start) {
                    assigned[index] = 1;
                    lastEnd[1] = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(assigned[i] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}