import java.util.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String assignActivities(int N, int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int jEnd = 0, cEnd = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> intervals[a][1]));

        for (int i = 0; i < N; i++) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int i = pq.poll();

            if (jEnd > cEnd) {
                if (intervals[i][0] < cEnd) {
                    return "IMPOSSIBLE";
                }
                if (intervals[i][0] < jEnd) {
                    result.append('C');
                    cEnd = intervals[i][1];
                } else {
                    result.append('J');
                    jEnd = intervals[i][1];
                }
            } else {
                if (intervals[i][0] < jEnd) {
                    return "IMPOSSIBLE";
                }
                if (intervals[i][0] < cEnd) {
                    result.append('J');
                    jEnd = intervals[i][1];
                } else {
                    result.append('C');
                    cEnd = intervals[i][1];
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = assignActivities(N, intervals);
            System.out.printf("Case #%d: %s\n", t, result);
        }

        scanner.close();
    }
}