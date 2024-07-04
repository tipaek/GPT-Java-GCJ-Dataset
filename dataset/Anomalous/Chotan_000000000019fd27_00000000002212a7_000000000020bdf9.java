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
            Set<Integer> setJ = new HashSet<>();
            int lastC = -1, lastJ = -1;

            for (int i = 0; i < N; i++) {
                if (lastC == -1 || intervals[i][0] >= lastC) {
                    setC.add(i);
                    lastC = intervals[i][1];
                } else if (lastJ == -1 || intervals[i][0] >= lastJ) {
                    setJ.add(i);
                    lastJ = intervals[i][1];
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    break;
                }

                if (i == N - 1) {
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < N; j++) {
                        if (setC.contains(j)) {
                            result.append('C');
                        } else {
                            result.append('J');
                        }
                    }
                    System.out.println("Case #" + t + ": " + result.toString());
                }
            }
        }
    }
}