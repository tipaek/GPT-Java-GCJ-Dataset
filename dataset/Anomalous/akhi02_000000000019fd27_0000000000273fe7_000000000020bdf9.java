import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new int[]{start, end, i});
            }

            intervals.sort(Comparator.comparingInt(o -> o[0]));

            int[] assigned = new int[N];
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            boolean isPossible = true;

            C.add(intervals.get(0));
            assigned[intervals.get(0)[2]] = 'C';
            if (N > 1) {
                J.add(intervals.get(1));
                assigned[intervals.get(1)[2]] = 'J';
            }

            for (int i = 2; i < intervals.size(); i++) {
                int[] current = intervals.get(i);
                if (current[0] >= C.get(C.size() - 1)[1]) {
                    C.add(current);
                    assigned[current[2]] = 'C';
                } else if (current[0] >= J.get(J.size() - 1)[1]) {
                    J.add(current);
                    assigned[current[2]] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append((char) assigned[i]);
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}