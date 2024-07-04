import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            Set<Integer> setC = new HashSet<>();
            int lastEndC = intervals[0][1];
            setC.add(0);

            for (int i = 1; i < N; i++) {
                if (lastEndC <= intervals[i][0]) {
                    setC.add(i);
                    lastEndC = intervals[i][1];
                }
            }

            Set<Integer> setJ = new HashSet<>();
            int lastEndJ = -1;

            for (int i = 0; i < N; i++) {
                if (!setC.contains(i)) {
                    if (lastEndJ == -1 || lastEndJ <= intervals[i][0]) {
                        setJ.add(i);
                        lastEndJ = intervals[i][1];
                    }
                }
            }

            if (setC.size() + setJ.size() == N) {
                StringBuilder schedule = new StringBuilder();

                for (int i = 0; i < N; i++) {
                    if (setC.contains(i)) {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                }

                System.out.println("Case #" + t + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}