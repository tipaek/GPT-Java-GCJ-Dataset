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
            SortedSet<int[]> intervals = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    int res = Integer.compare(a[0], b[0]);
                    if (res == 0) {
                        return Integer.compare(a[1], b[1]);
                    }
                    return res;
                }
            });

            for (int i = 0; i < n; i++) {
                int[] interval = new int[3];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                interval[2] = i;
                intervals.add(interval);
            }

            Iterator<int[]> itr = intervals.iterator();
            int[] prev = null;
            int i = 0;

            while (itr.hasNext()) {
                Set<Integer> labels = new HashSet<>(Arrays.asList(0, 1));
                int[] interval = itr.next();

                if (i == 0) {
                    schedule[interval[2]] = 0;
                } else {
                    Iterator<int[]> itr2 = intervals.iterator();
                    for (int j = 0; j < i; j++) {
                        prev = itr2.next();
                        if (overlaps(interval, prev)) {
                            labels.remove(schedule[prev[2]]);
                        }
                    }

                    if (labels.isEmpty()) {
                        impossible = true;
                        break;
                    }
                    schedule[interval[2]] = labels.contains(0) ? 0 : 1;
                }
                i++;
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int j = 0; j < n; j++) {
                    System.out.print(schedule[j] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}