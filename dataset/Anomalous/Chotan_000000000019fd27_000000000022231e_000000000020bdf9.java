import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] activities = new int[N][3];
            for (int i = 0; i < N; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            Set<Integer> C = new HashSet<>();
            Set<Integer> J = new HashSet<>();

            int lastEndC = -1;
            int lastEndJ = -1;

            for (int[] activity : activities) {
                if (lastEndC <= activity[0]) {
                    C.add(activity[2]);
                    lastEndC = activity[1];
                } else if (lastEndJ <= activity[0]) {
                    J.add(activity[2]);
                    lastEndJ = activity[1];
                } else {
                    C.clear();
                    J.clear();
                    break;
                }
            }

            if (C.size() + J.size() == N) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (C.contains(i)) {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}