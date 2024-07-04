import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt(), i});
            }
            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[N];
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            PriorityQueue<int[]> cameronQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            PriorityQueue<int[]> jamieQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            cameronQueue.add(intervals.get(0));
            assignments[intervals.get(0)[2]] = 'C';

            if (N > 1) {
                jamieQueue.add(intervals.get(1));
                assignments[intervals.get(1)[2]] = 'J';
            }

            for (int i = 2; i < N; i++) {
                int[] current = intervals.get(i);

                if (cameronQueue.peek()[1] <= current[0]) {
                    cameronQueue.poll();
                    cameronQueue.add(current);
                    assignments[current[2]] = 'C';
                } else if (jamieQueue.peek()[1] <= current[0]) {
                    jamieQueue.poll();
                    jamieQueue.add(current);
                    assignments[current[2]] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = 0; i < N; i++) {
                    result.append((char) assignments[i]);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}