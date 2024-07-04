import java.util.*;

public class Solution {
    public static String parentingPartnering(int[][] intervals) {
        int n = intervals.length;
        char[] result = new char[n];
        Arrays.sort(intervals, Comparator.comparingInt(itv -> itv[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int activeTasks = 0;

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];

            if (!heap.isEmpty() && interval[0] >= heap.peek()[1]) {
                heap.poll();
            } else {
                activeTasks++;
                if (activeTasks > 2) {
                    return "IMPOSSIBLE";
                }
            }

            if (heap.isEmpty()) {
                result[interval[2]] = 'C';
            } else {
                result[interval[2]] = (result[heap.peek()[2]] == 'C') ? 'J' : 'C';
            }

            heap.offer(interval);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][3];

            for (int n = 0; n < N; n++) {
                intervals[n][0] = scanner.nextInt();
                intervals[n][1] = scanner.nextInt();
                intervals[n][2] = n;
            }

            String result = parentingPartnering(intervals);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}