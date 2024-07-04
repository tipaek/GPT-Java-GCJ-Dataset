import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    private static final Comparator<int[]> START_TIME_COMPARATOR = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            int startComparison = Integer.compare(a1[0], a2[0]);
            if (startComparison != 0) return startComparison;
            return Integer.compare(a1[1], a2[1]);
        }
    };

    private static final Comparator<int[]> INDEX_COMPARATOR = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            return Integer.compare(a1[2], a2[2]);
        }
    };

    private static String solve(int[][] activities) {
        int N = activities.length;

        Arrays.sort(activities, START_TIME_COMPARATOR);

        PriorityQueue<int[]> cameronQueue = new PriorityQueue<>(START_TIME_COMPARATOR);
        PriorityQueue<int[]> jamieQueue = new PriorityQueue<>(START_TIME_COMPARATOR);

        StringBuilder result = new StringBuilder();

        for (int[] activity : activities) {
            while (!cameronQueue.isEmpty() && activity[0] >= cameronQueue.peek()[1]) {
                cameronQueue.poll();
            }

            while (!jamieQueue.isEmpty() && activity[0] >= jamieQueue.peek()[1]) {
                jamieQueue.poll();
            }

            if (cameronQueue.isEmpty() || cameronQueue.peek()[1] <= activity[0]) {
                cameronQueue.offer(activity);
                activity[3] = 'C';
            } else if (jamieQueue.isEmpty() || jamieQueue.peek()[1] <= activity[0]) {
                jamieQueue.offer(activity);
                activity[3] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        Arrays.sort(activities, INDEX_COMPARATOR);

        for (int[] activity : activities) {
            result.append((char) activity[3]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][4];

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new int[] { start, end, i, 0 };
            }

            String result = solve(activities);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}