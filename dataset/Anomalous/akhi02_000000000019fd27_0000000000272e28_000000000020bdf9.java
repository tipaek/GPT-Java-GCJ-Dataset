import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities.add(new int[]{start, end, i});
            }

            activities.sort(Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[N];
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            boolean isPossible = true;

            C.add(activities.get(0));
            assignments[activities.get(0)[2]] = 'C';

            if (N > 1) {
                J.add(activities.get(1));
                assignments[activities.get(1)[2]] = 'J';
            }

            for (int i = 2; i < N; i++) {
                int[] currentActivity = activities.get(i);
                int start = currentActivity[0];
                int end = currentActivity[1];
                int index = currentActivity[2];

                if (start >= C.get(C.size() - 1)[1]) {
                    C.add(currentActivity);
                    assignments[index] = 'C';
                } else if (start >= J.get(J.size() - 1)[1]) {
                    J.add(currentActivity);
                    assignments[index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append((char) assignments[i]);
                }
                System.out.println(result.toString());
            }
        }
    }
}