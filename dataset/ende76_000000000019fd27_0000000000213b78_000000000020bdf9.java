import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    private static final Comparator<int[]> CMP = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int cmp = Integer.compare(o1[0], o2[0]);

            if (cmp != 0) return cmp;

            return Integer.compare(o1[1], o2[1]);
        }
    };

    private static final Comparator<int[]> CMP_BY_INDEX = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[2], o2[2]);
        }
    };


    private static String solve(int[][] as) {
        int N = as.length;

        Arrays.sort(as, CMP);

        PriorityQueue<int[]> cameron = new PriorityQueue<>(CMP);
        PriorityQueue<int[]> jamie = new PriorityQueue<>(CMP);

        StringBuilder result = new StringBuilder();

        for (int[] a : as) {
            while (!cameron.isEmpty()) {
                if (a[0] < cameron.peek()[1]) break;

                cameron.poll();
            }

            while (!jamie.isEmpty()) {
                if (a[0] < jamie.peek()[1]) break;

                jamie.poll();
            }

            if (cameron.isEmpty() || cameron.peek()[1] <= a[0]) {
                cameron.offer(a);
                a[3] = 'C';
                continue;
            }

            if (jamie.isEmpty() || jamie.peek()[1] <= a[0]) {
                jamie.offer(a);
                a[3] = 'J';
                continue;
            }

            return "IMPOSSIBLE";
        }

        Arrays.sort(as, CMP_BY_INDEX);

        for (int[] a : as) {
            result.append((char) a[3]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int N = s.nextInt();


            int[][] activities = new int[N][];

            for (int i = 0; i < N; i += 1) {
                int S = s.nextInt();
                int E = s.nextInt();

                activities[i] = new int[] {S, E, i, 0};
            }

            String result = solve(activities);


            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}
